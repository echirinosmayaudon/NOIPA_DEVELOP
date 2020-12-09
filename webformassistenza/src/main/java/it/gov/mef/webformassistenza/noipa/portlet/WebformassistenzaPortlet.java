package it.gov.mef.webformassistenza.noipa.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalServiceUtil;
import it.gov.mef.shared.dto.assistenza.ListaAssistenza;
import it.gov.mef.shared.dto.assistenza.Tema;
import it.gov.mef.webformassistenza.noipa.common.util.ExecutableSignatures;
import it.gov.mef.webformassistenza.noipa.common.util.NoiPAWebAssistenzaUtils;
import it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration;
import it.gov.mef.webformassistenza.noipa.constants.WebformassistenzaPortletKeys;
import it.gov.mef.webformassistenza.noipa.http.CodEsito;
import it.gov.mef.webformassistenza.noipa.http.EsitoInvio;
import it.gov.mef.webformassistenza.noipa.http.HttpInternetCallResponseNoiPA;
import it.gov.mef.webformassistenza.noipa.http.serv.impl.HttpInternetClientServiceImplNoiPA;
import it.gov.mef.webformassistenza.noipa.http.util.FileAttachmentNoiPA;



// TODO: Auto-generated Javadoc
/**
 * The Class WebformassistenzaPortlet.
 *
 * @author g.serbino and e.chirinos
 */
@Component(
	    configurationPid =
	    "it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=NoiPA",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + WebformassistenzaPortletKeys.Webformassistenza,
		"javax.portlet.display-name="+ WebformassistenzaPortletKeys.WebformassistenzaName,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.check-auth-token=false"
	},
	service = Portlet.class
)
public class WebformassistenzaPortlet extends MVCPortlet {
	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(WebformassistenzaPortlet.class);
	
	/** The dl app service. */
	@Reference
	private DLAppService _dlAppService;
	
	/** The journal article local service. */
	@Reference
	private JournalArticleLocalService _journalArticleLocalService;
	
	/** The asset link local service. */
	@Reference
	private AssetLinkLocalService _assetLinkLocalService;
	
	/** The asset entry local service. */
	@Reference
	private AssetEntryLocalService _assetEntryLocalService;
	
	/** The Constant formati. */
	private final static String[] formati = {"txt","png","xls","pdf","doc","ipg"};
	
	/*ModConfig metodo da cambiare 25-11-2020*/
	
    /* (non-Javadoc)
     * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    @Override
    public void doView(RenderRequest renderRequest,
            RenderResponse renderResponse) throws IOException, PortletException {

    	//http://127.0.0.1:8080/web/guest?amminis=test&catuser=aaa&area=ddf&tematica=
    	String catuser = "";
    	String area = "";
    	String tematica = "";
    	String tipologia = "";
    	
		
    	PortletPreferences preferences = renderRequest.getPreferences();

    	
		String ddmStructureKeyR = 
				preferences.getValue(
                        "idWebContentRisposta", _exampleConfiguration.idWebContentRisposta());
		String ddmStructureKeyT = 
				preferences.getValue(
                        "idWebContentTema", _exampleConfiguration.idWebContentTema());
		
		
		ThemeDisplay themeDisplay= (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		long groupId= themeDisplay.getSiteGroupId();
    	
    	renderRequest.setAttribute("ddmStructureKeyT",ddmStructureKeyT);
    	renderRequest.setAttribute("ddmStructureKeyR",ddmStructureKeyR);
    	
    	
    	_log.info("ddmStructureKeyT: "+ddmStructureKeyT+" - ddmStructureKeyR:"+ddmStructureKeyR);
    	
    	ListaAssistenza assistenza = getStruttura(groupId, locale, ddmStructureKeyT, ddmStructureKeyR);
    	renderRequest.setAttribute("assistenza",assistenza);
    	
    	String url = PortalUtil.getCurrentURL(renderRequest);
    	
    	if(url != null && !"".equalsIgnoreCase(url) && url.contains("?")) {
    		String param = url.split("\\?")[1];
    		
    		String params[] = param.split("&");
    		
    		if(params != null && params.length>0) {
    			catuser =  isValid(params) ? "": (params[0].split("="))[1];
    			area =  isValid(params) ? "": (params[1].split("="))[1];
    			tematica =  isValid(params) ? "": (params[2].split("="))[1];
    			tipologia =  isValid(params) ? "": (params[3].split("="))[1];
    		}

        	
        	_log.info("catuser="+catuser);
        	_log.info("area="+area);
        	_log.info("tematica="+tematica);
        	_log.info("tipologia="+tipologia);
    		
    	}
    	
   
    	renderRequest.setAttribute("catuser", catuser);
    	renderRequest.setAttribute("area", area);
    	renderRequest.setAttribute("tematica", tematica);
    	renderRequest.setAttribute("tipologia", tipologia);
    	
    	/*ModConfig metodo da cambiare 25-11-2020*/
    	
    	//Creazione delle actionRequest per i tasti delle sezioni Amministrato;MVP;AreaPensioni;EntiCreditori
    	String urlAmministrato=generatePortletActionUrl("Amministrato","visualizzaForm",renderRequest,themeDisplay);
    	String urlMVP=generatePortletActionUrl("MVP","visualizzaForm",renderRequest,themeDisplay);
    	String urlAreaPensioni=generatePortletActionUrl("AreaPensioni","visualizzaForm",renderRequest,themeDisplay);
    	String urlEntiCreditori=generatePortletActionUrl("EntiCreditori","visualizzaForm",renderRequest,themeDisplay);
    	
    	//_log.info("Amministrato "+urlAmministrato);
    	//_log.info("MVP "+urlMVP);
    	//_log.info("AreaPensioni "+urlAreaPensioni);
    	//_log.info("EntiCreditori "+urlEntiCreditori);
    	
    	
    	renderRequest.setAttribute("urlAmministrato", urlAmministrato);
    	renderRequest.setAttribute("urlMVP", urlMVP);
    	renderRequest.setAttribute("urlAreaPensioni", urlAreaPensioni);
    	renderRequest.setAttribute("urlEntiCreditori", urlEntiCreditori);
    
    	setConfigurazioni(renderRequest);
    	
    
   	
        super.doView(renderRequest, renderResponse);
    }
    
    /**
     * Metodo per creare un portletActionUrl
     * @throws PortletException 
     */
    private String generatePortletActionUrl(String param,String portletActionMethod, PortletRequest portletRequest,ThemeDisplay themeDisplay) throws PortletException {
    	
    	  PortletURL actionUrl =  PortletURLFactoryUtil.create(portletRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
		  actionUrl.setWindowState(LiferayWindowState.NORMAL);
		  actionUrl.setPortletMode(LiferayPortletMode.VIEW);
		  actionUrl.setParameter("javax.portlet.action", portletActionMethod);
		  actionUrl.setParameter("sezione", param);    	
    	return actionUrl.toString();
    }
    
    
    
    /*ModConfig metodo da cambiare 25-11-2020*/
    
    /**
     * Visualizza il form dell'assistenza.
     *
     * @param actionRequest the action request
     * @param actionResponse the action response
     */
    public void visualizzaForm(ActionRequest actionRequest, ActionResponse actionResponse){
    	_log.info(".... visualizzaForm");
    
    	String amminis = ParamUtil.get(actionRequest, "amminis", "");
    	String catuser = ParamUtil.get(actionRequest, "catuser", "");
    	String area = ParamUtil.get(actionRequest, "area", "");
    	String tematica = ParamUtil.get(actionRequest, "tematica", "");
    	String tipologia = ParamUtil.get(actionRequest, "tipologia", "");
    	
    	
    	actionRequest.setAttribute("amminis", amminis);
    	actionRequest.setAttribute("catuser", catuser);
    	actionRequest.setAttribute("area", area);
    	actionRequest.setAttribute("tematica", tematica);
    	actionRequest.setAttribute("tipologia", tipologia);
    	
    	
     	/*ModConfig metodo da cambiare 25-11-2020*/
    	
    	/*
    	actionRequest.setAttribute("catuser", catuser);
    	actionRequest.setAttribute("area", area);
    	actionRequest.setAttribute("tematica", tematica);
    	actionRequest.setAttribute("tipologia", tipologia);
    	*/
    	
    	try {
    	setConfigurazioni(actionRequest);
    	}catch(Exception e) {
    		_log.error(e);
    	}
    	
    		String sezione = (String) ParamUtil.get(actionRequest, "sezione", "");
    		_log.info("Dentro visualizza la form variabile sezione "+sezione);
    		actionRequest.setAttribute("sezione", sezione);
    		
    	PortletPreferences preferences = actionRequest.getPreferences();
    	String codiceCaptcha = preferences.getValue("mailconfigNominativo", _exampleConfiguration.mailconfigNominativo());
    	actionRequest.setAttribute("codiceCaptcha", codiceCaptcha);
    	actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
    	
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
	
    
    
    /**
     * Restituisce il locale attuale
     * TODO il metodo e' stato predisposto per la richiesta
     * 		d'assistenza in multi lingua.
     *
     * @param portletRequest the portlet request
     * @return the locale
     */
    private Locale getLocale(PortletRequest portletRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		return locale;
    }
    
    /*ModConfig metodo da verificare 25-11-2020*/
    
    /**
     * Predispone ed invoca la chiamata rest al servizio d'assistenza.
     *
     * @param actionRequest the action request
     * @param actionResponse the action response
     */
    public void sendMailChech(ActionRequest actionRequest, ActionResponse actionResponse){
    	String nome = ParamUtil.get(actionRequest, "nome", "");
    	String cognome = ParamUtil.get(actionRequest, "cognome", "");
    	String codfis = ParamUtil.get(actionRequest, "codfis", "");
    	String tel = ParamUtil.get(actionRequest, "tel", "");
    	String mail = ParamUtil.get(actionRequest, "mail", "");
    	String amminisOriginale = ParamUtil.get(actionRequest, "amminis", "");
    	String amminis = clearCode(amminisOriginale);
    	String catuser = ParamUtil.get(actionRequest, "catuser", "");
    	String area =ParamUtil.get(actionRequest, "area", "");
    	String tematica = ParamUtil.get(actionRequest, "tematica", "");
    	String tipologia = ParamUtil.get(actionRequest, "tipologia", "");
    	String descrizione = ParamUtil.get(actionRequest, "descrizione", "");
    	String captchaText= ParamUtil.get(actionRequest, "captchaText", "");
    	String sezione = ParamUtil.get(actionRequest, "sezione", "");

    	actionRequest.setAttribute("sezione",sezione);
    	actionRequest.setAttribute("amminis",amminisOriginale);
    	
    	actionRequest.setAttribute("catuser",catuser);
    	actionRequest.setAttribute("area",area);
    	actionRequest.setAttribute("tematica",tematica);
    	actionRequest.setAttribute("tipologia",tipologia);
    	
    	
    	
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long sizeFile = uploadRequest.getSize("fileAllegatoWF");
        String sourceFileName = uploadRequest.getFileName("fileAllegatoWF");
        File file = uploadRequest.getFile("fileAllegatoWF");
        
        
    	_log.info("========> file: "+sourceFileName);
        /*ModConfig metodo da cambiare 25-11-2020*/
        setConfigurazioni(actionRequest);
	
		PortletPreferences preferences = actionRequest.getPreferences();
	
    	//Validazione campi required 
    	boolean emptyFormInput=(nome.isEmpty() || cognome.isEmpty() 
    			|| codfis.isEmpty() || tel.isEmpty() || mail.isEmpty()
    			|| amminis.isEmpty() || catuser.isEmpty() || area.isEmpty()
    			|| tematica.isEmpty() || tipologia.isEmpty() || descrizione.isEmpty() || captchaText.isEmpty());
    	
    	if(emptyFormInput) {
    		SessionErrors.add(actionRequest, "noipa.client.error.validation.required");
   		  actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
   		  return;
    	}
    	
    	if(!isValidMail(mail) || !NoiPAWebAssistenzaUtils.validate(mail,0)) {
  		  SessionErrors.add(actionRequest, "noipa.mail.error");
  		  actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
  		  return;
      	}
    	
		try {
			
			CaptchaUtil.check(actionRequest);
			
			Map<String,FileAttachmentNoiPA> appo = new  HashMap<String,FileAttachmentNoiPA>(0);
			JSONArray jsonArrayAssistenza = JSONFactoryUtil.createJSONArray();
			JSONObject richiestaModelForm = JSONFactoryUtil.createJSONObject();
			richiestaModelForm.put("nome", HtmlUtil.escape(nome));
			richiestaModelForm.put("cognome", HtmlUtil.escape(cognome));
			richiestaModelForm.put("codiceFiscale", HtmlUtil.escape(codfis));
			richiestaModelForm.put("email", HtmlUtil.escape(mail));
			richiestaModelForm.put("enteSelezionato", amminis);
			richiestaModelForm.put("descRichiesta", HtmlUtil.escape(descrizione));
			richiestaModelForm.put("telefono", HtmlUtil.escape(tel));
			richiestaModelForm.put("categoriaUtenti", catuser);
			richiestaModelForm.put("area", area);
			richiestaModelForm.put("tematica", tematica);
			richiestaModelForm.put("tipologiaProblematica", tipologia);
			//richiestaModelForm.put("locale", getLocale(actionRequest));
			jsonArrayAssistenza.put(richiestaModelForm);
			FileAttachmentNoiPA attch1 = new FileAttachmentNoiPA("richiestaModelForm.json","application/json",richiestaModelForm.toString().getBytes());
			appo.put("richiestaModelForm",attch1);
			
			String mailconfigMailHp = preferences.getValue("mailconfigMailHp", _exampleConfiguration.serviceUrl());
			if (sizeFile > 0) {
		        if(!checkFile(file, appo, sourceFileName,mailconfigMailHp)) {
		  		  _log.info("Formato file non valido");
		  		  SessionErrors.add(actionRequest, "tipi.documento.allegato.val");
		  		  actionRequest.setAttribute("view_format_type", true);
		  		  actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
		  		  return;
		        }
			}
			try {
				getEsito(actionRequest, actionResponse, mail, appo);
			} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | URISyntaxException | IOException e) {
				SessionErrors.add(actionRequest, "noipa.client.error");
				actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
				_log.error(e);
	    	} catch (Exception e) {
				SessionErrors.add(actionRequest, "noipa.generic.error");
				actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
				_log.error(e);
			}
		  } catch ( IOException e1) {
			  SessionErrors.add(actionRequest, "noipa.generic.error");
			  actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
			return;
		} catch (CaptchaException e1) {
			  actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
			  SessionErrors.add(actionRequest, CaptchaTextException.class.getName());
			  return;
		} 
    }
    
    /**
     * Verifica se l'allegato e' un eseguibile.
     *
     * @param inputFile the input file
     * @return true, if is executable file
     */
    private static boolean isExecutableFile(File inputFile) {
        MagicNumberFileFilter mnff = null;

        for (ExecutableSignatures es : EnumSet.allOf(ExecutableSignatures.class)) {
            mnff = new MagicNumberFileFilter(es.getMagicNumber(), es.getOffset());

            if (mnff.accept(inputFile)) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * Verifica il mimetype dei file.
     *
     * @param file the file
     * @param appo the appo
     * @param sourceFileName the source file name
     * @return true, if successful
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public boolean checkFile(File file,Map<String,FileAttachmentNoiPA> appo, String sourceFileName, String format) throws IOException {
        boolean valid = false;
		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] bytesArray = new byte[(int) file.length()];
			int byteReady = fis.read(bytesArray); // read file into bytes[]				
			if(byteReady>0) {
				_log.info("byte ready: "+byteReady);
			}
			fis.close();
			Path source = Paths.get(file.getAbsolutePath());
			String contentType = Files.probeContentType(source);
			FileAttachmentNoiPA fileAttachment = new FileAttachmentNoiPA(sourceFileName, contentType, bytesArray);
			appo.put("file", fileAttachment);
	        Set<String> key = MimeTypesUtil.getExtensions(MimeTypesUtil.getContentType(file));
	        
	        for(String type : format.split(",")) {
	        	if(key.contains("."+type)) {
	        		valid = true;
	        		break;
	        	}
	        }
	        
	        boolean isExe = isExecutableFile(file);
	        _log.info("valid: "+valid+" isExe:"+isExe);
	        return valid && !isExe;
		}
	
    }
    
    
    /**
     * Predisone i messaggi della chiamata rest ai 
     * servizi d'assistenza .
     *
     * @param actionRequest the action request
     * @param actionResponse the action response
     * @param mail the mail
     * @param appo the appo
     * @return the esito
     * @throws KeyManagementException the key management exception
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws KeyStoreException the key store exception
     * @throws URISyntaxException the URI syntax exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
	private void getEsito(ActionRequest actionRequest, ActionResponse actionResponse, String mail, Map<String,FileAttachmentNoiPA> appo) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, URISyntaxException, IOException {
    	PortletPreferences preferences = actionRequest.getPreferences();
    	String serviceUrl = preferences.getValue("serviceUrl", _exampleConfiguration.serviceUrl());
    	String sendMethod = preferences.getValue("sendMethod", _exampleConfiguration.sendMethod());
    	String userId = preferences.getValue("userId", _exampleConfiguration.userId());
    	String password = preferences.getValue("password", _exampleConfiguration.password());
		HttpInternetClientServiceImplNoiPA clientServiceImpl = new HttpInternetClientServiceImplNoiPA();
		HttpInternetCallResponseNoiPA response = clientServiceImpl.postMultipart(serviceUrl, sendMethod, appo,
				userId, password, true);
		
		
		String mailE = HtmlUtil.escape(mail);

		int code = response.getCode();
		String data = response.getData();
		_log.info("code:"+code+ " - "+data);
		EsitoInvio esito = new EsitoInvio();
		esito.setEsito(code+"");
		esito.setMessaggio(data);
		CodEsito cod_esito = CodEsito.valueOf("INSERT_"+code);
		data = cod_esito.getDescrizione();
		
		
		switch (cod_esito) {
		case INSERT_200:
			actionResponse.setRenderParameter("jspPage", "/success.jsp");
			actionRequest.setAttribute("mail_ok", mailE);
			break;
		case INSERT_201:
			actionResponse.setRenderParameter("jspPage", "/success.jsp");
			actionRequest.setAttribute("mail_ok", mailE);					
			break;
		case INSERT_400:
			SessionErrors.add(actionRequest, "noipa.client.error.400");
			actionResponse.setRenderParameter("jspPage", "/view_form.jsp");					
			actionRequest.setAttribute("error_descr", data);
			break;
		case INSERT_413:
			SessionErrors.add(actionRequest, "noipa.client.error.413");
			actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
			actionRequest.setAttribute("error_descr", data);
			break;
		case INSERT_403:
			SessionErrors.add(actionRequest, "noipa.client.error.403");
			actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
			actionRequest.setAttribute("error_descr", "Errore di autenticazione");
			break;
		case INSERT_500:
			SessionErrors.add(actionRequest, "noipa.client.error.500");
			actionResponse.setRenderParameter("jspPage", "/view_form.jsp");
			actionRequest.setAttribute("error_descr", data);
			break;
		}
		NoiPAWebAssistenzaUtils.hiddenDefaultMessage(actionRequest);
		
	}



	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException, PortletException {
				/*Controllo per apire se la chiamata è per generare il captcha img oppure 
				 per generare la domanda accessibile del captcha previamente generato*/
				if (resourceRequest.getResourceID().equals("captchaURL")) {
					//Genera il captcha
					CaptchaUtil.serveImage(resourceRequest, resourceResponse);
					//Recupera la stringa del captcha in forma di domanda spiegativa accessibile
					String domandaAccessibile=getCaptchaValueFromSession(resourceRequest);
					//Si setta la domanda sulla session
					resourceRequest.getPortletSession().setAttribute("domandaAccessibile", domandaAccessibile,PortletSession.PORTLET_SCOPE);
				} else if (resourceRequest.getResourceID().equals("testoCaptchaAccessibileURL")) {
						//Si recupera la domanda del captcha generato corrente
						String domandaAccessibile = (String) resourceRequest.getPortletSession().getAttribute("domandaAccessibile", PortletSession.PORTLET_SCOPE);
						//si torna una risposta alla funzione ajax per generare la domanda accessibile dentro la view
						PrintWriter out=resourceResponse.getWriter();
						out.print(domandaAccessibile);
				}
	}
	
	/**
	 * Predisone la lista dei temi da visualizzare per le faq.
	 *
	 * @param tema the tema
	 * @param locale the locale
	 * @param groupId the group id
	 * @param ddmStructureKeyT the ddm structure key T
	 * @param ddmStructureKeyR the ddm structure key R
	 * @return the list
	 */
	private Tema getList(Tema tema, Locale locale, long groupId, String ddmStructureKeyT, String ddmStructureKeyR) {

		long resourcePrimKey = tema.getResourcePrimKey();
		long id = Long.parseLong(tema.getId());
		AssetEntry assetEntry = null;
		try {
			assetEntry = _assetEntryLocalService.getEntry("com.liferay.journal.model.JournalArticle", resourcePrimKey);
		} catch (PortalException e) {
			_log.warn("recupero da ID");
			try {
				assetEntry = _assetEntryLocalService.getEntry("com.liferay.journal.model.JournalArticle", id);
			} catch (PortalException e1) {
				_log.warn("no assetentry!");
			}
		}
		try {
		if(assetEntry != null) {
			long entryId = assetEntry.getEntryId();
			List<AssetLink> assetLinks = _assetLinkLocalService.getDirectLinks(entryId, true);
			List<Tema> listArgomenti = new ArrayList<Tema>();

			long relatedAssetEntryPrimKey = -1;
			for (AssetLink assetLink : assetLinks) {
				long relatedAssetEntryId  = assetLink.getEntryId2();
				AssetEntry relatedAssetEntry = _assetEntryLocalService.getEntry(relatedAssetEntryId);
				relatedAssetEntryPrimKey = relatedAssetEntry.getClassPK();
				JournalArticle relatedArticle = _journalArticleLocalService.getLatestArticle(relatedAssetEntryPrimKey);
				Tema temaR = null; 
				if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyT)) {
					temaR = convertTema(relatedArticle, groupId, Long.parseLong(ddmStructureKeyT), locale);
				} else if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyR)) {
					temaR = convertRisposta(relatedArticle, groupId, Long.parseLong(ddmStructureKeyR), locale);
				}
				if(temaR!= null && !temaR.getId().equalsIgnoreCase(tema.getId()) && temaR.getLivello() > tema.getLivello() && !temaR.getAreaPortale().equalsIgnoreCase("PR")) {
					Tema temaCR = getList(temaR, locale, groupId, ddmStructureKeyT, ddmStructureKeyR);
					listArgomenti.add(temaCR);
				}
			}
			tema.setListArgomento(listArgomenti);
		}
		}catch (PortalException e) {
			_log.error(e);
		}
		return tema;
	}
	
	
	/**
	 * Predispone la lista completa dell'assitenza.
	 *
	 * @param groupId the group id
	 * @param locale the locale
	 * @param ddmStructureKeyT the ddm structure key T
	 * @param ddmStructureKeyR the ddm structure key R
	 * @return the struttura
	 */
	private  ListaAssistenza getStruttura(long groupId,  Locale locale, String ddmStructureKeyT, String ddmStructureKeyR){
		
		Map<Long, List<Tema>> tmp = new HashMap<Long, List<Tema>>();
		
		Map<Long, List<Tema>> assistenza  = AssitenzaNoipaLocalServiceUtil.getAssitenza(groupId,locale.toString(), ddmStructureKeyT, ddmStructureKeyR);
		
		Set<Long> keys = assistenza.keySet();
		for (Long key : keys) {
			List<Tema> listLivello = assistenza.get(key);
			List<Tema> nListLivello = new LinkedList<Tema>();
			for (Tema tema : listLivello) {
				if(tema.getAreaPortale()!=null && !tema.getAreaPortale().equalsIgnoreCase("PR") ) {
				long resourcePrimKey = tema.getResourcePrimKey();
				long id = Long.parseLong(tema.getId());
				AssetEntry assetEntry = null;
				try {
					assetEntry = _assetEntryLocalService.getEntry("com.liferay.journal.model.JournalArticle", resourcePrimKey);
				} catch (PortalException e) {
					_log.warn("recupero da ID");
					try {
						assetEntry = _assetEntryLocalService.getEntry("com.liferay.journal.model.JournalArticle", id);
					} catch (PortalException e1) {
						_log.warn("no assetentry!");
					}
				}
				try {
				if(assetEntry != null) {
					long entryId = assetEntry.getEntryId();
					List<AssetLink> assetLinks = _assetLinkLocalService.getDirectLinks(entryId, true);
					List<Tema> listArgomenti = new ArrayList<Tema>();

					long relatedAssetEntryPrimKey = -1;
					for (AssetLink assetLink : assetLinks) {
						long relatedAssetEntryId  = assetLink.getEntryId2();
						AssetEntry relatedAssetEntry = _assetEntryLocalService.getEntry(relatedAssetEntryId);
						relatedAssetEntryPrimKey = relatedAssetEntry.getClassPK();
						JournalArticle relatedArticle = _journalArticleLocalService.getLatestArticle(relatedAssetEntryPrimKey);
						Tema temaR = null; 
						if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyT)) {
							temaR = convertTema(relatedArticle, groupId, Long.parseLong(ddmStructureKeyR), locale);
						} else if(relatedArticle.getDDMStructureKey().equalsIgnoreCase(ddmStructureKeyR)) {
							temaR = convertRisposta(relatedArticle, groupId, Long.parseLong(ddmStructureKeyR),  locale);
						}
						if(temaR!=null && !temaR.getId().equalsIgnoreCase(tema.getId()) && temaR.getLivello() > tema.getLivello() && !temaR.getAreaPortale().equalsIgnoreCase("PR")) {
							Tema temaCR = getList(temaR, locale, groupId, ddmStructureKeyT, ddmStructureKeyR);
							listArgomenti.add(temaCR);
						}
					}
					tema.setListArgomento(listArgomenti);
					nListLivello.add(tema);
				}
				}catch (PortalException e) {
					_log.error(e);
				}
			}
		}	
			tmp.put(key, nListLivello);
		}
		
		
		
		ListaAssistenza listaAssistenza = new ListaAssistenza(tmp);

		
		return listaAssistenza;	
	}
	
	/*ModConfig metodo da cambiare 25-11-2020*/


	private void setConfigurazioni(PortletRequest portletRequest){
		PortletPreferences preferences = portletRequest.getPreferences();
		

		String jsonAmministrazioni= preferences.getValue("listaAmministrazioni",  _exampleConfiguration.listaAmministrazioni());
		String jsonTipologie= preferences.getValue("listaTipologie",  _exampleConfiguration.listaTipologie());
		
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
		
		portletRequest.setAttribute(WebFormAssistenzaConfiguration.class.getName(),_exampleConfiguration);
        NoiPAWebAssistenzaUtils.hiddenDefaultMessage(portletRequest);
        
	}
	
	
	
	/**
	 * COnverte il JournaArticle in Tema.
	 *
	 * @param journalArticle the journal article
	 * @param groupId the group id
	 * @param idStruttura the id struttura
	 * @param locale the locale
	 * @return the tema
	 */
	private Tema convertTema(JournalArticle journalArticle, long groupId,  long idStruttura, Locale locale) {
		
		Tema tema = null;
		String titolo = "";
		String descrizione = "";
		String id = journalArticle.getArticleId();
		XPath xPathSelectorTitolo = SAXReaderUtil.createXPath("dynamic-element[@name='titolo']");
		XPath xPathSelectorDescrizione = SAXReaderUtil.createXPath("dynamic-element[@name='descrizione']");
		XPath xPathSelectorLivello = SAXReaderUtil.createXPath("dynamic-element[@name='livello']");
		String areaPortale = "";
		XPath xPathSelectorAreaPortale = SAXReaderUtil.createXPath("dynamic-element[@name='areaPortale']");
		long livello = 0;
		String articleId = journalArticle.getArticleId();
		double version = journalArticle.getVersion();
		try {
			if(_journalArticleLocalService.isLatestVersion(groupId, articleId, version)) {
				String content = journalArticle.getContentByLocale(locale.toString());
				Document document = SAXReaderUtil.read(content);
				Element root = document.getRootElement();
				titolo = xPathSelectorTitolo.selectSingleNode(root).getStringValue();
				descrizione = xPathSelectorDescrizione.selectSingleNode(root).getStringValue();
				String liv = xPathSelectorLivello.selectSingleNode(root).getStringValue();
				areaPortale = xPathSelectorAreaPortale.selectSingleNode(root) == null ? "ET" : xPathSelectorAreaPortale.selectSingleNode(root).getStringValue();
				livello = Long.parseLong(NoiPAWebAssistenzaUtils.clearValue(liv));
				//30743
				long idDDM = Long.parseLong(journalArticle.getDDMStructureKey());
					long resourcePrimKey = journalArticle.getResourcePrimKey();
					boolean isRisposta = (idDDM -idStruttura) == 0;
					//_log.info("idDDM: "+idDDM+" - idStruttura: "+idStruttura+" - resourcePrimKey:"+resourcePrimKey+" ["+isRisposta+"]");
					tema = new Tema(titolo, descrizione, areaPortale, id, null, resourcePrimKey,livello);
					tema.setRispsota(false);
			}
		} catch (PortalException | DocumentException e) {
			_log.error(e);
		}
		return tema;
	}
	
	/**
	 * COnverte il JournaArticle in Risposta.
	 *
	 * @param journalArticle the journal article
	 * @param groupId the group id
	 * @param idStruttura the id struttura
	 * @param locale the locale
	 * @return the tema
	 */
	private Tema convertRisposta(JournalArticle journalArticle, long groupId,  long idStruttura, Locale locale) {
		
		Tema tema = null;
		String titolo = "";
		String descrizione = "";
		long livello = 0;
		List<String> labelLinks = new LinkedList<String>();
		List<String> links = new LinkedList<String>();
		
		
		String id = journalArticle.getArticleId();
		XPath xPathSelectorTitolo = SAXReaderUtil.createXPath("dynamic-element[@name='titolo']");
		XPath xPathSelectorDescrizione = SAXReaderUtil.createXPath("dynamic-element[@name='descrizione']");
		XPath xPathSelectorLivello = SAXReaderUtil.createXPath("dynamic-element[@name='livello']");
		String areaPortale = "";
		XPath xPathSelectorAreaPortale = SAXReaderUtil.createXPath("dynamic-element[@name='areaPortale']");
		String articleId = journalArticle.getArticleId();
		double version = journalArticle.getVersion();
		try {
			if(_journalArticleLocalService.isLatestVersion(groupId, articleId, version)) {
				String content = journalArticle.getContentByLocale(locale.toString());
				Document document = SAXReaderUtil.read(content);
				Element root = document.getRootElement();
				titolo = xPathSelectorTitolo.selectSingleNode(root).getStringValue();
				descrizione = xPathSelectorDescrizione.selectSingleNode(root).getStringValue();
				String liv = xPathSelectorLivello.selectSingleNode(root).getStringValue();
				areaPortale = xPathSelectorAreaPortale.selectSingleNode(root) == null ? "ET" : xPathSelectorAreaPortale.selectSingleNode(root).getStringValue();
				livello = Long.parseLong(NoiPAWebAssistenzaUtils.clearValue(liv));
				//30743
				String key = "dynamic-element[@name='link"; 
				String keyL = "dynamic-element[@name='labelLink"; 
				for (int i = 1; i < 6; i++) {
					String keyLink = key+i+"']";
					String keyLabel = keyL+i+"']";
					XPath xLink = SAXReaderUtil.createXPath(keyLink);
					XPath xLabelLink = SAXReaderUtil.createXPath(keyLabel);
					Node nodeLink = xLink.selectSingleNode(root);
					
					if(nodeLink != null) {
						String link = NoiPAWebAssistenzaUtils.clearValue(xLink.selectSingleNode(root).getStringValue());
						if(Validator.isNotNull(link))
							links.add(link);
					
					Node nodeLabel = xLink.selectSingleNode(root);
					if(nodeLabel!=null) {
						String label = NoiPAWebAssistenzaUtils.clearValue(xLabelLink.selectSingleNode(root).getStringValue());
						if(Validator.isNotNull(label))
							labelLinks.add(label);
					} else {
						labelLinks.add(link);
					}
					}
				}
				long idDDM = Long.parseLong(journalArticle.getDDMStructureKey());
					long resourcePrimKey = journalArticle.getResourcePrimKey();
					boolean isRisposta = (idDDM -idStruttura) == 0;
//					_log.info("idDDM: "+idDDM+" - idStruttura: "+idStruttura+" - resourcePrimKey:"+resourcePrimKey+" ["+isRisposta+"]");
					tema = new Tema(titolo, descrizione, areaPortale, id, null, resourcePrimKey,livello,links,labelLinks);
					tema.setRispsota(isRisposta);
			}
		} catch (PortalException | DocumentException e) {
			_log.error(e);
		}
		return tema;
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param object the object
	 * @return true, if is valid
	 */
	private boolean isValid(Object object) {
		return NoiPAWebAssistenzaUtils.isValid(object);
	}
	 
	
	/**
	 * Verifica se nella mail sono state
	 * inserite ulteriori indirizzi .
	 *
	 * @param mail the mail
	 * @return true, if is valid mail
	 */
	private boolean isValidMail(String mail) {
		boolean isValid = true;
		_log.info("isValidMail: "+mail);
		if(mail.contains(",") || mail.contains(";") ) {
			isValid = false;
		}
		return isValid;
		
	}
	
	
	/*ModConfig DA VERIFICARE PRIMA DI INVIARE LA MAIL*/
	/**
	 * Utility per la pulitura dei codici delle triplette.
	 *
	 * @param txt the txt
	 * @return the string
	 */
	private String clearCode(String txt) {
		_log.info("txt-org: "+txt);
		if(txt!=null && !"".equals(txt)) {
	    	if(txt.contains("N-")) {
	    		txt = txt.replaceAll("N-", "");
	    	}
	    	if(txt.contains("S-")) {
	    		txt = txt.replaceAll("S-", "");
	    	}
		}
		_log.info("txt-mod: "+txt);
    	return txt;
	}
	
	/**
	 * Utility per avere il valore del captcha generato da liferay
	 * 
	 * @param session
	 * @return
	 */
	private String getCaptchaValueFromSession(PortletRequest request) {
		PortletSession session = request.getPortletSession();
		String domandaAccessibile = "";
		//Controlliamo se è stato generato un captcha
		if (session.getAttribute(WebKeys.CAPTCHA_TEXT) != null) {
			//Recuperiamo il valore string del captcha 
			String captchaValueFromSession = (String) session.getAttribute(WebKeys.CAPTCHA_TEXT);
			// con questo oggetto possiamo avere i valori dai languages.properties files
			ResourceBundle resourceBundle = getPortletConfig().getResourceBundle(getLocale(request));
			//Trasformiamo il valore string numerico del captcha in una domanda accessibile
			domandaAccessibile = getValoreTestualeCaptcha(captchaValueFromSession, resourceBundle);
		}
		return domandaAccessibile;
	}

	/**
	 * Nuova utiliti per generare il captcha accessibile
	 * 
	 * @param valoreCaptcha
	 * @return
	 */
	private String getValoreTestualeCaptcha(String valoreCaptcha, ResourceBundle resourceBundle) {
		char[] caratteri = valoreCaptcha.toCharArray();
		String domandaAccessibile = resourceBundle.getString("captcha.label.domanda");
		for (char c : caratteri) {
			domandaAccessibile += " " + resourceBundle.getString("captcha.num." + c);
		}
		return domandaAccessibile;
	}
	
	
}