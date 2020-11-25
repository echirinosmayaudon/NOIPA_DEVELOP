package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new list imposte dto.
 */
@Data
/**
 * Dto per la ricezione della lista di voci di spesa
 * ogni elemento della lista contiene le voci di spesa a grana più grossa 
 * e una lista di voci di spesa a grana più fine che sono 
 * "figlie" delle voci di spesa a grana più grossa
 * @author d.brandi
 *
 */
public class ListImposteDto implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The tipo imposte. */
	private List<ImpostaDto> tipo_imposte;
	
	/** The dettaglio imposte. */
	private List<ImpostaDto> dettaglio_imposte;

}
