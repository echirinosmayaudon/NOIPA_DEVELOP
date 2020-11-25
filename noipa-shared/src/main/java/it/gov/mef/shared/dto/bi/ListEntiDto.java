package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new list enti dto.
 */
@Data
/**
 * Dto per la ricezione di una lista di enti per la dashboard dati spesa 
 * per l'anno di interesse ogni elemento della lista contiene 
 * i dati della spesa per un ente nell'anno di interesse
 * @author d.brandi
 *
 */
public class ListEntiDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The anno. */
	private int anno;
	
	/** The enti. */
	private List<EnteDto> enti;

}
