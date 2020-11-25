<#--
Web content templates are used to lay out the fields defined in a web
content structure.

Please use the left panel to quickly add commonly used variables.
Autocomplete is also available and can be invoked by typing "${".
-->

${titolo.getData()}${abstract.getData()}<#if img.getData()?? && img.getData() != "">
	<img data-fileentryid="${img.getAttribute("fileEntryId")}" alt="${img.getAttribute("alt")}" src="${img.getData()}" />
</#if>