package it.gov.mef.shared.dto.bi;

import com.liferay.portal.kernel.util.SortedArrayList;

import java.io.Serializable;
import java.util.Locale;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new list attivazioni cessazioni dto.
 */
@Data
/**
 * Dto per la ricezione di una lista di assunzioni cessazioni 
 * per l'anno di interesse.
 * ogni elemento della lista contiene le assunzioni e cessazioni 
 * per un mese dell'anno di interesse
 * @author d.brandi
 *
 */
public class ListAttivazioniCessazioniDto implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The anno. */
	private int anno;
	
	/** The mesi. */
	private SortedArrayList<AttivazioneCessazioneDto> mesi;
	
	/**
	 * Gets the dati attivazioni.
	 *
	 * @return stringa in formato json con i dati per le assunzioni
	 */
	public String getDatiAttivazioni() {
		StringBuilder result = new StringBuilder();
		if(mesi!=null && mesi.size() > 0 ) {
			result.append("[");
			for(int i=0; i<mesi.size(); i++) {
				AttivazioneCessazioneDto item =mesi.get(i);
				result.append(item.getAttivazioni());
				if(i<mesi.size()-1) {
					result.append(",");
				}
			}
			result.append("]");
		}
		return result.toString();
		
	}
	
	/**
	 * Gets the dati cessazioni.
	 *
	 * @return stringa in formato json con i dati per le cessazioni
	 */
	public String getDatiCessazioni() {
		StringBuilder result = new StringBuilder();
		if(mesi!=null && mesi.size() > 0 ) {
			result.append("[");
			for(int i=0; i<mesi.size(); i++) {
				AttivazioneCessazioneDto item =mesi.get(i);
				result.append(item.getCessazioni());
				if(i<mesi.size()-1) {
					result.append(",");
				}
			}
			result.append("]");
		}
		return result.toString();
	}
	
	/**
	 * Gets the dati temporali.
	 *
	 * @param locale the locale
	 * @return stringa in formato json con i mesi
	 * in lingua che rispetta il locale passato come parametro
	 */
	public String getDatiTemporali(Locale locale) {
		StringBuilder result = new StringBuilder();
		if(mesi!=null && mesi.size() > 0 ) {
			result.append("[");
			for(int i=0; i<mesi.size(); i++) {
				AttivazioneCessazioneDto item =mesi.get(i);
				result.append("'");
				result.append(item.getDescMeseAbbreviato(locale));
				result.append("'");
				if(i<mesi.size()-1) {
					result.append(",");
				}
			}
			result.append("]");
		}
		return result.toString();
	}
}
