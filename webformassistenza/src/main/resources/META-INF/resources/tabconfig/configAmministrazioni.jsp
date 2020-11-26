<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%
    boolean noConfigCatUser = true;//NoiPAWebAssistenzaUtils.isValid(mailconfigMail,mailconfigNominativo,mailconfigMailHp,linkAmministrazione, listaCategoriaUtenti, listaArea, listaTematica, listaTipologia, ConfigurazioneENUM.AMMINISTRAZIONE);
%>

<liferay-portlet:resourceURL id="/config/download/csv"
	var="downloadCsvUrl" copyCurrentRenderParameters="<%=false%>" >
	<liferay-portlet:param name="typeConfig" value="listaAmministrazioni" />
</liferay-portlet:resourceURL>

<c:choose>
    <c:when test="<%= !noConfigCatUser %>">
        <p>
            <liferay-ui:message key="noipawebformassistenza.no.mail.config" />
        </p>
    </c:when>
    <c:otherwise>
        <p>
            <liferay-ui:message key="noipawebformassistenza.config.csv.amministrazioni" />
        </p>

    <liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />
<aui:form action="<%= configurationActionURL %>" enctype="multipart/form-data" method="post" name="fm1">

    <aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" />

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" />    
	<div class="container">
		<div class="row">
	       <div class="col-md-10"><aui:input name="noipa_type_config" type="hidden" value="csvAmministrazioni" /></div>
	       <div class="col-md-2"></div> 
		</div>   
		<div class="row">
		  <div class="col-md-10">
		  	<% if(Validator.isNotNull(listaAmministrazioni)){ 
		  	
		  		//Variabile per poter scaricare il csv
		  		renderRequest.getPortletSession().setAttribute("config.session.lista.amministrazioni", listaAmministrazioni);
		  	%>
		  		<span class="label label-success">File csv Amministrazioni caricato correttamente</span>
		  	<% } else { %>
		  		<span class="label label-danger">Nessun file caricato</span>
		  	<% } %>
		  		
		  </div>
		  <div class="col-md-2"></div>
		</div>
		<div class="row">
		  <div class="col-md-6">
		  <aui:input label="File csv Amministrazioni" type="file" name="fileConfigCSV" id="fileConfigCSV" helpMessage="tipi-documento" >
				<aui:validator name="acceptFiles">
			        'csv,txt'
			    </aui:validator>
			     <aui:validator name="required" errorMessage="L'allegato e' obbligatorio!"/>
		  </aui:input></div>
		  
			 <div class="col-md-2"><aui:button type="submit"/></div>
		  	<div class="col-md-4">
		  	<% if(Validator.isNotNull(listaAmministrazioni)){ %>
			  	<aui:a href="<%=downloadCsvUrl%>" label="Scarica CSV"
						cssClass="btn btn-primary btn-default">
				</aui:a>
				
			<%}%>	
			</div>
		</div>      
	
		</div> 
	</div>
</aui:form>
</c:otherwise>
</c:choose>