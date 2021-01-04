
<%
    boolean noConfigService = true;//NoiPAWebAssistenzaUtils.isValid(serviceUrl,sendMethod,chechMethod,userId,password,token,idWebContentTema,idWebContentRisposta,ConfigurazioneENUM.SERVICE);
	_log.info("noConfigService: "+noConfigService);
%>

<c:choose>
    <c:when test="<%= !noConfigService %>">
        <p>
            <liferay-ui:message key="noipawebformassistenza.no.service.config" />
        </p>
    </c:when>
    <c:otherwise>


        <p>
            <liferay-ui:message key="noipawebformassistenza.config.contentconfig" />
        </p>

    <liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />
<aui:form action="<%= configurationActionURL %>" method="post" name="fm1">

    <aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" />

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" />    

		<div class="row">
	       <div class="col-md-1"></div> 
	       <div class="col-md-10"><aui:input name="noipa_type_config" type="hidden" value="content" /></div>
	       <div class="col-md-1"></div> 
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="id-struttura.tema" /></div>
		  <div class="col-md-4">
		  <aui:input name="idWebContentTema" type="text"  label="" value="<%= idWebContentTema %>" >
		  	<aui:validator name="number" />
		  </aui:input></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="id-struttura.risposta" /></div>
		  <div class="col-md-4">
		  <aui:input name="idWebContentRisposta" type="text"  label="" value="<%= idWebContentRisposta %>" >
		  	<aui:validator name="number" />
		  </aui:input></div>
		  <div class="col-md-4"></div>
		</div>
		
		<div class="row">
		  <div class="col-md-4">Link documento privacy</div>
		  <div class="col-md-4">
		  <aui:input name="linkDocumentoPrivacy" type="text"  label="" value="<%= linkDocumentoPrivacy %>" >
		  </aui:input></div>
		  <div class="col-md-4"></div>
		</div>
		
		<div class="row">
		<div class="col-md-4"><aui:button type="submit"/></div>
		</div>       

</aui:form>
</c:otherwise>
</c:choose>