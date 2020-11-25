package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

import org.springframework.util.CollectionUtils;

import it.gov.mef.shared.utility.bi.UtilityLang;
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
@EqualsAndHashCode(of= {"cod_imposta"})

/**
 * Instantiates a new imposta dto.
 */
@NoArgsConstructor
/**
 * Dto per la ricezione dal servizio rest (e passaggio verso la vista) 
 * dei dati relativi alle voci di spesa
 * @author d.brandi
 *
 */
public class ImpostaDto implements Serializable, Comparable<ImpostaDto> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod imposta. */
	private String cod_imposta;
	
	/** The descr imposta. */
	private List<DescrInternaz> descr_imposta;	
	
	/**
	 * Instantiates a new imposta dto.
	 *
	 * @param cod_imposta the cod imposta
	 */
	public ImpostaDto(String cod_imposta) {
		super();
		this.cod_imposta = cod_imposta;
	}
	
	/**
	 * Gets the descr imposta for locale.
	 *
	 * @return descrizione della voce di spesa per il locale
	 */
	public String getDescrImpostaForLocale() {
		return UtilityLang.getDescForLanguage(descr_imposta);	
	}
	
	/**
	 * Gets the json imposte for locale.
	 *
	 * @param listaImposte the lista imposte
	 * @return json con le imposte per il locale
	 */
	public static String getJsonImposteForLocale(List<ImpostaDto> listaImposte) {
		StringBuilder arrayJson = new StringBuilder();
		arrayJson.append("[");
		if(!CollectionUtils.isEmpty(listaImposte)) {
			for(ImpostaDto imposta : listaImposte) {
				arrayJson.append("'"+imposta.getDescrImpostaForLocale()+"'");
				arrayJson.append(",");
			}
			arrayJson.setLength(arrayJson.length()-1);
		}
		arrayJson.append("]");
		return arrayJson.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ImpostaDto o) {
		return getCod_imposta().compareTo(o.getCod_imposta());
	}

}
