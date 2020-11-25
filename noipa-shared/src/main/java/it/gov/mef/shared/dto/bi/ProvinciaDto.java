package it.gov.mef.shared.dto.bi;

import java.io.Serializable;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new provincia dto.
 */
@Data
/**
 * Dto per la ricezione dal servizio esterno dei dati di una provincia
 * @author d.brandi
 *
 */
public class ProvinciaDto implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod provincia. */
	private String cod_provincia;
	
	/** The descr provincia. */
	private String descr_provincia;
	
	/** The cod regione. */
	private String cod_regione;
	
}
