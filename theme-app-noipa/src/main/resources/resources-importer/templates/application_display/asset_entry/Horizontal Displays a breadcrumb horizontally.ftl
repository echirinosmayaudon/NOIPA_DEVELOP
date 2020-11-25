<div class="bg-white">
	<div>
		<#if entries?has_content>
			<ol class="breadcrumb bg-white m-0">
				<#assign cssClass = "" />

				<#list entries as entry>
					<#if entry?is_last>
						<#assign cssClass = "active" />
					</#if>

					<li class="${cssClass}">
						<#if entry?has_next>
							<a

							<#if entry.isBrowsable()>
								href="${entry.getURL()!""}"
							</#if>

							>
						</#if>

						${htmlUtil.escape(entry.getTitle())}

						<#if entry?has_next>
							</a>
						</#if>
					</li>
				</#list>
			</ol>
		</#if>	
	</div>
</div>