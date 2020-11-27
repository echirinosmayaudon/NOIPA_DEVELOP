<%
    boolean noConfigCatUser = true;//NoiPAWebAssistenzaUtils.isValid(mailconfigMail,mailconfigNominativo,mailconfigMailHp,linkAmministrazione, listaCategoriaUtenti, listaArea, listaTematica, listaTipologia, ConfigurazioneENUM.CATEGORIA_UTENTI);
%>

<liferay-portlet:resourceURL id="/config/download/csv"
	var="downloadCsvUrl" copyCurrentRenderParameters="<%=false%>" >
	<liferay-portlet:param name="typeConfig" value="listaTipologie" />
</liferay-portlet:resourceURL>

<c:choose>
    <c:when test="<%= !noConfigCatUser %>">
        <p>
            <liferay-ui:message key="noipawebformassistenza.no.admin.config" />
        </p>
    </c:when>

    <c:otherwise>
        
        
        <p>
            <liferay-ui:message key="noipawebformassistenza.config.csv.tipologie" />
        </p>

        
        
<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />
<aui:form action="<%= configurationActionURL %>" enctype="multipart/form-data" method="post" name="fm2">

    <aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" />

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" />    
        
        <aui:input name="noipa_type_config" type="hidden" value="csvTipologie" />
        
		<div class="container">
		<div class="row">

		  <div class="col-md-10">
		  	<% if(Validator.isNotNull(listaTipologie)){ 
		  	
		  		renderRequest.getPortletSession().setAttribute("config.session.lista.tipologie", listaTipologie);
		  	%>
		  		<span class="label label-success">File csv Tipologie caricato correttamente</span>
		  	<% } else { %>
		  		<span class="label label-danger">Nessun file caricata</span>
		  	<% } %>
		  		
		  </div>
		  <div class="col-md-2"></div>
		</div>
		<div class="row">
		 
		  <div class="col-md-6">
			  <aui:input label="File csv Tipologie" type="file" name="fileConfigCSV" id="fileConfigCSV" helpMessage="tipi-documento" >
					<aui:validator name="acceptFiles">
				        'csv,txt'
				    </aui:validator>
				     <aui:validator name="required" errorMessage="L'allegato e' obbligatorio!"/>
			  </aui:input>
		  </div>
		  
		  	<div class="col-md-1"><aui:button type="submit"/></div>
		  	<div class="col-md-5">
		  	<% if(Validator.isNotNull(listaTipologie)){ %>
				<aui:a href="<%=downloadCsvUrl%>" label="Scarica CSV"
					cssClass="btn btn-primary btn-default">
				</aui:a>
			<%}%>	
			</div>
		</div>   
		
	</div>
	
</aui:form>


</c:otherwise>
</c:choose>
        