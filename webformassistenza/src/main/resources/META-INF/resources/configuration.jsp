<%@ include file="/init.jsp" %>

<div class="container p-4">
	    <liferay-ui:tabs
	    names="noipawebformassistenza.config.serviceconfig,noipawebformassistenza.config.contentconfig,noipawebformassistenza.config.mailconfig,noipawebformassistenza.config.amministrazione,noipawebformassistenza.config.catuser,noipawebformassistenza.config.area,noipawebformassistenza.config.tematica,noipawebformassistenza.config.tipologia"
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
		       			<%@ include file="tabconfig/amministrazione.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
			       		<%@ include file="tabconfig/categoriautenti.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
			       		<%@ include file="tabconfig/area.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
			       		<%@ include file="tabconfig/tematica.jsp" %>	
			    </liferay-ui:section>
			    <liferay-ui:section >
			       		<%@ include file="tabconfig/tipologiaproblema.jsp" %>	
			    </liferay-ui:section>
		    </div>
	    </div>
	    </liferay-ui:tabs>


</div>


