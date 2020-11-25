package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

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
@EqualsAndHashCode(of= {"cod_tipo_imposta"})

/**
 * Instantiates a new imposta ente dto.
 */
@NoArgsConstructor
/**
 * Dto per la ricezione dal servizio rest (e passaggio verso la vista) 
 * dei dati relativi alle voci di spesa
 * dell'ente nel contesto dei dati della spesa
 * @author d.brandi
 *
 */
public class ImpostaEnteDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod tipo imposta. */
	private String cod_tipo_imposta;
	
	/** The tipo imposta. */
	private String tipo_imposta;
	
	/** The importo. */
	private double importo;
	
	/** The dettaglio imposta. */
	private List<DettaglioImpostaEnteDto> dettaglio_imposta;
	
	
	
	/**
	 * Instantiates a new imposta ente dto.
	 *
	 * @param cod_tipo_imposta the cod tipo imposta
	 */
	public ImpostaEnteDto(String cod_tipo_imposta) {
		super();
		this.cod_tipo_imposta = cod_tipo_imposta;
	}
	
	
	
}
