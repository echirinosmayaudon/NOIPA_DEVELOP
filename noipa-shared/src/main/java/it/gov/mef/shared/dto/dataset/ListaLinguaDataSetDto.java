package it.gov.mef.shared.dto.dataset;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class ListaLinguaDataSetDto.
 */
@Data
@NoArgsConstructor
public class ListaLinguaDataSetDto extends TranslatableDatasetDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dataset id. */
	private String dataset_id ;
	
	/** The dataset names. */
	private List<LinguaDataSetNamesDto> dataset_names ;
	
	/** The dataset descriptions. */
	private List<LinguaDataSetDescriptionsDto> dataset_descriptions ;
	
	
	public ListaLinguaDataSetDto(String dataset_id) {
		super();
		this.dataset_id = dataset_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaLinguaDataSetDto [dataset_id=" + dataset_id + ", dataset_names=" + dataset_names
				+ ", dataset_descriptions=" + dataset_descriptions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataset_id == null) ? 0 : dataset_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaLinguaDataSetDto other = (ListaLinguaDataSetDto) obj;
		if (dataset_id == null) {
			if (other.dataset_id != null)
				return false;
		} else if (!dataset_id.equals(other.dataset_id))
			return false;
		return true;
	}
	 
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
