package it.gov.mef.shared.dto.bi;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new spesa ente dto.
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(of= {"cod_ente"})
/**
 * Dto per la ricezione dei dati della spesa relativamente ad un ente 
 * del quale ho codice e descrizione.
 * Contiene i dati della spesa di un ente divisi per le varie voci di spesa 
 * (lista imposte_ente) e l'importo totale che raggruppa tutte le voci di spesa
 * 
 * @author d.brandi
 *
 */
public class SpesaEnteDto implements Serializable, Comparable<SpesaEnteDto>{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cod ente. */
	private String cod_ente;
	
	/** The descr ente. */
	private String descr_ente;
	
	/** The importo. */
	private double importo;
	
	/** The imposte ente. */
	private List<ImpostaEnteDto> imposte_ente;
	
	/**
	 * ordino i dati della spesa per gli enti 
	 * in base alla descrizione dell'ente.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(SpesaEnteDto o) {
		if(StringUtils.isNotBlank(getDescr_ente()) && o!=null && StringUtils.isNotBlank(o.getDescr_ente())) {
			return getDescr_ente().compareTo(o.getDescr_ente());
		}
		return 0;
	}
}
