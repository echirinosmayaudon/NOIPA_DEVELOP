package it.gov.mef.webformassistenza.noipa.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import it.gov.mef.webformassistenza.noipa.common.util.NoiPAWebAssistenzaUtils;
import it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaCheckConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class WebFormAssistenzaConfigurationCheckAction.
 */
@Component(
    configurationPid = "it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaCheckConfiguration",
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {
        "javax.portlet.name=it_gov_mef_webformassistenza_noipa_portlet_Webformassistenzacheck"
    },
    service = ConfigurationAction.class
)
public class WebFormAssistenzaConfigurationCheckAction extends DefaultConfigurationAction {

	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(WebFormAssistenzaConfigurationCheckAction.class);
	

	
	
	
    /* (non-Javadoc)
     * @see com.liferay.portal.kernel.portlet.SettingsConfigurationAction#processAction(javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
     */
    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {

		String serviceUrl = ParamUtil.getString(actionRequest, "serviceUrl");
		String sendMethod = ParamUtil.getString(actionRequest, "sendMethod");
		String chechMethod = ParamUtil.getString(actionRequest, "chechMethod");
		String userId = ParamUtil.getString(actionRequest, "userId");
		String password = ParamUtil.getString(actionRequest, "password");
		String token = ParamUtil.getString(actionRequest, "token");
		
		_log.info("serviceUrl: "+serviceUrl);
		_log.info("sendMethod: "+sendMethod);
		_log.info("chechMethod: "+chechMethod);
		_log.info("userId: "+userId);
		_log.info("password: "+password);
		_log.info("token: "+token);
		
		setPreference(actionRequest, "serviceUrl", serviceUrl);
		setPreference(actionRequest, "sendMethod", sendMethod);
		setPreference(actionRequest, "chechMethod", chechMethod);
		setPreference(actionRequest, "userId", userId);
		setPreference(actionRequest, "password", password);
		setPreference(actionRequest, "token", token);
    	
		actionRequest.setAttribute("serviceUrl", serviceUrl);
		actionRequest.setAttribute("sendMethod", sendMethod);
		actionRequest.setAttribute("chechMethod", chechMethod);
		actionRequest.setAttribute("userId", userId);
		actionRequest.setAttribute("password", password);
		actionRequest.setAttribute("token", token);
    	
    	NoiPAWebAssistenzaUtils.hiddenDefaultMessage(actionRequest);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }
	
	
	
    
    

    /* (non-Javadoc)
     * @see com.liferay.portal.kernel.portlet.BaseJSPSettingsConfigurationAction#include(javax.portlet.PortletConfig, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public void include(
        PortletConfig portletConfig, HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) throws Exception {

        httpServletRequest.setAttribute(
            WebFormAssistenzaCheckConfiguration.class.getName(),
            _exampleConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
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