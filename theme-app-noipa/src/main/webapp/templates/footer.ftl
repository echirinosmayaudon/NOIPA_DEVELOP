			<#assign labelSE = translate(locale,"Sito esterno")+" - "+translate(locale,"Nuova finestra") />		
			<div class="container text-200">
			
				<div class="row pb-2 mb-3">
					<div class="col-sm-6 col-md-3 py-4">
						<a href="http://www.mef.gov.it" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} Ministero dell'Economia e delle Finanze - ${labelSE}" target="_blank" ><img src="${images_folder_noipa}Logo_mef_footer.png" alt="Ministero dell'Economia e delle Finanze" class="img-fluid pr-5"></a>						
					</div>
					<div class="col-sm-6 col-md-3 py-4">
						<span class="d-block mb-4 text-24p">${translate(locale,"Recapiti e Contatti")}</span>
						<span class="text-18p">Via XX Settembre, 97 - Roma <br> Piazza Dalmazia, 1 - Roma</span>
					</div>
					<div class="col-sm-6 col-md-3 py-4">
						<div class="social">
							
							<span class="d-block mb-4 text-24p">${translate(locale,"Seguici su")}</span>
							<a href="${urlNoiPAFacebook}" title="${labelSE}" aria-label="${translate(locale,'Seguici su')} Facebook - ${labelSE}" target="_blank" class="d-inline-block rounded-circle text-primary-dark bg-b4 mr-4"><span class="fab fa-facebook-f"></span>
							</a>
							<a href="${urlNoiPATwitter}" title="${labelSE}" aria-label="${translate(locale,'Seguici su')} Twitter - ${labelSE}" target="_blank"  class="d-inline-block rounded-circle text-primary-dark bg-b4 mr-4"><span class="fab fa-twitter"></span>
							</a>
							<a href="${urlNoiPAYoutube}" title="${labelSE}" aria-label="${translate(locale,'Seguici su')} Youtube - ${labelSE}"  target="_blank" class="d-inline-block rounded-circle text-primary-dark bg-b4 mr-4"><span class="fab fa-youtube"></span>
							</a>
						</div>
						
						<div class="social">
							<span class="d-block mb-2 mt-2 text-18p">Feed RSS</span>
							<a href="${cPathNoiPa}/web/guest/feedrss" title="${translate(locale,"Vai a")} Feed RSS" aria-label="${translate(locale,'Vai alla pagina')} FeedRss" class="d-inline-block rounded-circle text-primary-dark bg-b4 mr-4">
 								<span class="fas fa-rss"></span>
							</a>
						</div>
				
					</div>
					<div class="col-sm-6 col-md-3 py-4">
						<span class="d-block mb-4 text-24p">${translateAP(locale)}</span>
						
						
						
						<a href="${urlNoiPAppApple}" title="${labelSE}"  target="_blank" aria-label="${translate(locale,'Scarica da App store')} - ${labelSE}" class="d-inline-block mr-4 mb-4 icoApple"><img src="${images_folder_noipa}icoAppAppleHQ.png" alt="${translate(locale,'Scarica da App store')} - ${labelSE}"></a>
						<a href="${urlNoiPAppGoogle}" title="${labelSE}" target="_blank" aria-label="${translate(locale,'Scarica da Google Play')} - ${labelSE}" class="d-inline-block mb-4 icoGPlay"><img src="${images_folder_noipa}icoAppGPlayHQ.png" alt="${translate(locale,'Scarica da Google Play')} - ${labelSE}"></a>
						<a href="${urlNoiPAppHuawei}" title="${labelSE}" target="_blank" aria-label="${translate(locale,'Scarica da App store')} - ${labelSE}" class="d-inline-block mb-4 icoGPlay"><img src="${images_folder_noipa}icon_AppGallery_footer.png" alt="${translate(locale,'Scarica da App store')} - ${labelSE}"></a>
					</div>
				</div>
						
				<ul class="list-inline text-18p border-top border-white float-right pt-4 mt-4">
					<#if ipAddress?starts_with("10.")>
						<li class="list-inline-item"><a href="http://sptnet.scsii.tesoro.it/SCIOPNET/LoginSSO.aspx?ReturnUrl=%2fsciopnet%2fDefault.aspx" class="text-white mr-4" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} SciopNet - ${labelSE}" target="_blank" >SciopNet</a></li>
						<li class="list-inline-item"><a href="http://sptnet.scsii.tesoro.it/ASSENZENET/LoginSSO.aspx?ReturnUrl=%2fassenzenet%2fDefault.aspx" class="text-white mr-4" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} AssenzeNet - ${labelSE}" target="_blank" >AssenzeNet</a></li>
						<li class="list-inline-item"><a href="http://sptnet.scsii.tesoro.it/GIUDICINET/LoginSSO.aspx?ReturnUrl=%2fgiudicinet%2fDefault.aspx" class="text-white mr-4" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} GiudiciNet - ${labelSE}" target="_blank" >GiudiciNet</a></li>					
					<#else>
						<li class="list-inline-item"><a href="https://sptnet.tesoro.it/SCIOPNET/LoginSSO.aspx?ReturnUrl=%2fsciopnet%2fDefault.aspx" class="text-white mr-4" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} SciopNet - ${labelSE}" target="_blank" >SciopNet</a></li>
						<li class="list-inline-item"><a href="https://sptnet.tesoro.it/ASSENZENET/LoginSSO.aspx?ReturnUrl=%2fassenzenet%2fDefault.aspx" class="text-white mr-4" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} AssenzeNet - ${labelSE}" target="_blank" >AssenzeNet</a></li>
						<li class="list-inline-item"><a href="https://sptnet.tesoro.it/GIUDICINET/LoginSSO.aspx?ReturnUrl=%2fgiudicinet%2fDefault.aspx" class="text-white mr-4" title="${labelSE}" aria-label="${translate(locale,'Vai al sito')} GiudiciNet - ${labelSE}" target="_blank" >GiudiciNet</a></li>
					</#if>

					<#assign lOperatore= translateOP(locale)>					
					<li class="list-inline-item"><a href="https://noipa.mef.gov.it/AccessoMEF" class="text-white mr-4" title="${labelSE}" aria-label="${translate(locale,'Accesso operatori')} - ${labelSE}" target="_blank" >${lOperatore}</a></li>
				</ul>
				
				
				
				

				<ul class="list-inline text-18p border-top border-white float-left pt-4 mt-4">
					<#-- 
					<li class="list-inline-item"><a href="${cPathNoiPa}/web/guest/view-news" class="text-white mr-4" lang="en">News</a></li>
					<#assign urlOperatore= "#">
					<#assign lOperatore= translateOP(locale)>
					<li class="list-inline-item"><a href="${urlOperatore}" class="text-white">${lOperatore}</a></li>
					-->
					<li class="list-inline-item"><a href="${urlNoiPAPressKit}" title="File ZIP - 927 kb" aria-label="${translate(locale,'Scarica il documento')} - File ZIP - 927 kb" class="text-white mr-4"><span lang="en">Press kit</span></a></li>
					 <#assign map = translate(locale,"Mappa del Sito") />
					<li class="list-inline-item"><a href="${cPathNoiPa}/web/guest/mappa-sito" title="${translate(locale,"Vai a")} ${map}" aria-label="${translate(locale,'Vai alla pagina')} ${map}" class="text-white mr-4">${map}</a></li>
				<#--	
					<li class="list-inline-item"><a href="${cPathNoiPa}/web/guest/policy-privacy" title="${translate(locale,"Vai a")} Privacy Policy" aria-label="${translate(locale,'Vai alla pagina')} Privacy Policy" class="text-white mr-4"><span lang="en">Privacy Policy</span></a></li>
					<li class="list-inline-item"><a href="${cPathNoiPa}/web/guest/cookies-policy" title="${translate(locale,"Vai a")} Cookies Policy" aria-label="${translate(locale,'Vai alla pagina')} Cookies Policy" class="text-white mr-4"><span lang="en"> Cookies Policy</span></a></li>
					-->
					<#assign note = translate(locale,"Note Legali") />
					<li class="list-inline-item"><a href="${cPathNoiPa}/web/guest/note-legali" title="${translate(locale,"Vai a")} ${note}" aria-label="${translate(locale,'Vai alla pagina')} ${note}" class="text-white">${note}</a></li>
					
					<li class="list-inline-item"><a href="${cPathNoiPa}/web/guest/social-media-policy" title="${translate(locale,"Vai a")} Social media policy" aria-label="${translate(locale,'Vai alla pagina')} Social media policy" class="text-white mr-4"><span lang="en">Social media policy</span></a></li>
				</ul>
			</div>