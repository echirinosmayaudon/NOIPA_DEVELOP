package it.gov.mef.shared.dto.dataset;

import java.io.Serializable;
 

// TODO: Auto-generated Javadoc
/**
 * The Class TendinaAnniDto.
 */
public class TendinaAnniDto implements Serializable,Comparable<TendinaAnniDto>{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The anno. */
	private String anno;
	
	/** The selected. */
	private String selected ;
	
	 
	
	
	/**
	 * Instantiates a new tendina anni dto.
	 *
	 * @param anno the anno
	 * @param selected the selected
	 */
	public TendinaAnniDto(String anno, String selected) {
		super();
		this.anno = anno;
		this.selected = selected;
	}
	
	/**
	 * Gets the anno.
	 *
	 * @return the anno
	 */
	public String getAnno() {
		return anno;
	}
	
	/**
	 * Gets the selected.
	 *
	 * @return the selected
	 */
	public String getSelected() {
		return selected;
	}
	
	/**
	 * Sets the anno.
	 *
	 * @param anno the new anno
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	/**
	 * Sets the selected.
	 *
	 * @param selected the new selected
	 */
	public void setSelected(String selected) {
		this.selected = selected;
	}

	@Override
	public int compareTo(TendinaAnniDto o) {
		return Integer.compare(Integer.parseInt(o.getAnno()),Integer.parseInt(getAnno()));
	}
	 
}
