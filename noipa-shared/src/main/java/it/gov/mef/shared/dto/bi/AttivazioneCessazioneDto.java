package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.Locale;

import it.gov.mef.shared.utility.bi.UtilityDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new attivazione cessazione dto.
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(of= {"cod_mese"})
/**
 * Dto per la ricezione dal servizio rest 
 * (e passaggio verso la vista) dei dati relativi 
 * alla dashboard assunzioni cessazioni
 * @author d.brandi
 *
 */
public class AttivazioneCessazioneDto implements Serializable,Comparable<AttivazioneCessazioneDto> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod mese. */
	private String cod_mese;
	
	/** The attivazioni. */
	private Integer attivazioni;
	
	/** The cessazioni. */
	private Integer cessazioni;
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AttivazioneCessazioneDto o) {
		return getCod_mese().compareTo(o.getCod_mese());
	}
	
	/**
	 * Gets the desc mese.
	 *
	 * @param locale the locale
	 * @return descrizione decodificata dal codice del mese
	 * in base al locale passato come parametro
	 */
	public String getDescMese(Locale locale) {
		return UtilityDate.getDescMese(getCod_mese(),locale);
	}
	
	/**
	 * Gets the desc mese abbreviato.
	 *
	 * @param locale the locale
	 * @return descrizione decodificata ed abbreviata del mese
	 * in base al locale passato come parametro
	 */
	public String getDescMeseAbbreviato(Locale locale) {
		return UtilityDate.getDescMeseAbbreviato(getCod_mese(), locale);
	}
}
