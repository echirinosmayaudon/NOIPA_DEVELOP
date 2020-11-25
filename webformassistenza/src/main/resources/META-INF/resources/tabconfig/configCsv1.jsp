


<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%
    boolean noConfigCatUser = true;//NoiPAWebAssistenzaUtils.isValid(mailconfigMail,mailconfigNominativo,mailconfigMailHp,linkAmministrazione, listaCategoriaUtenti, listaArea, listaTematica, listaTipologia, ConfigurazioneENUM.AMMINISTRAZIONE);
    ;
%>

<c:choose>
    <c:when test="<%= !noConfigCatUser %>">
        <p>
            <liferay-ui:message key="noipawebformassistenza.no.mail.config" />
        </p>
    </c:when>
    <c:otherwise>
        <p>
            <liferay-ui:message key="noipawebformassistenza.config.csv.1" />
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
	<div id="content">
		<div class="row">
	       <div class="col-md-1"></div> 
	       <div class="col-md-10"><aui:input name="noipa_type_config" type="hidden" value="configCsv1" /></div>
	       <div class="col-md-1"></div> 
		</div>   
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  	<% if(Validator.isNotNull(linkAmministrazione)){ %>
		  		<span class="label label-success">File caricato correttamente</span>
		  	<% } else { %>
		  		<span class="label label-danger">Nessun file caricato</span>
		  	<% } %>
		  		
		  </div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  <aui:input label="File configurazione 1" type="file" name="fileConfigCSV" id="fileConfigCSV" helpMessage="tipi-documento" >
				<aui:validator name="acceptFiles">
			        'csv,txt'
			    </aui:validator>
			     <aui:validator name="required" errorMessage="L'allegato e' obbligatorio!"/>
		  </aui:input></div>
		  <div class="col-md-4"><aui:button type="submit"/></div>
		</div>       
	</div>
</aui:form>
</c:otherwise>
</c:choose>