package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new list province dto.
 */
@Data
/**
 * Dto per la ricezione di una lista di province
 * ogni elemento della lista contiene i dati di una provincia
 * @author d.brandi
 *
 */
public class ListProvinceDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The province. */
	private List<ProvinciaDto> province;
}
