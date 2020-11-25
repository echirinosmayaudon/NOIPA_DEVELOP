        <p>
            <liferay-ui:message key="noipawebformassistenza.config.serviceconfig" />
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
	       <div class="col-md-10"><aui:input name="noipa_type_config" type="hidden" value="service" /></div>
	       <div class="col-md-1"></div> 
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="url-service" /></div>
		  <div class="col-md-4"><aui:input name="serviceUrl" type="text"  label="" value="<%= serviceUrl %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="service-insert-method" /></div>
		  <div class="col-md-4"><aui:input name="sendMethod" type="text"  label="" value="<%= sendMethod %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="service-check-method" /></div>
		  <div class="col-md-4"><aui:input name="chechMethod" type="text"  label="" value="<%= chechMethod %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="service-userid" /></div>
		  <div class="col-md-4"><aui:input name="userId" type="text"  label="" value="<%= userId %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="service-password" /></div>
		  <div class="col-md-4"><aui:input name="password" type="text"  label="" value="<%= password %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		  <div class="col-md-4"><liferay-ui:message key="service-token" /></div>
		  <div class="col-md-4"><aui:input name="token" type="text"  label="" value="<%= token %>" required="<%= true %>" /></div>
		  <div class="col-md-4"></div>
		</div>
		<div class="row">
		<div class="col-md-4"><aui:button type="submit"/></div>
		</div>       

</aui:form>
