package it.gov.mef.webformassistenza.noipa.portlet.command;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.gov.mef.webformassistenza.noipa.common.util.NoiPAWebAssistenzaUtils;
import it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration;
import it.gov.mef.webformassistenza.noipa.constants.WebformassistenzaPortletKeys;


@Component(configurationPid = "it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration",
immediate = true,
property = {
		"javax.portlet.name="+ WebformassistenzaPortletKeys.Webformassistenza,
        "mvc.command.name=/noipa/webform/visualizza"
},
service = MVCRenderCommand.class
)
public class VisualizzaFormMVCRenderCommand implements MVCRenderCommand{
	Log _log=LogFactoryUtil.getLog(this.getClass());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_log.info(".... renderForm");
	    
    	String amminis = ParamUtil.get(renderRequest, "amminis", "");
    	String catuser = ParamUtil.get(renderRequest, "catuser", "");
    	String area = ParamUtil.get(renderRequest, "area", "");
    	String tematica = ParamUtil.get(renderRequest, "tematica", "");
    	String tipologia = ParamUtil.get(renderRequest, "tipologia", "");
    	
    	
    	renderRequest.setAttribute("amminis", amminis);
    	renderRequest.setAttribute("catuser", catuser);
    	renderRequest.setAttribute("area", area);
    	renderRequest.setAttribute("tematica", tematica);
    	renderRequest.setAttribute("tipologia", tipologia);
    	
    	
    		setConfigurazioni(renderRequest);

    	
    		String sezione = (String) ParamUtil.get(renderRequest, "sezione", "");
    		_log.info("Dentro visualizza la form variabile sezione "+sezione);
    		renderRequest.setAttribute("sezione", sezione);
    		
    	PortletPreferences preferences = renderRequest.getPreferences();
    		String codiceCaptcha = preferences.getValue("mailconfigNominativo", _configuration.mailconfigNominativo());
    		renderRequest.setAttribute("codiceCaptcha", codiceCaptcha);
    	
    	
		return "/view_form.jsp";
	}

	
	/**
     * Activate.
     *
     * @param properties the properties
     */
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	_configuration = ConfigurableUtil.createConfigurable(
                    WebFormAssistenzaConfiguration.class, properties);
    }

    /** The example configuration. */
    private volatile WebFormAssistenzaConfiguration _configuration;
	
    private void setConfigurazioni(PortletRequest portletRequest){
		PortletPreferences preferences = portletRequest.getPreferences();
		

		String jsonAmministrazioni= preferences.getValue("listaAmministrazioni",  _configuration.listaAmministrazioni());
		String jsonTipologie= preferences.getValue("listaTipologie",  _configuration.listaTipologie());
		
		if(Validator.isNotNull(jsonAmministrazioni)){
			portletRequest.setAttribute("jsonAmministrazioni",jsonAmministrazioni);
		}else {
			portletRequest.setAttribute("jsonAmministrazioni","");
		}
	
		
		if(Validator.isNotNull(jsonTipologie)){
			portletRequest.setAttribute("jsonTipologie",jsonTipologie);
		}else {
			portletRequest.setAttribute("jsonTipologie","");
		}
		
		portletRequest.setAttribute(WebFormAssistenzaConfiguration.class.getName(),_configuration);
        NoiPAWebAssistenzaUtils.hiddenDefaultMessage(portletRequest);
        
	}
	
}
