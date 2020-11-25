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
 * Provides the remote service utility for EntiAmministrazione. This utility wraps
 * {@link it.gov.mef.opendata.webformassistenza.service.impl.EntiAmministrazioneServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazioneService
 * @see it.gov.mef.opendata.webformassistenza.service.base.EntiAmministrazioneServiceBaseImpl
 * @see it.gov.mef.opendata.webformassistenza.service.impl.EntiAmministrazioneServiceImpl
 * @generated
 */
@ProviderType
public class EntiAmministrazioneServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.gov.mef.opendata.webformassistenza.service.impl.EntiAmministrazioneServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void getPref() {
		getService().getPref();
	}

	public static EntiAmministrazioneService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EntiAmministrazioneService, EntiAmministrazioneService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EntiAmministrazioneService.class);

		ServiceTracker<EntiAmministrazioneService, EntiAmministrazioneService> serviceTracker =
			new ServiceTracker<EntiAmministrazioneService, EntiAmministrazioneService>(bundle.getBundleContext(),
				EntiAmministrazioneService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}