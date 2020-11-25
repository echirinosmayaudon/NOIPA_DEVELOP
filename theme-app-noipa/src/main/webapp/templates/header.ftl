<#---Variabile logica per verificare se la pagina corrente è la homepage per generare degli ancora a doc per la HP accessibilità--->
	<#assign isHomePage=(the_title?lower_case)?contains("home page") /> 

<a id="skippyContent" class="sr-only sr-only-focusable" href="#main-content" aria-label="${translate(locale,"Vai direttamente al contenuto")}">
	  <div class="container">
		  <div class="col-md-6">
			<span class="skiplink-text">${translate(locale,"Vai direttamente al contenuto")}</span>
		  </div>
	  </div>
</a>
<a id="skippyNav" class="sr-only sr-only-focusable" href="#menPrinc" aria-label="${translate(locale,"Vai direttamente alla navigazione")}">
	<div class="container"> 
	  <div class="col-md-6">
		<span class="skiplink-text">${translate(locale,"Vai direttamente alla navigazione")}</span>
	  </div>
	</div>  
</a>

<#--Ancora per la HP -->
 	<#if isHomePage>
		<a id="skippyEvidenza" class="sr-only sr-only-focusable" href="#in-evidenza" aria-label="${translate(locale,"Vai direttamente alla sezione In evidenza")}">
		  <div class="container">
			  <div class="col-md-6">
				<span class="skiplink-text">${translate(locale,"Vai direttamente alla sezione In evidenza")}</span>
			  </div>
		  </div>
		</a>
		<a id="skippyPrimoPiano" class="sr-only sr-only-focusable" href="#primo-piano" aria-label="${translate(locale,"Vai direttamente alla sezione In primo piano")}">
			<div class="container"> 
			  <div class="col-md-6">
				<span class="skiplink-text">${translate(locale,"Vai direttamente alla sezione In primo piano")}</span>
			  </div>
			</div>  
		</a>	
		<a id="skippyPatrimonioInfor" class="sr-only sr-only-focusable" href="#patrimonio-inf" aria-label="${translate(locale,"Vai direttamente alla sezione Patrimonio informativo")}">
			<div class="container"> 
			  <div class="col-md-6">
				<span class="skiplink-text">${translate(locale,"Vai direttamente alla sezione Patrimonio informativo")}</span>
			  </div>
			</div>  
		</a>	
	</#if>


<a id="skippyFooter" class="sr-only sr-only-focusable" href="#footer" aria-label="${translate(locale,"Vai direttamente al footer")}">
	<div class="container">	  
	  <div class="col-md-6">
		<span class="skiplink-text">${translate(locale,"Vai direttamente al footer")}</span>
	  </div>
	</div>  
</a>

<script>
	var userStore = "";
	var nomeStore = sessionStorage.getItem("Nome");
	var cognomeStore = sessionStorage.getItem("Cognome");
	var profiloUtente = sessionStorage.getItem("profiloUtente");
	if((nomeStore != null && nomeStore != "") && (cognomeStore != null && cognomeStore != "")){
		userStore = nomeStore +" "+cognomeStore;
	}
	
	var jsonPU;
	var cambio_pwd = false;
	var get_spid = false;
	if((profiloUtente != null && profiloUtente != "")){
		jsonPU = JSON.parse(profiloUtente);
		cambio_pwd = jsonPU.cambioPwdFlag;
		get_spid = jsonPU.ottieniSpidFlag;
	}
	
</script>

<#assign labelSE = translate(locale,"Sito esterno")+" - "+translate(locale,"Nuova finestra") />
<#assign labelMenu = translate(locale,"Menu lingua") />
<#assign labelAAR = translate(locale,"Apri il menu lingua") />

<div class="header">
			<div class="bg-primary-dark">
				<div class="container">
					<div class="row">
					  <div class="col-sm-6 col-md-7 col-lg-8 d-none d-md-block header-amm">
						<a href="http://www.dag.mef.gov.it/" class="text-white d-block pr-3" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} Dipartimento dell’Amministrazione Generale, del Personale e dei Servizi - ${labelSE}" target="_blank"><img src="${images_folder_noipa}MEF-logo.svg" alt="Logo del Dipartimento dell’Amministrazione Generale, del Personale e dei Servizi" class="p-0 mr-3 my-1 logo-mef">
						<span class="ml-2 pt-3 font-weight-300 d-none d-lg-inline-block">Dipartimento dell’Amministrazione Generale, del Personale e dei Servizi</span></a>
					  </div>
						<div class="col-sm-2 col-md-1 text-right" id="menuLingua">
							<a class="d-block text-white pt-3 pb-3 px-0" href="#" id="dropdownLingua" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" title="${labelMenu}" aria-label="${labelAAR}"><span class="mx-2 mt-0 dropdown-toggle font-weight-normal">${labelSelect()}</span><span class="fa fa-angle-down fa-1x5"></span></a>
							<div class="dropdown-menu dropdown-menu-right p-0 my-0 mx-2 mw-auto rounded-0" aria-labelledby="dropdownLingua">
									<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone") />
                                      <@liferay_portlet["runtime"]
                                    portletProviderAction=portletProviderAction.VIEW
                                    defaultPreferences="${freeMarkerPortletPreferences}"
                                    portletName="com_liferay_site_navigation_language_web_portlet_SiteNavigationLanguagePortlet" />
  									${freeMarkerPortletPreferences.reset()}
								<#--  
								<ul class="list-group m-0">
								

<#assign default_language = "/c/portal/update_language?p_l_id=0&redirect=%2Fde%2Fweb%2Fguest%2Fhome&languageId=it_IT&persistState=false&showUserLocaleOptionsMessage=false" />								
								  <li><a href="${cPathNoiPa}/en${currentURL}/" class="list-group-item rounded-0 px-4 border-0">ENG</a></li>
								   <li><a href="${cPathNoiPa}/${default_language}" class="list-group-item rounded-0 px-4 border-0">ITA</a></li>
								  <li><a href="${cPathNoiPa}/de${currentURL}" class="list-group-item rounded-0 px-4 border-0">DEU</a></li>
								</ul>
								
								-->

								
							</div>
						</div>
					  <div class="col-sm-4 col-md-4 col-lg-3 text-right" id="menuServizio">
					  	<#assign labelMenu = translate(locale,"Accedi all’area riservata") />
						<ul class="m-0 p-0 menuServizio">
						  <li class="d-block position-relative bg-primary text-center" id="menuUtente">
						  <#assign label = translateAR(locale) />
						  <#assign labelAAR = translate(locale,"Area riservata") />
							<a class="d-block text-white pt-3 pb-3" href="${urlPortalePrivato}" id="dropdownMenuUtente" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" title="${labelAAR}" aria-label="${labelMenu} - ${labelAAR}"><span class="fa fa-user fa-1 d-inline-block pt-0"></span><span class="mx-2 mt-0 d-none d-md-inline-block dropdown-toggle font-weight-normal text-16p" id="userStoreName">${label}</span></a>
								<div class="dropdown-menu p-0 m-0 w-100 rounded-0 right-0" aria-labelledby="dropdownMenuUtente">
									<ul class="list-group m-0" id="menuItemUserStore">
										<li>
											<a href="${urlPortalePrivato}" title="${labelAAR}" aria-label="${translate(locale,'Vai a')} ${labelAAR}" id="mylinkAP" class="list-group-item rounded-0 px-3 py-2 border-0">
											<span class="" aria-hidden="true"></span><span id="labelUserStore1">${labelAAR}</span></a>
										</li> 
										<li>
											  <#assign label = translate(locale,"Modifica Dati Personali") />
											<a href="${urlPortalePrivatoModifica}" title="${label}" aria-label="${translate(locale,'Vai a')} ${label}" class="list-group-item rounded-0 px-3 py-2 border-0">
											<span class="" aria-hidden="true"></span><span id="labelUserStoreHeader2">${label}</span></a>
										</li>
										<li class="hiddenUrlSpid">
											  <#assign label = translate(locale,"Ottieni SPID") />
											<a href="${urlPortalePrivatoSpid}" title="${label}" aria-label="${translate(locale,'Vai a')} ${label}" class="list-group-item rounded-0 px-3 py-2 border-0">
											<span class="" aria-hidden="true"></span><span id="labelUserStoreHeader3">${label}</span></a>
										</li>
										<li class="hiddenUrlModPwd">
											  <#assign label = translate(locale,"Modifica Password") />
											<a href="${urlPortalePrivatoReset}" title="${label}" aria-label="${translate(locale,'Vai a')} ${label}" class="list-group-item rounded-0 px-3 py-2 border-0">
											<span class="" aria-hidden="true"></span><span id="labelUserStoreHeader4">${label}</span></a>
										</li>
										<li>
											  <#assign label = translate(locale,"Esci") />
											<a href="${urlPortalePrivatoEsci}" title="${label}" aria-label="${label}"  id="mylinkPPHeader" onclick="jsfunction('mylinkPPHeader')"  class="list-group-item rounded-0 px-3 py-2 border-0">
											<span class="" aria-hidden="true"></span><span id="labelUserStoreHeader5">${label}</span></a>
										</li>
									</ul>
								</div>
									<script>
										if (userStore != null && userStore != "") {
										var itemS = "${translate(locale,"Torna all’area riservata")}";
										$('#userStoreName').text(userStore);
										$('#labelUserStore').text(itemS);
										$('#dropdownMenuUtente').get(0).setAttribute("data-toggle","dropdown");
										} else {
										var itemS = "${translateAR(locale)}";
										$('#labelUserStore').text(itemS);
										$('#dropdownMenuUtente').get(0).removeAttribute("data-toggle");										
										}
									</script>
								  </li>
								</ul>
							  </div>
							</div>
						</div>
					</div>
			
			
<div class="bg-white">
				<div class="container">
		  
					<div class="row">
						<div class="col-12 col-sm-8 col-md-8 col-lg-9">
							<#--<h1 class="m-0">-->
								<a class="link-muted" href="${cPathNoiPa}/" title="Home page NoiPA" aria-label="${translate(locale,'Torna alla Home')} page NoiPA">
									<img src="${images_folder_noipa}NoiPaLogo.png" alt="Logo NoiPA servizi Pubblica Amministrazione a persone Pubblica Amministrazione" class="logo py-4 mr-2 my-4"> 
								</a>
							<#--</h1>-->
						</div>
						<div class="d-none d-md-block col-sm-4 col-md-4 col-lg-3">
							
							<div class="pt-3 mt-3 pb-4 text-center social">
								<span class="d-inline-block mr-2 small">${translate(locale,"Seguici su")}</span>
							  	<#assign labelSE = translate(locale,"Sito esterno")+" - "+translate(locale,"Nuova finestra")  />
								<a href="${urlNoiPAFacebook}" title="${labelSE}" aria-label="${translate(locale,'Seguici su')} Facebook - ${labelSE}" target="_blank" class="d-inline-block rounded-circle text-white bg-primary mx-2 ml-lg-4"><span class="fab fa-facebook-f"></span>
								</a>
								<a href="${urlNoiPATwitter}" title="${labelSE}" aria-label="${translate(locale,'Seguici su')} Twitter - ${labelSE}" target="_blank" class="d-inline-block rounded-circle text-white bg-primary mx-2 ml-lg-4"><span class="fab fa-twitter"></span>
								</a>
								<a href="${urlNoiPAYoutube}" title="${labelSE}" aria-label="${translate(locale,'Seguici su')} Youtube - ${labelSE}" target="_blank" class="d-inline-block rounded-circle text-white bg-primary mx-2 ml-lg-4"><span class="fab fa-youtube"></span>
								</a>
							</div>
							<div id="divSearch" class="mt-3">
								<div id="navSearch">
								
									<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone") />
								
								<#---Ricerca custom--->
                                  <@liferay_portlet["runtime"]
                                    portletProviderAction=portletProviderAction.VIEW
                                    defaultPreferences="${freeMarkerPortletPreferences}"
                                    portletName="noipa_mef_gov_custom_search_ToogleBarSearch" />
  									${freeMarkerPortletPreferences.reset()} 
										
									<#---Ricerca originale liferay--->
									<#--	 <@liferay.search default_preferences="${freeMarkerPortletPreferences}" />
										${freeMarkerPortletPreferences.reset()} -->
									
								</div>
							</div>
							
						</div>
					</div>
				</div>
			</div>
			
			
<script>
function jsfunction(idElement){
console.log("start.....");
 sessionStorage.clear();
    window.onload = function() {
      var a = document.getElementById(idElement);
      console.log("a: "+a);
      a.onclick = function() {
        return false;
      }
      
    }
}
        
  document.getElementById('mylinkAP').onclick = function (e) {
	console.log("Calling <em>close()</em>");
	p.close();
  };
  
	if(!cambio_pwd){
		var liPwd = document.getElementsByClassName("hiddenUrlModPwd")[0];
		liPwd.style.display = "none";
	}
	
	if(!get_spid){
		var liSpid = document.getElementsByClassName("hiddenUrlSpid")[0];
		liSpid.style.display = "none";
	}

</script>
			
		</div> <#-- Chiudo HEADER -->