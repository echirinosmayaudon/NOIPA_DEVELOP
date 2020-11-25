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
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='titolo']")  >
	    <#assign titoloNews = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='abstract']")  >
	    <#assign abstract = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='img']")  >
	    <#assign immagine = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign imageStyle = "background: url("+immagine+");"  >
        <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
        <#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
        <#assign article = journalArticleLocalService.getArticle(getterUtil.getLong(scopeGroupId), journalArticle.getArticleId())>
        <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', article.resourcePrimKey) >
        <#assign assetCategoryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
        <#assign category = assetCategoryService.getCategories('com.liferay.journal.model.JournalArticle',article.resourcePrimKey) />
        <div class="BGContainer">
			<div class="container pb-4" id="contenuto">
				<div class="mx-1 card bg-b40 mb-4">
					<div class="row m-0">
					<div class="col-sm-6 m-0 img-news" style="${imageStyle}">
							<span class="d-blockd w-100g"></span>
						</div>
					
					<div class="col-sm-6 pb-4">
							<div class="pr-5 pl-2">
								<h2 class="text-white font-weight-700 text-32p pt-5">${titoloNews}</h2>
									<p class="text-white">${abstract} </p>
								</div>
								
								<a href="#" class="btn btn-default-light bg-transparent text-white text-16p font-weight-normal my-4 px-5 py-1 mx-2">Aderisci</a>
						</div>
					</div>
				</div>
					</div>
				</div>
	</#list>
</#if>