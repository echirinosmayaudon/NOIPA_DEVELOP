package it.gov.mef.shared.dto.dataset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lombok.Data;
 

// TODO: Auto-generated Javadoc
/**
 * The Class DataSetDto.
 */
@Data
public class DataSetDto extends TranslatableDatasetDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dataset names. */
	private List<LinguaDataSetNamesDto> dataset_names ;
	
	/** The dataset descriptions. */
	private List<LinguaDataSetDescriptionsDto> dataset_descriptions ;
	
	/** The dataset id. */
	private String dataset_id ;
	
	/** The tendina anni. */
	private List<TendinaAnniDto> tendinaAnni =new ArrayList<TendinaAnniDto>();
	
	/** The dettaglio. */
	private List<DettaglioDataSetDto> dettaglio =new ArrayList<DettaglioDataSetDto>();
	
	/** The dataset correlati. */
	private List<ListaLinguaDataSetDto> datasetCorrelati =new ArrayList<ListaLinguaDataSetDto>();
	
	/** The path link sparql. */
	private String pathLinkSparql ;
	

	/* (non-Javadoc)
	 * @see it.gov.mef.shared.dto.dataset.TranslatableDatasetDto#getDataset_description(java.util.Locale)
	 */
	@Override
	public String getDataset_description(Locale locale) {
		return getDataset_description(locale, dataset_descriptions);
	}
	 
	/* (non-Javadoc)
	 * @see it.gov.mef.shared.dto.dataset.TranslatableDatasetDto#getDataset_name(java.util.Locale)
	 */
	@Override
	public String getDataset_name(Locale locale) {
		return getDataset_name(locale, dataset_names);
	}

	@Override
	public String getDataset_description_cutted(Locale locale) {
		return getDataset_description_cutted(locale, dataset_descriptions);
	} 
	 
}
