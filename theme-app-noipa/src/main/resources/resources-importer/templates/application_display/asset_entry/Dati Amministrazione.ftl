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
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='nomeAmministrazione']")  >
	    <#assign nomeAmministrazione = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	    <#assign xPathSelector = saxReaderUtil.createXPath("dynamic-element[@name='percentuale']")  >
	    <#assign percentuale = xPathSelector.selectSingleNode(rootElement).getStringValue()  >
	   
        <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
        <#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
        <#assign article = journalArticleLocalService.getArticle(getterUtil.getLong(scopeGroupId), journalArticle.getArticleId())>
        <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', article.resourcePrimKey) >
        <#assign assetCategoryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
        <#assign category = assetCategoryService.getCategories('com.liferay.journal.model.JournalArticle',article.resourcePrimKey) />
        
        
        
        <div class="row mb-4">
					<div class="col-sm-6 bg-005 mb-4 p-4 text-24p">
						${nomeAmministrazione} 
						<#assign n = (percentuale?trim)?number>
					</div>
					<div class="col-sm-6 mb-4 text-center">
						<div class="mx-4">
							<span class="sr-only"></span>
							<#assign x=10>
                            <#list 1..x as i>

                            <#if (i <= n)>
                                  <#if i?is_odd_item>
                                  <i class="fa fa-male text-primary mx-1 pt-2 text-56p" aria-hidden="true"></i>
                                  <#else>
                                  <i class="fa fa-female text-primary mx-1 pt-2 text-56p" aria-hidden="true"></i>                                                              </#if>
                            <#else>
                              <#if i?is_odd_item>
                                  <i class="fa fa-male text-light mx-1 pt-2 text-56p" aria-hidden="true"></i>
                                  <#else>
                                  <i class="fa fa-female text-light mx-1 pt-2 text-56p" aria-hidden="true"></i>                                                         </#if>
                                   </#if>
                            </#list>  
							
							
						</div>
					</div>
				</div>
        
        
	</#list>
</#if>