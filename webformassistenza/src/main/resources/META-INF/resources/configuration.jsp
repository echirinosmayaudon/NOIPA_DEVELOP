<%@ include file="/init.jsp" %>

<div class="container p-4">
	    <liferay-ui:tabs
	    names="noipawebformassistenza.config.serviceconfig,noipawebformassistenza.config.contentconfig,noipawebformassistenza.config.mailconfig,noipawebformassistenza.config.csv.1,noipawebformassistenza.config.csv.2"
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
		       			<%@ include file="tabconfig/configCsv1.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
			       		<%@ include file="tabconfig/configCsv2.jsp" %>	
			    </liferay-ui:section>
		    </div>
	    </div>
	    </liferay-ui:tabs>


</div>


