<link rel="stylesheet" type="text/css" href="${javascript_folder}/cookiebar/cookieconsent.min.css" />


<#--<#assign accetto = translateCB(locale,"Accetto") />-->


<#---Testo non tradotto-->

<#-- <#assign testo = "Questo sito fa uso di cookie tecnici per migliorare l’esperienza di navigazione degli utenti e per raccogliere informazioni sull’utilizzo del sito stesso. È possibile conoscere i dettagli consultando il link" /> -->

 <#assign testo = "Questo sito fa uso di cookie tecnici per migliorare l’esperienza di navigazione degli utenti e per raccogliere informazioni sull’utilizzo del sito stesso. È possibile conoscere i dettagli consultando il link <a id='link_cookie_bar' aria-label='Vai alla pagina Cookie policy' href='${cPathNoiPa}/web/guest/cookie-policy' class='cc-link' style='float:none!important;'>Cookie policy</a>" /> 

<#assign accetto = "X" />

<script src="${javascript_folder}/cookiebar/cookieconsent.min.js"></script>
<script>
var p;
window.addEventListener("load", function(){
window.cookieconsent.initialise({
  "palette": {
    "popup": {
      "background": "#000"
    },
    "button": {
      "background": "#f1d600"
    }
  },
  "elements":{
	 dismiss: '<a aria-label="Esci" tabindex="0" class="cc-btn cc-dismiss" style="min-width:40%; ">${accetto}</a>',
  },
  "theme": "classic",
  "position": "bottom-right",
  "content": {
    "message": "${testo}",
    "allow": "${accetto}",
	"link": "Cookie policy",
	"href": "${cPathNoiPa}/web/guest/cookie-policy"
  }
}, function (popup) {
        p = popup;
		
		
		$('.cc-link').each(function(){
			$(this).addClass('mr-4');
		
			var idElement=$(this).attr("id"); 
			
			if(idElement!='link_cookie_bar')
			{
				$(this).addClass('d-none');
			}
	});
	
	
      })}); 
</script>

