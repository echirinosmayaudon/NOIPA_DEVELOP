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
					<h2 class="mb-4 p-0 text-primary-dark text-32p font-weight-bold"><liferay-ui:message key="noipawebformassistenza.dati.supporto.${sezione}" /></h2>
					

					
					<p><liferay-ui:message key="noipawebformassistenza.dati.desc.nota1" /></p>
					 <c:if test = "${sezione eq 'Amministrato'}">
         				<p><liferay-ui:message key="noipawebformassistenza.dati.desc.nota2" /></p>
    				  </c:if>
					 
					   
    <liferay-ui:error key="" message=""/>
   
<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="Verificare il testo del captcha!" />
<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="Numero massimo di tentativi raggiunti!" />
    
    <portlet:actionURL name="sendMailChech" var="sendMailURL" />
    
    
    
    <aui:form name="fm" action="${sendMailURL}" enctype="multipart/form-data" method="post">
    	 <liferay-ui:error key="noipa.client.error.validation.required" message="noipa.client.error.validation.required" />
		<h3 class="my-4 p-0 text-primary-dark text-28p font-weight-bold border-bottom"><liferay-ui:message key="noipawebformassistenza.dati.us" /></h3>
			<div class="row">
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="nome"  id="nome" label="${sezione eq 'EntiCreditori' ? 'noipawebformassistenza.dati.denominazione' : 'noipawebformassistenza.dati.nome'}" cssClass="formControl" value="${nome}" onblur="validationEmptyMessage(this);">
				        
				         <c:if test = "${sezione ne 'EntiCreditori'}">
         					<aui:validator errorMessage="campo.alfa" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/^[a-zA-Z][\S]\D*$/i);
					                        return regex.test(val);
					                }
					        </aui:validator>	
    					 </c:if>
				        
					</aui:input>
						<div class="help-block d-none" role="alert" id="<portlet:namespace/>nomeErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="cognome"  id="cognome" label="${sezione eq 'EntiCreditori' ? 'noipawebformassistenza.dati.ragSociale' : 'noipawebformassistenza.dati.cognome'}" cssClass="formControl" value="${cognome}" onblur="validationEmptyMessage(this);">
				       
				        <c:if test = "${sezione ne 'EntiCreditori'}">
         					 <aui:validator errorMessage="campo.alfa" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/^[a-zA-Z][\S]\D*$/i);
					                        return regex.test(val);
					                }
					    	</aui:validator>
    					 </c:if>
				        
				       
					</aui:input>
						<div class="help-block d-none" role="alert" id="<portlet:namespace/>cognomeErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:input name="codfis"  id="codfis" label="${sezione eq 'EntiCreditori' ? 'noipawebformassistenza.dati.piva' : 'noipawebformassistenza.dati.cf'}" cssClass="formControl" value="${codfis}" maxlength="16" onblur="validationEmptyMessage(this);">
					        <aui:validator errorMessage="${sezione eq 'EntiCreditori' ? 'noipawebformassistenza.dati.piva.error' : 'noipawebformassistenza.dati.cf.error'}" name="custom">
					                function(val, fieldNode, ruleValue) {
					                        var regex = new RegExp(/(^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$)|(^[0-9]{11,11}$)/i);
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
			<div class="row" id="amminisRow">
				<div class="form-group required col-sm-8 mb-4">
					<aui:select name="amminis" id="amminis" label="noipawebformassistenza.dati.amm" value="${amminis}" onblur="validationEmptyMessage(this);">
						
					</aui:select>
					
					<div class="help-block d-none" role="alert" id="<portlet:namespace/>amminisErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">
					<aui:select name="catuser" id="catuser" label="noipawebformassistenza.dati.catuser"   value="${catuser}" onblur="validationEmptyMessage(this);">
					</aui:select>
					<div class="help-block d-none" id="<portlet:namespace/>catuserErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
			</div> 
			<div class="row">
				<div class="form-group required col-sm-4 mb-4">
					<aui:select name="area" id="area" label="noipawebformassistenza.dati.ar" value="${area}" 
					 onblur="validationEmptyMessage(this);">
						
					</aui:select>
					<div class="help-block d-none" id="<portlet:namespace/>areaErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4"> 
					<aui:select name="tematica" id="tematica" label="noipawebformassistenza.dati.tem"  value="${tematica}"
					 onblur="validationEmptyMessage(this);">
						
					</aui:select>
					<div class="help-block d-none" id="<portlet:namespace/>tematicaErrorMessage"><span class="control-error-message"><liferay-ui:message key="this-field-is-required" /></span></div>
				</div>
				<div class="form-group required col-sm-4 mb-4">  
					<aui:select name="tipologia" id="tipologia" label="noipawebformassistenza.dati.tip"   value="${tipologia}" onblur="validationEmptyMessage(this);">
						
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

<div class="text-center my-5">
		<aui:input name="sezione" type="hidden" value="${sezione}"/>
		<aui:input name="isSanita" type="hidden"/>
		<aui:input name="enteVal" type="hidden"/>
</div>

</aui:form>

</div>
</div>
</div>

 <portlet:resourceURL id="testoCaptchaAccessibileURL" var="testoCaptchaAccessibileURL" />


<script type="text/javascript">
	var emptyOptionText="<liferay-ui:message key='noipawebformassistenza.dati.seleziona' />";

	var amminis = "${amminis}";
	var catuser = "${catuser}";
	var area = "${area}";
	var tematica = "${tematica}";
	var tipologia = "${tipologia}";
	var sezione = "${sezione}"; 
	var jsonAmministrazioni=${jsonAmministrazioni};
	var jsonTipologie=${jsonTipologie};

	function resetComboz(combos) {
    	if (combos != null) {
        	for (var i = 0; i <= combos.length; i++) {
               if ($("#<portlet:namespace/>" + combos[i]).length) {
            	  $("#<portlet:namespace/>" + combos[i]).empty();
               }        
    		}
		}
	}
	//Metodo che controlla se la combo è stata popolata in precedenza è per qualsiasi motivo non siamo riusciti ad inviare la form il valore non si perderà
	//oppure il caso in cui la combo verrà caricata con un'unico valore esso deve essere selezzionato in automatico
	function checkValueComboz(idCombo,valueCombo,arrayCombo){
	//Vengo dal return la fail invio mail
		 if(valueCombo!=""){
				 $(idCombo).find('option[value="'+valueCombo+'"]').attr("selected","selected");
	        	//$(idCombo+' option[value="'+ valueCombo +'"]').attr("selected","selected");	
	        	$(idCombo).trigger( "change" );
	      //Primo avvio della form 	
	     }else if(arrayCombo.length==1){
	    	 //	console.log("check combo arrayCombo == 1");
	    	 	
	    		$($(idCombo).find('option')[1]).attr("selected","selected");
	        	$(idCombo).trigger( "change" );
			// Se la combo ha già l'option seleziona...  	
	      } 
	}

	function loadComboEnte(amministrazioni){
			comboz = $("#<portlet:namespace/>amminis");
			comboz.empty();
	        comboz.append("<option>"+emptyOptionText+"</option>");
	         
	        $.each(amministrazioni, function(i, item) {    
	        	$option = $("<option/>").attr("value", item.Tipo+"-"+item.Codice).text(item.Amministrazione);
	        	comboz.append($option);
	        });
	     
	    	//console.log("loadCombo amminis variabile amminis: "+amminis);
	        checkValueComboz("#<portlet:namespace/>amminis",amminis,amministrazioni);
	}
	
	function filterCategoria(){
	  _sezione = $("#<portlet:namespace/>sezione").val();
	  _isSanita = $("#<portlet:namespace/>isSanita").val();
		_items = [];
		$.each(jsonTipologie, function(i, item) {
			if(item.sezione==_sezione && item.sanita == _isSanita){
				if($.inArray(item.categoriaUtente,_items)< 0) {
				_items.push(item.categoriaUtente);
				}
			}
		});
	     
		return _items;
	}
	
	function filterArea(){
	  _sezione = $("#<portlet:namespace/>sezione").val();
	  _isSanita = $("#<portlet:namespace/>isSanita").val();
	  _cat = $("#<portlet:namespace/>catuser").val();
		_items = [];
		$.each(jsonTipologie, function(i, item) {
			if(item.sezione==_sezione && item.sanita == _isSanita && item.categoriaUtente == _cat){
				if($.inArray(item.area,_items)< 0) {
				_items.push(item.area);
				}
			}
		});
		
		return _items;
	}
	
	function filterTematica(){
	  _sezione = $("#<portlet:namespace/>sezione").val();
	  _isSanita = $("#<portlet:namespace/>isSanita").val();
	  _cat = $("#<portlet:namespace/>catuser").val();
	  _area  = $("#<portlet:namespace/>area").val();
		_items = [];
		$.each(jsonTipologie, function(i, item) {
			if(item.sezione==_sezione && item.sanita == _isSanita && item.categoriaUtente == _cat  && item.area == _area){
				if($.inArray(item.tematica,_items)< 0) {
				_items.push(item.tematica);
				}
			}
		});
		
		return _items;
	}
	
	function filterTipoProblema(){
		_sezione = $("#<portlet:namespace/>sezione").val();
	  _isSanita = $("#<portlet:namespace/>isSanita").val();
	  _cat = $("#<portlet:namespace/>catuser").val();
	  _area  = $("#<portlet:namespace/>area").val();
	  _tematica  = $("#<portlet:namespace/>tematica").val();
		_items = [];
		$.each(jsonTipologie, function(i, item) {
			if(item.sezione==_sezione && item.sanita == _isSanita && item.categoriaUtente == _cat  && item.area == _area && item.tematica == _tematica){
				if($.inArray(item.tipoProblema,_items)< 0) {
				_items.push(item.tipoProblema);
				}
			}
		});
		
		return _items;
	}
	
	function loadComboCategoria(){
		comboz = $("#<portlet:namespace/>catuser");
		comboz.empty();
		comboz.append("<option>"+emptyOptionText+"</option>");

        data = filterCategoria();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        
        checkValueComboz("#<portlet:namespace/>catuser",catuser,data);
	}
	
	function loadComboArea(){
		comboz = $("#<portlet:namespace/>area");
		comboz.empty();
		comboz.append("<option>"+emptyOptionText+"</option>");
        
        data = filterArea();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        
        checkValueComboz("#<portlet:namespace/>area",area,data);
	}
	
	function loadComboTematica(){
		comboz = $("#<portlet:namespace/>tematica");
		comboz.empty();
		comboz.append("<option>"+emptyOptionText+"</option>");
        data = filterTematica();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        
        checkValueComboz("#<portlet:namespace/>tematica",tematica,data);
	}

	function loadComboTipoProblema(){
		comboz = $("#<portlet:namespace/>tipologia");
		comboz.empty();
		comboz.append("<option>"+emptyOptionText+"</option>");
        data = filterTipoProblema();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        
        checkValueComboz("#<portlet:namespace/>tipologia",tipologia,data);
	}
	  

	$('#<portlet:namespace/>amminis').bind("change", function (event) { 
        _xval =  $(this).val();
        _innersVal = _xval.split("-");
   
        $('#<portlet:namespace/>isSanita').val(_innersVal[0]);
        $('#<portlet:namespace/>enteVal').val(_innersVal[1]);
      
        resetComboz(['catuser','area','tematica','tipologia']);
        
        if(_xval){
        	amminis = "";
       
        	loadComboCategoria(); 
        }
    });
	
	
	/*VALIDATO*/
    $('#<portlet:namespace/>catuser').bind("change", function (event) { 
        resetComboz(['area','tematica','tipologia']);
        if(_xval){  
         	catuser = "";
        	loadComboArea();        	        	        	
        }    
    });
    
    $('#<portlet:namespace/>area').bind("change", function (event) { 
        resetComboz(['tematica','tipologia']);
        if(_xval){   
        	area = "";
        	loadComboTematica();        	        	        	
        }
    });
    
    
    $('#<portlet:namespace/>tematica').bind("change", function (event) { 
        resetComboz(['tipologia']);
        if(_xval){     
        	 tematica = "";
        	 tipologia = "";
        	loadComboTipoProblema();        	        	        	
        }
    });
    
    $('#<portlet:namespace/>cancella').bind("click", function (event) { 
    	//Puliamo tutte le 
    	resetInputz();
    	resetComboz(['amminis','catuser','area','tematica','tipologia']);
    	initComboz();
    	
    });
    
    function resetInputz(){
    	$("#<portlet:namespace/>fm").find('input').each(function(index){
	    	var input=$(this);	
	    	
	    	if(input.attr("name")!="<portlet:namespace/>sezione"){
	    		input.attr("value","").text("");
	    	}
	    });
    	
    	$("#<portlet:namespace/>fm").find('textarea').each(function(index){
	    	var input=$(this);	
	    	input.attr("value","").text("");
	    });
    }
    
   function initComboz(){
			_sezione = $("#<portlet:namespace/>sezione").val();			
			if( _sezione == "Amministrato") {
				 var ente = $.grep(jsonAmministrazioni, function( item ) { return item.Amministrato == "S"; });
			 		loadComboEnte(ente);
			}; 
     
			if( _sezione == "MVP"){
			  var ente = $.grep(jsonAmministrazioni, function( item ) { return item.MVP == "S"; });
		      	loadComboEnte(ente);
			};
     
			if( _sezione == "AreaPensioni") {
				 $('#amminisRow').addClass("d-none");
      		  var ente = $.grep(jsonAmministrazioni, function( item ) { return item.AreaPensioni == "S"; });
			 	loadComboEnte(ente);
			};
     
			if( _sezione == "EntiCreditori") {
				 $('#amminisRow').addClass("d-none");
      			  var ente = $.grep(jsonAmministrazioni, function( item ) { return item.EntiCreditori == "S"; });
			 	loadComboEnte(ente);
			}
   }
    
   
  
    
</script>
	
<aui:script>
	AUI().ready(
		function(){
			//Primo caricamento delle combo
			initComboz();
		});	
</aui:script>		
	
	
<script >


function validationEmptyMessage(input){	
	var inputValue=input.value;
	var inputID=input.id;
	var divMessageID=inputID+"ErrorMessage";

		if(inputValue=="" || inputValue==emptyOptionText){
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
