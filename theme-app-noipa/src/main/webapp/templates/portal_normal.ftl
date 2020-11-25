<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title}</title>
	<#-- 
	<title>${the_title} - ${company_name}</title>
	<meta charset="utf-8">
	  -->
	
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="description" content="">
	<meta name="author" content="">
	
	
	<link rel="icon" href="${images_folder_noipa}favicon.ico">
	
	
	<!-- BOOTSTRAP -->
	<link rel="stylesheet" href="${css_folder_noipa}bootstrapAdd4.css" type="text/css" media="all">
	
	<!-- FONT ICONS -->

	<link rel="stylesheet" href="${css_folder_noipa}fontTitillium.css" type="text/css" media="all">
	<link rel="stylesheet" href="${css_folder_noipa}font-awesome.min.css" type="text/css" media="all">

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<link href="${css_folder_noipa}ie10-viewport-bug-workaround.css" rel="stylesheet">

	<link rel="stylesheet" href="${css_folder_noipa}lity.min.css" type="text/css" media="all">
	<!-- file jquery.js eliminato in quanto aggiunto il file jquery-3.4.1.min.js (e puntato poche righe sotto)-->
	<!-- <script src="${javascript_folder_noipa}/jquery.js"></script>-->
	<!-- Script Base -->
	<script src="${javascript_folder_noipa}/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="${javascript_folder_noipa}lity.min.js"></script>

	<script type="text/javascript" src="${javascript_folder_noipa}ie-emulation-modes-warning.js"></script>
	
		<!-- accessibilità gestione del focus in navigazione tabellare js -->
		<script type="text/javascript" src="${javascript_folder_noipa}accessibilita.js"></script>
	
	<!--[if lte IE 9]>
	<link rel="stylesheet" href="css/ie9.css" type="text/css" media="all">
	<![endif]-->
	
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">


<#--<@liferay_ui["quick-access"]  contentId="#main-content" />-->

<@liferay_util["include"] page=body_top_include />

	<#-- <#include "${full_templates_path}/cookiebar.ftl" 
	<#if showControlPanel()>
<@liferay.control_menu />
</#if>
	
	/>  -->
<@liferay.control_menu />
	<div class="container-fluid-1" id="wrapper">
		<header id="banner" role="banner">
			<h1 class="sr-only"><span lang="en">Header</span></h1>
			<#--  <div id="heading">
					<h1 class="site-title">
					<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
					</a>

					<#if show_site_name>
						<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							${site_name}
						</span>
					</#if>
				</h1>
			</div>
			-->

			<#include "${full_templates_path}/header.ftl" />
			<#-- 
			<#if !is_signed_in>
				<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
			</#if>
			-->
			<#if has_navigation && is_setup_complete>
				<div class="bg-primary">
					<div class="navbar yamm bg-primary rounded-0 affix-top" data-spy="affix" data-offset-top="355" id="slide-nav"><!--  navbar-fixed-top-->
						<div class="container">
							<div id="navbar-collapse-1" class="position-relative">
								<#include "${full_templates_path}/navigation.ftl" />
							</div>
						</div>
					</div>
				</div>
			</#if>
		</header>

		<section id="content">
			<h1 class="sr-only">Main</h1>
		<#--<h1 class="sr-only">${the_title}</h1>-->
			<div class="bg-white">
				<div class="container px-0">
					<nav id="breadcrumbs">
							<h1 class="sr-only">Briciole di pane</h1>
						<@liferay.breadcrumbs />
					</nav>
				</div>
			</div>

			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}

				${portletDisplay.setTitle(the_title)}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
			
		</section>
		
		<@liferay_portlet["runtime"] portletName="com_liferay_asset_publisher_web_portlet_AssetPublisherPortlet" />
		

	<#--	
	
			<liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
	
		<footer id="footer" class="footer bg-primary-dark container-fluid py-4 px-0 text-white" role="contentinfo">
			<h1 class="sr-only"><span lang="en">Footer</span></h1>
				<#include "${full_templates_path}/footer.ftl" />
		</footer>
	--->
	
	
	</div>
<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- -->
	
	<!-- Menu mobile -->
	<script src="${javascript_folder_noipa}jPushMenu.js"></script>
	
	<!-- Script CookieBar -->
	<script src="${javascript_folder_noipa}jquery-cookie.js"></script>
	<script src="${javascript_folder_noipa}cookiebar.js"></script>
	
	<!-- Script Inizializzazione -->
	<script src="${javascript_folder_noipa}scriptInit.js"></script>
	
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	 <script src="${javascript_folder_noipa}ie10-viewport-bug-workaround.js"></script>
<!-- -->

<span id="noipa-cookies-bar">
<#include "${full_templates_path}/cookiebar.ftl" />
</span>
</body>
</html>