package it.gov.mef.shared.dto.dataset;

import java.io.Serializable;
import java.util.List;
 

// TODO: Auto-generated Javadoc
/**
 * The Class DataSetPaginaDto.
 */
public class DataSetPaginaDto implements Serializable{

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The categoria name. */
	private String categoria_name ;
	
	/** The categoria description. */
	private String categoria_description ;
	
	/** The lista dataset pagina. */
	private List<ListaLinguaDataSetDto> listaDatasetPagina ;

	/**
	 * Gets the lista dataset pagina.
	 *
	 * @return the lista dataset pagina
	 */
	public List<ListaLinguaDataSetDto> getListaDatasetPagina() {
		return listaDatasetPagina;
	}

	/**
	 * Sets the lista dataset pagina.
	 *
	 * @param listaDatasetPagina the new lista dataset pagina
	 */
	public void setListaDatasetPagina(List<ListaLinguaDataSetDto> listaDatasetPagina) {
		this.listaDatasetPagina = listaDatasetPagina;
	}
	



	/**
	 * Gets the categoria name.
	 *
	 * @return the categoria name
	 */
	public String getCategoria_name() {
		return categoria_name;
	}

	/**
	 * Gets the categoria description.
	 *
	 * @return the categoria description
	 */
	public String getCategoria_description() {
		return categoria_description;
	}

	/**
	 * Sets the categoria name.
	 *
	 * @param categoria_name the new categoria name
	 */
	public void setCategoria_name(String categoria_name) {
		this.categoria_name = categoria_name;
	}

	/**
	 * Sets the categoria description.
	 *
	 * @param categoria_description the new categoria description
	 */
	public void setCategoria_description(String categoria_description) {
		this.categoria_description = categoria_description;
	}
	 
}
