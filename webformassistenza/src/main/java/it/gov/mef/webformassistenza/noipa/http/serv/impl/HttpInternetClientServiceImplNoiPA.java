package it.gov.mef.webformassistenza.noipa.http.serv.impl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;

import it.gov.mef.webformassistenza.noipa.http.HttpInternetCallResponseNoiPA;
import it.gov.mef.webformassistenza.noipa.http.serv.HttpInternetClientService;
import it.gov.mef.webformassistenza.noipa.http.util.FileAttachmentNoiPA;
import it.gov.mef.webformassistenza.noipa.http.util.HttpRequestMethodNoiPA;



// TODO: Auto-generated Javadoc
/**
 * The Class HttpInternetClientServiceImplNoiPA.
 */
public class HttpInternetClientServiceImplNoiPA implements HttpInternetClientService {
	
	/** The log. */
	private static Log _log  = LogFactoryUtil.getLog(HttpInternetClientServiceImplNoiPA.class.getName());
	
	
	
	




	/* (non-Javadoc)
	 * @see it.gov.mef.webformassistenza.noipa.http.serv.HttpInternetClientService#get(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public HttpInternetCallResponseNoiPA get(String url, String method, Map<String, String> params, String username,	String password, boolean authenticate) throws URISyntaxException, IOException, KeyManagementException,
			NoSuchAlgorithmException, KeyStoreException {
		return executeCall(url, method, HttpRequestMethodNoiPA.GET, params, username, password, true);
	}




	/* (non-Javadoc)
	 * @see it.gov.mef.webformassistenza.noipa.http.serv.HttpInternetClientService#get(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public HttpInternetCallResponseNoiPA get(String url, String method, Map<String, String> params)
			throws URISyntaxException, IOException, KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException {
		// TODO Auto-generated method stub
		return get(url,method,params,null,null,false);
	}




	/* (non-Javadoc)
	 * @see it.gov.mef.webformassistenza.noipa.http.serv.HttpInternetClientService#post(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public HttpInternetCallResponseNoiPA post(String url, String method, Map<String, String> params, String username,String password, boolean authenticate) throws URISyntaxException, IOException, KeyManagementException,NoSuchAlgorithmException, KeyStoreException {
		return executeCall(url, method, HttpRequestMethodNoiPA.POST, params, username, password, authenticate);

	}

	/* (non-Javadoc)
	 * @see it.gov.mef.webformassistenza.noipa.http.serv.HttpInternetClientService#post(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public HttpInternetCallResponseNoiPA post(String url, String method, Map<String, String> params)	throws URISyntaxException, IOException, KeyManagementException, NoSuchAlgorithmException,KeyStoreException {		
		return post(url, method,  params, null, null, false);
			}
	
	/**
	 * Execute call.
	 *
	 * @param url the url
	 * @param urlMethodName the url method name
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
	private HttpInternetCallResponseNoiPA executeCall(String url, String urlMethodName,HttpRequestMethodNoiPA method, Map<String, String> params,  String username,String password, boolean authenticate) throws URISyntaxException, IOException, KeyManagementException, NoSuchAlgorithmException,
	KeyStoreException {
		method = method==null?HttpRequestMethodNoiPA.GET:method;
		HttpInternetCallResponseNoiPA response = new HttpInternetCallResponseNoiPA();
		CloseableHttpClient httpclient = null;
		response.setCode(-1);
		
		URIBuilder uri = new URIBuilder()
		        .setScheme(url.substring(0, url.indexOf("://")))
		        .setHost(url.substring(url.indexOf("://")+3))
		        .setPath(String.format("/%s",urlMethodName));
		
//		List<NameValuePair> _params = (params!=null)?
//				params.entrySet()
//				.stream()
//				.map( e -> new BasicNameValuePair(e.getKey(),e.getValue()))
//				.collect(Collectors.toList()):
//					new ArrayList<NameValuePair>();
				
		StringEntity requestEntity = null;
		List<NameValuePair> _params  = new ArrayList<NameValuePair>();
		JSONObject json = null;
		if(params!= null && params.size()>0) {
			
			json = JSONFactoryUtil.createJSONObject();
//			NameValuePair nameValuePair1 = new BasicNameValuePair("idUtenteRic", params.get("idUtenteRic"));
//			NameValuePair nameValuePair = new BasicNameValuePair("json", json.toJSONString());
//			_params.add(nameValuePair);
			
			json.put("sid", params.get("sid"));
			json.put("idUtenteRic", params.get("idUtenteRic"));

			
			
			requestEntity = new StringEntity(
					json.toJSONString(),
				    ContentType.APPLICATION_JSON);
			
		}
		
		
		

		_log.info("Parms: "+params);
		_log.info("Json:  "+json);
		
		 
		httpclient = getClient(username, password, authenticate);		 
		
		//httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		switch (method) {
		case POST:
			_log.info("PAASING INTO POST --->"+method);
//			_log.info("PARAMS BEFORE --->"+_params);
			HttpPost prequest = new HttpPost(uri.build());
			
			
			
//			UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(_params,"UTF-8");
//			encodedFormEntity.setContentType("application/json");
			prequest.setEntity(requestEntity);
			//prequest.setEntity(new UrlEncodedFormEntity(_params));
			
			prequest.addHeader("Content-Type", "application/json");
			
			_log.info("CALL HTTP METHOD --->"+method);
			_log.info("URI --->"+prequest.getURI().toString());
			_log.info("PARAMS --->"+_params);
			try (CloseableHttpResponse resp = httpclient.execute(prequest)) {
				String returnx = IOUtils.toString(resp.getEntity().getContent(),"UTF-8");
				response.setCode(resp.getStatusLine().getStatusCode());
				response.setData(returnx);
			}
			break;
		default:
			_log.info("CALL HTTP METHOD --->"+method);
			uri.addParameters(_params);
			
			HttpGet grequest = new HttpGet();
			grequest.setURI(uri.build());
			
			_log.info("CALL HTTP METHOD --->"+method);
			_log.info("URI --->"+grequest.getURI().toString());
			_log.info("PARAMS --->"+grequest.getParams());
			try (CloseableHttpResponse resp = httpclient.execute(grequest)) {
				String returnx = IOUtils.toString(resp.getEntity().getContent(),"UTF-8");
				response.setCode(resp.getStatusLine().getStatusCode());
				response.setData(returnx);
			}
		
			break;
		}
		
		
		
		_log.info("RESPONSE --->"+response);
		return response;

	}




	/**
	 * Gets the client.
	 *
	 * @param username the username
	 * @param password the password
	 * @param authenticate the authenticate
	 * @return the client
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyManagementException the key management exception
	 * @throws KeyStoreException the key store exception
	 */
	private CloseableHttpClient getClient(String username, String password, boolean authenticate)
			throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
		CloseableHttpClient httpclient;
		if(authenticate) {
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials
		 = new UsernamePasswordCredentials(username, password);
		provider.setCredentials(AuthScope.ANY, credentials);
		_log.info("credentials: "+credentials.toString());
		_log.info("credentials: "+credentials.getPassword());
		_log.info("credentials: "+credentials.getUserName());
		_log.info("credentials: "+credentials.getUserPrincipal());
		httpclient = HttpClientBuilder.create().setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
	            .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).setDefaultCredentialsProvider(provider).build();
		
		
		}else {	
			httpclient = HttpClientBuilder.create().setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
	            .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
		}
		
		return httpclient;
	}




	/* (non-Javadoc)
	 * @see it.gov.mef.webformassistenza.noipa.http.serv.HttpInternetClientService#postMultipart(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public HttpInternetCallResponseNoiPA postMultipart(String url, String urlMethodName, Map<String, FileAttachmentNoiPA> multiparts, String username, String password, boolean authenticate)
			throws URISyntaxException, IOException, KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException {
		HttpInternetCallResponseNoiPA response = new HttpInternetCallResponseNoiPA();
		CloseableHttpClient httpclient = null;
		response.setCode(-1);
		
		URIBuilder uri = new URIBuilder()
		        .setScheme(url.substring(0, url.indexOf("://")))
		        .setHost(url.substring(url.indexOf("://")+3))
		        .setPath(String.format("/%s",urlMethodName));
		
		/*
		List<NameValuePair> _params = (params!=null)?
				params.entrySet()
				.stream()
				.map( e -> new BasicNameValuePair(e.getKey(),e.getValue()))
				.collect(Collectors.toList()):
					new ArrayList<NameValuePair>();
		

		_log.info(params);
		*/
		 
		httpclient = getClient(username, password, authenticate);		 
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		for(String key: multiparts.keySet()) {
			FileAttachmentNoiPA obj = multiparts.get(key);
			builder.addBinaryBody(key, obj.getContent(),ContentType.create(obj.getMimeType()), obj.getFileName());
		}
		
		//httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		//org.apache.http.client.entity.mime
		
			
			HttpPost prequest = new HttpPost(uri.build());
			//Http
			
			
			prequest.setEntity(builder.build());
			//prequest.setEntity(new UrlEncodedFormEntity(_params));
			
			prequest.addHeader("Content-Type", "multipart/form-data; charset=utf-8");
			
			_log.info("URI --->"+prequest.getURI().toString());
			
			try (CloseableHttpResponse resp = httpclient.execute(prequest)) {
				String returnx = IOUtils.toString(resp.getEntity().getContent(),"UTF-8");
				response.setCode(resp.getStatusLine().getStatusCode());
				response.setData(returnx);
		
		
		
		}
		
		
		
		_log.info("RESPONSE --->"+response);
		return response;

	}








	

	


	
	
	
	
	
	

}