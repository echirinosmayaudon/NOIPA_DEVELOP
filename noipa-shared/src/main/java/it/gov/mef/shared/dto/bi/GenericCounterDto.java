package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.Locale;

import it.gov.mef.shared.utility.bi.UtilityDate;
import it.gov.mef.shared.utility.bi.UtilityNumbers;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new generic counter dto.
 */
@Data
/**
 * Dto che mette a fattor comune i dati relativi alle dashboard dei vari counter. 
 * Ogni counter estende questa classe ed aggiunge i campi specifici
 * @author d.brandi
 *
 */
public class GenericCounterDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The variazione percentuale mese prev. */
	private double variazione_percentuale_mese_prev;
	/**
	 * contiene la concatenazione di mese/anno dei dati della istanza. Es.: 201906
	 */
	private String rata;
	
	/**
	 * Metodo che restituisce la variazione percentuale 
	 * formattandola con un numero di decimali prefissato.
	 *
	 * @return the variazione percentuale mese prev
	 */
	public double getVariazione_percentuale_mese_prevFormat() {
		return UtilityNumbers.formatDecimalNumber(variazione_percentuale_mese_prev).doubleValue();
	}
	
	/**
	 * Metodo che suddivide il campo rata e preleva il mese 
	 * Es.: 201906 -> 06
	 *
	 * @return the mese
	 */
	public String getMese() {
		return getRata().substring(4, 6);
	}
	
	/**
	 * Metodo che suddivide il campo rata e preleva l'anno 
	 * Es.: 201906 -> 2019
	 *
	 * @return the anno
	 */
	public String getAnno() {
		return getRata().substring(0, 4);
	}
	
	/**
	 * Metodo che restituisce la descrizione decodificata dal codice del mese 
	 * in base al locale passato come parametro.
	 *
	 * @param locale the locale
	 * @return the desc mese
	 */
	public String getDescMese(Locale locale) {
		return UtilityDate.getDescMese(getMese(), locale);
	}
	
	/**
	 * Metodo che restituisce la descrizione decodificata dal codice del mese 
	 * più l'anno in base al locale passato come parametro.
	 *
	 * @param locale the locale
	 * @return the periodo
	 */
	public String getPeriodo(Locale locale) {
		return getDescMese(locale) + " " + getAnno();
	}
}
