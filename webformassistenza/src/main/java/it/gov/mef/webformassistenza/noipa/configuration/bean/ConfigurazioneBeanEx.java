package it.gov.mef.webformassistenza.noipa.configuration.bean;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurazioneBeanEx.
 */
public class ConfigurazioneBeanEx extends ConfigurazioneBean {
	
	/** The rif key. */
	private String rifKey;
	
	/** The extra. */
	private String extra;
	
	/**
	 * Instantiates a new configurazione bean ex.
	 */
	public ConfigurazioneBeanEx() {}
	
	/**
	 * Instantiates a new configurazione bean ex.
	 *
	 * @param key the key
	 * @param value the value
	 * @param rifKey the rif key
	 */
	public ConfigurazioneBeanEx(String key, String value, String rifKey) {
		super(key, value);
		this.rifKey = rifKey;
	}
	
	/**
	 * Instantiates a new configurazione bean ex.
	 *
	 * @param key the key
	 * @param value the value
	 * @param rifKey the rif key
	 * @param extra the extra
	 */
	public ConfigurazioneBeanEx(String key, String value, String rifKey,String extra) {
		super(key, value);
		this.rifKey = rifKey;
		this.extra=extra;
	}

	/**
	 * Gets the rif key.
	 *
	 * @return the rif key
	 */
	public String getRifKey() {
		return rifKey;
	}

	/**
	 * Sets the rif key.
	 *
	 * @param rifKey the new rif key
	 */
	public void setRifKey(String rifKey) {
		this.rifKey = rifKey;
	}

	/* (non-Javadoc)
	 * @see it.gov.mef.webformassistenza.noipa.configuration.bean.ConfigurazioneBean#toString()
	 */
	@Override
	public String toString() {
		String toString = super.toString()+" - ConfigurazioneBeanEx [rifKey=" + rifKey + "]";
		return toString;
	}
	
	
	

}
