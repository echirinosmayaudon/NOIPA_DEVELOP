<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="it.gov.mef.webformassistenza.noipa.configuration.WebFormAssistenzaCheckConfiguration"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />


<%

Log _log = LogFactoryUtil.getLog("INIT PAGE");
WebFormAssistenzaCheckConfiguration exampleConfiguration =
        (WebFormAssistenzaCheckConfiguration)
        renderRequest.getAttribute(WebFormAssistenzaCheckConfiguration.class.getName());

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
}




%>
