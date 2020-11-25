<%
    boolean noConfigArea = true;//NoiPAWebAssistenzaUtils.isValid(mailconfigMail,mailconfigNominativo,mailconfigMailHp,linkAmministrazione, listaCategoriaUtenti, listaArea, listaTematica, listaTipologia, ConfigurazioneENUM.AREA);
%>

<c:choose>
	<c:when test="<%= !noConfigArea %>">
		<p>
			<liferay-ui:message key="noipawebformassistenza.no.catuser.config" />
		</p>
	</c:when>

	<c:otherwise>
		<p>
			<liferay-ui:message key="noipawebformassistenza.config.area" />
		</p>









<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />
<aui:form action="<%= configurationActionURL %>" enctype="multipart/form-data" method="post" name="fm3">

    <aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" />

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" />    
        
        <aui:input name="noipa_type_config" type="hidden" value="area" />
        
		
		<div id="content">
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  	<% if(Validator.isNotNull(listaArea)){ %>
		  		<span class="label label-success">Aree caricate correttamente</span>
		  	<% } else { %>
		  		<span class="label label-danger">Nessuna area caricata</span>
		  	<% } %>
		  		
		  </div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-3"></div>
		  <div class="col-md-5">
		  <aui:input type="file" name="fileConfigCSV" id="fileConfigCSV" helpMessage="tipi-documento" >
				<aui:validator name="acceptFiles">
			        'csv,txt'
			    </aui:validator>
			     <aui:validator name="required" errorMessage="L'allegato e' obbligatorio!"/>
		  </aui:input></div>
		</div>       
	</div>
		
       <aui:button type="submit"/>
</aui:form>

	</c:otherwise>
</c:choose>
