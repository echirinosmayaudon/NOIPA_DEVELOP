package it.gov.mef.shared.dto.bi;

import java.io.Serializable;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new regione dto.
 */

/**
 * Instantiates a new regione dto.
 */

/**
 * Instantiates a new regione dto.
 */
@Data

/**
 * Dto per la ricezione dal servizio esterno dei dati di una regione
 * @author d.brandi
 *
 */
public class RegioneDto  implements Serializable, Comparable<RegioneDto> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod regione. */
	private String cod_regione;
	
	/** The descr regione. */
	private String descr_regione;

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(RegioneDto o) {
		return this.getDescr_regione().compareTo(o.getDescr_regione());
	}	
}
