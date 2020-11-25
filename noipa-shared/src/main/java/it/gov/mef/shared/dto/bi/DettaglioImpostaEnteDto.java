package it.gov.mef.shared.dto.bi;

import java.io.Serializable;

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
 * Instantiates a new dettaglio imposta ente dto.
 */
@NoArgsConstructor
/**
 * Dto per la ricezione dal servizio rest 
 * (e passaggio verso la vista) dei dati relativi al dettaglio
 * delle voci di spesa dell'ente 
 * nel contesto dei dati della spesa
 * @author d.brandi
 *
 */
public class DettaglioImpostaEnteDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod imposta. */
	private String cod_imposta;
	
	/** The imposta. */
	private String imposta;
	
	/** The importo. */
	private double importo;
	
	/**
	 * Instantiates a new dettaglio imposta ente dto.
	 *
	 * @param cod_imposta the cod imposta
	 */
	public DettaglioImpostaEnteDto(String cod_imposta) {
		super();
		this.cod_imposta = cod_imposta;
	}
		
		
}
