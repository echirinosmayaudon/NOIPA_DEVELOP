package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new list regioni dto.
 */
@Data
/**
 * Dto per la ricezione di una lista di regioni
 * ogni elemento della lista contiene i dati di una regione
 * @author d.brandi
 *
 */
public class ListRegioniDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The regioni. */
	private List<RegioneDto> regioni;	
	
}
