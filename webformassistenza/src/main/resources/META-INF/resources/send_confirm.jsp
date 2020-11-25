<%@ include file="/init.jsp" %>


<!-- 

    	actionRequest.setAttribute("nome", nome);
    	actionRequest.setAttribute("cognome", cognome);
    	actionRequest.setAttribute("codfis", codfis);
    	actionRequest.setAttribute("psti", psti);
    	actionRequest.setAttribute("tel", tel);
    	actionRequest.setAttribute("mail", mail);
    	actionRequest.setAttribute("amminis", amminis);
    	actionRequest.setAttribute("catuser", catuser);
    	actionRequest.setAttribute("area", area);
    	actionRequest.setAttribute("tematica", tematica);
    	actionRequest.setAttribute("tipologia", tipologia);
    	actionRequest.setAttribute("descrizione", descrizione);

 -->


   <portlet:actionURL name="sendMailHD" var="sendMailHDURL">
   			<portlet:param name="nome" value="${nome}"/>
   			<portlet:param name="cognome" value="${cognome}"/>
   			<portlet:param name="codfis" value="${codfis}"/>
   			<portlet:param name="psti" value="${psti}"/>
   			<portlet:param name="tel" value="${tel}"/>
   			<portlet:param name="mail" value="${mail}"/>
   			<portlet:param name="amminis" value="${amminis}"/>
   			<portlet:param name="catuser" value="${catuser}"/>
   			<portlet:param name="area" value="${area}"/>
   			<portlet:param name="tematica" value="${tematica}"/>
   			<portlet:param name="tipologia" value="${tipologia}"/>
   			<portlet:param name="descrizione" value="${descrizione}"/>
   </portlet:actionURL>
    
    <aui:form name="fm" action="${sendMailHDURL}" method="post">
    
    	
			<div class="row">
				<div class="col-sm-4">
				</div>
				<div class="col-sm-4">
					<div class="alert alert-success">
					<strong>Trascriva\Incolli</strong> il codice che le &egrave; stato inviato alla mail E-mail: ${mail}.
					<br/>
					</div>
				</div>
				<div class="col-sm-4">
				</div>				
			</div>
    	
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-4">
				</div>
				<div class="col-sm-4">
					<aui:input name="check_code_mail"  id="check_code_mail" label="Codice di Verifica" cssClass="formControl" required="<%= true %>" value="${check_code_mail}" />
				</div>
				<div class="col-sm-4">
				</div>				
			</div>
			<div class="row" id="div_button" style="visibility: hidden" >
				<div class="col-sm-4"></div>
				<div class="col-sm-4 text-center mt-3 border-top pt-4">
					<aui:button-row>
						<aui:button type="submit" name="invia"
							value="noipawebformassistenza.dati.in" cssClass="btn btn-primary btm-noipa" />
						<aui:button type="reset" name="cancella"
							value="noipawebformassistenza.dati.clear" cssClass="btn btn-primary btm-noipa" />
					</aui:button-row>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</div>
    </aui:form>
    
    <script type="text/javascript">
		$('#<portlet:namespace/>check_code_mail').keyup(function () {
		  
			if($(this).val() == $('#uuid_mail').val()){
				$('#div_button').css('visibility', 'inherit');
			} else {
				$('#div_button').css('visibility', 'hidden');
			}
			 
			
		});inherit;
    
    </script>
    
    
    <style>
	.btm-noipa {
	    color: #FFFF;
	}
	.lexicon-icon {
    display: inline;
    fill: currentColor;
    height: 13px;
    transform: translateZ(0);
    vertical-align: middle;
    width: 13px;
}
.label-noipa{
	font-size: 15px;
}
</style>