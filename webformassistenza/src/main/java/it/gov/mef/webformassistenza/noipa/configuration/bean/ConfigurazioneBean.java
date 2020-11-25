package it.gov.mef.webformassistenza.noipa.configuration.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurazioneBean.
 */
public class ConfigurazioneBean {
	
	/** The key. */
	private String key;
	
	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new configurazione bean.
	 */
	public ConfigurazioneBean() {}


	/**
	 * Instantiates a new configurazione bean.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public ConfigurazioneBean(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{key:\"" + key + "\", value:\"" + value + "\"}";
	}
}
