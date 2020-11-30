<%@ include file="init.jsp" %>

<%

String ddmStructureKeyT = (String)renderRequest.getAttribute("ddmStructureKeyT");
String ddmStructureKeyR = (String)renderRequest.getAttribute("ddmStructureKeyR");
ListaAssistenza assistenza = (ListaAssistenza)renderRequest.getAttribute("assistenza");
long groupId= themeDisplay.getSiteGroupId();

%>

<div class="BGContainer">
	<div id="group">
			<div class="container py-4">
				
				<div class="my-5 text-center">
					<h2 class="font-weight-700 text-28p"><liferay-ui:message key="noipawebformassistenza.wizard.start.2" /></h2>
					<p class="px-sm-5"><liferay-ui:message key="noipawebformassistenza.wizard.start.3" /></p>
				</div>
			
				<div class="grid py-4">
				
		<%		
			List<Tema> listLivello = assistenza.getLinea(1);
			
			for (Tema tema : listLivello) {
		%>
	
				
					<div class="grid-col col-sm-6 col-md-4 col-lg-3 mb-5">
						<div class="shadow link-card w-100">
							<a href="#<%=tema.getId() %>" class="text-center d-block p-5 text-16p h-100" data-toggle="collapse" data-parent="#group" data-target="#<%=tema.getId() %>">
 								<span class="fa fa-cube fa-5x ml-2 pt-2 d-block"></span>
								<strong class="text-28p d-block py-3"><%=tema.getTitolo() %></strong>
								<%-- <span class="pt-3 d-block"><%=tema.getDescrizione() %></span> --%>
							</a>
						</div>
					</div>
					<% } %>
				</div>
			</div>
					<%		
						List<Tema> listLivello1 = assistenza.getLinea(1);
						for (Tema tema1 : listLivello1) {
					%>
					<div class="panel" style="border:none;">
						<div id="<%=tema1.getId() %>" class="collapse py-5">
							<div class="bg-light">
								<div class="container" >
							<h3 class="my-5 pb-0 text-28p font-weight-bold" id="cat-1<%=tema1.getId() %>"><%=tema1.getTitolo() %></h3>
							
							<!-- Domanda livello 1 -->
							
							<%
							boolean showDiv2 = true;
							List<Tema> correlate = tema1.getListArgomento();
							if(NoiPAWebAssistenzaUtils.isValid(correlate)){
								
								for (Tema tema2 : correlate) {
												
	
							if(showDiv2){
								showDiv2 = false;
							%>	
							<div class="panel-group pb-5">
							  <div class="panel panel-default bg-white border-0 rounded-0 shadow-none">
							  <% } %>
								<h4 class="text-20p my-0">
									<a data-toggle="collapse" href="#<%=tema2.getId() %>" aria-expanded="false" class="px-5 py-4 dropdown-toggle d-block font-weight-bold border-bottom"><span class="fa fa-angle-down font-weight-bold ml-3 fa-1x5 float-right"></span><%=tema2.getTitolo() %></a>
								</h4>
							
								<div id="<%=tema2.getId() %>" class="panel-collapse collapse border-0">
								
									<!-- Domanda livello 2 -->
									
									<%		
										boolean showDiv3 = true;
										List<Tema> correlate2 = tema2.getListArgomento();
										if(NoiPAWebAssistenzaUtils.isValid(correlate2)){
										for (Tema tema3 : correlate2){
											if(!tema3.isRispsota()){
									if(showDiv3){
										showDiv3 = false;
									%>
									
									<div class="panel-group m-0">
									  <div class="panel panel-default bg-005 border-0 rounded-0 shadow-none">
									  <% } %>
										<h5 class="text-18p my-0 noipa-margin-4">
											<a data-toggle="collapse" href="#<%=tema3.getId() %>" aria-expanded="false" class="px-5 py-4 dropdown-toggle d-block font-weight-bold"><span class="fa fa-angle-down font-weight-bold ml-3 fa-1x5 float-right"></span><%=tema3.getTitolo() %></a>
										</h5>
										<div id="<%=tema3.getId() %>" class="panel-collapse collapse border-0">
										
											<!-- Domanda livello 3 con risposta -->
											<%		
												boolean showDiv4 = true;
												List<Tema> correlate3 = tema3.getListArgomento();
												if(NoiPAWebAssistenzaUtils.isValid(correlate3)){
												for (Tema tema4 : correlate3){
													if(tema4.isRispsota()){
											if(showDiv4){
												showDiv4 = false;
											%>
											<div class="panel-group m-0">
											  <div class="panel panel-default bg-005 border-0 rounded-0 shadow-none pl-4">
											<% } %>
	<%-- 											<h6 class="text-18p my-0">
													<a data-toggle="collapse" href="#<%=tema4.getId() %>" aria-expanded="false" class="px-5 py-4 dropdown-toggle d-block font-weight-normal"><span class="fa fa-angle-down font-weight-bold ml-3 fa-1x5 float-right"></span><%=tema4.getTitolo() %></a>
												</h6> --%>
												<div id="<%=tema4.getId() %>" class="panel-collapse border-0 px-5">
												  <div class="panel-body pr-5 py-3 t-0 text-18p bg-white noipa-margin-4">
													<p><%=tema4.getDescrizione() %></p>
													<%
													List<String> listLabel = tema4.getLabelLinks();
													List<String> link = tema4.getLinks();
													if(listLabel!=null){
														for(int i = 0; i<listLabel.size();i++){
															%>
															<p><a href="<%=link.get(i)%>"><%=listLabel.get(i) %></a></p>
															<%
														}
													}
													%>
												  </div>
												</div>
												<% 
												} else { %>
										<h6 class="text-18p my-0 norisp noipa-margin-5">
											<a data-toggle="collapse" href="#<%=tema4.getId() %>" aria-expanded="false" class="px-5 py-4 dropdown-toggle d-block font-weight-bold"><span class="fa fa-angle-down font-weight-bold ml-3 fa-1x5 float-right"></span><%=tema4.getTitolo() %></a>
										</h6>
										<div id="<%=tema4.getId() %>" class="panel-collapse collapse border-0">
										
											<%		
												boolean showDiv5 = true;
												List<Tema> correlate4 = tema4.getListArgomento();
												if(NoiPAWebAssistenzaUtils.isValid(correlate4)){
												for (Tema tema5 : correlate4){
											%>
										
										
										
											<%-- <h6 class="text-18p my-0">
											<a data-toggle="collapse" href="#<%=tema5.getId() %>" aria-expanded="false" class="px-5 py-4 dropdown-toggle d-block font-weight-normal"><span class="fa fa-angle-down font-weight-bold ml-3 fa-1x5 float-right"></span><%=tema5.getTitolo()%></a>
										</h6> --%>
										<div id="<%=tema5.getId() %>" class="panel-collapse border-0 px-5">
										  <div class="panel-body pr-5 py-3 t-0 text-18p bg-white noipa-margin-6">
											<p><%=tema5.getDescrizione() %></p>
													<%
													List<String> listLabel = tema5.getLabelLinks();
													List<String> link = tema5.getLinks();
													if(listLabel!=null){
														for(int i = 0; i<listLabel.size();i++){
															%>
															<p><a href="<%=link.get(i)%>"><%=listLabel.get(i) %></a></p>
															<%
														}
													}
													%>
										  </div>
										</div>								
																		
												<% } 
												} %>
												</div>
												<% } %>
												
												<%
												}
												}
												%>
												
												<% if(!showDiv4){ %>
											  </div>
											</div>
											<% } %>
										
										</div>
	
										<% } else { %>
							
											<div class="panel-group m-0">
											  <div class="panel panel-default bg-005 border-0 rounded-0 shadow-none pl-4">
	<%-- 											<h6 class="text-18p my-0">
													<a data-toggle="collapse" href="#<%=tema3.getId() %>" aria-expanded="false" class="px-5 py-4 dropdown-toggle d-block font-weight-normal"><span class="fa fa-angle-down font-weight-bold ml-3 fa-1x5 float-right"></span><%=tema3.getTitolo() %></a>
												</h6> --%>
												<div id="<%=tema3.getId() %>" class="panel-collapse border-0 px-5">
												  <div class="panel-body pr-5 py-3 t-0 text-18p bg-white noipa-margin-2">
													<p><%=tema3.getDescrizione() %></p>
													<%
													List<String> listLabel = tema3.getLabelLinks();
													List<String> link = tema3.getLinks();
													if(listLabel!=null){
														for(int i = 0; i<listLabel.size();i++){
															%>
															<p><a href="<%=link.get(i)%>"><%=listLabel.get(i) %></a></p>
															<%
														}
													}
													%>
												  </div>
												</div>
											  </div>
											</div>
											
											
									<% }
											}
											 } %>
										<% if(!showDiv3){ %>
									  </div>
									</div>
										<% } %>
								</div>
								<%
								}
								} 
								%>
								<%if(!showDiv2){ %>
							  </div>
							</div>
							<% }%>
						</div>
					</div>
				</div>
			</div>
			<% } %>
	</div>
</div>
    
<div class="text-center py-3">
			<h2 class="mt-5 pb-0 text-28p" id="cat-1"><liferay-ui:message key="noipawebformassistenza.wizard.start" /></h2>
			
</div>

<div class="text-center py-3">
<div class="row">
	<div class="col-md-3"> <%-- <liferay-ui:message key="noipawebformassistenza.wizard.start.1" />--%> 
		<a title="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" aria-label="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" href="${urlAmministrato}" class="btn btn-default bg-transparent btn-lg my-5 px-5 text-16p py-2">Amministrato</a>
	</div>
	
	<div class="col-md-3">
		<a title="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" aria-label="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" href="${urlMVP}" class="btn btn-default bg-transparent btn-lg my-5 px-5 text-16p py-2">MVP</a>
	</div>
	
	<div class="col-md-3">
		<a title="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" aria-label="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" href="${urlAreaPensioni}" class="btn btn-default bg-transparent btn-lg my-5 px-5 text-16p py-2">Area pensioni</a>
	</div>
	
	<div class="col-md-3">
		<a title="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" aria-label="<liferay-ui:message key="noipawebformassistenza.label.link.accessibilita" />" href="${urlEntiCreditori}" class="btn btn-default bg-transparent btn-lg my-5 px-5 text-16p py-2">Enti creditori</a>
	</div>
</div>

</div>
