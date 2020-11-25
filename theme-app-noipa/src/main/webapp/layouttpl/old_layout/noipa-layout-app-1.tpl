<div class="noipa-layout-app-1" id="main-content" role="main">
	<div class="portlet-layout row">
		<div class="col-md-1 portlet-column portlet-column-only" id="column-1">
			${processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")}
		</div>
		<div class="col-md-10 portlet-column portlet-column-only" id="column-2">
				<div class="portlet-layout row">
					<div class="col-md-12 portlet-column portlet-column-only" id="column-3">
						${processor.processColumn("column-3", "portlet-column-content portlet-column-content-only")}
					</div>
				</div>
				<div class="portlet-layout row">
					<div class="col-md-6 portlet-column portlet-column-only" id="column-4">
						${processor.processColumn("column-4", "portlet-column-content portlet-column-content-only")}
					</div>
					<div class="col-md-6 portlet-column portlet-column-only" id="column-5">
						${processor.processColumn("column-5", "portlet-column-content portlet-column-content-only")}
					</div>
				</div>
		</div>
		<div class="col-md-1 portlet-column portlet-column-only" id="column-6">
			${processor.processColumn("column-6", "portlet-column-content portlet-column-content-only")}
		</div>
	</div>

</div>

