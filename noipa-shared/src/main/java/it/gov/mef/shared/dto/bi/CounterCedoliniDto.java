package it.gov.mef.shared.dto.bi;

import java.io.Serializable;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new counter cedolini dto.
 */
@Data
/**
 * Dto per la ricezione dal servizio rest 
 * (e passaggio verso la vista) dei dati relativi 
 * alla dashboard counter cedolini
 * @author d.brandi
 *
 */
public class CounterCedoliniDto extends GenericCounterDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cedolini mese curr. */
	private long cedolini_mese_curr;
	
	
}



