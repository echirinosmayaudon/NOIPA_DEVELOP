package it.gov.mef.eim;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Classe per il passaggio dei parametri
 * di configurazione del client eim.
 */

/**
 * Instantiates a new eim client configuration dto.
 */
@Data
public class EimClientConfigurationDto {
	
	/** The host. */
	private String host;
	
	/** The path. */
	private String path;
	
	/** The use cache. */
	private boolean useCache;
	
	/** The refresh cache monthly. */
	private boolean refreshCacheMonthly;
	
	/** The refresh time. */
	private int refreshTime;
}
