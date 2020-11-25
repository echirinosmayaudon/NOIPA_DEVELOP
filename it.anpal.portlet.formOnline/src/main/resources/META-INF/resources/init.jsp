<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
	
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@ page import="it.anpal.portlet.formOnline.config.PortletFormOnlineConfig"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%	
	PortletFormOnlineConfig _portletConfig = portletDisplay.getPortletInstanceConfiguration(PortletFormOnlineConfig.class);
	
	String itFormConfigSessionMappa = _portletConfig.mappaForm();
	
	String privateKeyCaptcha = _portletConfig.privateKeyCaptcha();
	String dataSiteKeyCaptcha = _portletConfig.dataSiteKeyCaptcha();
	String email = _portletConfig.email();
	String toEmailDefault = _portletConfig.toEmailDefault();
	String linkPDF = _portletConfig.linkPDF();
	String instanceID = themeDisplay.getPortletDisplay().getInstanceId();

	
	renderRequest.setAttribute("privateKeyCaptcha", privateKeyCaptcha);  
	renderRequest.setAttribute("dataSiteKeyCaptcha", dataSiteKeyCaptcha);  
	renderRequest.setAttribute("email", email);  
	renderRequest.setAttribute("toEmailDefault", toEmailDefault);
	renderRequest.setAttribute("linkPDF", linkPDF);
%>