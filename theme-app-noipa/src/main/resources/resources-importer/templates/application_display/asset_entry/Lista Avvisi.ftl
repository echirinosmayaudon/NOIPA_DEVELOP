<#--
Application display templates can be used to modify the look of a
specific application.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->
            <div class="container py-4" id="contenuto">
					<h2 class="mb-4 p-0 text-primary-dark text-32p font-weight-bold">Avvisi</h2>
<#if entries?has_content>
	<#list entries as curEntry>
	    <#assign renderer = curEntry.getAssetRenderer() >
	    <#assign journalArticle = renderer.getArticle() >
	    <#assign document = saxReaderUtil.read(journalArticle.getContentByLocale(locale))  >
	    <#assign rootElement = document.document.getRootElement()  >
	    <#assign createDate = dateUtil.getDate(curEntry.createDate, "dd/MM/yyyy", locale)  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='titoloAvviso']")  >
	    <#assign titoloAvviso = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='descrizioneAvviso']")  >
	    <#assign descrizioneAvviso = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	   
        <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
        <#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
        <#assign article = journalArticleLocalService.getArticle(getterUtil.getLong(scopeGroupId), journalArticle.getArticleId())>
        <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', article.resourcePrimKey) >
        <#assign assetCategoryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
        <#assign category = assetCategoryService.getCategories('com.liferay.journal.model.JournalArticle',article.resourcePrimKey) />
        
					
					
					
					
				<div class="mb-5">
					<div class="news-div">
						<div class="text-primary-dark text-28p my-2 font-weight-600"><i class="fa fa-bullhorn text-gold mr-3" aria-hidden="true"></i>${titoloAvviso}</div>
<p>${descrizioneAvviso}</p>
					</div>
					<div class="social float-right text-link">
						Condividi:
						<a href="#" title="Facebook - Sito esterno" class="d-inline-block"><span class="fa fa-facebook"></span>
						<span class="sr-only">Facebook</span></a>
						<a href="#" title="Twitter  -Sito esterno" class="d-inline-block"><span class="fa fa-twitter"></span>
						<span class="sr-only">Twitter</span></a>
					</div>
					<p class="py-2">
						<span class="mr-3">${createDate}</span>
                            <#if asset?has_content>
                            <#list asset.getTags() as tag>
                            <a href="#" class="border border-link rounded-13 px-5 py-0 text-16p mr-2 mb-2 d-inline-block line-height-20p">${tag.name}</a>
                            </#list>
                            </#if>
					</p>
					<hr class="mb-2">
				</div>
				
	</#list>
</#if>
</div>