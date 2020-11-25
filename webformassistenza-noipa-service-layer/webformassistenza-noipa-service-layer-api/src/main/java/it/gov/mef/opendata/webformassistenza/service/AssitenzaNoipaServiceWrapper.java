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

package it.gov.mef.opendata.webformassistenza.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssitenzaNoipaService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaService
 * @generated
 */
@ProviderType
public class AssitenzaNoipaServiceWrapper implements AssitenzaNoipaService,
	ServiceWrapper<AssitenzaNoipaService> {
	public AssitenzaNoipaServiceWrapper(
		AssitenzaNoipaService assitenzaNoipaService) {
		_assitenzaNoipaService = assitenzaNoipaService;
	}

	@Override
	public Object getAssitenzaOld(long groupId, String locale,
		String ddmStructureKeyT, String ddmStructureKeyR) {
		return _assitenzaNoipaService.getAssitenzaOld(groupId, locale,
			ddmStructureKeyT, ddmStructureKeyR);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAssitenzaRemota(
		long groupId, String locale, String ddmStructureKeyT,
		String ddmStructureKeyR) {
		return _assitenzaNoipaService.getAssitenzaRemota(groupId, locale,
			ddmStructureKeyT, ddmStructureKeyR);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getContenutoPrivato(
		long groupId, String structureId, String locale, String areaId) {
		return _assitenzaNoipaService.getContenutoPrivato(groupId, structureId,
			locale, areaId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _assitenzaNoipaService.getOSGiServiceIdentifier();
	}

	@Override
	public AssitenzaNoipaService getWrappedService() {
		return _assitenzaNoipaService;
	}

	@Override
	public void setWrappedService(AssitenzaNoipaService assitenzaNoipaService) {
		_assitenzaNoipaService = assitenzaNoipaService;
	}

	private AssitenzaNoipaService _assitenzaNoipaService;
}