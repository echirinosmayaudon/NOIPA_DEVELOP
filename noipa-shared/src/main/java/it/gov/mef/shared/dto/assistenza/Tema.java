package it.gov.mef.shared.dto.assistenza;


import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class Tema.
 */
public class Tema implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5236510430564428272L;
	
	/** The titolo. */
	private String titolo;
	
	/** The descrizione. */
	private String descrizione;
	
	/** The area portale. */
	private String areaPortale;
	
	/** The id. */
	private String id;
	
	/** The list argomento. */
	private List<Tema> listArgomento;
	
	/** The resource prim key. */
	private long resourcePrimKey;// risposta
	
	/** The is rispsota. */
	private boolean isRispsota;
	
	/** The links. */
	private List<String> links;
	
	/** The label links. */
	private List<String> labelLinks;
	
	/** The livello. */
	private long livello;

	/**
	 * Instantiates a new tema.
	 *
	 * @param titolo the titolo
	 * @param descrizione the descrizione
	 * @param id the id
	 * @param listArgomento the list argomento
	 * @param resourcePrimKey the resource prim key
	 */
	public Tema(String titolo, String descrizione, String id, List<Tema> listArgomento, long resourcePrimKey) {

	}

	/**
	 * Instantiates a new tema.
	 *
	 * @param titolo the titolo
	 * @param descrizione the descrizione
	 * @param id the id
	 * @param listArgomento the list argomento
	 * @param resourcePrimKey the resource prim key
	 * @param livello the livello
	 */
	public Tema(String titolo, String descrizione, String id, List<Tema> listArgomento, long resourcePrimKey,
			long livello) {
		this.titolo = clearValue(titolo);
		this.descrizione = clearValue(descrizione);
		this.id = id;
		this.listArgomento = listArgomento;
		this.resourcePrimKey = resourcePrimKey;
		this.livello = livello;
	}
	
	/**
	 * Instantiates a new tema.
	 *
	 * @param titolo the titolo
	 * @param descrizione the descrizione
	 * @param areaPortale the area portale
	 * @param id the id
	 * @param listArgomento the list argomento
	 * @param resourcePrimKey the resource prim key
	 * @param livello the livello
	 */
	public Tema(String titolo, String descrizione, String areaPortale, String id, List<Tema> listArgomento, long resourcePrimKey,
			long livello) {
		this.titolo = clearValue(titolo);
		this.descrizione = clearValue(descrizione);
		this.id = id;
		this.listArgomento = listArgomento;
		this.resourcePrimKey = resourcePrimKey;
		this.livello = livello;
		this.areaPortale = clearValue(areaPortale);
	}

	/**
	 * Instantiates a new tema.
	 *
	 * @param titolo the titolo
	 * @param descrizione the descrizione
	 * @param id the id
	 * @param listArgomento the list argomento
	 * @param resourcePrimKey the resource prim key
	 * @param livello the livello
	 * @param links the links
	 * @param labelLinks the label links
	 */
	public Tema(String titolo, String descrizione, String id, List<Tema> listArgomento, long resourcePrimKey,
			long livello, List<String> links, List<String> labelLinks) {
		this.titolo = clearValue(titolo);
		this.descrizione = clearValue(descrizione);
		this.id = id;
		this.listArgomento = listArgomento;
		this.resourcePrimKey = resourcePrimKey;
		this.links = links;
		this.labelLinks = labelLinks;
		this.livello = livello;
	}
	
	/**
	 * Instantiates a new tema.
	 *
	 * @param titolo the titolo
	 * @param descrizione the descrizione
	 * @param areaPortale the area portale
	 * @param id the id
	 * @param listArgomento the list argomento
	 * @param resourcePrimKey the resource prim key
	 * @param livello the livello
	 * @param links the links
	 * @param labelLinks the label links
	 */
	public Tema(String titolo, String descrizione, String areaPortale, String id, List<Tema> listArgomento, long resourcePrimKey,
			long livello, List<String> links, List<String> labelLinks) {
		this.titolo = clearValue(titolo);
		this.descrizione = clearValue(descrizione);
		this.id = id;
		this.listArgomento = listArgomento;
		this.resourcePrimKey = resourcePrimKey;
		this.links = links;
		this.labelLinks = labelLinks;
		this.livello = livello;
		this.areaPortale = clearValue(areaPortale);
	}
	

	/**
	 * Gets the titolo.
	 *
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * Sets the titolo.
	 *
	 * @param titolo the new titolo
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Gets the descrizione.
	 *
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Sets the descrizione.
	 *
	 * @param descrizione the new descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the list argomento.
	 *
	 * @return the list argomento
	 */
	public List<Tema> getListArgomento() {
		return listArgomento;
	}

	/**
	 * Sets the list argomento.
	 *
	 * @param listArgomento the new list argomento
	 */
	public void setListArgomento(List<Tema> listArgomento) {
		this.listArgomento = listArgomento;
	}

	/**
	 * Gets the resource prim key.
	 *
	 * @return the resource prim key
	 */
	public long getResourcePrimKey() {
		return resourcePrimKey;
	}

	/**
	 * Sets the resource prim key.
	 *
	 * @param resourcePrimKey the new resource prim key
	 */
	public void setResourcePrimKey(long resourcePrimKey) {
		this.resourcePrimKey = resourcePrimKey;
	}

	/**
	 * Checks if is rispsota.
	 *
	 * @return true, if is rispsota
	 */
	public boolean isRispsota() {
		return isRispsota;
	}

	/**
	 * Sets the rispsota.
	 *
	 * @param isRispsota the new rispsota
	 */
	public void setRispsota(boolean isRispsota) {
		this.isRispsota = isRispsota;
	}

	/**
	 * Gets the links.
	 *
	 * @return the links
	 */
	public List<String> getLinks() {
		return links;
	}

	/**
	 * Sets the links.
	 *
	 * @param links the new links
	 */
	public void setLinks(List<String> links) {
		this.links = links;
	}

	/**
	 * Gets the label links.
	 *
	 * @return the label links
	 */
	public List<String> getLabelLinks() {
		return labelLinks;
	}

	/**
	 * Sets the label links.
	 *
	 * @param labelLinks the new label links
	 */
	public void setLabelLinks(List<String> labelLinks) {
		this.labelLinks = labelLinks;
	}

	/**
	 * Gets the livello.
	 *
	 * @return the livello
	 */
	public long getLivello() {
		return livello;
	}

	/**
	 * Sets the livello.
	 *
	 * @param livello the new livello
	 */
	public void setLivello(long livello) {
		this.livello = livello;
	}

	/**
	 * Gets the area portale.
	 *
	 * @return the area portale
	 */
	public String getAreaPortale() {
		return areaPortale;
	}

	/**
	 * Sets the area portale.
	 *
	 * @param areaPortale the new area portale
	 */
	public void setAreaPortale(String areaPortale) {
		this.areaPortale = areaPortale;
	}

	/**
	 * Convert to json.
	 *
	 * @return the JSON object
	 */
	public JSONObject convertToJson() {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		jsonObj.put("titolo", this.titolo);
		jsonObj.put("descrizione", this.descrizione);
		jsonObj.put("id", this.id);
		jsonObj.put("resourcePrimKey", this.resourcePrimKey);
		jsonObj.put("isRisposta", this.isRispsota);
		jsonObj.put("livello", this.livello);
		jsonObj.put("labelLinks", this.labelLinks);
		jsonObj.put("links", this.links);
		jsonObj.put("areaPortale", this.areaPortale);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		if(!getListArgomento().isEmpty())
		for (Tema tema : this.listArgomento) {
			jsonArray.put(tema.convertToJson());
		}
		jsonObj.put("listArgomento", jsonArray);
		
		return jsonObj;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.convertToJson().toJSONString();
	}

	/**
	 * Clear value.
	 *
	 * @param value the value
	 * @return the string
	 */
	private String clearValue(String value) {
		String val = "";
		if(Validator.isNotNull(value) ) {
			if(value.startsWith("_") )
				val = value.substring(1).trim();
			else
				val = value.trim();
		}
		return val;
	}

}
