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
	    <#assign imageStyle = "background: url("+immagine+");"  >
        <#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
        <#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
        <#assign article = journalArticleLocalService.getArticle(getterUtil.getLong(scopeGroupId), journalArticle.getArticleId())>
        <#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', article.resourcePrimKey) >
        <#assign assetCategoryService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryService")>
        <#assign category = assetCategoryService.getCategories('com.liferay.journal.model.JournalArticle',article.resourcePrimKey) />
        
				<div class="mx-1 card bg-white shadow ml-1 ml-md-4 mb-5">
					<div class="row">
						<div class="col-sm-6 pr-0 img-news img-news-dx" style="${imageStyle}">
							<span class="d-block w-100"></span>
						</div>
						<div class="col-sm-6 py-4">
							<div class="px-4 p-md-0">
							
							
							<#if category?has_content>
                                <#list category as cat>
								<div class="text-link text-uppercase font-weight-300 ">${cat.getName()}
								</div>
                                </#list>
                            </#if>

								<div class="news-div h-150p pr-4">
									<div class="text-primary-dark text-28p my-2 font-weight-600">${titoloNews}</div>
									<p>${abstract} </p>
								</div>
								<p class="py-2">
									<span class="mr-3">${createDate}</span>
                                    <#if asset?has_content>
                                    <#list asset.getTags() as tag>
                                        <#assign size = asset.getTags()?size />
                                        <#assign index = tag?index />
                                    <#if index <= 0 >    
                        		    <#assign info = tag.name?contains("_altra") />
                        		    <#if !info>
                                    <a href="#" class="border border-link rounded-13 px-5 py-0 text-16p mr-2 mb-2 d-inline-block line-height-20p">${tag.name}</a>
                                    </#if>
                                    </#if>
                                    </#list>
                                    </#if>
                                    <#if 1 < size >
									<span href="#" class="border border-link rounded-13 px-2 py-0 text-16p mr-2 mb-2 d-inline-block line-height-20p">...</span> </#if>
								</p>
								<a href="dettaglio-news/-/asset_publisher/GBFi2ZJ8I37i/content/${journalArticle.getUrlTitle()}" class="font-weight-300 text-16p">Continua a leggere<i class="fa fa-arrow-right ml-3" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</div>
	</#list>
</#if>