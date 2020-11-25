package it.gov.mef.shared.dto.dataset;

import java.util.List;
import java.util.Locale;

import org.springframework.util.CollectionUtils;

import it.gov.mef.shared.utility.bi.UtilityLang;

public abstract class TranslatableDatasetDto {

	private static final int MAX_LENGTH_DESCRIPTION_DATASET = 100;
	
	abstract public String getDataset_description(Locale locale);

	abstract public String getDataset_name(Locale locale);
	abstract public String getDataset_description_cutted(Locale locale);
	
	public String getDataset_description(Locale locale,List<LinguaDataSetDescriptionsDto> listaDatasetDescriptions) {
		String language = getLanguage(locale);
		if (!CollectionUtils.isEmpty(listaDatasetDescriptions)) {
			for (LinguaDataSetDescriptionsDto desc : listaDatasetDescriptions) {
				if (desc.getLang().equals(language)) {
					return desc.getDesc();
				}
			}
		}
		return null;
	}
	 
	public String getDataset_name(Locale locale,List<LinguaDataSetNamesDto> listaDatasetNames) {
		String language = getLanguage(locale);
		if (!CollectionUtils.isEmpty(listaDatasetNames)) {
			for (LinguaDataSetNamesDto name : listaDatasetNames) {
				if (name.getLang().equals(language)) {
					return name.getName();
				}
			}
		}
		return null;
	}	
	public String getDataset_description_cutted(Locale locale,List<LinguaDataSetDescriptionsDto> listaDatasetDescriptions) {
		String dataset_description = getDataset_description(locale,listaDatasetDescriptions);
		if (dataset_description.length() > MAX_LENGTH_DESCRIPTION_DATASET) {
			StringBuilder descCutted = new StringBuilder();
			int lastIndex = dataset_description.substring(0, MAX_LENGTH_DESCRIPTION_DATASET-3).lastIndexOf(" ");
			descCutted.append(dataset_description.substring(0, lastIndex));
			descCutted.append("...");
			return descCutted.toString();
		}
		else {
			return dataset_description;
		}
	}	
	private static String getLanguage(Locale locale) {
		UtilityLang.setLocale(locale);
		return UtilityLang.getDescLanguageForLocale();
	}
	
 
}