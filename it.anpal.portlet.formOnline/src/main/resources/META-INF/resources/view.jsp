<%@ include file="init.jsp"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>


<script type="text/javascript" src="<%=request.getContextPath()%>/Javascript/DynamicSelect.js"></script>
<script src="https://www.google.com/recaptcha/api.js?onload=callback&render=explicit" async defer></script>

<liferay-ui:success key="success" message="anpal.formonline.label.success"/>
<liferay-ui:error key="error" message="anpal.formonline.label.captcha.error"/>

<%
JSONArray jsonArray = JSONFactoryUtil.createJSONArray(_portletConfig.mappaForm());
List<String> sezioni = new ArrayList();

for (int i = 0; i<jsonArray.length() ; i++){
	JSONObject json = (JSONObject)jsonArray.get(i);
	
	if(!sezioni.contains(json.get("tipo")))
		sezioni.add(json.getString("tipo")); 
}

request.setAttribute("sezioniList", sezioni);
request.setAttribute("jArray", jsonArray);
request.setAttribute("pdfLink", linkPDF);

%>

<portlet:renderURL var="viewURL">
</portlet:renderURL>

<portlet:actionURL name="sendMail" var="sendMailURL"></portlet:actionURL>

<div class="col-md-10" style="margin-left: 5%">
	<h1><liferay-ui:message key="anpal.formonline.label.title" /></h1>
</div>

<aui:form action="<%=sendMailURL%>" name="fm" method="POST" style="margin-left: 5%">

	<div class="col-md-10">
		<div class="row">
			<div class="col-11">
				<aui:select label="anpal.formonline.label.sezioni" ignoreRequestValue="true" name="ScegliTipologia" class="col-md-12" style="padding-left:0px"
					helpMessage="anpal.formonline.help.sezioni-message" >
					<aui:option selected="true" value="ALL"><liferay-ui:message key="anpal.formonline.blank-option.sezioni" /></aui:option>
					<c:forEach items="${sezioniList}" var="element">
						<aui:option value="${element}">${element}</aui:option>
					</c:forEach>
				</aui:select>
			</div>
		</div>
	</div>
	<br> <br>

	<div id="<portlet:namespace />completeForm" class="col-md-10 d-none">
	
	<div>
		<h3 class="col-10"><liferay-ui:message key="anpal.formonline.label.subtitle" /></h3>
	</div>
	
	<aui:fieldset>
		
		<aui:input name="nome" 
				   ignoreRequestValue="true"
				   label="anpal.formonline.label.nome" 
				   placeholder="anpal.formonline.placeholder.nome" 
				   helpMessage="anpal.formonline.help.nome-message" >
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.nome" />
			<aui:validator name="custom" errorMessage="anpal.formonline.error.parse.nome">
				function(val,fieldNode,ruleValue){
                        var regex = new RegExp("^[a-zA-Z‡ÚËÈÏ]+(?:([ '])?[a-zA-Z‡ÚËÈÏ]+)*$");
                        return regex.test(val);
                                }
			</aui:validator>
		</aui:input>
		
		<aui:input name="cognome" label="anpal.formonline.label.cognome" ignoreRequestValue="true"
			placeholder="anpal.formonline.placeholder.cognome" 
			helpMessage="anpal.formonline.help.cognome-message">
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.cognome" />
						<aui:validator name="custom" errorMessage="anpal.formonline.error.parse.cognome">
				function(val,fieldNode,ruleValue){
                        var regex = new RegExp("^[a-zA-Z‡ÚËÈÏ]+(?:([ '])?[a-zA-Z‡ÚËÈÏ]+)*$");
                        return regex.test(val);
                                }
			</aui:validator>
		</aui:input>
		
		<aui:input name="CF" 
				label="anpal.formonline.label.cf" 
				ignoreRequestValue="true"
				placeholder="anpal.formonline.placeholder.cf" 
				type="text" 
				helpMessage="anpal.formonline.help.cf-message" 
				maxLength="16">
				<aui:validator name="required" errorMessage="anpal.formonline.error.required.cf" />
				<aui:validator
					errorMessage="anpal.formonline.error.custom.cf"
					name="custom">
                	function(val, fieldNode, ruleValue) {
                		var regex = new RegExp("(^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$)|(^[0-9]{11,11}$)");
                		return (regex.test(val));
               		}
        		</aui:validator>
			</aui:input>
			
			<aui:input label="Non conosco il mio codice fiscale" name="no-cf" type="checkbox" value="X"  />

		<aui:select label="anpal.formonline.label.user" name="Users" helpMessage="anpal.formonline.help.users-message" required="true">
			<aui:option selected="true" value=""></aui:option>
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.user" />
		</aui:select>

		<aui:select
			label="anpal.formonline.label.second-categories"
			name="SecondCategories" helpMessage="anpal.formonline.help.second-categories-message" required="true">
			<aui:option selected="true" value=""></aui:option>
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.second-categories" />
		</aui:select>
		
		<span id="<portlet:namespace />subCategories" class="d-none">
		<aui:select label="anpal.formonline.label.sub-categories" name="SubCategories" helpMessage="anpal.formonline.help.sub-categories-message" required="true">
			<aui:option selected="true" value=""></aui:option>
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.sub-categories" />
		</aui:select>
		</span>

		<aui:input label="anpal.formonline.label.richiesta" 
			name="Oggetto"
			type="textarea" ignoreRequestValue="true" 
			helpMessage="anpal.formonline.help.richiesta-message">
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.richiesta" />
		</aui:input>

			<div class="campi-Allegati" id="campi-Allegati">
                    <div class="lfr-form-row lfr-form-row-inline">
                        <div class="row-fields d-flex align-items-center" style="display: flex;">
                            <div name="icon_check" id="icon_check" class="d-none mr-2">
                            <liferay-ui:icon image="check" message=""/>
                            </div>
                            <div>
                            <aui:input fieldParam='Allegato0'
                                id='Allegato0' name="Allegato0"
                                label="anpal.formonline.label.allegati" type="file"
                                helpMessage="anpal.formonline.help.allegati-message" 
                                onChange="checkFile(this.id)"
                                value=""> 
                                <aui:validator name="custom" errorMessage="anpal.formonline.error.custom.allegati">
                                function(val,fieldNode,ruleValue){
                                let currentID = fieldNode._node.id;
                                let filesize = fieldNode._node.files[0].size;
                                let node = document.getElementById(currentID);
                                let iconNode = node.parentNode.parentNode.parentNode.childNodes[1]
                                	
                                	if(filesize > 1048576 ){
                                	iconNode.classList.add("d-none");
                                	return false;
                                	}else{
	                                	if(filesize == 0 ){
	                                		iconNode.classList.add("d-none");
	                                	} else {
	                                		iconNode.classList.remove("d-none");
	                                	}                                	
                                	return true;
                                	}
                                }
                                </aui:validator>
                                </aui:input>
                             </div>   
                        </div>
                    </div>
                </div>
		
		<aui:input name="emailAddress" 
				label="anpal.formonline.label.email-address" 
				ignoreRequestValue="true"
				placeholder="anpal.formonline.placeholder.email-address" 
				helpMessage="anpal.formonline.help.email-address-message">
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.email-address" />
			<aui:validator name="email" errorMessage="anpal.formonline.error.email.email-address" />
		</aui:input>
		<aui:input name="emailAddressConfirm" 
				label="anpal.formonline.label.email-address-confirm" 
				ignoreRequestValue="true"
				placeholder="anpal.formonline.placeholder.email-address-confirm" 
				helpMessage="anpal.formonline.help.email-address-confirm-message">
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.email-address-confirm" />
			<aui:validator name="email" errorMessage="anpal.formonline.error.email.email-address" />
			<aui:validator name="equalTo" 
					errorMessage="anpal.formonline.error.equal.email-address-confirm" >'#<portlet:namespace />emailAddress'</aui:validator>
		</aui:input>

		<aui:input name="telefono" 
					label="anpal.formonline.label.telefono" 
					ignoreRequestValue="true"
					placeholder="anpal.formonline.placeholder.telefono" 
					helpMessage="anpal.formonline.help.telefono-message">
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.telefono" />
			<aui:validator
					errorMessage="anpal.formonline.error.custom.parse.telefono"
					name="custom">
                	function(val, fieldNode, ruleValue) {
                		var regex = new RegExp("^[0-9-+s()]*$");
                		return (regex.test(val));
               		}
        		</aui:validator>
		</aui:input>
		<aui:input name="telefonoConfirm" 
					label="anpal.formonline.label.telefono-confirm" 
					ignoreRequestValue="true"
					placeholder="anpal.formonline.placeholder.telefono-confirm" 
					helpMessage="anpal.formonline.help.telefono-confirm-message">
			<aui:validator name="required" errorMessage="anpal.formonline.error.required.telefono-confirm" />
			<aui:validator name="equalTo" errorMessage="anpal.formonline.error.equal.telefono-confirm">'#<portlet:namespace />telefono'</aui:validator>
			<aui:validator
					errorMessage="errore numero"
					name="custom">
                	function(val, fieldNode, ruleValue) {
                		var regex = new RegExp("^[0-9-+s()]*$");
                		return (regex.test(val));
               		}
        		</aui:validator>
		</aui:input>

			<div class="col-md-10">
 					<br><aui:input 
 					label="<a href='${pdfLink}' target='_blank'>Leggere l'informativa sulla privacy</a>" 
 					ignoreRequestValue="true" 
 					name="checkboxGDPR" 
 					type="checkbox" 
 					cssClass="mr-2">
					<aui:validator name="required" errorMessage="anpal.formonline.error.required.privacy"/>
				</aui:input>
 				</div>

	</aui:fieldset>
	
	<br>	
		<div id="id-google-captcha" data-callback="recaptchaCallback"></div>
		<aui:input ignoreRequestValue="true" 
					label="" value="" id="captcha" name="Captcha" hidden="true">
			<aui:validator name="required" errorMessage="Dimostra di non essere un robot"/>
		</aui:input>
	
	<aui:button-row>
		<aui:button value="Invia" type="submit" ></aui:button>
		<aui:button value="Azzera" type="cancel" onClick="<%=viewURL%>" ></aui:button>
	</aui:button-row>
	</div>
</aui:form>

<aui:script>
AUI().use('liferay-auto-fields',function(A) {
 var maxRow = 5;
 var autoFields = new Liferay.AutoFields(
       {
           contentBox: '#campi-Allegati',
           fieldIndexes: '<portlet:namespace />indexAllegati'
       }
   );
   // Evento aggiunta riga
autoFields.on("clone", function(newField) {
            
            var _guid = this._guid;
            var fieldName = "<portlet:namespace />Allegato";
            console.log("add AUI");
            
            fieldName = fieldName + (_guid-1);
            document.getElementById(fieldName).value="";
            
            let iconNode = document.getElementById(fieldName).parentNode.parentNode.parentNode.childNodes[1]
             if (!iconNode.classList.contains("d-none")) {
   			 	iconNode.classList.add("d-none");
 			 }
            console.log(iconNode);
            
            
            var row = AUI().all('.campi-Allegati .lfr-form-row:visible').size();
            
            if(row == 0){
            	row = $('.campi-Allegati .lfr-form-row:visible').length;
            	console.log(row);
            }
            
            var rowObj = newField.row;
            var idNewDiv = rowObj._node.id;        
            var rowObjChildren1A = rowObj._node.children[1];
            var buttonDelete = rowObj._node.children[1].children[0].children[1];
            $(buttonDelete).attr('onclick','cancellaRiga('+idNewDiv+','+fieldName+')');         
            //Serve per far scomparire il pulsante aggiungi
            //if(row >= maxRow){
            //AUI().all('.add-row.btn.btn-default').hide();
            //}
          });
         
  // Evento rimuovi riga       
   autoFields.on("delete", function() {
            var row = AUI().all('.campi-Allegati .lfr-form-row:visible').size();
            console.log("delete AUI");
            //Da reimplementare nel caso si usi guest
            //Serve per far ricomparire il pulsante aggiungi
            //if(row <= maxRow){
            //AUI().all('.add-row.btn.btn-default').show();
           //}
          });
   autoFields.render(); 
   
      $(".delete-row").click(function(){
      	row = $('.campi-Allegati .lfr-form-row:visible').length;
    	if(row>1){
    		$(".lfr-form-row")[0].remove();
    	} else {
 			document.getElementById("<portlet:namespace />Allegato0").value="";
 			let iconNode = document.getElementById("<portlet:namespace />Allegato0").parentNode.parentNode.parentNode.childNodes[1];
   			 	iconNode.classList.add("d-none");
    	}
	});
   
   });
   
   function cancellaRiga(id, fieldName){
   	row = $('.campi-Allegati .lfr-form-row:visible').length;
   		if(row>1){
    		 $(id).remove();
    	} else {
    		console.log(fieldName.id);
 			document.getElementById(fieldName.id).value="";
 			let iconNode = document.getElementById(fieldName.id).parentNode.parentNode.parentNode.childNodes[1];
 			iconNode.classList.add("d-none");
    	}
   }
   
</aui:script>

<aui:script>
	function resetComboz(combos) {
	    if (combos != null) {
	        for (var i = 0; i <= combos.length; i++) {
	               if ($("#<portlet:namespace />" + combos[i]).length) {
	                    $("#<portlet:namespace />" + combos[i]).empty();
	                    $("#<portlet:namespace />" + combos[i]).append($('<option>', { 
	                           value: '',
	                        text : '<liferay-ui:message key="anpal.formonline.blank-option.select" />' 
	                     }));
	                }        
	        }
	    }
	}

    function loadComboByParentValue(comboz,data){
        comboz.empty();
        comboz.append($('<option>', { 
                   value: '',
                text : '<liferay-ui:message key="anpal.formonline.blank-option.select" />' 
            }));
        $.each(data, function (i, item) {
            comboz.append($('<option>', { 
                   value: item,
                text : item 
            }));
            
        });
    }
    
    $('#<portlet:namespace />ScegliTipologia').bind("change", function (event) {
        if($("#<portlet:namespace />ScegliTipologia option:selected").val() == "ALL"){
            $("#<portlet:namespace />completeForm").addClass("d-none");
        }else{
            $("#<portlet:namespace />completeForm").removeClass("d-none");
    } 
        resetComboz(['Users','SecondCategories','SubCategories']);
        $("#<portlet:namespace />subCategories").addClass("d-none");
        Liferay.Form.get('<portlet:namespace />fm').formValidator.get('rules')["<portlet:namespace />SubCategories"] = {required:false};
        loadComboByParentValue($('#<portlet:namespace />Users'),recuperaUtente(${jArray},this.value));
    })
    
    $('#<portlet:namespace />Users').bind("change", function (event) { 
        resetComboz(['SecondCategories','SubCategories']);
        $("#<portlet:namespace />subCategories").addClass("d-none");
        Liferay.Form.get('<portlet:namespace />fm').formValidator.get('rules')["<portlet:namespace />SubCategories"] = {required:false};
        loadComboByParentValue($('#<portlet:namespace />SecondCategories'),recuperaRichiesta(${jArray},$('#<portlet:namespace />ScegliTipologia').val(),this.value));
    })
    
    $('#<portlet:namespace />SecondCategories').bind("change", function (event) { 
        resetComboz(['SubCategories']);
        if(recuperaSubRichiesta(${jArray},$('#<portlet:namespace />ScegliTipologia').val(),$('#<portlet:namespace />Users').val(),this.value).length>0 ){
            $("#<portlet:namespace />subCategories").removeClass("d-none");
            Liferay.Form.get('<portlet:namespace />fm').formValidator.get('rules')["<portlet:namespace />SubCategories"] = {required:true};
            loadComboByParentValue($('#<portlet:namespace />SubCategories'),recuperaSubRichiesta(${jArray},$('#<portlet:namespace />ScegliTipologia').val(),$('#<portlet:namespace />Users').val(),this.value));
        }else{
            $("#<portlet:namespace />subCategories").addClass("d-none");
            Liferay.Form.get('<portlet:namespace />fm').formValidator.get('rules')["<portlet:namespace />SubCategories"] = {required:false};
        }
    })
    
    
    function checkFile(id){
    	let iconNode = document.getElementById(id).parentNode.parentNode.parentNode.childNodes[1];
             if (document.getElementById(id).value == "") {
   			 	iconNode.classList.add("d-none");
 			 }  	
    }
    
    $('#<portlet:namespace />no-cf').bind("change", function (event) { 
        
        var obj = Liferay.Form.get('<portlet:namespace />fm').formValidator.get('rules')["<portlet:namespace />CF"];
        //console.log(obj);
        if($('#<portlet:namespace />no-cf').prop('checked')){
 			//console.log("X");  
			$('#<portlet:namespace />CF').parent().children().filter('label').children().filter('.text-warning').addClass('d-none');    
        	obj.required = false;
        }else{
        	//console.log("NO X");
        	$('#<portlet:namespace />CF').parent().children().filter('label').children().filter('.text-warning').removeClass('d-none');        	
        	obj.required = true;
        }
        //console.log(obj);
        Liferay.Form.get('<portlet:namespace />fm').formValidator.get('rules')["<portlet:namespace />CF"] = obj;
    })
    
</aui:script>

<script>
   var callback = function() {
      grecaptcha.render('id-google-captcha', {
         'sitekey': '${dataSiteKeyCaptcha}',
         'expired-callback': expCallback
       });
   };
   var expCallback = function() {
	   $('#<portlet:namespace/>captcha').val("");
      grecaptcha.reset();
   };
</script>

<script type="text/javascript">
function recaptchaCallback(response){
    $('#<portlet:namespace/>captcha').val(response);
}
</script>




