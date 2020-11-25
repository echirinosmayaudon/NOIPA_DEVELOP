<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="./init.jsp"%>


<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />

<liferay-portlet:resourceURL id="/config/download/csv"
	var="downloadCsvUrl" copyCurrentRenderParameters="<%=false%>" >
	</liferay-portlet:resourceURL>
<%
renderRequest.getPortletSession().setAttribute("it.form.config.session.mappa", itFormConfigSessionMappa);
%>
<div class="row justify-content-center mt-5">
	<div class="col-10">
	
		<div class="card">
			<div class="card-header">Configuration</div>
			<div class="card-body">
				<aui:form action="<%=configurationActionURL%>" method="post"
					name="fm">

					<aui:input name="<%=Constants.CMD%>" type="hidden"
						value="<%=Constants.UPDATE%>" />

					<aui:input name="redirect" type="hidden"
						value="<%=configurationRenderURL%>" />

						<aui:fieldset>
							<aui:row>
								<aui:col width="50">
									<aui:input type="file" name="fileCSV"
										label="Carica CSV Configurazione">
									</aui:input>
								</aui:col>
								<aui:col width="50" cssClass="d-flex align-items-center">
									<aui:a href="<%=downloadCsvUrl%>" label="Scarica CSV"
										cssClass="btn btn-primary"></aui:a>
								</aui:col>
							</aui:row>
						</aui:fieldset>

					
	<div id="content">
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  
		  	<% if(Validator.isNotNull(dataSiteKeyCaptcha)){ %>
		  		<span class="label label-success"><liferay-ui:message key="anpal.formonline.label.configurazionecaricata"/></span> 	
		  	<% } else {%>
		  		<span class="label label-danger"><liferay-ui:message key="anpal.formonline.label.configurazionenoncaricata"/></span>  	
		  	<% } %>
		  		
		  </div>
		  <div class="col-md-4"></div>
		</div>
		
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  <aui:input type="text" label="anpal.formonline.label.input.sitekey" name="dataSiteKeyCaptcha" id="dataSiteKeyCaptcha" helpMessage="anpal.formonline.label.helpmessage.sitekey" value="${dataSiteKeyCaptcha}" >
			     <aui:validator name="required" errorMessage="anpal.formonline.label.errormessage.sitekey"/>
		  </aui:input></div>
		</div>   
		
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  <aui:input type="text" label="anpal.formonline.label.input.privatekey" name="privateKeyCaptcha" id="privateKeyCaptcha" helpMessage="anpal.formonline.label.helpmessage.privatekey" value="${privateKeyCaptcha}" >
			     <aui:validator name="required" errorMessage="anpal.formonline.label.errormessage.privatekey"/>
		  </aui:input></div>
		</div>   
		
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  <aui:input type="text" label="anpal.formonline.label.input.emailfrom" name="email" id="email" helpMessage="anpal.formonline.label.helpmessage.emailfrom" value="${email}" >
			     <aui:validator name="required" errorMessage="anpal.formonline.label.errormessage.emailfrom"/>
		  </aui:input></div>
		</div>   
		
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  <aui:input type="text" label="anpal.formonline.label.input.toEmailDefault" name="toEmailDefault" id="toEmailDefault" helpMessage="anpal.formonline.label.helpmessage.toEmailDefault" value="${toEmailDefault}" >
			     <aui:validator name="required" errorMessage="anpal.formonline.label.errormessage.toEmailDefault"/>
		  </aui:input></div>
		</div>       
		
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  <aui:input type="text" label="anpal.formonline.label.input.linkPDF" name="linkPDF" helpMessage="anpal.formonline.label.helpmessage.linkPDF" value="${linkPDF}" >
			     <aui:validator name="required" errorMessage="anpal.formonline.label.errormessage.linkPDF"/>
		  </aui:input></div>
		</div>  
		
	</div>
					
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
	
				</aui:form>
			</div>
		</div>

	</div>
</div>


