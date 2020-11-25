package it.gov.mef.shared.dto.bi;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new descr internaz.
 */
@Data
/**
 * Classe per l'internazionalizzazione 
 * di alcuni dati ritornati dai servizi esterni, 
 * come ad esempio le descrizioni delle voci di imposta
 * @author d.brandi
 *
 */
public class DescrInternaz {
	
	/** The desc. */
	private String desc;
	
	/** The lang. */
	private String lang;
}
