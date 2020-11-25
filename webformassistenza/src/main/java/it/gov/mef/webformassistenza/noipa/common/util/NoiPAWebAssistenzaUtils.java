package it.gov.mef.webformassistenza.noipa.common.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.portlet.PortletRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class NoiPAWebAssistenzaUtils.
 */
public class NoiPAWebAssistenzaUtils {

	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(NoiPAWebAssistenzaUtils.class);
	
	/**
	 * Verifica se la configurazione della portlet è valida.
	 *
	 * @param serviceUrl the service url
	 * @param sendMethod the send method
	 * @param chechMethod the chech method
	 * @param userId the user id
	 * @param password the password
	 * @param token the token
	 * @param idWebContentTema the id web content tema
	 * @param idWebContentRisposta the id web content risposta
	 * @param configurazioneENUM the configurazione ENUM
	 * @return true, if is valid
	 */
	public static boolean isValid(String serviceUrl, String sendMethod, String chechMethod,
			String userId, String password, String token,
			String idWebContentTema, String idWebContentRisposta,
			ConfigurazioneENUM configurazioneENUM) {
		boolean isValid = false;
		
		switch (configurazioneENUM) {
		case SERVICE:
			isValid = Validator.isNotNull(serviceUrl) && Validator.isNotNull(sendMethod) && Validator.isNotNull(chechMethod) &&
					Validator.isNotNull(userId) && Validator.isNotNull(password) && Validator.isNotNull(token);
		case CONTENT:
			isValid = Validator.isNotNull(idWebContentTema) && Validator.isNotNull(idWebContentRisposta);
			break;
		}
		_log.info(configurazioneENUM.getDescrizione()+": "+isValid);
		return isValid;
	}
	
	/**
	 * Verifica se la configurazione della portlet è valida.
	 *
	 * @param mailconfigMail the mailconfig mail
	 * @param mailconfigNominativo the mailconfig nominativo
	 * @param mailconfigMailHp the mailconfig mail hp
	 * @param linkAmministrazione the link amministrazione
	 * @param listaCategoriaUtenti the lista categoria utenti
	 * @param listaArea the lista area
	 * @param listaTematica the lista tematica
	 * @param listaTipologia the lista tipologia
	 * @param configurazioneENUM the configurazione ENUM
	 * @return true, if is valid
	 */
	public static boolean isValid(String mailconfigMail, String mailconfigNominativo, String mailconfigMailHp,
			String linkAmministrazione , List<?> listaCategoriaUtenti, List<?> listaArea, 
			List<?> listaTematica, List<?> listaTipologia, 
			ConfigurazioneENUM configurazioneENUM) {
		
		boolean isValid = false;
		
		switch (configurazioneENUM) {
		case MAIL_CONFIG:
			isValid = true;
		case AMMINISTRAZIONE:
			isValid = Validator.isNotNull(mailconfigMail) && Validator.isNotNull(mailconfigNominativo) && Validator.isNotNull(mailconfigMailHp);
			break;
		case CATEGORIA_UTENTI:
			isValid = Validator.isNotNull(mailconfigMail) && Validator.isNotNull(mailconfigNominativo) && Validator.isNotNull(mailconfigMailHp) &&
					  Validator.isNotNull(linkAmministrazione);
			break;
		case AREA:
			isValid = Validator.isNotNull(mailconfigMail) && Validator.isNotNull(mailconfigNominativo) && Validator.isNotNull(mailconfigMailHp) && 
					  Validator.isNotNull(linkAmministrazione) && (listaCategoriaUtenti != null && listaCategoriaUtenti.size()>0);
			break;
		case TEMATICA:
			isValid = Validator.isNotNull(mailconfigMail) && Validator.isNotNull(mailconfigNominativo) && Validator.isNotNull(mailconfigMailHp) && 
					  Validator.isNotNull(linkAmministrazione) && (listaCategoriaUtenti != null && listaCategoriaUtenti.size()>0) && (listaArea != null && listaArea.size()>0) ;
			break;
		case TIPOLOGIA:
			isValid = Validator.isNotNull(mailconfigMail) && Validator.isNotNull(mailconfigNominativo) && Validator.isNotNull(mailconfigMailHp) && 
					  Validator.isNotNull(linkAmministrazione) && (listaCategoriaUtenti != null && listaCategoriaUtenti.size()>0) && (listaArea != null && listaArea.size()>0) && (listaTematica != null && listaTematica.size()>0) ;
			break;
		case HOME:
			isValid = Validator.isNotNull(mailconfigMail) && Validator.isNotNull(mailconfigNominativo) && Validator.isNotNull(mailconfigMailHp) && 
					  Validator.isNotNull(linkAmministrazione) && (listaCategoriaUtenti != null && listaCategoriaUtenti.size()>0) && (listaArea != null && listaArea.size()>0) && (listaTematica != null && listaTematica.size()>0) && (listaTipologia != null && listaTipologia.size()>0) ;
			break;
		}
		
		_log.info(configurazioneENUM.getDescrizione()+": "+isValid);
		return isValid;
	}
	
	
	
		/**
		 * Genera un UUID valido .
		 *
		 * @return the string
		 */
	    public static String generateString() {
	        String uuid = UUID.randomUUID().toString().toUpperCase().substring(0,5);
	        return uuid;
	    }
	
	
	    /**
    	 * Provvede ad eliminare caratteri non validi in una stringa.
    	 *
    	 * @param value the value
    	 * @return the string
    	 */
		public static String clearValue(String value) {
			String val = "";
			if(Validator.isNotNull(value) ) {
				if(value.startsWith("_") )
					val = value.substring(1).trim();
				else
					val = value.trim();
			}
			return val;
		}
	
	/**
	 * Nasconde i messaggi di default di lifera.
	 *
	 * @param portletRequest the portlet request
	 */
	public static void hiddenDefaultMessage(PortletRequest portletRequest){
		SessionMessages.add(portletRequest, PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionMessages.add(portletRequest, PortalUtil.getPortletId(portletRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	
	/**
	 * Verifica se un oggetto è valido .
	 *
	 * @param object the object
	 * @return true, if is valid
	 */
	public static boolean isValid(Object object) {
		boolean isValid = false;
		if(object instanceof String) {
			String param = (String)object;
			isValid = (param == null || "".equals(param));
		} else if(object instanceof String[]) {
			String [] params = (String[])object;
			isValid = (params == null || params.length<=0);
		} else if(object instanceof List<?> ) {
			List<?> params = (List<?>)object;
			isValid = (params != null && params.size()>0);
		}
			
		return isValid;
	}
	
	
	/** The Constant VALID_EMAIL_ADDRESS_REGEX. */
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.]+$", Pattern.CASE_INSENSITIVE);
	
	/** The Constant VALID_CHECK_MAIL. */
	private static final Pattern VALID_CHECK_MAIL = 
		    Pattern.compile("^sid=[A-Za-z0-9]*&idUtenteRic=[0-9]*$", Pattern.CASE_INSENSITIVE);
	
	/**
	 * Permette di verificare se:
	 * 	- una mail è formalmente valida
	 *  - il codice di verifica dell'assistenza è valido .
	 *
	 * @param toCheck the to check
	 * @param type the type
	 * @return true, if successful
	 */
	public static boolean validate(String toCheck, int type) {
		_log.info("verifico la stringa: "+toCheck+" - type: "+type );
				Matcher matcher = null;
				
				if( type == 0 ) {
					matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(toCheck);
				} else if (type == 1 ) {
					matcher = VALID_CHECK_MAIL .matcher(toCheck);
				}
				boolean status = matcher!=null?matcher.find():false; 
				_log.info("status: "+status);
		        return status;
	}
	
	
	
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
//	public static final String secret = "6LdQp6QUAAAAAGhyvrTuElzDA2I_qNGXMUTlFkUb";
	private final static String USER_AGENT = "Mozilla/5.0";

	public static boolean verify(String gRecaptchaResponse, String secret) throws IOException {
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
			return false;
		}
		
		try{
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String postParams = "secret=" + secret + "&response="
				+ gRecaptchaResponse;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		_log.info("\nSending 'POST' request to URL : " + url);
		_log.info("Post parameters : " + postParams);
		_log.info("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		_log.info(response.toString());
		
		//parse JSON response and return 'success' value
		
		String json = response.toString();
		
		_log.info("json: "+json);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(json);
		
		
		return jsonObject.getBoolean("success");
		}catch(Exception e){
			_log.error(e.getMessage());
			return false;
		}
	}
	
	
}
