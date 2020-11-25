<%@ include file="init.jsp" %>

<p>
	<b><liferay-ui:message key="samplecombox.caption"/></b>
</p>

<script type="text/javascript">
var entiAmministrato = 
	[ {"ente": "Ente 1","tipo":"N","codice":"1"},
	{"ente": "Ente 2","tipo":"N","codice":"2"},
	{"ente": "Ente 3","tipo":"N","codice":"3"},
	{"ente": "Ente 4","tipo":"N","codice":"4"},
	{"ente": "Ente 5","tipo":"N","codice":"5"},
	{"ente": "Ente 6","tipo":"N","codice":"6"},
	{"ente": "Ente 7","tipo":"N","codice":"7"},
	{"ente": "Ente 8","tipo":"N","codice":"8"},
	{"ente": "Ente 9","tipo":"N","codice":"9"},
	{"ente": "Ente 10","tipo":"N","codice":"10"},
	{"ente": "Ente 11","tipo":"N","codice":"11"},
	{"ente": "Ente 12","tipo":"N","codice":"12"},
	{"ente": "Ente 12","tipo":"N","codice":"12"},
	{"ente": "Ente 14","tipo":"N","codice":"14"},
	{"ente": "Ente 15","tipo":"N","codice":"15"},
	{"ente": "Ente 16","tipo":"N","codice":"16"},
	{"ente": "Ente 17","tipo":"S","codice":"17"},
	{"ente": "Ente 18","tipo":"S","codice":"18"},
	{"ente": "Ente 18","tipo":"S","codice":"18"},
	{"ente": "Ente 20","tipo":"S","codice":"20"}]; 
var entiMVP = [ {"ente": "Altro","tipo":"N","codice":"1"}];
var entiAreaPensioni = [ {"ente": "Altro","tipo":"N","codice":"1"}];
var entiCreditori = [ {"ente": "Altro","tipo":"N","codice":"1"}];

var tipologie = [

	{"tipo":"Amministrato","flag":"S","pl":"Accesso e Gestione Utenze ","sl":"Primo accesso","tl":"Primo accesso","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Accesso e Gestione Utenze ","sl":"Reset password","tl":"Reset password","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Accesso e Gestione Utenze ","sl":"Reset PIN","tl":"Reset PIN","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Voci e compensi accessori","tl":"Voci e compensi accessori","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Accessorie fuori sistema ","tl":"Accessorie fuori sistema ","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Fiscale ","tl":"Certificazione Unica","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Fiscale ","tl":"Dichiarazioni, ritenute e conguagli fiscali","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Previdenziale ","tl":"Contributi, dichiarazioni, conguagli e versamenti previdenziali","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Previdenziale ","tl":"Previdenza complementare","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Altre ritenute","tl":"Altre ritenute","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Applicazione rinnovi contrattuali","tl":"Applicazione rinnovi contrattuali","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Servizi per il Comparto Scuola ","tl":"Pagamenti e contratti personale docente non di ruolo","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Consultazione Cedolino e CU","tl":"Consultazione Cedolino e CU","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Segnalazione mancato accredito","tl":"Segnalazione mancato accredito","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Servizi stipendiali","sl":"Altro","tl":"Altro","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi anagrafici","tl":"Gestione residenza fiscale e domicilio","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi stipendiali","tl":"Gestione modalità di riscossione","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi stipendiali","tl":"Gestione Bonus IRPEF DL 66/2014","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi stipendiali","tl":"Gestione detrazioni familiari a carico","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Visualizzazione cartellino","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Gestione autorizzazioni straordinario","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Visualizzazione turni","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Gestione eccedenza","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Gestione timbrature","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Gestione assenze e permessi","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Gestione ferie e festività soppresse","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Previdenza ","tl":"Gestione previdenza complementare","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Previdenza ","tl":"Cruscotto previdenziale","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"Assistenza alle funzionalità online","sl":"Prestiti e Convenzioni","tl":"NoiPAssicura","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"S","pl":"App NoiPA","sl":"Supporto Tecnico","tl":"Supporto Tecnico","cat":"Amministrato Sanità"},
	{"tipo":"Amministrato","flag":"N","pl":"Accesso e Gestione Utenze ","sl":"Primo accesso","tl":"Primo accesso","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Accesso e Gestione Utenze ","sl":"Reset password","tl":"Reset password","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Accesso e Gestione Utenze ","sl":"Reset PIN","tl":"Reset PIN","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Voci e compensi accessori","tl":"Voci e compensi accessori","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Accessorie fuori sistema ","tl":"Accessorie fuori sistema ","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Fiscale ","tl":"Certificazione Unica","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Fiscale ","tl":"Dichiarazioni, ritenute e conguagli fiscali","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Previdenziale ","tl":"Contributi, dichiarazioni, conguagli e versamenti previdenziali","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Previdenziale ","tl":"Previdenza complementare","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Altre ritenute","tl":"Altre ritenute","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Applicazione rinnovi contrattuali","tl":"Applicazione rinnovi contrattuali","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Servizi per il Comparto Scuola ","tl":"Pagamenti e contratti personale docente non di ruolo","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Consultazione Cedolino e CU","tl":"Consultazione Cedolino e CU","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Segnalazione mancato accredito","tl":"Segnalazione mancato accredito","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Servizi stipendiali","sl":"Altro","tl":"Altro","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi anagrafici","tl":"Gestione residenza fiscale e domicilio","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi stipendiali","tl":"Gestione modalità di riscossione","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi stipendiali","tl":"Gestione Bonus IRPEF DL 66/2014","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi stipendiali","tl":"Gestione detrazioni familiari a carico","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi per il Comparto Scuola ","tl":"Self Service di Visualizzazione contratti scuola","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Visualizzazione cartellino","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Gestione assenze e permessi","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Servizi di rilevazione presenze","tl":"Gestione ferie e festività soppresse","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Previdenza ","tl":"Gestione previdenza complementare","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Previdenza ","tl":"Cruscotto previdenziale","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Prestiti e Convenzioni","tl":"Piccolo prestito","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"Assistenza alle funzionalità online","sl":"Prestiti e Convenzioni","tl":"NoiPAssicura","cat":"Amministrato"},
	{"tipo":"Amministrato","flag":"N","pl":"App NoiPA","sl":"Supporto Tecnico","tl":"Supporto Tecnico","cat":"Amministrato"},
	{"tipo":"MVP","flag":"N","pl":"Modulo di Valutazione Performance","sl":"Assistenza alle funzionalità","tl":"Assistenza alle funzionalità","cat":"Amministrato"},
	{"tipo":"MVP","flag":"N","pl":"Modulo di Valutazione Performance","sl":"Configurazione e gestione delle funzionalità","tl":"Configurazione e gestione delle funzionalità","cat":"Operatore"},
	{"tipo":"Area Pensioni","flag":"N","pl":"Area Pensioni","sl":"Informazioni","tl":"Informazioni","cat":"Amministrato"},
	{"tipo":"Enti creditori","flag":"N","pl":"Servizi per Enti Creditori e Professionisti","sl":"Richieste convenzionamento Ente, cessioni di credito","tl":"Richieste convenzionamento Ente, cessioni di credito","cat":"Amministrato"},
	{"tipo":"Enti creditori","flag":"N","pl":"Servizi per Enti Creditori e Professionisti","sl":"Richiesta altre certificazioni","tl":"Richiesta altre certificazioni","cat":"Amministrato"}
];
</script>
	
	<aui:form>
		<aui:input name="tipo" type="text" value="MVP"/>
		<aui:input name="flag" type="text"/>
		<aui:input name="enteVal" type="text"/>
		<br/><br/>
		ENTE :<aui:select name="ente"></aui:select><br/>
		Categoria :<aui:select name="categoria"></aui:select><br/>
		PL:<aui:select name="pl"></aui:select><br/>
		SL:<aui:select name="sl"></aui:select><br/>
		TL:<aui:select name="tl"></aui:select><br/>
	</aui:form>
	
	<aui:script>

	
	
	function resetComboz(combos) {
    	if (combos != null) {
        	for (var i = 0; i <= combos.length; i++) {
               if ($("#<portlet:namespace/>" + combos[i]).length) {
                    $("#<portlet:namespace/>" + combos[i]).empty();
                }        
    		}
		}
	}
	
	
	
	
	function loadComboEnte(data){
		comboz = $("#<portlet:namespace/>ente");
		comboz.empty();
        comboz.append("<option/>");
         
        $.each(data, function(i, item) {    
        	$option = $("<option/>").attr("value", item.tipo+"-"+item.codice).text(item.ente);
        	comboz.append($option);
        });
        
        if(data.length==1){
        	$($("#<portlet:namespace/>ente").find('option')[1]).attr("selected","selected");
        	
        	$("#<portlet:namespace/>ente" ).trigger( "change" );

        }	 	
	}
	
	function filterCategoria(){
	  _tipo = $("#<portlet:namespace/>tipo").val();
	  _flag = $("#<portlet:namespace/>flag").val();
		_items = [];
		$.each(tipologie, function(i, item) {
			if(item.tipo==_tipo && item.flag == _flag){
				if($.inArray(item.cat,_items)< 0) {
				_items.push(item.cat);
				}
			}
		});
		
		return _items;
	}
	
	function filterPl(){
	  _tipo = $("#<portlet:namespace/>tipo").val();
	  _flag = $("#<portlet:namespace/>flag").val();
	  _cat = $("#<portlet:namespace/>categoria").val();
		_items = [];
		$.each(tipologie, function(i, item) {
			if(item.tipo==_tipo && item.flag == _flag && item.cat == _cat){
				if($.inArray(item.pl,_items)< 0) {
				_items.push(item.pl);
				}
			}
		});
		
		return _items;
	}
	
	
	function filterSl(){
	  _tipo = $("#<portlet:namespace/>tipo").val();
	  _flag = $("#<portlet:namespace/>flag").val();
	  _cat = $("#<portlet:namespace/>categoria").val();
	  _pl  = $("#<portlet:namespace/>pl").val();
		_items = [];
		$.each(tipologie, function(i, item) {
			if(item.tipo==_tipo && item.flag == _flag && item.cat == _cat  && item.pl == _pl){
				if($.inArray(item.sl,_items)< 0) {
				_items.push(item.sl);
				}
			}
		});
		
		return _items;
	}
	
	function filterTl(){
	  _tipo = $("#<portlet:namespace/>tipo").val();
	  _flag = $("#<portlet:namespace/>flag").val();
	  _cat = $("#<portlet:namespace/>categoria").val();
	  _pl  = $("#<portlet:namespace/>pl").val();
	  _sl  = $("#<portlet:namespace/>sl").val();
		_items = [];
		$.each(tipologie, function(i, item) {
			if(item.tipo==_tipo && item.flag == _flag && item.cat == _cat  && item.pl == _pl && item.sl == _sl){
				if($.inArray(item.tl,_items)< 0) {
				_items.push(item.tl);
				}
			}
		});
		
		return _items;
	}
	
	function loadComboCategoria(){
		comboz = $("#<portlet:namespace/>categoria");
		comboz.empty();
        comboz.append("<option/>");
        data = filterCategoria();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        if(data.length==1){
        	$($("#<portlet:namespace/>categoria").find('option')[1]).attr("selected","selected");
        	$("#<portlet:namespace/>categoria" ).trigger( "change" );

        }	 	
	}

	function loadComboPl(){
		comboz = $("#<portlet:namespace/>pl");
		comboz.empty();
        comboz.append("<option/>");
        data = filterPl();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        if(data.length==1){
        	$($("#<portlet:namespace/>pl").find('option')[1]).attr("selected","selected");
        	$("#<portlet:namespace/>pl" ).trigger( "change" );

        }	 	
		
	}
	
	
	function loadComboSl(){
		comboz = $("#<portlet:namespace/>sl");
		comboz.empty();
        comboz.append("<option/>");
        data = filterSl();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        if(data.length==1){
        	$($("#<portlet:namespace/>sl").find('option')[1]).attr("selected","selected");
        	$("#<portlet:namespace/>sl" ).trigger( "change" );

        }	 	
		
	}


function loadComboTl(){
		comboz = $("#<portlet:namespace/>tl");
		comboz.empty();
        comboz.append("<option/>");
        data = filterTl();
        
        $.each(data, function(i, item) {
        	$option = $("<option/>").attr("value", item).text(item);
        	comboz.append($option);
        });	
        if(data.length==1){
        	$($("#<portlet:namespace/>tl").find('option')[1]).attr("selected","selected");
        	$("#<portlet:namespace/>tl" ).trigger( "change" );

        }	 	
		
	}


	$('#<portlet:namespace/>ente').bind("change", function (event) { 
        _xval =  $(this).val();
        _innersVal = _xval.split("-");
        console.log(_innersVal);
        $('#<portlet:namespace/>flag').val(_innersVal[0]);
        $('#<portlet:namespace/>enteVal').val(_innersVal[1]);
        resetComboz(['categoria','pl','sl','tl']);
        if(_xval){        	        
        	loadComboCategoria();        	        	        	
        }
    });
    $('#<portlet:namespace/>categoria').bind("change", function (event) { 
        resetComboz(['pl','sl','tl']);
        if(_xval){        	        
        	loadComboPl();        	        	        	
        }
    });
    
    $('#<portlet:namespace/>pl').bind("change", function (event) { 
        resetComboz(['sl','tl']);
        if(_xval){        	        
        	loadComboSl();        	        	        	
        }
    });
    
    
    $('#<portlet:namespace/>sl').bind("change", function (event) { 
        resetComboz(['tl']);
        if(_xval){        	        
        	loadComboTl();        	        	        	
        }
    });
	
	AUI().ready(
		function(){
		
			_type = $("#<portlet:namespace/>tipo").val();
			
			if(_type=="Amministrato"){loadComboEnte(entiAmministrato);}
			if(_type=="MVP"){loadComboEnte(entiMVP);}
			if(_type=="Area Pensioni"){loadComboEnte(entiAreaPensioni);}
			if(_type=="Enti creditori"){loadComboEnte(entiCreditori);}
		});
		
		
	</aui:script>