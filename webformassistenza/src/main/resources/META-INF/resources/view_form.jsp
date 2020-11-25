<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="it.gov.mef.webformassistenza.noipa.configuration.bean.ConfigurazioneBeanEx"%>
<%@page import="java.util.Random"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


					<liferay-ui:error key="noipa.client.error" message="noipa.client.error" />
					<liferay-ui:error key="noipa.generic.error" message="noipa.generic.error" />
					<liferay-ui:error key="noipa.mail.error" message="noipa.mail.error" />
					<liferay-ui:error key="tipi.documento.allegato.val" message="tipi.documento.allegato.val" />
					<liferay-ui:error key="noipa.generic.error.400" message="noipa.generic.error.400" />
					<liferay-ui:error key="noipa.generic.error.413" message="noipa.generic.error.413" />
					<liferay-ui:error key="noipa.generic.error.500" message="noipa.generic.error.500" />
					
					
					<liferay-ui:error key="noipa.client.error.400" message="${error_descr}" />
					<liferay-ui:error key="noipa.client.error.413" message="${error_descr}" />
					<liferay-ui:error key="noipa.client.error.403" message="${error_descr}" />
					<liferay-ui:error key="noipa.client.error.500" message="${error_descr}" />
					

    
		<div class="BGContainer">
			<div class="container">
				<div class="">
					<h2 class="mb-4 p-0 text-primary-dark text-32p font-weight-bold"><liferay-ui:message key="noipawebformassistenza.dati.supporto" /></h2>
					

					
					<p><liferay-ui:message key="noipawebformassistenza.dati.desc.nota1" /></p>
					<p><liferay-ui:message key="noipawebformassistenza.dati.desc.nota2" /></p> 
					   
    <liferay-ui:error key="" message=""/>
   
<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="Verificare il testo del captcha!" />
<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="Numero massimo di tentativi raggiunti!" />
    
    <portlet:actionURL name="sendMailChech" var="sendMailURL" />
    
    
    
    <aui:form name="fm" action="${sendMailURL}" enctype="multipart/form-data" method="post">
    	 <liferay-ui:error key="noipa.client.error.validation.required" message="noipa.client.error.validation.required" />
		<h3 class="my-4 p-0 text-primary-dark text-28p font-weight-bold border-bottom"><liferay-ui:message key="noipawebformassistenza.dati.us" /></h3>
			<div class="row">
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="nome"  id="nome" label="noipawebformassistenza.dati.nome" cssClass="formControl" value="${nome}" onblur="validationEmptyMessage(this);">
				        <aui:validator errorMessage="campo.alfa" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/^[a-zA-Z][\S]\D*$/i);
					                        return regex.test(val);
					                }
					        </aui:validator>
					</aui:input>
						<div class="help-block d-none" role="alert" id="<portlet:namespace/>nomeErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="cognome"  id="cognome" label="noipawebformassistenza.dati.cognome" cssClass="formControl" value="${cognome}" onblur="validationEmptyMessage(this);">
				        <aui:validator errorMessage="campo.alfa" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/^[a-zA-Z][\S]\D*$/i);
					                        return regex.test(val);
					                }
					        </aui:validator>
					</aui:input>
						<div class="help-block d-none" role="alert" id="<portlet:namespace/>cognomeErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="codfis"  id="codfis" label="noipawebformassistenza.dati.cf" cssClass="formControl" value="${codfis}" maxlength="16" onblur="validationEmptyMessage(this);">
					        <aui:validator errorMessage="noipawebformassistenza.dati.cf.error" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/^[A-Z]{6}\d{2}[A-Z]\d{2}[A-Z]\d{3}[A-Z]$/i);
					                        return regex.test(val);
					                }
					        </aui:validator>
					</aui:input>
					<div class="help-block d-none" role="alert" id="<portlet:namespace/>codfisErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-sm-4 mb-4">
					<aui:input name="psti"  id="psti" label="noipawebformassistenza.dati.psti" cssClass="formControl" value="${psti}">
								<aui:validator name="alphanum" errorMessage="campo.alfanum"/>
					</aui:input>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="tel"  id="tel" label="noipawebformassistenza.dati.tel" cssClass="formControl" value="${tel}" helpMessage="campo.exptel.ex" onblur="validationEmptyMessage(this);">
							<aui:validator errorMessage="campo.exptel" name="custom">
										function(val, fieldNode, ruleValue) {
												var regex = new RegExp(/^[+]*\d{2,7}[.]*[/]*\d{4,}$/i);
												return regex.test(val);
										}
							</aui:validator>
					</aui:input>
					<div class="help-block d-none" role="alert" id="<portlet:namespace/>telErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="mail"  id="mail" label="noipawebformassistenza.dati.mail" cssClass="formControl" value="${mail}" onblur="validationEmptyMessage(this);">
						<aui:validator name="email" errorMessage="campo.mail"/>
					</aui:input>
					<div class="help-block d-none" role="alert" id="<portlet:namespace/>mailErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>		
			</div>

			
			
<h3 class="my-4 p-0 text-primary-dark text-28p font-weight-bold border-bottom"><liferay-ui:message key="noipawebformassistenza.dati.dett.seg" /></h3>
		<span class="sr-only"><liferay-ui:message key="noipa.client.aiuto.accessibilita.popolazione.combo" /></span>
			<div class="row">
				<div class="form-group required col-sm-8 mb-4">
					<aui:select name="amminis" id="amminis" label="noipawebformassistenza.dati.amm" value="${amminis}" onblur="validationEmptyMessage(this);">
						<aui:option value="" ><liferay-ui:message key="noipawebformassistenza.dati.seleziona" /></aui:option>
												<% 
				        for(ConfigurazioneBeanEx beanCU : listaEnti){
				        	String cuKey = beanCU.getKey();
				        	String cuValue = beanCU.getValue();
				        	cuValue = cuValue.contains("-X-") ? cuValue.replaceAll("-X-", "'"):cuValue;
				        	String cuFlag = beanCU.getRifKey();
				      	 %>
							<aui:option value="<%=cuFlag+"-"+cuKey%>" ><%=cuValue%></aui:option>
						<%  }  %>
					</aui:select>
					<div class="help-block d-none" role="alert" id="<portlet:namespace/>amminisErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:select name="catuser" id="catuser" label="noipawebformassistenza.dati.catuser"   value="${catuser}"
					disabled="${empty catuser or fn:length(catuser) eq 0}" onblur="validationEmptyMessage(this);">
						<c:choose>
						    <c:when test="${empty catuser or fn:length(catuser) eq 0}">
						        <aui:option value="" ><liferay-ui:message key="noipawebformassistenza.dati.seleziona" /></aui:option>
						    </c:when>
						    <c:otherwise>
						         <aui:option value="${catuser}" selected="<%=true%>">${catuser}</aui:option>
						    </c:otherwise>
						</c:choose>

<%-- 						<% 
				        for(ConfigurazioneBean beanCU : listaCategoriaUtenti){
				        	String cuKey = beanCU.getKey();
				        	String cuValue = beanCU.getValue();
				      	 %>
							<aui:option value="<%=cuValue%>"><%=cuKey%></aui:option>
						<%  }  %> --%>
					</aui:select>
					<div class="help-block d-none" id="<portlet:namespace/>catuserErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
			</div>
			<div class="row">
				<div class="form-group required col-sm-4 mb-4">
					<aui:select name="area" id="area" label="noipawebformassistenza.dati.ar" value="${area}" 
					disabled="${empty area or fn:length(area) eq 0}" onblur="validationEmptyMessage(this);">
						<c:choose>
						    <c:when test="${empty area or fn:length(area) eq 0}">
						        <aui:option value="" ><liferay-ui:message key="noipawebformassistenza.dati.seleziona" /></aui:option>
						    </c:when>
						    <c:otherwise>
						         <aui:option value="${area}" selected="<%=true%>">${area}</aui:option>
						    </c:otherwise>
						</c:choose>
					</aui:select>
					<div class="help-block d-none" id="<portlet:namespace/>areaErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:select name="tematica" id="tematica" label="noipawebformassistenza.dati.tem"  value="${tematica}"
					disabled="${empty tematica or fn:length(tematica) eq 0}" onblur="validationEmptyMessage(this);">
						<c:choose>
						    <c:when test="${empty tematica or fn:length(tematica) eq 0}">
						        <aui:option value="" ><liferay-ui:message key="noipawebformassistenza.dati.seleziona" /></aui:option>
						    </c:when>
						    <c:otherwise>
						         <aui:option value="${tematica}" selected="<%=true%>">${tematica}</aui:option>
						    </c:otherwise>
						</c:choose>
					</aui:select>
					<div class="help-block d-none" id="<portlet:namespace/>tematicaErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:select name="tipologia" id="tipologia" label="noipawebformassistenza.dati.tip"   value="${tipologia}" 
					disabled="${empty tipologia or fn:length(tipologia) eq 0}" onblur="validationEmptyMessage(this);">
						<c:choose>
						    <c:when test="${empty tipologia or fn:length(tipologia) eq 0}">
						        <aui:option value="" ><liferay-ui:message key="noipawebformassistenza.dati.seleziona" /></aui:option>
						    </c:when>
						    <c:otherwise>
						         <aui:option value="${tipologia}" selected="<%=true%>">${tipologia}</aui:option>
						    </c:otherwise>
						</c:choose>
					</aui:select>
					<div class="help-block d-none" role="alert" id="<portlet:namespace/>tipologiaErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
			</div>

			<div class="row">
				<div class="form-group required col-sm-12 mb-4">
							<span class="sr-only"><liferay-ui:message key="noipa.client.aiuto.accessibilita.popolazione.descrizione" /></span>
					<aui:input type="textarea" name="descrizione"  id="descrizione" label="noipawebformassistenza.dati.desc" cssClass="formControl" value="${descrizione}" rows="5" cols="70" onblur="validationEmptyMessage(this);">
						<aui:validator name="maxLength" errorMessage="campo.desc">2000</aui:validator>
					</aui:input>
					<div class="help-block d-none" role="alert" id="<portlet:namespace/>descrizioneErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12">
					<p aria-hidden="true"><small><liferay-ui:message key="noipawebformassistenza.dati.desc.nota" /></small><p>
					<p><small><liferay-ui:message key="noipawebformassistenza.dati.desc.info" /></small><p>
				</div>
			</div>


	
	<h3 class="my-4 p-0 text-primary-dark text-28p font-weight-bold border-bottom"><liferay-ui:message key="noipawebformassistenza.dati.filtro.captcha-text" /></h3>
<%-- 		<div class="container-fluid">
			<div class="row">
				<div class="form-group col-sm-4 mb-4">
					<label><liferay-ui:message key="noipawebformassistenza.dati.filtro.captcha-text" /></label>
				</div>
				<div class="form-group col-sm-4 mb-4">
<portlet:resourceURL var="captchaURL"/>
  <img style="float:left;padding:0px !important;margin-left:10px;" alt='<liferay-ui:message key="text-to-identify" />' class="captcha" border=0 src="${captchaURL}<%= "&amp;" + new Random().nextInt(Integer.MAX_VALUE) %>" />  
  <a href="#" class="refreshCaptcha captcha-reload ml-4" style="text-decoration: none;">
  	<i class="fas fa-sync-alt"></i>
  </a>

		
				</div>
				<div class="form-group col-sm-4 mb-4">
    <aui:input label="noipawebformassistenza.dati.filtro.risp" name="captchaText" size="10" type="text" value="">
      <aui:validator name="required" />
    </aui:input>					
			
				</div>
			</div>
		</div> --%>
		
 
<div class="container-fluid">
    <div class="row mt-4 rounded p-3 font-weight-700">
        <div class="form-group col-sm-3 pr-0 rounded p-3 font-weight-700 text-primary">
        
        	<!-- <portlet:resourceURL id="captchaAccessibile" var="captchaAccessibile"/> -->
            <portlet:resourceURL id="captchaURL" var="captchaURL" />
            
            <img style="float:left;padding:0px !important;margin-left:10px;" alt='<liferay-ui:message key="text-to-identify" />' class="captcha" border=0 src="${captchaURL}<%= " &amp; " + new Random().nextInt(Integer.MAX_VALUE) %>" />
            <a aria-label="<liferay-ui:message key="noipawebformassistenza.label.captcha.refresh.accessibilita" />" title="<liferay-ui:message key="noipawebformassistenza.label.captcha.refresh.accessibilita" />" href="#" class="refreshCaptcha captcha-reload ml-4" style="text-decoration: none;"><span class="sr-only"><liferay-ui:message key="noipawebformassistenza.label.captcha.refresh.accessibilita" /></span> <span class="fas fa-sync-alt"></span></a>
			<!-- <br/>
			<a href="#" class="text-24p font-weight-700">
				<span class="sr-only"></span>
				<i class="fa text-primary fa-volume-up ml-4"></i>
			</a> -->
        </div>
        <div class="form-group required col-sm-7 mb-7">
        	<span id="domandaCaptchaAccessibile" class="sr-only"></span>
        
            <aui:input label="noipawebformassistenza.dati.filtro.risp" name="captchaText" size="10" type="text" onblur="validationEmptyMessage(this);">
            
            </aui:input>
			<div class="help-block d-none" role="alert" id="<portlet:namespace/>captchaTextErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
        </div>
    </div>
</div>
		
		
		
		
		
		<!--  -->
		
		
	<h3 class="my-4 p-0 text-primary-dark text-28p font-weight-bold border-bottom"><liferay-ui:message key="noipawebformassistenza.dati.file" /></h3>
		<div class="container-fluid">
			<div class="row">
				<div class="form-group col-sm-12 mb-4">
					<aui:input type="file" name="fileAllegatoWF" id="fileAllegatoWF" cssClass="noipa-file" helpMessage="tipi.documento.allegato" onchange="setUploadSize(this)" >
 						<aui:validator name="acceptFiles" errorMessage="tipi.documento.allegato.val">
					        '<%=mailconfigMailHp %>'
					    </aui:validator>
 						<aui:validator name="custom" errorMessage="noipa.client.error.413">
                            function(val,node,junction){
                                if(uploadSize==true){
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                        </aui:validator>
					 </aui:input>
				</div>
			</div>
		</div>
		
		<!--  -->


	<p><liferay-ui:message key="noipawebformassistenza.dati.dett.note" /></p>
	<br>
	<p>
	<liferay-ui:message key="noipawebformassistenza.dati.nota.finale" />
	<liferay-ui:message key="noipawebformassistenza.dati.nota.finale.link" />
	</p>

	<div class="text-center my-5">
		<aui:button-row>
			<aui:button type="submit" name="invia"
				value="noipawebformassistenza.dati.in" cssClass="btn btn-primary btm-noipa" />
			<aui:button type="reset" name="cancella"
				value="noipawebformassistenza.dati.clear" cssClass="btn btn-primary btm-noipa" />
		</aui:button-row>
	</div>

<%-- <div class="row">
	<div class="col-sm-12">
		<liferay-ui:message key="noipawebformassistenza.dati.nota.concl" />
		<liferay-ui:message key="noipawebformassistenza.dati.nota.concl.link" arguments="<%=mailconfigMail %>" />
	</div>
</div>
 --%>

</aui:form>

</div>
</div>
</div>

 <portlet:resourceURL id="testoCaptchaAccessibileURL" var="testoCaptchaAccessibileURL" />





		<aui:script>
		function clearCombo(comboId,booleanDisable) {
			$("#<portlet:namespace/>" + comboId).empty();
			$optionVoid = $("<option/>").attr("value", "").text("<liferay-ui:message key="noipawebformassistenza.dati.seleziona" />");
			$("#<portlet:namespace/>" + comboId).append($optionVoid);
			if(booleanDisable) {
				$("#<portlet:namespace/>" + comboId).prop('disabled', booleanDisable);
			}
			else {
				$("#<portlet:namespace/>" + comboId).removeAttr('disabled');
			}
		}
		
		
		AUI()
		.use(
				'aui-base',
				'aui-io-request',
				function(A) {
					A
							.one("#<portlet:namespace/>amminis")
							.on(
									'change',
									function() {
										var inputObject = A
												.one(
														"#<portlet:namespace/>amminis")
												.get('value');
										console.log("inputObject: "+inputObject);
										console.log("appoCU: "+appoCU);
										clearCombo('catuser',false);
										clearCombo('area',true);
										clearCombo('tematica',true);
										clearCombo('tipologia',true);
										$.each(appoCU, function (index, element) {
											console.log(element.key);
											if(includesIE(inputObject,"-")){
												if(element.key == inputObject.split("-")[0]){
													$option = $("<option/>").attr("value", element.value).text(element.value);
													$("#<portlet:namespace/>catuser").append($option);
													console.log($option);
												}
										}
										});
									});

				});
		
		
		
		
			AUI()
					.use(
							'aui-base',
							'aui-io-request',
							function(A) {
								A
										.one("#<portlet:namespace/>catuser")
										.on(
												'change',
												function() {
													var inputObject = A
															.one(
																	"#<portlet:namespace/>catuser")
															.get('value');
													console.log("inputObject: "+inputObject);
													clearCombo('area',false);
													clearCombo('tematica',true);
													clearCombo('tipologia',true);
													$.each(appoA, function (index, element) {
														if(element.value == inputObject){
															var valueA = element.key+"-"+element.type;
															$option = $("<option/>").attr("value", valueA).text(element.type);
															$("#<portlet:namespace/>area").append($option);
															console.log($option);
														}
													});
												});

							});
			
			
			AUI()
			.use(
					'aui-base',
					'aui-io-request',
					function(A) {
						A
								.one("#<portlet:namespace/>area")
								.on(
										'change',
										function() {
											var inputObject = A
													.one(
															"#<portlet:namespace/>area")
													.get('value');
											
											var inputObjectCU = A
											.one(
													"#<portlet:namespace/>catuser")
											.get('value');
											
											console.log("inputObjectA: "+inputObject);
											var listOps = [];
											clearCombo('tematica',false);
											clearCombo('tipologia',true);
											$.each(appoTm, function (index, element) {
												if(includesIE(inputObject,"-")){
													
													
													var flag = inputObject.split("-")[0];
													var okF = false;
													if(flag == "S"){
														
														okF = includesIE(element.key.toUpperCase(), "Sanit".toUpperCase()); 
														
													} else {
														okF = !includesIE(element.key.toUpperCase(), "Sanit".toUpperCase());
													}
													
													
													if(element.value == inputObject.split("-")[1] && okF && inputObjectCU == element.key && !includesIE(listOps,element.type)){
														var valueT = inputObject.split("-")[0]+"-"+element.type;
														$option = $("<option/>").attr("value", valueT).text(element.type);
														$("#<portlet:namespace/>tematica").append($option);
														listOps.push(element.type);
													}
												}
											});
										});

					});
			
			AUI()
			.use(
					'aui-base',
					'aui-io-request',
					function(A) {
						A
								.one("#<portlet:namespace/>tematica")
								.on(
										'change',
										function() {
											var inputObject = A
													.one(
															"#<portlet:namespace/>tematica")
													.get('value');
											
											
											
												var inputObjectCA = A
												.one(
														"#<portlet:namespace/>catuser")
												.get('value');
												
												var inputObjectAr = A
												.one(
														"#<portlet:namespace/>area")
												.get('value');
												
												
											console.log("inputObject: "+inputObject);
											var listOps = [];
											clearCombo('tipologia',false);
											$.each(appoTp, function (index, element) {
												if(includesIE(inputObject,"-")){
													
													
													
													
													var flag = inputObject.split("-")[0];
													var okF = false;
													if(flag == "S"){
														
														okF = includesIE(element.key.toUpperCase(), "Sanit".toUpperCase()); 
														
													} else {
														okF = !includesIE(element.key.toUpperCase(), "Sanit".toUpperCase());
													}
													
													if(okF && inputObjectCA == element.key && inputObjectAr.split("-")[1] == element.value && element.type == inputObject.split("-")[1]){
													
													/* if(element.key == inputObject.split("-")[0] && element.value == inputObject.split("-")[1] && !includesIE(listOps,element.type)){ */
														$option = $("<option/>").attr("value", element.extra).text(element.extra);
														$("#<portlet:namespace/>tipologia").append($option);
														listOps.push(element.extra);
													}
												}
											});
										});

					});
			
		</aui:script>
<script>
function validationEmptyMessage(input){
	var inputValue=input.value;
	var inputID=input.id;
	var divMessageID=inputID+"ErrorMessage";
	
		if(inputValue==""){
			$("#"+inputID).attr("aria-invalid","true");
			$("#"+inputID).attr("aria-describedby",divMessageID);
			$("#"+divMessageID).removeClass("d-none");
		}else{
			$("#"+inputID).removeAttr("aria-invalid");
			$("#"+inputID).removeAttr("aria-describedby");
			$("#"+divMessageID).addClass("d-none");
		}
}

jQuery("document").ready(function(){
		setCaptchaDomandaAccessibile();
	});
		
jQuery(".refreshCaptcha").click(function(evt){
	jQuery(".captcha").attr('src', '${captchaURL}&amp;force='+encodeURIComponent(Math.floor(Math.random()*Math.pow(2, 53))));
		setTimeout(function(){setCaptchaDomandaAccessibile();}, 200);
	  evt.preventDefault();
	});
	
function setCaptchaDomandaAccessibile(){
	$.ajax({
		type: "GET",
		url:'${testoCaptchaAccessibileURL}',
		success: function(value){
			$("#domandaCaptchaAccessibile").text(value);
	}	
	});
}

function includesIE(container, value) {
	var returnValue = false;
	var pos = container.indexOf(value);
	if (pos >= 0) {
		returnValue = true;
	}
	return returnValue;
}

	var uploadSize = true;
	function setUploadSize(fileInput) {
		var size = 0;
		for (var num1 = 0; num1 < fileInput.files.length; num1++) {
			var file = fileInput.files[num1];
			if (file.size > 1024000) {
				document.getElementById('<portlet:namespace/>fileAllegatoWF')
						.focus();
				uploadSize = false;
			} else {
				uploadSize = true;
			}
			size += file.size;
		}
	}
</script>
