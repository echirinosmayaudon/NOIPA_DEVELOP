package it.gov.mef.webformassistenza.noipa.http.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import org.apache.commons.text.StringEscapeUtils;

import it.gov.mef.webformassistenza.noipa.http.EsitoInvio;
import it.gov.mef.webformassistenza.noipa.http.HttpInternetCallResponseNoiPA;








// TODO: Auto-generated Javadoc
/**
 * The Class HttpInternetClientUtilNoiPA.
 */
public class HttpInternetClientUtilNoiPA {
	
	
	/** The log. */
	private static Log _log  = LogFactoryUtil.getLog(HttpInternetClientUtilNoiPA.class.getName());
	
	/**
	 * Clear response.
	 *
	 * @param responseContent the response content
	 * @return the string
	 */
	public static String clearResponse(String responseContent) {
		String appoz = responseContent.substring(responseContent.indexOf("<json>")+"<json>".length());
    	appoz = appoz.substring(0,appoz.indexOf("</json>"));
		return appoz;
	}
	
	/**
	 * Permette l'unescape di una stringa.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String unescapeHtml4(String input) {
		
		return StringEscapeUtils.unescapeHtml4(input);
	}
		
		/**
		 * Permette la conversione in JSON.
		 *
		 * @param <T> the generic type
		 * @param response the response
		 * @param valueType the value type
		 * @return the t
		 * @throws JsonParseException the json parse exception
		 * @throws JsonMappingException the json mapping exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
	 public static <T> T convert(HttpInternetCallResponseNoiPA response, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
		 _log.info(response.getData());
			String responseContent = clearResponse(response.getData());
			responseContent = StringEscapeUtils.unescapeHtml4(responseContent);		
			return  new ObjectMapper().readValue(responseContent,valueType);
	 }
	
	/**
	 * Converte la response in EsitoInvio.
	 *
	 * @param response the response
	 * @return the esito invio
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static EsitoInvio converEsito(HttpInternetCallResponseNoiPA response) throws JsonParseException, JsonMappingException, IOException {
		_log.info(response.getData());
		String responseContent = clearResponse(response.getData());
		responseContent = StringEscapeUtils.unescapeHtml4(responseContent);		
		return  new ObjectMapper().readValue(responseContent, EsitoInvio.class);		
	}
	
	
	
}
