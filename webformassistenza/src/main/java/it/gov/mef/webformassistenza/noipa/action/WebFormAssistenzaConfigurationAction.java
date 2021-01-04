package it.gov.mef.webformassistenza.noipa.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
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
import it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration;
import it.gov.mef.webformassistenza.noipa.constants.WebformassistenzaPortletKeys;

// TODO: Auto-generated Javadoc
/**
 * The Class WebFormAssistenzaConfigurationAction.
 */
@Component(
    configurationPid = "it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration",
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {
        "javax.portlet.name=it_gov_mef_webformassistenza_noipa_portlet_WebformassistenzaPortlet"
    },
    service = ConfigurationAction.class
)
public class WebFormAssistenzaConfigurationAction extends DefaultConfigurationAction {

	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(WebFormAssistenzaConfigurationAction.class);
	//private static String headerFile="";

	
	/**
	 * Gets the content.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the content
	 */
	/*
	 * Salvataggio dei parametri di Contenuto
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */
	private void getContent(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) {
		String idWebContentTema = ParamUtil.getString(actionRequest, "idWebContentTema");
        _log.info("entro in : "+noipa_type_config+" - idWebContentTema: "+idWebContentTema);
        setPreference(actionRequest, "idWebContentTema", idWebContentTema);
		String idWebContentRisposta = ParamUtil.getString(actionRequest, "idWebContentRisposta");
        _log.info("entro in : "+noipa_type_config+" - idWebContentRisposta: "+idWebContentRisposta);
        setPreference(actionRequest, "idWebContentRisposta", idWebContentRisposta);
        
        String linkDocumentoPrivacy = ParamUtil.getString(actionRequest, "linkDocumentoPrivacy");
        _log.info("entro in : "+noipa_type_config+" - linkDocumentoPrivacy: "+linkDocumentoPrivacy);
        setPreference(actionRequest, "linkDocumentoPrivacy", linkDocumentoPrivacy);
	}


	/**
	 * Gets the service.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the service
	 */
	/*
	 * Salvataggio dei parametri di Service
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */
	private void getService(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) {
		String serviceUrl = ParamUtil.getString(actionRequest, "serviceUrl");
		String sendMethod = ParamUtil.getString(actionRequest, "sendMethod");
		String chechMethod = ParamUtil.getString(actionRequest, "chechMethod");
		String userId = ParamUtil.getString(actionRequest, "userId");
		String password = ParamUtil.getString(actionRequest, "password");
		String token = ParamUtil.getString(actionRequest, "token");
		_log.info("entro in : "+noipa_type_config+" - serviceUrl: "+serviceUrl);
		_log.info("entro in : "+noipa_type_config+" - sendMethod: "+sendMethod);
		_log.info("entro in : "+noipa_type_config+" - chechMethod: "+chechMethod);
		_log.info("entro in : "+noipa_type_config+" - userId: "+userId);
		_log.info("entro in : "+noipa_type_config+" - password: "+password);
		_log.info("entro in : "+noipa_type_config+" - token: "+token);
		setPreference(actionRequest, "serviceUrl", serviceUrl);
		setPreference(actionRequest, "sendMethod", sendMethod);
		setPreference(actionRequest, "chechMethod", chechMethod);
		setPreference(actionRequest, "userId", userId);
		setPreference(actionRequest, "password", password);
		setPreference(actionRequest, "token", token);
	}
	
	/**
	 * Gets the mail.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the mail
	 */
	/* 
	 * Salvataggio dei parametri di Mail
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */
	private void getMail(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) {
		String mailconfigMailHp = ParamUtil.getString(actionRequest, "mailconfigMailHp");
        _log.info("entro in : "+noipa_type_config+" - mailconfigMailHp: "+mailconfigMailHp);
        setPreference(actionRequest, "mailconfigMailHp", mailconfigMailHp);
        String mailconfigMail = ParamUtil.getString(actionRequest, "mailconfigMail");
        _log.info("entro in : "+noipa_type_config+" - mailconfigMail: "+mailconfigMail);
        setPreference(actionRequest, "mailconfigMail", mailconfigMail);
        String mailconfigNominativo = ParamUtil.getString(actionRequest, "mailconfigNominativo");
        _log.info("entro in : "+noipa_type_config+" - mailconfigNominativo: "+mailconfigNominativo);
        setPreference(actionRequest, "mailconfigNominativo", mailconfigNominativo);
        String mailconfigNominativoBE = ParamUtil.getString(actionRequest, "mailconfigNominativoBE");
        _log.info("entro in : "+noipa_type_config+" - mailconfigNominativoBE: "+mailconfigNominativoBE);
        setPreference(actionRequest, "mailconfigNominativoBE", mailconfigNominativoBE);
	}
	
	/**
	 * Gets the amministrazioni.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the amministrazioni
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Salvataggio dei parametri di Admin
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */
	private void getConfigCsvAmministrazioni(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) throws FileNotFoundException, IOException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFile = uploadRequest.getSize("fileConfigCSV");
		JSONArray jsonArrayAmministrazioni = JSONFactoryUtil.createJSONArray();
        
		if (sizeFile==0) {
            SessionErrors.add(actionRequest, "error");
        } else {
            //String sourceFileName = uploadRequest.getFileName("fileConfigCSV");
            File csvAmministrazioni = uploadRequest.getFile("fileConfigCSV");
            
		       //Chiamata new metodo
            jsonArrayAmministrazioni=readFileCsv(csvAmministrazioni);
            
            //Set della costante header per i files Amministrazioni csv
        
              _log.info("jsonArray ="+jsonArrayAmministrazioni.toJSONString());  
        }
		String json = jsonArrayAmministrazioni.toJSONString();
		
		//_log.info("json: "+json);
		
		if( Validator.isNotNull(json) && json.length()>2)
			setPreference(actionRequest, "listaAmministrazioni",json);
		else 
			setPreference(actionRequest, "listaAmministrazioni", "");
		
		
	}
	
	/**
	 * Gets the categoria user.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the categoria user
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Salvataggio dei parametri di Categoria
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */	
	private void getConfigCsvTipologie(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) throws FileNotFoundException, IOException {
		UploadPortletRequest uploadRequestCat = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFile = uploadRequestCat.getSize("fileConfigCSV");
		JSONArray jsonArrayTipologie = JSONFactoryUtil.createJSONArray();
        if (sizeFile==0) {
            SessionErrors.add(actionRequest, "error");
        } else {	
            //String sourceFileName = uploadRequestCat.getFileName("fileConfigCSV");
            File csvTipologie = uploadRequestCat.getFile("fileConfigCSV");
            
            jsonArrayTipologie=readFileCsv(csvTipologie);  
          
        }
			String json = jsonArrayTipologie.toJSONString();		
		//_log.info("json: "+json);
		if( Validator.isNotNull(json) && json.length()>2)
			setPreference(actionRequest, "listaTipologie",json);
		else 
			setPreference(actionRequest, "listaTipologie", "");
	}
	
	//Metodo che converte un file java csv in un JSONArray
	private JSONArray readFileCsv(File fileCsv) throws IOException {
		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		
		 List<String> listaRigheCsv=ListUtil.fromFile(fileCsv);
		 
		 if(ListUtil.isNotEmpty(listaRigheCsv) && ListUtil.isNotNull(listaRigheCsv)) {
			 String[] intestazioneFile=listaRigheCsv.get(0).split(";");
			 
			 //Eliminando l'intestazione dalla lista delle righe del file
			 listaRigheCsv.remove(0);
		 
			 //Ciclo delle righe del file
			 for (String riga : listaRigheCsv) {
				 JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
				 
				 String[] listaCelle=riga.split(";");
				 
				 //Recuperando il valore corrispondente all'intestazione per ogni riga 
				 for(int index=0;index<intestazioneFile.length;index++) {
					 jsonObject.put(intestazioneFile[index], listaCelle[index]);
				 }
				 jsonArray.put(jsonObject);
			}
		 }
		return jsonArray;
	}
	
    /* (non-Javadoc)
     * @see com.liferay.portal.kernel.portlet.SettingsConfigurationAction#processAction(javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
     */
    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse)        throws Exception {

    	String noipa_type_config = ParamUtil.getString(actionRequest, "noipa_type_config"); 
    	_log.info("noipa_type_config: "+noipa_type_config);
    	switch (noipa_type_config) {
    	case "content":
    		getContent(portletConfig, actionRequest, actionResponse, noipa_type_config);
    		break;
    	case "service":
    		getService(portletConfig, actionRequest, actionResponse, noipa_type_config);
    		break;
    	case "mailconfig":
    		getMail(portletConfig, actionRequest, actionResponse, noipa_type_config);
    		break;
		case "csvAmministrazioni":
			this.getConfigCsvAmministrazioni(portletConfig, actionRequest, actionResponse, noipa_type_config);
			break;
		case "csvTipologie":
			this.getConfigCsvTipologie(portletConfig, actionRequest, actionResponse, noipa_type_config);			
			break;
		}
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
            WebFormAssistenzaConfiguration.class.getName(),
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
            WebFormAssistenzaConfiguration.class, properties);
    }

    /** The example configuration. */
    private volatile WebFormAssistenzaConfiguration _exampleConfiguration;

}