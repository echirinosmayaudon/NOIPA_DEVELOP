package it.gov.mef.shared.dto.assistenza;

import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class ListaAssistenza.
 */
public class ListaAssistenza {
	
	/** The assistenza. */
	private Map<Long, List<Tema>> assistenza;
	
	/**
	 * Instantiates a new lista assistenza.
	 *
	 * @param assistenza the assistenza
	 */
	public ListaAssistenza( Map<Long, List<Tema>> assistenza) {
		this.assistenza = assistenza ;
	}
	
	
	/**
	 * Adds the livello.
	 *
	 * @param livello the livello
	 * @param linea the linea
	 */
	public void addLivello(long livello, List<Tema> linea) {
		assistenza.put(livello, linea);
	}
	
	/**
	 * Gets the linea.
	 *
	 * @param livello the livello
	 * @return the linea
	 */
	public List<Tema> getLinea(long livello){
		return assistenza.get(livello);
	}
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return assistenza != null ? assistenza.size() :0;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaAssistenza [assistenza=" + assistenza + "]";
	}
	
	
	
	
	
}
