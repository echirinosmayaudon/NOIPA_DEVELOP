function recuperaTipo(jsonArray){
var sezione = [];
jsonArray.forEach(myFunction);
function myFunction(item) {
  if(!sezione.includes(item.tipo)){
  sezione = sezione.concat(item.tipo);
  }
}
console.log(sezione);
}

function recuperaUtente(jsonArray,filtroTipo){
	var userList = [];
	var arrayFilter =  jsonArray.filter(function(list) {
		return list.tipo == filtroTipo;
	});
	arrayFilter.forEach(forFiltro);
	function forFiltro(item) {
	    if(!userList.includes(item.utente)){
	    	userList = userList.concat(item.utente);
	   }
	}
	return userList;
}

function recuperaRichiesta(jsonArray,filtroTipo,filtroUtente){
	var richiestaList = [];
	var arrayFilter =  jsonArray.filter(function(list) {
		return (list.tipo == filtroTipo && list.utente == filtroUtente);
	});
	arrayFilter.forEach(forFiltroUser);
	function forFiltroUser(item){
		if(!richiestaList.includes(item.richiesta)){
			richiestaList = richiestaList.concat(item.richiesta);
		}
	}
	return richiestaList;
}

function recuperaSubRichiesta(jsonArray,filtroTipo,filtroUtente,filtroRichiesta){
	
	var subRichiestaList = [];
	var arrayFilter =  jsonArray.filter(function(list) {
		return (list.tipo == filtroTipo && list.utente == filtroUtente && list.richiesta == filtroRichiesta);
	});
	
	arrayFilter.forEach(forFiltroRichiesta);
	
	function forFiltroRichiesta(item){
		console.log(item.sottorichiesta);
		if(!subRichiestaList.includes(item.sottorichiesta) && item.sottorichiesta !== undefined){
			subRichiestaList = subRichiestaList.concat(item.sottorichiesta);
		}
	}
	console.log(subRichiestaList);
	return subRichiestaList;
}

