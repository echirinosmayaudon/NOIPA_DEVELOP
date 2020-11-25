<%@page import="it.gov.mef.shared.dto.assistenza.Tema"%>
<%@page import="it.gov.mef.shared.dto.assistenza.ListaAssistenza"%><%@page import="java.util.Locale"%>
<%@page import="it.gov.mef.webformassistenza.noipa.common.util.NoiPAWebAssistenzaUtils"%>
<%@page import="it.gov.mef.webformassistenza.noipa.configuration.bean.ConfigurazioneBean"%>
<%@page import="it.gov.mef.webformassistenza.noipa.configuration.bean.ConfigurazioneBeanEx"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="it.gov.mef.webformassistenza.noipa.common.util.ConfigurazioneENUM"%>
<%@page import="it.gov.mef.webformassistenza.noipa.common.util.NoiPAWebAssistenzaUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaConfiguration"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<link href="<%=request.getContextPath()%>/css/assistenza.css" rel="stylesheet" type="text/css"/> 

<portlet:defineObjects />



<input name="uuid_mail"  id="uuid_mail" type="hidden" value="${token}" />


<liferay-theme:defineObjects />
<script type="text/javascript">
	var appoE = [];
	var appoCU = [];
	var appoA = [];
	var appoTm = [];
	var appoTp = [];

<%
Log _log = LogFactoryUtil.getLog("INIT PAGE");
WebFormAssistenzaConfiguration exampleConfiguration =
        (WebFormAssistenzaConfiguration)
        renderRequest.getAttribute(WebFormAssistenzaConfiguration.class.getName());

	String favoriteColor = StringPool.BLANK;
	String favoriteColor1 = StringPool.BLANK;
	String linkSorgente = StringPool.BLANK;
	String linkAmministrazione = StringPool.BLANK;
	String elementCategoriautentiNum = StringPool.BLANK; 
	List<ConfigurazioneBeanEx> listaEnti = new LinkedList<ConfigurazioneBeanEx>(); 
	List<ConfigurazioneBean> listaCategoriaUtenti = new LinkedList<ConfigurazioneBean>(); 
	List<ConfigurazioneBeanEx> listaArea = new LinkedList<ConfigurazioneBeanEx>();
	List<ConfigurazioneBeanEx> listaTematica = new LinkedList<ConfigurazioneBeanEx>();
	List<ConfigurazioneBeanEx> listaTipologia = new LinkedList<ConfigurazioneBeanEx>();
	String categoriaUtenti = StringPool.BLANK; 
	String area  = StringPool.BLANK;
	String tematica  = StringPool.BLANK;
	String tipologia  = StringPool.BLANK;
	String mailconfigMail  = StringPool.BLANK;
	String mailconfigNominativo  = StringPool.BLANK;
	String mailconfigNominativoBE  = StringPool.BLANK;
	String mailconfigMailHp  = StringPool.BLANK;
	String idWebContentTema  = StringPool.BLANK;
	String idWebContentRisposta = StringPool.BLANK;
	
	String serviceUrl = StringPool.BLANK; 
	String sendMethod = StringPool.BLANK;
	String chechMethod = StringPool.BLANK;
	String userId = StringPool.BLANK;
	String password = StringPool.BLANK;
	String token = StringPool.BLANK;
	
    if (Validator.isNotNull(exampleConfiguration)) {
           
    	serviceUrl =
    	        portletPreferences.getValue(
    	            "serviceUrl", exampleConfiguration.serviceUrl());
    	sendMethod =
    	        portletPreferences.getValue(
    	            "sendMethod", exampleConfiguration.sendMethod());
    	chechMethod =
    	        portletPreferences.getValue(
    	            "chechMethod", exampleConfiguration.chechMethod());
    	userId =
    	        portletPreferences.getValue(
    	            "userId", exampleConfiguration.userId());
    	password =
    	        portletPreferences.getValue(
    	            "password", exampleConfiguration.password());
    	token =
    	        portletPreferences.getValue(
    	            "token", exampleConfiguration.token());
    	
    	String noipa_type_config = "";
		_log.info("entro in : "+noipa_type_config+" - serviceUrl: "+serviceUrl);
		_log.info("entro in : "+noipa_type_config+" - sendMethod: "+sendMethod);
		_log.info("entro in : "+noipa_type_config+" - chechMethod: "+chechMethod);
		_log.info("entro in : "+noipa_type_config+" - userId: "+userId);
		_log.info("entro in : "+noipa_type_config+" - password: "+password);
		_log.info("entro in : "+noipa_type_config+" - token: "+token);
    	
    	
    	
    	mailconfigMailHp =
	        portletPreferences.getValue(
	            "mailconfigMailHp", exampleConfiguration.mailconfigMailHp());
    	
    	idWebContentTema =
    	        portletPreferences.getValue(
    	            "idWebContentTema", exampleConfiguration.idWebContentTema());
    	
    	idWebContentRisposta =
    	        portletPreferences.getValue(
    	            "idWebContentRisposta", exampleConfiguration.idWebContentRisposta());
    	
    	mailconfigMail =
                portletPreferences.getValue(
                    "mailconfigMail", exampleConfiguration.mailconfigMail());
        
    	mailconfigNominativo =
                portletPreferences.getValue(
                    "mailconfigNominativo", exampleConfiguration.mailconfigNominativo());
    	
    	mailconfigNominativoBE =  portletPreferences.getValue(
                "mailconfigNominativoBE", exampleConfiguration.mailconfigNominativoBE());
    	
        /*
        elementCategoriautentiNum =
                portletPreferences.getValue(
                        "elementCategoriautentiNum", exampleConfiguration.elementCategoriautentiNum());
        
         	int size = elementCategoriautentiNum != null ? Integer.parseInt(elementCategoriautentiNum):0;
        
        */
        
     	
        
       
        
        linkAmministrazione =
                portletPreferences.getValue(
                    "linkAmministrazione", exampleConfiguration.linkAmministrazione());
        if(linkAmministrazione != null && !"".equalsIgnoreCase(linkAmministrazione) && linkAmministrazione.length()>2){
        	JSONArray jsonArray = JSONFactoryUtil.createJSONArray(linkAmministrazione);
        	int length = jsonArray.length();
        	for(int i = 0; i<length; i++){
        		
        		/*
	        	        json.put("kenti" + index, key);
	        	        json.put("venti" + index, value);
	        	        json.put("fenti" + index, flag);
        		*/
        		
        		
        		JSONObject jsonObject = jsonArray.getJSONObject(i);
        		String key = jsonObject.getString("kenti"+(i+1));
        		String value = jsonObject.getString("venti"+(i+1));
        		value = value.contains("'") ? value.replaceAll("'", "-X-"):value;
        		String flag = jsonObject.getString("tenti"+(i+1));
        		ConfigurazioneBeanEx bean = new ConfigurazioneBeanEx(key,value,flag);
        		String appoEN = "{\"key\":\""+key+"\",\"value\":\""+value+"\",\"type\":\""+flag+"\"}";
        		//_log.info("appoEN: "+appoEN);
        		listaEnti.add(bean);
        	     %>
        	        appoE[<%=i%>] = jQuery.parseJSON('<%=appoEN%>');
        	     <%
        	}
        	
        }
        
        
        
        categoriaUtenti =
                portletPreferences.getValue("listaCategoriaUtenti", exampleConfiguration.listaCategoriaUtenti());
        if(categoriaUtenti != null && !"".equalsIgnoreCase(categoriaUtenti) && categoriaUtenti.length()>2){
        	JSONArray jsonArray = JSONFactoryUtil.createJSONArray(categoriaUtenti);
        	int length = jsonArray.length();
        	for(int i = 0; i<length; i++){
        		JSONObject jsonObject = jsonArray.getJSONObject(i);
        		String kcategoria = jsonObject.getString("kcategoria"+(i+1));
        		String vcategoria = jsonObject.getString("vcategoria"+(i+1));
        		ConfigurazioneBean bean = new ConfigurazioneBean(kcategoria,vcategoria);
        		String appoJ = "{\"key\":\""+kcategoria+"\",\"value\":\""+vcategoria+"\"}";
        		_log.info("appoJ: "+appoJ);
        		listaCategoriaUtenti.add(bean);
        	     %>
        	     	appoCU[<%=i%>] = jQuery.parseJSON('<%=appoJ%>');
        	     <%
        	}
        	
        }  
    } 
%>
</script>