package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.gov.mef.shared.utility.bi.UtilityJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(of= {"cod_ente"})

/**
 * Instantiates a new ente dto.
 */
@NoArgsConstructor
/**
 * Dto per la ricezione dal servizio rest 
 * (e passaggio verso la vista) dei dati relativi 
 * all'elenco degli enti
 * @author d.brandi
 *
 */
public class EnteDto implements Serializable, Comparable<EnteDto>{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod ente. */
	private String cod_ente;
	
	/** The descr ente. */
	private String descr_ente;

	/**
	 * Instantiates a new ente dto.
	 *
	 * @param cod_ente the cod ente
	 */
	public EnteDto(String cod_ente) {
		super();
		this.cod_ente = cod_ente;
	}
	
	/**
	 * ordino i dati della spesa per gli enti 
	 * in base alla descrizione dell'ente.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(EnteDto o) {
		if(StringUtils.isNotBlank(getDescr_ente()) && o!=null && StringUtils.isNotBlank(o.getDescr_ente())) {
			return getDescr_ente().compareTo(o.getDescr_ente());
		}
		return 0;
	}

	/**
	 * Stampa desc enti selezionati for token field.
	 *
	 * @param listEnti the list enti
	 * @param entiSelectedList the enti selected list
	 * @return stringa preparata per tokenfield contenente gli enti selezionati
	 */
	public static String stampaDescEntiSelezionatiForTokenField(List<EnteDto> listEnti, List<String> entiSelectedList) { 
		return stampaDescEntiSelezionati(listEnti, entiSelectedList, true);
	}
	
	/**
	 * Stampa desc enti selezionati.
	 *
	 * @param listEnti the list enti
	 * @param entiSelectedList the enti selected list
	 * @return stringa contenente gli enti selezionati
	 */
	public static String stampaDescEntiSelezionati(List<EnteDto> listEnti, List<String> entiSelectedList) { 
		return stampaDescEntiSelezionati(listEnti, entiSelectedList, false);		
	}
	
	/**
	 * Stampa desc enti selezionati.
	 *
	 * @param listEnti the list enti
	 * @param entiSelectedList the enti selected list
	 * @param forTokenField stabilisce se usare una formattazione per tokenfield
	 * @return stringa contenente gli enti selezionati
	 */
	private static String stampaDescEntiSelezionati(List<EnteDto> listEnti, List<String> entiSelectedList,boolean forTokenField) { 
		StringBuilder entiSelected = new StringBuilder();
		if(listEnti!=null){
			entiSelected.append("[");
			creaJsonEnti(listEnti, entiSelectedList, forTokenField, entiSelected);
			entiSelected.append("]");
		}
		return entiSelected.toString();
	}
	
	/**
	 * metodo di appoggio che crea una stringa json che contiene label e value di un ente.
	 *
	 * @param listEnti the list enti
	 * @param entiSelectedList the enti selected list
	 * @param forTokenField the for token field
	 * @param entiSelected the enti selected
	 */
	private static void creaJsonEnti(List<EnteDto> listEnti, List<String> entiSelectedList, boolean forTokenField,
			StringBuilder entiSelected) {
		int contSel = 0;
		for(int i=0; i < listEnti.size(); i++) {
			if(entiSelectedList!=null && entiSelectedList.contains(listEnti.get(i).getCod_ente()) ){
				if(!forTokenField) {
					entiSelected.append( UtilityJson.escapeString(listEnti.get(i).getDescr_ente()));
				}
				else {
					entiSelected.append("{ label: '"+UtilityJson.escapeString(listEnti.get(i).getDescr_ente())+
							"', value: '"+listEnti.get(i).getCod_ente() +"'}");
				}
				if(contSel < entiSelectedList.size()-1) {
					entiSelected.append(",");
				}
				contSel++;
			}
		}
	}
	
	/**
	 * Stampa desc enti for tokenfield.
	 *
	 * @param listEnti the list enti
	 * @return stringa contenente il json con la descrizione degli enti necessaria a tokenfield
	 */
	public static String stampaDescEntiForTokenfield(List<EnteDto> listEnti) {
		StringBuilder comboEnti = new StringBuilder();
		if(listEnti!=null){
			comboEnti.append("[");
			for(int i=0; i < listEnti.size(); i++) {
				comboEnti.append("{ label: '"+UtilityJson.escapeString(listEnti.get(i).getDescr_ente())+"', value: '"+listEnti.get(i).getCod_ente() +"'}");
				if(i < listEnti.size()-1) {
					comboEnti.append(",");
				}
			}
			comboEnti.append("]");
		}
		return comboEnti.toString();
	}
	public static String stampaIdEnti(List<String> listEntiSelected) {
		StringBuilder comboEnti = new StringBuilder();
		if(listEntiSelected!=null){
			for(int i=0; i < listEntiSelected.size(); i++) {
				if(StringUtils.isNotBlank(listEntiSelected.get(i))) {
					comboEnti.append(listEntiSelected.get(i));
					if(i < listEntiSelected.size()-1 && StringUtils.isNotBlank(listEntiSelected.get(i+1))) {
						comboEnti.append(",");
					}
				}
			}
			return comboEnti.toString();
		}
		else {
			return "";
		}
	}
}
