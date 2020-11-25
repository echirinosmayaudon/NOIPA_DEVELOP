package it.gov.mef.webformassistenza.noipa.common.util;

// TODO: Auto-generated Javadoc
/**
 * The Enum ConfigurazioneENUM.
 */
public enum ConfigurazioneENUM {
	
	/** The mail config. */
	MAIL_CONFIG("mailconf"),
	
	/** The amministrazione. */
	AMMINISTRAZIONE("amministrazione"),
	
	/** The categoria utenti. */
	CATEGORIA_UTENTI("categoriautenti"),
	
	/** The area. */
	AREA("area"),
	
	/** The tematica. */
	TEMATICA("tematica"),
	
	/** The tipologia. */
	TIPOLOGIA("tipologia"),
	
	/** The home. */
	HOME("home"),
	
	/** The service. */
	SERVICE("service"),
	
	/** The content. */
	CONTENT("content");
	
	/** The descrizione. */
	private String descrizione;
	
	/**
	 * Gets the descrizione.
	 *
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Instantiates a new configurazione ENUM.
	 *
	 * @param descrizione the descrizione
	 */
	private ConfigurazioneENUM (String descrizione) {
		this.descrizione = descrizione;
	}
	
}
