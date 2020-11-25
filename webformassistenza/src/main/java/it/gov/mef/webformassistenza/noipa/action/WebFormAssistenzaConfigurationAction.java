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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	private void getAmministrazioni(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) throws FileNotFoundException, IOException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFile = uploadRequest.getSize("fileConfigCSV");
		JSONArray jsonArray_enti = JSONFactoryUtil.createJSONArray();
        if (sizeFile==0) {
            SessionErrors.add(actionRequest, "error");
        } else {
        	
            String sourceFileName = uploadRequest.getFileName("fileConfigCSV");
            File file = uploadRequest.getFile("fileConfigCSV");
            
            
            _log.info("sourceFileName: "+sourceFileName);
            _log.info("sizeFile: "+sizeFile);
            _log.info("file: "+file.toPath());
            
        	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	    String line;
        	    int index = 1;
        	    while ((line = br.readLine()) != null) {
        	        String[] values = line.split(";");
        	        String flag = values[0];
        	        String key = values[1];
        	        String value = values[2];
        	        JSONObject json = JSONFactoryUtil.createJSONObject();
//        	        json.put(key, value);
        	        json.put("kenti" + index, key);
        	        json.put("venti" + index, value);
        	        json.put("tenti" + index, flag);
        	        jsonArray_enti.put(json);
        	        index = index+1;
        	    }
        	}
        	_log.info("Enti size ="+jsonArray_enti.length());
        }
		String json_enti = jsonArray_enti.toJSONString();
		if( Validator.isNotNull(json_enti) && json_enti.length()>2)
			setPreference(actionRequest, "linkAmministrazione",json_enti);
		else 
			setPreference(actionRequest, "linkAmministrazione", "");
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
	private void getCategoriaUser(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) throws FileNotFoundException, IOException {
		UploadPortletRequest uploadRequestCat = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFileCat = uploadRequestCat.getSize("fileConfigCSV");
		JSONArray jsonArray_cat = JSONFactoryUtil.createJSONArray();
        if (sizeFileCat==0) {
            SessionErrors.add(actionRequest, "error");
        } else {
        	
            String sourceFileName = uploadRequestCat.getFileName("fileConfigCSV");
            File file = uploadRequestCat.getFile("fileConfigCSV");
            
            
            _log.info("sourceFileName: "+sourceFileName);
            _log.info("sizeFile: "+sizeFileCat);
            _log.info("file: "+file.toPath());
            
        	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	    String line;
        	    int index = 1;
        	    while ((line = br.readLine()) != null) {
        	        String[] values = line.split(";");
        	        String key = values[0];
        	        String value = values[1];
        	        JSONObject json = JSONFactoryUtil.createJSONObject();
		            json.put("kcategoria" + index, key);
		            json.put("vcategoria" + index, value);
        	        jsonArray_cat.put(json);
        	        index = index+1;
        	    }
        	}
        	_log.info("Categoria size ="+jsonArray_cat.length());
        }
		String json_cat = jsonArray_cat.toJSONString();
		if( Validator.isNotNull(json_cat) && json_cat.length()>2)
			setPreference(actionRequest, "listaCategoriaUtenti",json_cat);
		else 
			setPreference(actionRequest, "listaCategoriaUtenti", "");
	}
	
	/**
	 * Gets the area.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the area
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Salvataggio dei parametri di Area
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */
	private void getArea(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) throws FileNotFoundException, IOException {
		UploadPortletRequest uploadRequestArea = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFileArea = uploadRequestArea.getSize("fileConfigCSV");
		JSONArray jsonArray_area = JSONFactoryUtil.createJSONArray();
        if (sizeFileArea==0) {
            SessionErrors.add(actionRequest, "error");
        } else {
        	
            String sourceFileName = uploadRequestArea.getFileName("fileConfigCSV");
            File file = uploadRequestArea.getFile("fileConfigCSV");
            
            
            _log.info("sourceFileName: "+sourceFileName);
            _log.info("sizeFile: "+sizeFileArea);
            _log.info("file: "+file.toPath());
            
        	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	    String line;
        	    int index = 1;
        	    while ((line = br.readLine()) != null) {
        	        String[] values = line.split(";");
        	        String karea = values[0];
        	        String varea = values[1];
        	        String tarea = values[2];
					JSONObject json_area = JSONFactoryUtil.createJSONObject();
					json_area.put("karea" + index, karea);
					json_area.put("varea" + index, varea);
					json_area.put("tarea" + index, tarea);
					jsonArray_area.put(json_area);
					index = index+1;
        	    }
        	}
        	_log.info("Area size ="+jsonArray_area.length());
        }
		String json_area = jsonArray_area.toJSONString();
		if( Validator.isNotNull(json_area) && json_area.length()>2)
			setPreference(actionRequest, "listaArea",json_area);
		else 
			setPreference(actionRequest, "listaArea", "");
	}
	
	
	/**
	 * Gets the tematica.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the tematica
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Salvataggio dei parametri di Tematica
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */
	private void getTematica(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) throws FileNotFoundException, IOException {
		UploadPortletRequest uploadRequestTematica = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFileTematica = uploadRequestTematica.getSize("fileConfigCSV");
		JSONArray jsonArray_tematica = JSONFactoryUtil.createJSONArray();
        if (sizeFileTematica==0) {
            SessionErrors.add(actionRequest, "error");
        } else {
        	
            String sourceFileName = uploadRequestTematica.getFileName("fileConfigCSV");
            File file = uploadRequestTematica.getFile("fileConfigCSV");
            
            
            _log.info("sourceFileName: "+sourceFileName);
            _log.info("sizeFile: "+sizeFileTematica);
            _log.info("file: "+file.toPath());
            
        	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	    String line;
        	    int index = 1;
        	    while ((line = br.readLine()) != null) {
        	        String[] values = line.split(";");
        	        String ktematica = values[0];
        	        String vtematica = values[1];
        	        String ttematica = values[2];
					JSONObject json_tematica = JSONFactoryUtil.createJSONObject();
					json_tematica.put("ktematica" + index, ktematica);
					json_tematica.put("vtematica" + index, vtematica);
					json_tematica.put("ttematica" + index, ttematica);
					jsonArray_tematica.put(json_tematica);
					index = index+1;
        	    }
        	}
        	_log.info("tematica size ="+jsonArray_tematica.length());
        }
		String json_tematica = jsonArray_tematica.toJSONString();
		if( Validator.isNotNull(json_tematica) && json_tematica.length()>2)
			setPreference(actionRequest, "listaTematica",json_tematica);
		else 
			setPreference(actionRequest, "listaTematica", "");
	}
	
	/**
	 * Gets the tipologia.
	 *
	 * @param portletConfig the portlet config
	 * @param actionRequest the action request
	 * @param actionResponse the action response
	 * @param noipa_type_config the noipa type config
	 * @return the tipologia
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * Salvataggio dei parametri di Tipologia
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @param noipa_type_config
	 */
	private void getTipologia(PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, String noipa_type_config) throws FileNotFoundException, IOException {
		UploadPortletRequest uploadRequestTipologia = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFileTipologia = uploadRequestTipologia.getSize("fileConfigCSV");
		JSONArray jsonArray_tipologia = JSONFactoryUtil.createJSONArray();
        if (sizeFileTipologia==0) {
            SessionErrors.add(actionRequest, "error");
        } else {
        	
            String sourceFileName = uploadRequestTipologia.getFileName("fileConfigCSV");
            File file = uploadRequestTipologia.getFile("fileConfigCSV");
            
            
            _log.info("sourceFileName: "+sourceFileName);
            _log.info("sizeFile: "+sizeFileTipologia);
            _log.info("file: "+file.toPath());
            
        	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	    String line;
        	    int index = 1;
        	    while ((line = br.readLine()) != null) {
        	        String[] values = line.split(";");
        	        
        	        
        	        String cutipologia = values[0];
        	        String artipologia = values[1];
        	        String tetipologia = values[2];
        	        String titipologia = values[3];
					JSONObject json_tipologia = JSONFactoryUtil.createJSONObject();
					json_tipologia.put("cutipologia" + index, cutipologia);
					json_tipologia.put("artipologia" + index, artipologia);
					json_tipologia.put("tetipologia" + index, tetipologia);
					json_tipologia.put("titipologia" + index, titipologia);
					jsonArray_tipologia.put(json_tipologia);
					index = index+1;
        	    }
        	}
        	_log.info("tematica size ="+jsonArray_tipologia.length());
        }
		String json_tipologia = jsonArray_tipologia.toJSONString();
		if( Validator.isNotNull(json_tipologia) && json_tipologia.length()>2)
			setPreference(actionRequest, "listaTipologia",json_tipologia);
		else 
			setPreference(actionRequest, "listaTipologia", "");
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
		case "amministrazione":
			getAmministrazioni(portletConfig, actionRequest, actionResponse, noipa_type_config);
			break;
		case "categoriautenti":
			getCategoriaUser(portletConfig, actionRequest, actionResponse, noipa_type_config);			
			break;
		case "area":
			getArea(portletConfig, actionRequest, actionResponse, noipa_type_config);
			break;
		case "tematica":
			getTematica(portletConfig, actionRequest, actionResponse, noipa_type_config);
			break;
		case "tipologia":
			getTipologia(portletConfig, actionRequest, actionResponse, noipa_type_config);
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