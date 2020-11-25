/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.gov.mef.webformassistenza.noipa.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.gov.mef.webformassistenza.noipa.common.util.NoiPAWebAssistenzaUtils;
import it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaCheckConfiguration;
import it.gov.mef.webformassistenza.noipa.constants.WebformassistenzaPortletKeys;
import it.gov.mef.webformassistenza.noipa.http.HttpInternetCallResponseNoiPA;
import it.gov.mef.webformassistenza.noipa.http.serv.impl.HttpInternetClientServiceImplNoiPA;

// TODO: Auto-generated Javadoc
/**
 * The Class Webformassistenzacheck.
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=NoiPA",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + WebformassistenzaPortletKeys.Webformassistenzacheck,
		"javax.portlet.display-name="+ WebformassistenzaPortletKeys.WebformassistenzaNamecheck,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.view-template=/webformassistenzacheck/view.jsp"
	},
	service = Portlet.class
)
public class Webformassistenzacheck extends MVCPortlet {
	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(Webformassistenzacheck.class);
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
	

		PortletPreferences preferences =  renderRequest.getPreferences();
		
		
    	String serviceUrl = preferences.getValue("serviceUrl", _exampleConfiguration.serviceUrl());
    	String chechMethod = preferences.getValue("chechMethod", _exampleConfiguration.chechMethod());
    	
    	String userId = preferences.getValue("userId", _exampleConfiguration.userId());
    	String password = preferences.getValue("password", _exampleConfiguration.password());
    	
    	
    	String noipa_type_config = "Webformassistenzacheck";
		_log.info("entro in : "+noipa_type_config+" - serviceUrl: "+serviceUrl);
		_log.info("entro in : "+noipa_type_config+" - chechMethod: "+chechMethod);
		_log.info("entro in : "+noipa_type_config+" - userId: "+userId);
		_log.info("entro in : "+noipa_type_config+" - password: "+password);
		
		
		//https://noipa.mef.gov.it/web/guest/valida-richiesta-assistenza?sid=FC2RCNYYBG3JPUQFPR&idUtenteRic=9
		
    	String url = PortalUtil.getCurrentURL(renderRequest);
    	String sid = "";
    	String idUtenteRic = "";
    	if(url != null && !"".equalsIgnoreCase(url) && url.contains("?")) {
    		String param = url.split("\\?")[1];
    		
    		String params[] = param.split("&");
    		try {
	    		if(params != null && params.length>0) {
	    			sid =  NoiPAWebAssistenzaUtils.isValid(params) ? "": (params[0].split("="))[1];
	    			idUtenteRic =  NoiPAWebAssistenzaUtils.isValid(params) ? "": (params[1].split("="))[1];
	    			if(!NoiPAWebAssistenzaUtils.validate(param,1)) {
	    				genericError(renderRequest, renderResponse, sid, idUtenteRic);
	    				super.doView(renderRequest, renderResponse);
	    				return;
	    			}
	    		}
    		}  catch (Exception e) {

    			genericError(renderRequest, renderResponse, sid, idUtenteRic);
    	    	super.doView(renderRequest, renderResponse);
    			return;
			}
        	
        	_log.info("sid="+sid);
        	_log.info("idUtenteRic="+idUtenteRic);
        	
        	Map<String,String> appo = new  HashMap<String,String>();
			appo.put("sid", sid);
			appo.put("idUtenteRic", idUtenteRic);
			_log.info("appo: "+appo.toString());
	    	HttpInternetClientServiceImplNoiPA clientServiceImpl = new HttpInternetClientServiceImplNoiPA();
	    	HttpInternetCallResponseNoiPA response = null;
			try {
				response = clientServiceImpl.post(serviceUrl, chechMethod, appo, userId, password, true);
				int code = response.getCode();
				String data = response.getData();
				
				_log.info("code: "+code);
				_log.info("data: "+data);
				
				renderRequest.setAttribute("code", code+"");
			} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | URISyntaxException e) {
				renderRequest.setAttribute("code", "-1");
				_log.error(e);
			} catch (Exception e) {
				renderRequest.setAttribute("code", "-2");
				_log.error(e);
			} 
		    
			
    		
    	} else {
    		renderRequest.setAttribute("code", "-20");
    	}
		renderRequest.setAttribute("sid", sid+"");
		renderRequest.setAttribute("idUtenteRic", idUtenteRic+"");
		
    	NoiPAWebAssistenzaUtils.hiddenDefaultMessage(renderRequest);
		super.doView(renderRequest, renderResponse);
	}
	
	
	/**
	 * Predispone un generic error.
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @param sid the sid
	 * @param idUtenteRic the id utente ric
	 */
	private void genericError(RenderRequest renderRequest, RenderResponse renderResponse, String sid, String idUtenteRic) {
		
		String sidE = HtmlUtil.escape(sid);
		String idUtenteRicE = HtmlUtil.escape(idUtenteRic);
		
		
		String args[] = new String[] {NoiPAWebAssistenzaUtils.isValid(sidE)?" ":sidE, NoiPAWebAssistenzaUtils.isValid(idUtenteRicE)?" ":idUtenteRicE};
		renderRequest.setAttribute("args", args);
		renderRequest.setAttribute("code", "-10");
    	NoiPAWebAssistenzaUtils.hiddenDefaultMessage(renderRequest);
	}
	
	
    /**
     * Activate.
     *
     * @param properties the properties
     */
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
            _exampleConfiguration = ConfigurableUtil.createConfigurable(
            		WebFormAssistenzaCheckConfiguration.class, properties);
    }

    /** The example configuration. */
    private volatile WebFormAssistenzaCheckConfiguration _exampleConfiguration;
	
	
}