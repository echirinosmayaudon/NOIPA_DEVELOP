<#--
Web content templates are used to lay out the fields defined in a web
content structure.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->
<#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />
<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
<#assign journalArticleId = .vars['reserved-article-id'].data/>
<#assign article = journalArticleLocalService.getArticle(getterUtil.getLong(groupId), journalArticleId)>
<#assign asset = assetEntryLocalService.getEntry('com.liferay.journal.model.JournalArticle', article.resourcePrimKey) >


<div class="container py-4" id="contenuto"
                                                               <div class="row">
                                                                               <div class="col-sm-2 col-md-3"></div>
                                                                               <div class="col-sm-8 col-md-6">
                                                                                              <h2 class="mb-3 pb-0 text-primary-dark text-32p pt-0 font-weight-bold">${titoloNews.getData()}</h2>
                                                                                              
                                                                                              <p class="pt-0 mt-0 pb-4 text-24p">${abstract.getData()}</p>
                                                                                              
                                                                                              
                                                                                              
                                                                                              
                                                                                              <div class="immagine">
                                                                                              
                                                                                                  <#if immagine.getData()?? && immagine.getData() != "">
<img data-fileentryid="${immagine.getAttribute("fileEntryId")}" alt="${immagine.getAttribute("alt")}" src="${immagine.getData()}" />
                            <p class="text-14p">${immagine.getAttribute("alt")}</p>
                            </#if>
                                                                                                              
                                                                                              </div>
                                                                                              
                                                                                              <p class="pt-2 pb-4">${corpoNewsIniziale.getData()}</p>
                                                                                              
                                                                                              <#if linkVideo.getData()?has_content>
                                                                                              
                                                                                              <div class="position-relative">
                                <a href="${linkVideo.getData()}" class="link-video">
                                    <img src="images/noipa/imgLunga.jpg" alt="" class="img-fluid w-100">
                                </a>
                                                                                              </div>
                                                                                              <#if linkVideo.didascaliaVideo.getData()?has_content >
                                                                                              <p class="text-14p">${linkVideo.didascaliaVideo.getData()}</p>
                                                                                              </#if>
                                                                                              
                                                                                              
                                                                                              </#if>
                                                                                              

                                                                                              
                                                                                              <p class="pt-2 pb-4">${corpoNewsIniziale.getData()}</p>
                                                                                              
                                                                                              <#assign videoTube = Video.getData() />
                                                                                              <#if videoTube?has_content >
                                                                                              <div class="embed-responsive embed-responsive-16by9">
<iframe class="embed-responsive-item" src="${Video.getData()}"></iframe>
<iframe width="560" height="315" src="${Video.getData()}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                                                                                              </div>
                                                                                              <#if Video.didascaliaVideoYou.getData()?has_content >
                                                                                              <p class="text-14p">${Video.didascaliaVideoYou.getData()}</p>
                                                                                              </#if>
                                                                                              </#if>
                                                                                              <p class="pt-2 pb-4">${corpoNewsIniziale.getData()}</p>
                                                                                              
                                                                                              <div id="myCarousel" class="carousel slide mb-4" data-ride="carousel">
                                                                                                <!-- Indicators -->
                                                                                                <#assign index = 0 />
<#if galleriaImmagini.getSiblings()?has_content>
    <ol class="carousel-indicators">
                <#list galleriaImmagini.getSiblings() as cur_galleriaImmagini>
                               <#if cur_galleriaImmagini.getData()?? && cur_galleriaImmagini.getData() != "">
                                   <#if index == 0>
                                        <li data-target="#myCarousel" data-slide-to="${index}" class="active"></li>
                         <#else>
                            <li data-target="#myCarousel" data-slide-to="${index}" ></li>
                        </#if>
                               </#if>
                               <#assign index = index+1 />
                </#list>
                </ol>
</#if>
                <#assign index = 0 />                                                                      
<#if galleriaImmagini.getSiblings()?has_content>
<div class="carousel-inner">
                <#list galleriaImmagini.getSiblings() as cur_galleriaImmagini>
                               <#if cur_galleriaImmagini.getData()?? && cur_galleriaImmagini.getData() != "">
                               <#if index == 0>
                               <div class="item active">
                                   <img src="${cur_galleriaImmagini.getData()}" alt="${cur_galleriaImmagini.getAttribute("alt")}">
                               </div>
        <#else>
                               <div class="item">
                                   <img src="${cur_galleriaImmagini.getData()}" alt="${cur_galleriaImmagini.getAttribute("alt")}">
                               </div>
                               </#if>
                               </#if>
                               <#assign index = index+1 >
                </#list>
</div>
</#if>

<#if galleriaImmagini.getSiblings()?has_content>
                                                                                                <!-- Left and right controls -->
                                                                                                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                                                                                                              <span class="fa fa-arrow-left text-white" aria-hidden="true"></span>
                                                                                                              <span class="sr-only">Previous</span>
                                                                                                </a>
                                                                                                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                                                                                                              <span class="fa fa-arrow-right text-white" aria-hidden="true"></span>
                                                                                                              <span class="sr-only">Next</span>
                                                                                                </a>
                                                                                              </div>
</#if>
                                                                                              <p class="pt-2 pb-4">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                                                                              
                                                                                              <p class="py-2">
                                                                                                              01/01/2019
                                                                                              </p>
                                                                                              
                                                                                              <div class="social float-right text-link">
                                                                                                              Condividi:
                                                                                                              <a href="#" title="Facebook - Sito esterno" class="d-inline-block"><span class="fab fa-facebook-f"></span>
                                                                                                              <span class="sr-only">Facebook</span></a>
                                                                                                              <a href="#" title="Twitter  -Sito esterno" class="d-inline-block"><span class="fab fa-twitter"></span>
                                                                                                              <span class="sr-only">Twitter</span></a>
                                                                                              </div>
                                                                                              <p class="pt-2 pb-4">
                                                                                              
                                                                                              
                                                                               <#if asset?has_content>
                                                                                              <#list asset.getTags() as tag>
                                                                                              <#-- ${tag.getUrl()} 
                                                                                              <textarea>
                                                                                              ${tag}
                                                                                              </textarea>-->
                                                                                                              <#assign size = asset.getTags()?size />
                                                                                                              <#assign index = tag?index />
<a href="#" class="border border-link rounded-13 px-5 py-0 text-16p mr-2 mb-2 d-inline-block line-height-20p">${tag.name}</a>
                                                                                              </#list>
                                                                               </#if>
                                                                                              

                                                                                              </p>
                                                                               </div>
                                                                               <div class="col-sm-2 col-md-3">
                
<#assign viewLink = false />
<#if linkUtili.getSiblings()?has_content>
                <#list linkUtili.getSiblings() as cur_linkUtili>
                               <#if cur_linkUtili.getData()?has_content>
                                   <#assign viewLink = true />
                                   <#break>
                    </#if>
                </#list>
</#if>
                
                                                                               
<#if linkUtili.getSiblings()?has_content && viewLink>
<div class="bg-light px-3 py-3">Link utili</div>
<ul class="list-unstyled px-4 mb-4 pb-4 text-16p">
                <#list linkUtili.getSiblings() as cur_linkUtili>
                               <li class="pt-3"><a href="${cur_linkUtili.getData()}">${cur_linkUtili.descrizioneLink.getData()}</a></li>
                </#list>
</ul>
</#if>


<#assign viewLink = false />
<#if allegati.getSiblings()?has_content>
                <#list allegati.getSiblings() as cur_allegati>
                    <#if cur_allegati.getData()?has_content>
                        <#assign viewLink = true />
                        <#break>
                    </#if>
                </#list>
</#if>

<#if allegati.getSiblings()?has_content && viewLink>
<div class="bg-light px-3 py-3">Allegati</div>
<ul class="list-unstyled px-4 mb-4 pb-4 text-16p">
                <#list allegati.getSiblings() as cur_allegati>
                               <li class="pt-3">
                               <a href="${cur_allegati.getData()}">
                               <i class="fa fa-file-pdf-o mr-3" aria-hidden="true"></i>
                                               ${cur_allegati.descrizioneAllegato.getData()}
                               </a>
                               </li>
                </#list>
</ul>
</#if>

                                                                               </div>
                                                               </div>
                                               </div>
                                               
                                               <style>
                                               .header-title{
                                                       visibility: hidden;
                                               }
                                               </style>
