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
<%
Log _log = LogFactoryUtil.getLog("INIT PAGE");
WebFormAssistenzaConfiguration exampleConfiguration =
        (WebFormAssistenzaConfiguration)
        renderRequest.getAttribute(WebFormAssistenzaConfiguration.class.getName());
	

	String listaAmministrazioni = StringPool.BLANK;
	String listaTipologie = StringPool.BLANK; 
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
        
    	
        listaAmministrazioni =
                portletPreferences.getValue(
                    "listaAmministrazioni", exampleConfiguration.listaAmministrazioni());
      
        listaTipologie =
                portletPreferences.getValue("listaTipologie", exampleConfiguration.listaTipologie());
        
    } 
%>

</script>

