<%@ include file="/init.jsp" %>

<div class="container p-4">
	    <liferay-ui:tabs
	    names="noipawebformassistenza.config.serviceconfig,noipawebformassistenza.config.contentconfig,noipawebformassistenza.config.mailconfig,noipawebformassistenza.config.csv.amministrazioni,noipawebformassistenza.config.csv.tipologie"
	    param="tabs2"
	    refresh="<%= false %>"
	    type="tabs nav-tabs-default"
	    >
		<div class="container-fluid">        
			<div class="card mt-2 p-4">
			    <liferay-ui:section >
		       			<%@ include file="tabconfig/serviceconfig.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
		       			<%@ include file="tabconfig/contentconfig.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
		       			<%@ include file="tabconfig/mailconfig.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
		       			<%@ include file="tabconfig/configAmministrazioni.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
			       		<%@ include file="tabconfig/configTipologie.jsp" %>	
			    </liferay-ui:section>
		    </div>
	    </div>
	    </liferay-ui:tabs>


</div>


