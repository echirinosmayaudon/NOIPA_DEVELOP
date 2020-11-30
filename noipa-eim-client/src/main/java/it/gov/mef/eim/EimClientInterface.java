package it.gov.mef.eim;

import java.util.List;
import java.util.SortedMap;
// TODO: Auto-generated Javadoc

/**
 * The Interface EimClientInterface.
 *
 * @author d.brandi
 * @param <T> the generic type
 */
public interface EimClientInterface<T> {

	/**
	 *  metodi che utilizzano l'url come key per la cache *.
	 *
	 * @param urlMethod the url method
	 * @return the list
	 */
	public List<T> callEimClientForList(String urlMethod);
	
	/**
	 * Call eim client for object.
	 *
	 * @param urlMethod the url method
	 * @return the t
	 */
	public T callEimClientForObject(String urlMethod);
	
	/**
	 * Call eim client for list.
	 *
	 * @param urlMethod the url method
	 * @param parameter the parameter
	 * @return the list
	 */
	public List<T> callEimClientForList(String urlMethod, SortedMap<String, String> parameter);
	
	/**
	 * Call eim client for object.
	 *
	 * @param urlMethod the url method
	 * @param parameter the parameter
	 * @return the t
	 */
	public T callEimClientForObject(String urlMethod,SortedMap<String, String> parameter);
	
	/**
	 * Call eim client for array byte.
	 *
	 * @param urlMethod the url method
	 * @return the byte[]
	 */
	public byte[] callEimClientForArrayByte(String urlMethod);

	/**
	 *  metodi che utilizzano una key apposita differente dalla url *.
	 *
	 * @param key the key
	 * @param urlMethod the url method
	 * @return the list
	 */
	public List<T> callEimClientForList(String key,String urlMethod);
	
	/**
	 * Call eim client for object.
	 *
	 * @param key the key
	 * @param urlMethod the url method
	 * @return the t
	 */
	public T callEimClientForObject(String key,String urlMethod);
	
	/**
	 * Call eim client for list.
	 *
	 * @param key the key
	 * @param urlMethod the url method
	 * @param parameter the parameter
	 * @return the list
	 */
	public List<T> callEimClientForList(String key,String urlMethod, SortedMap<String, String> parameter);
	
	/**
	 * Call eim client for object.
	 *
	 * @param key the key
	 * @param urlMethod the url method
	 * @param parameter the parameter
	 * @return the t
	 */
	public T callEimClientForObject(String key,String urlMethod, SortedMap<String, String> parameter);
	
	/**
	 * Call eim client for array byte.
	 *
	 * @param key the key
	 * @param urlMethod the url method
	 * @return the byte[]
	 */
	public byte[] callEimClientForArrayByte(String key,String urlMethod);
	
	/**
	 * Clear cached key.
	 *
	 * @param key the key
	 */
	public void clearCachedKey(String key);
	
	/**
	 * Clear all cached elements.
	 */
	public void clearAllCachedElements();

}