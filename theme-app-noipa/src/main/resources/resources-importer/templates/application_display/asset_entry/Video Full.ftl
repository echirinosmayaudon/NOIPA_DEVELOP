<#--
Application display templates can be used to modify the look of a
specific application.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->


<#if entries?has_content>
	<#list entries as curEntry>
	    <#assign renderer = curEntry.getAssetRenderer() >
	    <#assign journalArticle = renderer.getArticle() >
	    <#assign document = saxReaderUtil.read(journalArticle.getContentByLocale(locale))  >
	    <#assign rootElement = document.document.getRootElement()  >
	    <#assign createDate = dateUtil.getDate(curEntry.createDate, "dd/MM/yyyy", locale)  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='titoloNews']")  >
	    <#assign titoloNews = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='abstract']")  >
	    <#assign abstract = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='immagine']")  >
	    <#assign immagine = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='linkVideo']")  >
	    <#assign linkVideo = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign imageStyle = "background: url("+immagine+");"  >
        <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
        <#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
        <#assign article = journalArticleLocalService.getArticle(getterUtil.getLong(scopeGroupId), journalArticle.getArticleId())>
        <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', article.resourcePrimKey) >
        <#assign assetCategoryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
        <#assign category = assetCategoryService.getCategories('com.liferay.journal.model.JournalArticle',article.resourcePrimKey) />
        
        
				<div class="pb-5">
					<h2 class="mb-4 pb-0 text-primary-dark text-32p">${titoloNews}</h2>
					<div class="row my-4">
						<div class="col-sm-5">
							<div class="position-relative">
								<a href="${linkVideo}" class="link-video"><img src="${immagine}" alt="" class="img-fluid w-100"></a>
							</div>
						</div>
						<div class="col-sm-7">
							<p class="pt-2 pb-4 mb-4">${abstract}</p>
							<p>Lorem ipsum dolor sit amet:</p>
							<a href="/web/guest/amministrazioni" class="btn btn-default bg-transparent btn-lg mb-4 px-5 mr-3 text-16p">Amministrazione e Comparti</a>
							<a href="/web/guest/enti-terzi" class="btn btn-default bg-transparent btn-lg mb-4 px-5 mr-3 text-16p">Enti Terzi</a>
							<a href="web/guest/partner-istituzionali" class="btn btn-default bg-transparent btn-lg mb-4 px-5 mr-3 text-16p">Partner Istituzionali</a>
						</div>
					</div>
				</div>
        
	</#list>
</#if>