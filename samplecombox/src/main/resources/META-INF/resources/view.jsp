<%@ include file="init.jsp" %>

<p>
	<b><liferay-ui:message key="samplecombox.caption"/></b>
</p>

<script type="text/javascript">

var data =  [
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 1",
	      "Codice":"1"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 2",
	      "Codice":"2"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 3",
	      "Codice":"3"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 4",
	      "Codice":"4"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 5",
	      "Codice":"5"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 6",
	      "Codice":"6"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 7",
	      "Codice":"7"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 8",
	      "Codice":"8"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 9",
	      "Codice":"9"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 10",
	      "Codice":"10"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 11",
	      "Codice":"11"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 12",
	      "Codice":"12"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 12",
	      "Codice":"12"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 14",
	      "Codice":"14"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 15",
	      "Codice":"15"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 16",
	      "Codice":"16"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"S",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 17",
	      "Codice":"17"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"S",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 18",
	      "Codice":"18"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"S",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 19",
	      "Codice":"19"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"S",
	      "MVP":"N",
	      "Amministrato":"S",
	      "Ente":"Ente 20",
	      "Codice":"20"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"S",
	      "Amministrato":"N",
	      "Ente":"Altro",
	      "Codice":"1"
	   },
	   {
	      "AreaPensioni":"S",
	      "EntiCreditori":"N",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"N",
	      "Ente":"Altro",
	      "Codice":"1"
	   },
	   {
	      "AreaPensioni":"N",
	      "EntiCreditori":"S",
	      "Tipo":"N",
	      "MVP":"N",
	      "Amministrato":"N",
	      "Ente":"Altro",
	      "Codice":"1"
	   }
	];

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
		<aui:input name="tipo" type="text" value="Amministrato"/>
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
	
	
	
	
	function loadComboEnte(ente){
		comboz = $("#<portlet:namespace/>ente");
		comboz.empty();
        comboz.append("<option/>");
         
        $.each(ente, function(i, item) {    
        	$option = $("<option/>").attr("value", item.Tipo+"-"+item.Codice).text(item.Ente);
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

			if( _type == "Amministrato") {
			 var ente = data.filter(x => x.Amministrato == "S");
       console.log(ente);
			 loadComboEnte(ente)
			}; 
      
			if( _type == "MVP"){
			 var ente = data.filter(x => x.MVP == "S");
       console.log(ente);
       loadComboEnte(ente)
			
			};
      
			if( _type == "AreaPensioni") {
			 var ente = data.filter(x => x.AreaPensioni == "S");
       console.log(ente);
			 loadComboEnte(ente)
			};
      
			if( _type == "EntiCreditori") {
			 var ente = data.filter(x => x.EntiCreditori == "S");
       console.log(ente);
			 loadComboEnte(ente)
			}
		
		});
		
		
	</aui:script>