package it.gov.mef.shared.dto.bi;

import java.io.Serializable;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new counter retribuzioni dto.
 */
@Data
/**
 * Dto per la ricezione dal servizio rest 
 * (e passaggio verso la vista) dei dati relativi 
 * alla dashboard counter retribuzioni
 * @author d.brandi
 *
 */
public class CounterRetribuzioniDto extends GenericCounterDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The retribuzioni mese curr. */
	private long retribuzioni_mese_curr;	
	
}
