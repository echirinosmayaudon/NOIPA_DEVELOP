package it.gov.mef.eim;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// TODO: Auto-generated Javadoc
/**
 * Classe che si interfaccia con un generico client rest
 * con la possibilità di usare una cache configurabile
 * sia sulla scelta di usarla o no sia sui giorni 
 * di validità dei dati nella cache.
 * La classe è generica e prende come input la classe che 
 * matcha il tipo di ritorno dove andranno messi i dati di output
 * delle chiamate
 *
 * @author d.brandi
 * @param <T> the generic type
 */
public class EimClient<T extends Serializable> implements EimClientInterface<T> {

	/** The Constant CACHE_NAME. */
	private static final String CACHE_NAME = "NoiPaCache";

	/** The clazz. */
	protected Class<T> clazz;

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
	
	/** The private token for rest service*/
	
	private String token;

	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(EimClient.class);
	
	/**
	 * Instantiates a new eim client.
	 *
	 * @param clazz the clazz
	 * @param config the config
	 */
	public EimClient(Class<T> clazz,EimClientConfigurationDto config) {
		super();
		this.clazz = clazz;
		if(config!=null) {
			
			this.host = config.getHost();	
			this.path = config.getPath();
			this.useCache = config.isUseCache();
			this.refreshCacheMonthly = config.isRefreshCacheMonthly();
			this.token=setToken();
			
			if(!this.refreshCacheMonthly) {
				//converto il parametro che mi arriva in giorni riportandolo in secondi
				if(refreshTime > 0) {
					this.refreshTime = config.getRefreshTime() * (int)(Time.DAY / Time.SECOND);
				}
				else {
					this.refreshTime = 365 * (int)(Time.DAY / Time.SECOND);
				}
				
			}
		}
	}
	
	/**
	 * Gets the refresh time.
	 *
	 * @return the refresh time
	 */
	public int getRefreshTime() {
		if(refreshCacheMonthly) {
			return DateUtility.getRemainingDaysOfMonth();
		}
		else {
			return refreshTime;
		}

	}
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClient(java.lang.String)
	 */
	@Override
	public List<T> callEimClientForList(String urlMethod) {
		return callEimClientForList(urlMethod, urlMethod);
	}
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClient(java.lang.String)
	 */
	@Override
	public T callEimClientForObject(String urlMethod) {
		return callEimClientForObject(null, urlMethod);
	}
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClient(java.lang.String, java.lang.String)
	 */
	@Override
	public List<T> callEimClientForList(String key,String urlMethod) {
		return callEimClientForList(key, urlMethod, null);
	}
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClient(java.lang.String, java.lang.String)
	 */
	@Override
	public T callEimClientForObject(String key,String urlMethod) {
		return callEimClientForObject(key, urlMethod,null);
	}
	
	/**
	 * Gets the cache value if valid.
	 *
	 * @param key the key
	 * @return the cache value if valid
	 */
	private Serializable getCacheValueIfValid(String key) {
		return MultiVMPoolUtil.getPortalCache(CACHE_NAME).get(key);
	}
	
	/**
	 * Put on cache.
	 *
	 * @param key the key
	 * @param response the response
	 */
	private void putOnCache(String key,Object response) {
		
		
		
		MultiVMPoolUtil.getPortalCache(CACHE_NAME).put(key,(Serializable) response,getRefreshTime());
		_log.info("Key: "+key+" - Size: "+MultiVMPoolUtil.getPortalCache(CACHE_NAME).getKeys().size());
	}
	
	/**
	 * Call rest service for list.
	 *
	 * @param url the url
	 * @return the list
	 */
	private List<T> callRestServiceForList(URI url) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<T[]> responseEntityArray = restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), getArrayClass(clazz));
	 	_log.info("Body della risposta "+responseEntityArray.getBody());
		//ResponseEntity<T[]> responseEntityArray = restTemplate.getForEntity(url, getArrayClass(clazz));

		return Arrays.asList(responseEntityArray.getBody());
	}
	
	/**
	 * Call rest service for object.
	 *
	 * @param url the url
	 * @return the t
	 */
	private T callRestServiceForObject(URI url) {
		
			RestTemplate restTemplate = new RestTemplate();
			
        	ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), clazz);
        		
        	_log.info("Body della risposta "+response.getBody());
		//ResponseEntity<T> response = restTemplate.getForEntity(url, clazz);
		return response.getBody();
	}
	
	/**
	 * Gets the url.
	 *
	 * @param host the host
	 * @param path the path
	 * @param method the method
	 * @return the url
	 */
	public static URI getUrl(String host, String path, String method) {
		return getUrl(host, path, method, null);
	}
	
	/**
	 * Gets the url.
	 *
	 * @param host the host
	 * @param path the path
	 * @param method the method
	 * @param parameter the parameter
	 * @return the url
	 */
	public static URI getUrl(String host, String path, String method, SortedMap<String, String> parameter) {
			
		UriComponentsBuilder uri = UriComponentsBuilder.fromUriString(host).path(path+"/"+method);
		if(parameter!=null && !parameter.isEmpty()) {
			for(Map.Entry<String,String> parameterEntry: parameter.entrySet()) {
				uri.queryParam(parameterEntry.getKey(), parameterEntry.getValue());
			}
		}
		return uri.build().encode().toUri();
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClientForArrayByte(java.lang.String)
	 */
	@Override
	public byte[] callEimClientForArrayByte(String urlMethod) {
		return callEimClientForArrayByte(urlMethod, urlMethod);
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClientForArrayByte(java.lang.String, java.lang.String)
	 */
	@Override
	public byte[] callEimClientForArrayByte(String key,String urlMethod) {
		byte[] response = null;
		if(useCache) {
			response = (byte[])getCacheValueIfValid(key);
		}
		if(response==null) {

			response = callRestServiceForArrayByte(urlMethod);
			if(useCache) {
				putOnCache(key, response);
			}
		}
		return response;
	}
	
	/**
	 * Call rest service for array byte.
	 *
	 * @param urlMethod the url method
	 * @return the byte[]
	 */
	private byte[] callRestServiceForArrayByte(String urlMethod) {
		RestTemplate restTemplate = new RestTemplate();
		URI url = getUrl(host, path, urlMethod);
		ResponseEntity<byte[]> response =(ResponseEntity<byte[]>) restTemplate.exchange(url, HttpMethod.GET, getHttpEntity(), clazz);
    	_log.info("Body della risposta "+response.getBody());		
		//ResponseEntity<byte[]> response = (ResponseEntity<byte[]>) restTemplate.getForEntity(url, clazz);
		return response.getBody();
	}
	
	/**
	 * Gets the array class.
	 *
	 * @param <T> the generic type
	 * @param clazz the clazz
	 * @return the array class
	 */
	@SuppressWarnings("unchecked")
	static <T> Class<T[]> getArrayClass(Class<T> clazz) {
	    return (Class<T[]>) Array.newInstance(clazz, 0).getClass();
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClientForList(java.lang.String, java.util.SortedMap)
	 */
	@Override
	public List<T> callEimClientForList(String urlMethod, SortedMap<String, String> parameter) {
		return callEimClientForList(urlMethod, urlMethod,parameter);
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClientForList(java.lang.String, java.lang.String, java.util.SortedMap)
	 */
	@Override
	public List<T> callEimClientForList(String key, String urlMethod, SortedMap<String, String> parameter) {
		URI url = getUrl(host, path, urlMethod);
		if(key==null) {
			key = url.toString();
		}
		_log.info("requested url: " + url.toString());
		List<T> response = getCacheValueForList(key);

		if(response==null) {
			_log.info("cache empty calling external service url: " + url.toString());
			response = callRestServiceForList(url);
			_log.info("response data returned from external service");
			if(useCache) {
				_log.info("saving data on cache");
				putOnCache(key, response);
			}
		}
		else {
			_log.info("response data returned from cache");
		}
		return response;
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClientForObject(java.lang.String, java.util.SortedMap)
	 */
	@Override
	public T callEimClientForObject(String urlMethod, SortedMap<String, String> parameter) {
		return callEimClientForObject(null,urlMethod,parameter);
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#callEimClientForObject(java.lang.String, java.lang.String, java.util.SortedMap)
	 */
	@Override
	public T callEimClientForObject(String key,String urlMethod, SortedMap<String, String> parameter) {
		URI url = getUrl(host, path, urlMethod,parameter);
		if(key==null) {
			key = url.toString();
		}
		_log.info("requested url: " + url.toString());
		T response = getCacheValueForObject(key);
		
		if(response==null) {
			_log.info("data not founded on cache. Calling external service url: " + url.toString());
			response = callRestServiceForObject(url);
			_log.info("response data returned from external service");
			if(useCache) {
				_log.info("saving data on cache");
				putOnCache(key, response);
			}
		}
		else {
			_log.info("response data returned from cache");
		}
		return response;
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#clearCachedKey(java.lang.String)
	 */
	@Override
	public void clearCachedKey(String key) {
		MultiVMPoolUtil.getPortalCache(CACHE_NAME).remove(key);
		
	}
	
	/* (non-Javadoc)
	 * @see it.gov.mef.eim.EimClientInterface#clearAllCachedElements()
	 */
	@Override
	public void clearAllCachedElements() {
		MultiVMPoolUtil.getPortalCache(CACHE_NAME).removeAll();
	}

	/**
	 * Gets the cache value for list.
	 *
	 * @param key the key
	 * @return the cache value for list
	 */
	private List<T> getCacheValueForList(String key) {
		List<T> response = null;
		if(useCache) {
			response = (List<T>)getCacheValueIfValid(key);
		}
		return response;
	}
	
	/**
	 * Gets the cache value for object.
	 *
	 * @param key the key
	 * @return the cache value for object
	 */
	private T getCacheValueForObject(String key) {
		T response = null;
		if(useCache) {
			response = (T)getCacheValueIfValid(key);
		}
		return response;
	}
	/**Metodo che recupera il token dal portal-ext.properties altrimenti prende un value per default
	 * 
	 */
	private String setToken() {
		String tempToken= PropsUtil.get("noipa.eim.client.token");
		return (Validator.isNotNull(tempToken))?tempToken: "8shqmeba1bfglh8gyao5sqy30q0jwy5x";
	}
	
	/**
	 * Metodo che setta gli headers all'interno di un HttpEntity object partendo dalla Map dei headers
	 * @return
	 */
	private HttpEntity<String> getHttpEntity(Map<String,String> mapHeaders) {
		HttpHeaders headers = new HttpHeaders();
		
		for(String key: mapHeaders.keySet()) {
			headers.add(key, mapHeaders.get(key));
		}
		
		HttpEntity<String> httpEntityReq = new HttpEntity<String>(headers);
		
		return httpEntityReq;
	}
	
	/**
	 * Metodo che setta gli headers all'interno di un HttpEntity object partendo dalla keyHeader e valueHeader 
	 * @return
	 */
	private HttpEntity<String> getHttpEntity(String keyHeader,String valueHeader) {
		HttpHeaders headers = new HttpHeaders();
			headers.add(keyHeader, valueHeader);
			HttpEntity<String> httpEntityReq = new HttpEntity<String>(headers);
		return httpEntityReq;
	}
	
	/**
	 * Metodo che setta gli headers all'interno di un HttpEntity object settando token come header 
	 * @return
	 */
	private HttpEntity<String> getHttpEntity() {
		
		HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
			headers.add("user-key",token);
			
			HttpEntity<String> httpEntityReq = new HttpEntity<>(headers);
			
			
		_log.info("List Headers  "+httpEntityReq.getHeaders());
			
		return httpEntityReq;
	}
	
}
