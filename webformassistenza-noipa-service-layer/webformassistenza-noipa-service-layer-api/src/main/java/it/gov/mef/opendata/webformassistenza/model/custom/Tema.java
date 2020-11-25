package it.gov.mef.opendata.webformassistenza.model.custom;

import com.liferay.portal.kernel.util.Validator;

import java.util.List;


public class Tema {

	private String titolo;
	private String descrizione;
	private String id;
	private List<Tema> listArgomento;
	private long resourcePrimKey;// risposta
	private boolean isRispsota;
	private List<String> links;
	private List<String> labelLinks;
	private long livello;

	public Tema(String titolo, String descrizione, String id, List<Tema> listArgomento, long resourcePrimKey) {

	}

	public Tema(String titolo, String descrizione, String id, List<Tema> listArgomento, long resourcePrimKey,
			long livello) {
		this.titolo = clearValue(titolo);
		this.descrizione = clearValue(descrizione);
		this.id = id;
		this.listArgomento = listArgomento;
		this.resourcePrimKey = resourcePrimKey;
		this.livello = livello;
	}

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

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Tema> getListArgomento() {
		return listArgomento;
	}

	public void setListArgomento(List<Tema> listArgomento) {
		this.listArgomento = listArgomento;
	}

	public long getResourcePrimKey() {
		return resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		this.resourcePrimKey = resourcePrimKey;
	}

	public boolean isRispsota() {
		return isRispsota;
	}

	public void setRispsota(boolean isRispsota) {
		this.isRispsota = isRispsota;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

	public List<String> getLabelLinks() {
		return labelLinks;
	}

	public void setLabelLinks(List<String> labelLinks) {
		this.labelLinks = labelLinks;
	}

	public long getLivello() {
		return livello;
	}

	public void setLivello(long livello) {
		this.livello = livello;
	}

	@Override
	public String toString() {

//		String toString = titolo + " - " + descrizione + " - " + id + " - " + resourcePrimKey + " - " + livello + " - "
//				+ links + " - " + labelLinks + " - " + isRispsota + "";
		String toString = livello + ". " +titolo + " - " + id + " - " + resourcePrimKey + " - "
				+ links + " - " + labelLinks + " - " + isRispsota + "";
		return toString;
		// return "Tema [titolo=" + titolo + ", descrizione=" + descrizione + ", id=" +
		// id + ", resourcePrimKey="
		// + resourcePrimKey + ", isRispsota=" + isRispsota + "]";
	}
	
	
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
