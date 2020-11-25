package it.gov.mef.shared.dto.bi;

import java.io.Serializable;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new counter amministrati dto.
 */
@Data
/**
 * Dto per la ricezione dal servizio rest 
 * (e passaggio verso la vista) dei dati relativi 
 * alla dashboard counter amministrati
 * @author d.brandi
 *
 */
public class CounterAmministratiDto extends GenericCounterDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The amministrati mese curr. */
	private long amministrati_mese_curr;
	
	
}
