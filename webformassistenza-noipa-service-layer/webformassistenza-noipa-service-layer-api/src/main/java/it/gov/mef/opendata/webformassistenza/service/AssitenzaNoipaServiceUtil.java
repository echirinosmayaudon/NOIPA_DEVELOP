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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AssitenzaNoipa. This utility wraps
 * {@link it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaService
 * @see it.gov.mef.opendata.webformassistenza.service.base.AssitenzaNoipaServiceBaseImpl
 * @see it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaServiceImpl
 * @generated
 */
@ProviderType
public class AssitenzaNoipaServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static Object getAssitenzaOld(long groupId, String locale,
		String ddmStructureKeyT, String ddmStructureKeyR) {
		return getService()
				   .getAssitenzaOld(groupId, locale, ddmStructureKeyT,
			ddmStructureKeyR);
	}

	public static com.liferay.portal.kernel.json.JSONArray getAssitenzaRemota(
		long groupId, String locale, String ddmStructureKeyT,
		String ddmStructureKeyR) {
		return getService()
				   .getAssitenzaRemota(groupId, locale, ddmStructureKeyT,
			ddmStructureKeyR);
	}

	public static com.liferay.portal.kernel.json.JSONArray getContenutoPrivato(
		long groupId, String structureId, String locale, String areaId) {
		return getService()
				   .getContenutoPrivato(groupId, structureId, locale, areaId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AssitenzaNoipaService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AssitenzaNoipaService, AssitenzaNoipaService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AssitenzaNoipaService.class);

		ServiceTracker<AssitenzaNoipaService, AssitenzaNoipaService> serviceTracker =
			new ServiceTracker<AssitenzaNoipaService, AssitenzaNoipaService>(bundle.getBundleContext(),
				AssitenzaNoipaService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}