<div class="noipa-layout-app-masonry" id="main-content" role="main">
	
	<div>
		<div class="container py-5" >
			<h2 class="sr-only">Masonry grafici</h2>
			<div class="portlet-layout row">
				<div class="portlet-column portlet-column-only col-md-12 grid-masonry"
					id="column-2">
					<div class="grid-sizer"></div>
					$processor.processColumn("column-2",
					"portlet-column-content portlet-column-content-only")
				</div>
			</div>
		</div>
	</div>
	<div class="portlet-layout row">
		<div class="col-md-12 portlet-column portlet-column-only"
			id="column-9">${processor.processColumn("column-9",
			"portlet-column-content portlet-column-content-only")}
		</div>
	</div>
</div>