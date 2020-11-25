<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>


<input type="hidden" id="idUtenteRic" value="${idUtenteRic}" />
<input type="hidden" id="sid" value="${sid}" />

<%@ include file="/webformassistenzacheck/init.jsp"%>


<liferay-ui:error key="noipa.client.error" message="noipa.client.error" />
<liferay-ui:error key="noipa.generic.error"
	message="noipa.generic.error" />
<liferay-ui:error key="noipa.generic.error.check"
	message="noipa.generic.error.check" />

<div class="BGContainer">
	<div class="container" id="contenuto">
		<c:choose>
			<c:when test="${code == '200' || code == '201'}">
				<div class="container ">
					<!-- <div class="alert alert-success"> -->
					<div>
						<liferay-ui:message key="noipa.check.insert.ok" />
						<br /> <a href="/"><liferay-ui:message key="noipa.goto.home" /></a>
					</div>
				</div>
			</c:when>
			<c:when test="${code == '400'}">
				<div class="container ">
					<!-- <div class="alert alert-danger"> -->
					<div>
						<liferay-ui:message key="noipa.client.error.400" />
						<br /> <a href="/"><liferay-ui:message key="noipa.goto.home" /></a>
					</div>
				</div>
			</c:when>
			<c:when test="${code == '500'}">
				<div class="container ">
					<!-- <div class="alert alert-danger"> -->
					<div>
						<liferay-ui:message key="noipa.client.error.500" />
						<br /> <a href="/"><liferay-ui:message key="noipa.goto.home" /></a>
					</div>
				</div>
			</c:when>
			<c:when test="${code == '-20'}">
				<div class="container ">
					<!-- <div class="alert alert-danger"> -->
					<div>
						<liferay-ui:message key="noipa.client.error.param.error"
							arguments="noipa.client.error.param.error" />
						<br /> <a href="/"><liferay-ui:message key="noipa.goto.home" /></a>
					</div>
				</div>
			</c:when>
			<c:when test="${code == '-10'}">
				<div class="container ">
					<!-- <div class="alert alert-danger"> -->
					<div>
						<liferay-ui:message key="noipa.client.error.paramnofound"
							arguments="${args}" />
						<br /> <a href="/"><liferay-ui:message key="noipa.goto.home" /></a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="container ">
					<!-- <div class="alert alert-danger"> -->
					<div>
						<liferay-ui:message key="noipa.generic.error.check" />
						<br /> <a href="/"><liferay-ui:message key="noipa.goto.home" /></a>
					</div>
				</div>
			</c:otherwise>

		</c:choose>
	</div>
</div>