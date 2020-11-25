package it.gov.mef.webformassistenza.noipa.http.serv;


import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import it.gov.mef.webformassistenza.noipa.http.HttpInternetCallResponseNoiPA;
import it.gov.mef.webformassistenza.noipa.http.util.FileAttachmentNoiPA;



// TODO: Auto-generated Javadoc
/**
 * The Interface HttpInternetClientService.
 */
public interface HttpInternetClientService {
	
	/**
	 * Permette una chiamata in GET con basic auth.
	 *
	 * @param url the url
	 * @param method the method
	 * @param params the params
	 * @param username the username
	 * @param password the password
	 * @param authenticate the authenticate
	 * @return the http internet call response noi PA
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyStoreException the key store exception
	 */
	public  HttpInternetCallResponseNoiPA get(String url,String method,Map<String,String> params,String username,String password,boolean authenticate) throws URISyntaxException,IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException;
	
	/**
	 * Permette una chiamata in GET.
	 *
	 * @param url the url
	 * @param method the method
	 * @param params the params
	 * @return the http internet call response noi PA
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyStoreException the key store exception
	 */
	public  HttpInternetCallResponseNoiPA get(String url,String method,Map<String,String> params) throws URISyntaxException,IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException;
	
	/**
	 * Permette una chiamata in POST con basic auth.
	 *
	 * @param url the url
	 * @param method the method
	 * @param params the params
	 * @param username the username
	 * @param password the password
	 * @param authenticate the authenticate
	 * @return the http internet call response noi PA
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyStoreException the key store exception
	 */
	public  HttpInternetCallResponseNoiPA post(String url,String method,Map<String,String> params,String username,String password,boolean authenticate) throws URISyntaxException,IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException;
	
	/**
	 * Permette una chiamata in POST.
	 *
	 * @param url the url
	 * @param method the method
	 * @param params the params
	 * @return the http internet call response noi PA
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyStoreException the key store exception
	 */
	public  HttpInternetCallResponseNoiPA post(String url,String method,Map<String,String> params) throws URISyntaxException,IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException;
	
	/**
	 * Permette una chiamata in POSTMultipart.
	 *
	 * @param url the url
	 * @param method the method
	 * @param multiparts the multiparts
	 * @param username the username
	 * @param password the password
	 * @param authenticate the authenticate
	 * @return the http internet call response noi PA
	 * @throws URISyntaxException the URI syntax exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyStoreException the key store exception
	 */
	public  HttpInternetCallResponseNoiPA postMultipart(String url,String method,Map<String,FileAttachmentNoiPA> multiparts, String username,String password,boolean authenticate) throws URISyntaxException,IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException;
	
	
}
