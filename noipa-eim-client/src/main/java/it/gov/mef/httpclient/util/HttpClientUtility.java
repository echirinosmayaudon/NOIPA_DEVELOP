package it.gov.mef.httpclient.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtility {
	private static Log _log=LogFactoryUtil.getLog(HttpClientUtility.class);
	
	/**
	 * Metodo che fa una chiamata rest HttpGet
	 * @param url
	 * @param token
	 * @return
	 */
	public static String callRestService(URI url, String token) {
		String responseEntity="";
		
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			HttpGet httpGet = new HttpGet(url);
			httpGet.addHeader("Content-Type", "application/json");
			httpGet.addHeader("accept", "application/json");
			httpGet.addHeader("user-key", token);
			
			HttpResponse response = httpclient.execute(httpGet);
		
			int status = response.getStatusLine().getStatusCode();
			_log.info("Http client status response "+status);
			
	        if (status >= 200 && status < 300) {
	            HttpEntity entity = response.getEntity();

	            if( Validator.isNotNull(entity)) {
	            	responseEntity= EntityUtils.toString(entity);
	            }
	        
	        }
			httpclient.close();	
		}catch (Exception e) {
			_log.error("Client http Error: "+e);
		}
		return responseEntity;
	}
	
	/**
	 * Metodo che fa una chiamata rest HttpGet
	 * @param url
	 * @param token
	 * @return
	 */
	public static byte[] callRestGetArrayBytes(URI url, String token) {
		byte[] responseEntity=null;
		
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			HttpGet httpGet = new HttpGet(url);
			httpGet.addHeader("Content-Type", "application/octet-stream");
			//httpGet.addHeader("accept", "application/json");
			httpGet.addHeader("user-key", token);
			
			HttpResponse response = httpclient.execute(httpGet);
		
			int status = response.getStatusLine().getStatusCode();
			_log.info("Http client status "+status);
			
	        if (status >= 200 && status < 300) {
	            HttpEntity entity = response.getEntity();

	            if( Validator.isNotNull(entity)) {
	            	responseEntity= EntityUtils.toByteArray(entity);
	            	
	            	_log.info("byte[]: "+responseEntity);
	            }
	        
	        }
			httpclient.close();	
		}catch (Exception e) {
			_log.error("Client http Error: "+e);
		}
		return responseEntity;
	}
	
	/**
	 * Metodo per fare mapping da json to genericObjects
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T mappingObject(String json,Class<T> clazz) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		T genericObject=null;		
		
		try {
			if(clazz.getName().equals("java.lang.String")) {
				_log.info("Sono string");
				genericObject=(T) json;
			}else {
				genericObject=objectMapper.readValue(json, clazz);
			}
		} catch (Exception e) {
			_log.error("Mapping genericObject Error: "+e);
		}

		return genericObject;
	}
	
}
