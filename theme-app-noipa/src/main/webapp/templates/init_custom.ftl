<#--
This file allows you to override and define new FreeMarker variables.
-->

<#--
This file allows you to override and define new FreeMarker variables.
-->

<#assign urlPortalePrivato = propsUtil.get("url.portale.privato")>
<#assign urlPortalePrivatoModifica = propsUtil.get("url.portale.privato.modifica-dati-personali")>
<#assign urlPortalePrivatoSpid = propsUtil.get("url.portale.privato.ottieni-spid")>
<#assign urlPortalePrivatoReset = propsUtil.get("url.portale.privato.resetpwd")>
<#assign urlPortalePrivatoEsci = propsUtil.get("url.portale.privato.esci")>
<#assign cPathNoiPa = propsUtil.get("portal.ctx")>


<#assign urlNoiPA = propsUtil.get("noipa.url.home")>
<#assign urlNoiPAPressKit = urlNoiPA + propsUtil.get("noipa.presskit.url.home")>
<#assign urlNoiPAYoutube = propsUtil.get("noipa.url.youtube")>
<#assign urlNoiPAFacebook = propsUtil.get("noipa.url.facebook")>
<#assign urlNoiPATwitter = propsUtil.get("noipa.url.twitter")>
<#assign urlNoiPAppGoogle = propsUtil.get("noipa.url.app.google")>
<#assign urlNoiPAppApple = propsUtil.get("noipa.url.app.apple")>
<#assign urlNoiPAppHuawei = "https://appgallery.cloud.huawei.com/marketshare/app/C102092841?locale=it_IT&source=appshare&subsource=C102092841">

<#-- 

<#assign urlPortalePrivato = "">
<#assign urlPortalePrivatoModifica = "">
<#assign urlPortalePrivatoSpid = "">
<#assign urlPortalePrivatoReset = "">
<#assign urlPortalePrivatoEsci = "">
<#assign cPathNoiPa = "" >
 
 -->

<#function translateAR locale >

  <#assign info = "Accedi all'area riservata" />
  <#assign EN = "en_US" />
  <#assign DE = "de_DE" />
  <#assign IT = "it_IT" />
  
	<#if locale == IT >
		<#assign info = "Accedi all'area riservata" />
	<#elseif locale == EN >
		<#assign info = "Access the private area" />
	<#elseif locale == DE >
		<#assign info = "Passwort geschützter Zugang " />
	</#if>
  
  <#return info>
  
</#function>

<#function translateAP locale >
  <#assign info = "Scarica l'App" />
  <#assign EN = "en_US" />
  <#assign DE = "de_DE" />
  <#assign IT = "it_IT" />
  
	<#if locale == IT >
		<#assign info = "Scarica l'App" />
	<#elseif locale == EN >
		<#assign info = "Download the app" />
	<#elseif locale == DE >
		<#assign info = "App herunterladen" />
	</#if>
  
  <#return info>
  
</#function>

<#function translateOP locale >
  <#assign info = "Accesso operatori" />
  <#assign EN = "en_US" />
  <#assign DE = "de_DE" />
  <#assign IT = "it_IT" />
  
	<#if locale == IT >
		<#assign info = "Accesso operatori" />
	<#elseif locale == EN >
		<#assign info = "Accesso operatori" />
	<#elseif locale == DE >
		<#assign info = "Accesso operatori" />
	</#if>
  
  <#return info>
  
</#function>


<#function translate locale value>

<#assign pecette = ["Avvisi","Download","Documenti/ Documento","Fai parte del Personale  della Pubblica Amministrazione?","i servizi a te dedicati","Leggi di più","Modulo/Moduli","News","Scarica L'app","Sei Una Pubblica Amministrazione?","Aderisci a NoiPA","Foto","Video","Accedi all'area riservata","Cerca","Seguici","Cookies policy","Mappa del Sito","News","Note Legali","Press Kit","Privacy policy","L'App NoiPA","Sei un Ente privato? Attiva la convenzione","Scopri il catalogo dei servizi","Pubbliche Amministrazioni","Continua a leggere","Ultimo avviso","Lorem Ipsum","Vedi altre notizie di","Lorem ipsum dolor sit amet","Amministrazione e Comparti","Enti Terzi","Partner Istituzionali","Torna all’area riservata","Accedi all'area riservata","Mappa del Sito","Note Legali","Modifica Dati Personali","Ottieni SPID","Modifica Password","Esci","Patrimonio Informatico","Accedi all’area riservata","Recapiti e Contatti","Seguici su","Scarica L’app","Collegamento a sito esterno","Menu utente","Menu area riservata","Sito esterno","Nuova finestra","Vai al sito","Menu lingua a tendina","Apri il menu a tendina lingua","Area riservata","Cerca nel sito","Ricerca","Torna alla Home","Scarica da App store","Scarica da Google Play","Accesso operatori","Vai a","Scarica il documento","Apri il menù di navigazione","Menù di navigazione","Apri il menu area riservata","Vai direttamente al contenuto","Vai direttamente alla navigazione","Vai direttamente al footer","Vai alla pagina","Vai direttamente alla sezione In evidenza","Vai direttamente alla sezione In primo piano","Vai direttamente alla sezione Patrimonio informativo"] />
<#assign pecetteEN = ["Notices","Download","Documents / Document","Do you belong to the Public Administration Personnel?","Discover the services dedicated to you","Read more","Form / Forms","News","Download the app","Are you a Public Administration?","Join NoiPA","Photo","Video","Access the private area","Search","Follow us","Cookies policy","Site Map","News","Legal notices","Press Kit","Privacy policy","App NoiPA","Are you a private body? Activate the agreement","Discover the services catologue","Public Administrations","Keep reading","Ultimo avviso","Lorem Ipsum","Vedi altre notizie di","Lorem ipsum dolor sit amet","Amministrazione e Comparti","Enti Terzi","Institutional partners","Back to private area","Access the private area","Site Map","Legal Notices","Change personal data","Get SPID","Change Password","Logout","Information Assets","Access the private area","Address and Contact","Follow us on","Download the app","Link to external site","User menu","Menu area riservata","External site","New window","Vai al sito","Menu lingua a tendina","Apri il menu a tendina lingua","Area riservata","Cerca nel sito","Search","Torna alla Home","Download from the App Store","Download from the Google Play","Accesso operatori","Go to","Download Document","Apri il menù di navigazione","Menù di navigazione","Apri il menu area riservata","Go directly to the content","Go directly to navigation","Go directly to the footer","Go to the page","Vai direttamente alla sezione In evidenza","Vai direttamente alla sezione In primo piano","Vai direttamente alla sezione Patrimonio informativo"] />
<#assign pecetteDE = ["Hinweise","Download","Dokumente/Dokument","BistDuAngestellte/rderöffentlichenVerwaltung?","FürDichvorbehalteneDienstleistungen","mehr","Vordruck/Vorlagen","News","Appherunterladen","BistDueineöffentlicheVerwaltung?","NimmNoiPAan","Foto","Video","PasswortgeschützterZugang","Suche","Folgeuns","Cookiespolicy","Seitenübersicht","News","RechtlicheHinweise","PressKit","Privacypolicy","NoiPAApp","BistDueineprivateKörperschaft? AktivierediKonvention","EntdeckedenDienstleistungskatalog","Öffentliche Verwaltungen","Lesen Sie weiter","Ultimo avviso","Lorem Ipsum","Vedi altre notizie di","Lorem ipsum dolor sit amet","Amministrazione e Comparti","Enti Terzi","Institutionelle Partner","Zurück zu geschützter Zugang","Passwort geschützter Zugang","Site Map","Seitenübersicht","Ändere die persönlichen Daten","Erlangung des SPID","Ändere dein Passwort","Schließen","informativen Bestandes","Passwort geschützter Zugang","Adressen und Kontakte","Folge uns auf","App herunterladen","Link zu externer Seite","Benutzermenü","Menu area riservata","Externer Seite","Neues Fenster","Vai al sito","Menu lingua a tendina","Apri il menu a tendina lingua","Area riservata","Cerca nel sito","Suchen","Torna alla Home","Im App Store herunterladen","Im Google Play herunterladen","Accesso operatori","Gehe zu","Dokument herunterladen","Apri il menù di navigazione","Menù di navigazione","Apri il menu area riservata","Gehe direkt zum Inhal","Gehe direkt zur Navigation","Gehe direkt in die Fußzeile","Gehe zur Seite","Vai direttamente alla sezione In evidenza","Vai direttamente alla sezione In primo piano","Vai direttamente alla sezione Patrimonio informativo"] />


<#assign indexPecette = pecette?seq_index_of(value) />
  <#assign info = value />
  <#assign EN = "en_US" />
  <#assign DE = "de_DE" />
  <#assign IT = "it_IT" />
  
  <#if indexPecette < 0 >
    <#assign info = value />
  <#else>
	<#if locale == IT >
		<#assign info = value />
	<#elseif locale == EN >
		<#assign info = pecetteEN[indexPecette] />
	<#elseif locale == DE >
		<#assign info = pecetteDE[indexPecette] />
	</#if>
  </#if>
  

  
  <#return info>
  
</#function>

<#function showControlPanel>
   <#assign showcontrolmenu = false />
<#if is_signed_in>
    <#assign roles = user.getRoles() />
 
    <#list roles as role>
          <#if role.getName() == "Administrator" || role.getName() == "Other Role" >
                    <#assign showcontrolmenu = true />
                    <#break>
        </#if>             
    </#list> 
 
</#if>
  <#return showcontrolmenu>
</#function>

<#-- 
<#function labelSelect>
   <#assign currentURLC = theme_display.getURLCurrent() />
   <#assign label = "ITA" />
   
<#if currentURLC?contains("/en")>
	<#assign label = "ENG" />	
</#if>

<#if currentURLC?contains("/de")>
	<#assign label = "DEU" />
</#if>

<#if currentURLC?contains("/it")>
	<#assign label = "ITA" />
</#if>

  <#return label>
</#function>
 -->
<#function labelSelect>
   <#assign currentURLC = theme_display.getURLCurrent() />
   <#assign label = "ITA" />
   
<#if language?contains("en")>
	<#assign label = "ENG" />	
</#if>

<#if language?contains("de")>
	<#assign label = "DEU" />
</#if>

<#if language?contains("it")>
	<#assign label = "ITA" />
</#if>

  <#return label>
</#function>



<#function translateCB locale value>

<#assign pecette   = ["Questo sito utilizza cookie tecnici, analytics e di terze parti. Proseguendo nella navigazione accetti l’utilizzo dei cookie.","Accetto"] />
<#assign pecetteEN = ["This site uses technical, analytics and third-party cookies. By continuing on this site, you accept the use of cookies.","Accept"] />
<#assign pecetteDE = ["Diese Seite verwendet technische Cookies, Analytics und Cookies von Dritten. Wenn du in der Navigation fortfährst, akzeptierst du die Benutzung der Cookies. ","Annehmen"] />


<#assign indexPecette = pecette?seq_index_of(value) />
  <#assign info = value />
  <#assign EN = "en_US" />
  <#assign DE = "de_DE" />
  <#assign IT = "it_IT" />
  
  <#if indexPecette < 0 >
    <#assign info = value />
  <#else>
	<#if locale == IT >
		<#assign info = value />
	<#elseif locale == EN >
		<#assign info = pecetteEN[indexPecette] />
	<#elseif locale == DE >
		<#assign info = pecetteDE[indexPecette] />
	</#if>
  </#if>
  

  
  <#return info>
  
</#function>
<#assign ipAddress = request.getRemoteAddr() />

