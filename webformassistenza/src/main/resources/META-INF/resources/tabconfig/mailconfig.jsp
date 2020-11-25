
<%
    boolean noConfiContent = true;//NoiPAWebAssistenzaUtils.isValid(serviceUrl,sendMethod,chechMethod,userId,password,token,idWebContentTema,idWebContentRisposta,ConfigurazioneENUM.CONTENT);
%>

<c:choose>
    <c:when test="<%= !noConfiContent %>">
        <p>
            <liferay-ui:message key="noipawebformassistenza.no.content.config" />
        </p>
    </c:when>
    <c:otherwise>


        <p>
            <liferay-ui:message key="noipawebformassistenza.config.mailconfig" />
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
	       <div class="col-md-10"><aui:input name="noipa_type_config" type="hidden" value="mailconfig" required="<%= true %>" /></div>
	       <div class="col-md-1"></div> 
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="mailconfig-mail-hp" /></div>
		  <div class="col-md-4">
		  	<aui:input name="mailconfigMailHp" type="text"  label="" value="<%= mailconfigMailHp %>" required="<%= true %>" />
		  </div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="mailconfig-mail" /></div>
		  <div class="col-md-4"><aui:input name="mailconfigMail" type="text"  label="" value="<%=mailconfigMail %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="mailconfig-nominativo" /></div>
		  <div class="col-md-4"><aui:input name="mailconfigNominativo" type="text"  label="" value="<%=mailconfigNominativo %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="mailconfig-nominativo-be" /></div>
		  <div class="col-md-4"><aui:input name="mailconfigNominativoBE" type="text"  label="" value="<%=mailconfigNominativoBE %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
<%-- 		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="mailconfig-mail" /></div>
		  <div class="col-md-4"><aui:input name="mailconfigMail" type="hidden"  label="" value="NoReply.Assistenza.NoiPA@mef.gov.it" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
--%>  
		<div class="row">
		<div class="col-md-4"><aui:button type="submit"/></div>
		</div>  
		    

</aui:form>
</c:otherwise>
</c:choose>