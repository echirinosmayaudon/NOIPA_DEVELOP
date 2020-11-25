package it.gov.mef.shared.utility;

  
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import it.gov.mef.shared.dto.dataset.ConfigurazioneDatasetBean;
import it.gov.mef.shared.dto.dataset.ListaLinguaDataSetDto;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilJson.
 */
public class UtilJson  {

	
//	protected Class <T> clazz;
//		
//	public void setClazz(Class <T> t){
//		this.clazz=t;
//	}
//	 
//	public Class<T> getClazz(){
//		return  clazz;
//	}
	/**
 * Converti dto lista lingua data set dto.
 *
 * @param json the json
 * @return the list
 */
	public   List<ListaLinguaDataSetDto> convertiDtoListaLinguaDataSetDto(String json) {
		 Gson gson = new Gson();
		 
		 java.lang.reflect.Type tipo = new TypeToken<List<ListaLinguaDataSetDto>>(){}.getType();
 		 List<ListaLinguaDataSetDto> dto =  gson.fromJson(json.toString(), tipo);
 		
		 return dto;
		
	}
	
	/**
	 * Converti dto lista data set dto.
	 *
	 * @param json the json
	 * @return the list
	 */
	public   List<ConfigurazioneDatasetBean> convertiDtoListaDataSetDto(String json) {
		 Gson gson = new Gson();
		 
		 java.lang.reflect.Type tipo = new TypeToken<List<ConfigurazioneDatasetBean>>(){}.getType();
		 List<ConfigurazioneDatasetBean> dto =  gson.fromJson(json.toString(), tipo);
		
		 return dto;
		
	}
	
	


//	public  List<T> convertiJsonToDtoLista(String json) {
//		 Gson gson = new Gson();
//		java.lang.reflect.Type tipo = new TypeToken<List<T>>(){}.getType();
//  		 List<T> dto =  gson.fromJson(json, tipo);
//		  return dto;
//		
//	}
}
