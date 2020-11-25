<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId","noipasearch")>
<#assign VOID = freeMarkerPortletPreferences.setValue("searchScope", "everything") />

<script>
	var userStore = "";
	var nomeStore = sessionStorage.getItem("Nome");
	var cognomeStore = sessionStorage.getItem("Cognome");
	var profiloUtente = sessionStorage.getItem("profiloUtente");
	if((nomeStore != null && nomeStore != "") && (cognomeStore != null && cognomeStore != "")){
		userStore = nomeStore +" "+cognomeStore;
	}
	
</script>

<div class="float-right">
	<div id="menuUtente2" class="d-inline-block d-md-none pb-1 white-space-nowrap">
		<a class="d-block bg-white text-primary rounded-circle pt-2 mt-2 pb-2 px-3" href="#" id="dropdownMenuUtente2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" title="${translate(locale,"Menu area riservata")}" aria-label="${translate(locale,"Apri il menu area riservata")}"><span class="fa fa-user fa-1 d-inline-block pt-0"></span></a>
		<div class="dropdown-menu m-0 rounded-0 right-0 border-0 shadow p-0 mt-2" aria-labelledby="dropdownMenuUtente2">
			<#assign label = translate(locale,"Accedi all'Area Riservata") />
			<ul class="list-group m-3" id="noipa-view">
			  <li>
			  	<a href="${urlPortalePrivato}" class="list-group-item rounded-0 px-3 py-2 border-0" title="${translate(locale,'Area riservata')}" aria-label="${translate(locale,"Accedi all'Area Riservata")} - ${translate(locale,'Area riservata')}">
			  	<span class="fa fa-address-card mr-2" aria-hidden="true"></span><span id="labelUserStore6">${label}</span></a>
			  </li>
			</ul>
			<ul class="list-group m-3" id="noipa-view-no">
				  <li>
					<a href="${urlPortalePrivato}" class="list-group-item rounded-0 px-3 py-2 border-0" title="${label}" aria-label="${translate(locale,'Vai a')} ${label}">
					<span class="fa fa-address-card mr-2" aria-hidden="true"></span><span id="labelUserStore7">${label}</span></a>
				  </li>
				<li>
					  <#assign label = translate(locale,"Modifica Dati Personali") />
					<a href="${urlPortalePrivatoModifica}" class="list-group-item rounded-0 px-3 py-2 border-0" title="${label}" aria-label="${translate(locale,'Vai a')} ${label}">
					<span class="" aria-hidden="true"></span><span id="labelUserStore2">${label}</span></a>
				</li>
				<li class="hiddenUrlSpid">
					  <#assign label = translate(locale,"Ottieni SPID") />
					<a href="${urlPortalePrivatoSpid}" class="list-group-item rounded-0 px-3 py-2 border-0" title="${label}" aria-label="${translate(locale,'Vai a')} ${label}">
					<span class="" aria-hidden="true"></span><span id="labelUserStore3">${label}</span></a>
				</li>
				<li class="hiddenUrlModPwd">
					  <#assign label = translate(locale,"Modifica Password") />
					<a href="${urlPortalePrivatoReset}" class="list-group-item rounded-0 px-3 py-2 border-0" title="${label}" aria-label="${translate(locale,'Vai a')} ${label}">
					<span class="" aria-hidden="true"></span><span id="labelUserStore4">${label}</span></a>
				</li>
				<li>
					  <#assign label = translate(locale,"Esci") />
					<a href="${urlPortalePrivatoEsci}" id="mylinkPPNav" onclick="jsfunction('mylinkPPNav')"  class="list-group-item rounded-0 px-3 py-2 border-0">
					<span class="" aria-hidden="true"></span><span id="labelUserStore5">${label}</span></a>
				</li>
			 </ul>
		</div>
									<script>
										if (userStore != null && userStore != "") {
										
										var itemS = "${translate(locale,"Torna all'area risevata")}";
										$('#labelUserStore7').text(itemS);
										$('#noipa-view-no')[0].style.display="";
										$('#noipa-view')[0].style.display="none";
										} else {
										var itemS = "${translate(locale,"Accedi all'Area Riservata")}";
										$('#labelUserStore6').text(itemS);
										$('#noipa-view-no')[0].style.display="none";
										$('#noipa-view')[0].style.display="";
										}
									</script>
	</div>
</div>

<div class="float-right">
	<div id="search-megamenu" class="d-inline-block d-md-none">
		<a class="d-block text-white pt-2 mt-1 pb-3 px-4" href="#" id="dropdownSearchMegamenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" title="${translate(locale,'Ricerca')}" aria-label="${translate(locale,'Cerca nel sito')} - ${translate(locale,'Ricerca')}"><span class="fa fa-search fa-1x5 d-inline-block pt-0"></span></a>
		<div id="divBarSearch" class="dropdown-menu m-0 w-max-200 rounded-0 right-0 border-0 shadow p-0" aria-labelledby="dropdownSearchMegamenu">
			
			<#-- <form name="msearch" id="msearch" class="m-0 p-0" action="${company_url_search}?p_p_id=com_liferay_portal_search_web_portlet_SearchPortlet" method="post">
				<div class="position-relative overflow">
					<input type="text" class="form-control border-0 rounded-0 text-18p w-100 p-4" placeholder="Cerca" aria-label="Recipient's username" aria-describedby="button-addon2a" id="_com_liferay_portal_search_web_portlet_SearchPortlet_keywords" name="_com_liferay_portal_search_web_portlet_SearchPortlet_keywords">
					<input name="p_p_id" type="hidden" value="com_liferay_portal_search_web_portlet_SearchPortlet">
					<input name="p_p_lifecycle" type="hidden" value="0">
					<input name="p_p_state" type="hidden" value="maximized">
					<input name="p_p_mode" type="hidden" value="view">
					<input name="currentURL" type="hidden" value="${currentURL}">
					<input name="company_url" type="hidden" value="">
					<input name="_com_liferay_portal_search_web_portlet_SearchPortlet_mvcPath" type="hidden" value="/search.jsp">
					<input name="_com_liferay_portal_search_web_portlet_SearchPortlet_redirect" type="hidden" value="http://10.206.193.109:8080/web/guest/home-page?p_p_id=com_liferay_portal_search_web_portlet_SearchPortlet&amp;p_p_lifecycle=0&amp;p_p_state=normal&amp;p_p_mode=view">
					<button class="searcoverlr70 btn btn-primary bg-white text-primary border-0 rounded-0 right-0 top-0 position-absolute" type="button" id="button-addon2a"><span class="fa fa-search fa-1x5"></span><span class="sr-only">Cerca</span></button>

				</div>
			</form>  

			<@liferay.search default_preferences="${freeMarkerPortletPreferences}" />
			-->
		</div>
	</div>
</div>
<div class="navbar-header">
	<a class="navbar-toggle collapsed float-left m-0 toggle-menu menu-left jPushMenuBtn" href="#menu" title="${translate(locale,'Menù di navigazione')}" aria-label="${translate(locale,'Apri il menù di navigazione')}"><span class="fa fa-bars fa-1x5 text-white"></span></a>	
	<div id="logo-small">
		<a href="${cPathNoiPa}" title="Home page NoiPA" aria-label="${translate(locale,'Torna alla Home')} - Home page NoiPA" class=""><img src="${images_folder_noipa}logo-white.png" alt="NoiPA servizi PA a persone PA" class=""></a>
	</div>
</div>

<nav class="navbar-collapse bs-navbar-collapse collapse p-0" id="menu" role="navigation">
	<h2 class="sr-only">Elementi del menù di navigazione</h2>
	
<#-- <ul class="nav navbar-nav w-100 position-relative" id="menPrinc" aria-label="<@liferay.language key="site-pages" />" role="menubar"> -->
		<ul class="nav navbar-nav w-100 position-relative" id="menPrinc">
		
				
		<#list nav_items as nav_item>
		<#--
			<#assign
				nav_item_attr_has_popup = ""
				nav_item_attr_selected = ""
				nav_item_css_class = ""
				nav_item_layout = nav_item.getLayout()
			/>

			<#if nav_item.isSelected()>
				<#assign
					nav_item_attr_has_popup = "aria-haspopup='true'"
					nav_item_attr_selected = "aria-selected='true'"
					nav_item_css_class = "selected"
				/>
			</#if>
		-->
<#if nav_item.getName()?contains("Servizi") || nav_item.getName()?contains("Services") || nav_item.getName()?contains("Dienstleistungen") >
			<!-- MENU SERVIZI -->
			<li class="yamm-fullwidth dropdown">
				<a aria-expanded="false" aria-haspopup="true" href="javascript:void(0)" title="${nav_item.getName()}" aria-label="${nav_item.getName()}" class="dropdown-toggle text-white px-4 pt-2 pb-3 mr-4" data-toggle="dropdown">
					<span>${nav_item.getName()}<strong class="fa fa-angle-down font-weight-bold ml-3 pt-2"></strong></span>
				</a>
				
				<ul class="dropdown-menu mega-menu rounded-0 border-0 w-max-800">
					<li>
						<div class="yamm-content">
								<#assign viewDivOpen = true />
								<#assign viewDivClose = true />
									<#if nav_item.hasChildren()>
										<#list nav_item.getChildren() as nav_child>
											<#if !nav_child.getName()?contains("Aderisci a NoiPA") && !nav_child.getName()?contains("Nimm NoiPA an") && !nav_child.getName()?contains("Join NoiPA")>
												<#if viewDivOpen>
													<div class="row BGMenu1 text-16p">
													<#assign viewDivOpen = false />
												</#if>
												<div class="col-sm-12">
													<h3 class="text-primary text-24p pt-0"><a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" >${nav_child.getName()}</a></h3>
												</div>
													<#if nav_child.hasChildren()>
														<#assign sizeChildServizi = nav_child.getChildren()?size />
														<#assign colServizi = 12/sizeChildServizi />
														<#list nav_child.getChildren() as nav_sub_child>
															<div class="col-sm-${colServizi}">
<#--  																<h4 class="text-primary text-18p"><a title="${translate(locale,'Vai a')} ${nav_sub_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_sub_child.getName()}" href="${nav_sub_child.getURL()}">${nav_sub_child.getName()}</a></h4>-->
																	<h4 class="text-primary text-18p">${nav_sub_child.getName()}</h4>
																<#if nav_sub_child.hasChildren()>
																	<ul class="list-unstyled">
																	<#list nav_sub_child.getChildren() as nav_sub_child_sub>
																		<li class="my-4"><a href="${nav_sub_child_sub.getURL()}" title="${translate(locale,'Vai a')} ${nav_sub_child_sub.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_sub_child_sub.getName()}">${nav_sub_child_sub.getName()}</a></li>
																	</#list>
																	</ul>
																</#if>	
															</div>
														</#list>
													</#if>	
											<#else>
												<#if viewDivClose && !viewDivOpen>
													</div> <#-- close <div class="row BGMenu3 text-16p"> -->
													<#assign viewDivClose = false />
												</#if>
												<hr>
												<div class="text-center">
													<#if nav_child.getName()?contains("Aderisci a NoiPA")>
														<strong class="text-dark">Sei un'Amministrazione?</strong><a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" class="btn btn-default btn-lg px-5 py-3 text-16p ml-4">${nav_child.getName()}</a>
													<#elseif nav_child.getName()?contains("Nimm NoiPA an")>
														<strong class="text-dark">Bist Du eine öffentliche Verwaltung?</strong><a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" class="btn btn-default btn-lg px-5 py-3 text-16p ml-4">${nav_child.getName()}</a>
													<#elseif nav_child.getName()?contains("Join NoiPA") || nav_child.getName()?contains("Join")>
														<strong class="text-dark">Are you a Public Administration?</strong><a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" class="btn btn-default btn-lg px-5 py-3 text-16p ml-4">${nav_child.getName()}</a>
													</#if>>
												</div>
											</#if>
										</#list>
									</#if>

						</div>
					</li>
				</ul>
			</li>
			<!-- FINE MENU SERVIZI -->
<#elseif nav_item.getName()?contains("Dati") || nav_item.getName()?contains("Data") || nav_item.getName()?contains("Daten")>
<!-- MENU DATI -->
			<li class="yamm-fullwidth dropdown">
				<a aria-expanded="false" aria-haspopup="true" href="javascript:void(0)" title="${nav_item.getName()}" aria-label="${nav_item.getName()}"  class="dropdown-toggle text-white px-4 pt-2 pb-3 mr-4" data-toggle="dropdown">
				<span>${nav_item.getName()}<strong class="fa fa-angle-down font-weight-bold ml-3 pt-2"></strong></span></a>
				
				<ul class="dropdown-menu mega-menu rounded-0 border-0 w-max-600">
					<li>
					  <div class="yamm-content">
						<div class="row BGMenu2 text-16p h-150p">
						  <#if nav_item.hasChildren()>
							<#list nav_item.getChildren() as nav_child>
								<div class="col-sm-12">
									<h3 class="text-primary text-24p pt-0"><a title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" href="${nav_child.getURL()}">${nav_child.getName()}</a></h3>
								</div>
								<#if nav_child.hasChildren()>
								<#list nav_child.getChildren() as nav_sub_child>
									<#assign sizeChildDati = nav_child.getChildren()?size />
									<#assign colDati = 12/sizeChildDati />
									<div class="col-sm-${colDati}">
										 <h4 class="text-primary text-18p">
										<#assign labelSE = translate(locale,"Sito esterno")+" - "+translate(locale,"Nuova finestra") />
											<#if nav_sub_child.getName()?contains("Open Data")>
												<a href="${nav_sub_child.getURL()}" target="_blank" title="${labelSE}" aria-label="${translate(locale,'Vai a')} ${nav_sub_child.getName()} - ${labelSE}">${nav_sub_child.getName()}</a>
											<#else>
												<a title="${translate(locale,'Vai a')} ${nav_sub_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_sub_child.getName()}" href="${nav_sub_child.getURL()}">${nav_sub_child.getName()}</a>
											</#if>
										</h4>
									</div>
								</#list>
								</#if>
							</#list>
						  </#if>
						</div>
					  </div>
					</li>
				</ul>
			</li>
			<!-- FINE MENU DATI -->
<#elseif nav_item.getName()?contains("Innovazione") || nav_item.getName()?contains("Innovation") || nav_item.getName()?contains("Innovation")>
<!-- MENU INNOVAZIONE -->
			<li class="yamm-fullwidth dropdown">
				<a aria-expanded="false" aria-haspopup="true" href="javascript:void(0)" title="${nav_item.getName()}" aria-label="${nav_item.getName()}" class="dropdown-toggle text-white px-4 pt-2 pb-3 mr-4" data-toggle="dropdown">
				<span>${nav_item.getName()}<strong class="fa fa-angle-down font-weight-bold ml-3 pt-2"></strong></span></a>
				
				<ul class="dropdown-menu mega-menu rounded-0 border-0 w-max-800">
					<li>
						<div class="yamm-content">
								<#assign viewDivOpen = true />
								<#assign viewDivClose = true />
									<#if nav_item.hasChildren()>
										<#list nav_item.getChildren() as nav_child>
											<#if !nav_child.getName()?contains("Facciamo rete") && !nav_child.getName()?contains("We do Network") && !nav_child.getName()?contains("Vernetzung")>
												<#if viewDivOpen>
													<div class="row BGMenu3 text-16p">
													<#assign viewDivOpen = false />
												</#if>
												<#assign sizeChildInno = nav_item.getChildren()?size />
												<#assign colInno = 12/sizeChildInno />
												<div class="col-sm-${colInno}">
													<h3 class="text-primary text-18p pt-0"><a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}">${nav_child.getName()}</a></h3>
													<#if nav_child.hasChildren()>
														<ul class="list-unstyled">
															<#list nav_child.getChildren() as nav_sub_child>
																<li class="my-4"><a href="${nav_sub_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_sub_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_sub_child.getName()}">${nav_sub_child.getName()}</a></li>
															</#list>
														</ul>	
													</#if>
												</div>
											<#else>
												<#if viewDivClose && !viewDivOpen>
													</div> <#-- close <div class="row BGMenu3 text-16p"> -->
													<#assign viewDivClose = false />
												</#if>
												<hr>
												<div class="text-center">
													<a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" class="btn btn-default btn-lg px-5 py-3 text-16p">${nav_child.getName()}</a>
												</div>
											</#if>
										</#list>
									</#if>
								</div>
							</li>
						</ul>
					</li>
			<!-- FINE MENU INNOVAZIONE -->
<#elseif nav_item.getName()?contains("Mondo NoiPA") || nav_item.getName()?contains("MondoNoiPA") || nav_item.getName()?contains("NoiPAWorld") || nav_item.getName()?contains("NoiPA World") || nav_item.getName()?contains("Die Welt von NoiPA")>
<!-- MENU MONDO NOIPA -->
			<li class="dropdown float-right">
				<a aria-expanded="false" aria-haspopup="true" href="javascript:void(0)" title="${nav_item.getName()}" aria-label="${nav_item.getName()}" class="dropdown-toggle text-white px-4 pt-2 pb-3" data-toggle="dropdown">
				<span>${nav_item.getName()}<strong class="fa fa-angle-down font-weight-bold ml-3 pt-2"></strong></span></a>
				<#if nav_item.hasChildren()>
				<div class="dropdown-menu rounded-0 border-0 right-0 p-4">
					<ul class="list-unstyled BGMenu4 text-16p">
						<#list nav_item.getChildren() as nav_child>
							<li class="pt-3"><a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" class="text-18p">${nav_child.getName()}</a>
							<#if nav_child.hasChildren()>
								<ul class="list-unstyled">
									<#list nav_child.getChildren() as nav_sub_child>
										<li class="my-4"><a href="${nav_sub_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_sub_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_sub_child.getName()}" class="py-0">${nav_sub_child.getName()}</a></li>
									</#list>
								</ul>
							<#else>
							</li>
							</#if>
						</#list>
					</ul>

				    <hr class="my-4">
				    <ul class="list-unstyled">
				    	<#if nav_item.getName()?contains("Mondo NoiPA") || nav_item.getName()?contains("MondoNoiPA") >
				        	<li class=""><span class="fa fa-question-circle mr-2 text-28p vertical-align-top text-primary" aria-hidden="true"></span> <a href="${cPathNoiPa}/web/guest/supporto" title="${translate(locale,'Vai a')} Supporto" aria-label="${translate(locale,'Vai alla pagina')} Supporto"> Supporto</a></li>
				        <#elseif nav_item.getName()?contains("NoiPAWorld") || nav_item.getName()?contains("NoiPA World")>
				        	<li class=""><span class="fa fa-question-circle mr-2 text-28p vertical-align-top text-primary" aria-hidden="true"></span> <a href="${cPathNoiPa}/web/guest/support" title="${translate(locale,'Vai a')} Support" aria-label="${translate(locale,'Vai alla pagina')} Support"> Support</a></li>
				        <#elseif nav_item.getName()?contains("Die Welt von NoiPA")>
				        	<li class=""><span class="fa fa-question-circle mr-2 text-28p vertical-align-top text-primary" aria-hidden="true"></span> <a href="${cPathNoiPa}/web/guest/unterstützung" title="${translate(locale,'Vai a')} Unterstützung" aria-label="${translate(locale,'Vai alla pagina')} Unterstützung"> Unterstützung</a></li>
				        </#if>
				    </ul>

					
					
					
				</div>
			</#if>
			</li>
			<!-- FINE MENU MONDO NOIPA -->
<#else >
<#--  <li class="yamm-fullwidth dropdown">  -->
<li class="dropdown">
				<a aria-expanded="false" aria-haspopup="true" href="javascript:void(0)" title="${nav_item.getName()}" aria-label="${nav_item.getName()}" class="dropdown-toggle text-white px-4 pt-2 pb-3" data-toggle="dropdown">
				<span>${nav_item.getName()}<strong class="fa fa-angle-down font-weight-bold ml-3 pt-2"></strong></span></a>
				<#if nav_item.hasChildren()>
				<div class="dropdown-menu rounded-0 border-0 p-4">
					<ul class="list-unstyled BGMenu5 text-16p">
						<#list nav_item.getChildren() as nav_child>
							<li class="pt-3"><a href="${nav_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_child.getName()}" class="text-18p">${nav_child.getName()}</a>
							<#if nav_child.hasChildren()>
								<ul class="list-unstyled">
									<#list nav_child.getChildren() as nav_sub_child>
										<li class="my-4"><a href="${nav_sub_child.getURL()}" title="${translate(locale,'Vai a')} ${nav_sub_child.getName()}" aria-label="${translate(locale,'Vai alla pagina')} ${nav_sub_child.getName()}" class="py-0">${nav_sub_child.getName()}</a></li>
									</#list>
								</ul>
							<#else>
							</li>
							</#if>
						</#list>
					</ul>   
				
				</div>
			</#if>
			</li>

</#if>	

				
			
	  

			
			
			
			
			
			
		
		
		</#list>
		</ul>
</nav>


<script>
$(document).ready(function(){
  $(".searcoverlr70").click(function(){
    document.forms['msearch'].action=url;
    document.forms['msearch'].submit();
  });
});



function submitTheForm(url,formRef){

}


</script>

<#assign VOID = freeMarkerPortletPreferences.reset()>