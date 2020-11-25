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

package it.gov.mef.opendata.webformassistenza.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PortalPreferences;
import com.liferay.portal.kernel.service.PortalPreferencesLocalServiceUtil;

import java.util.List;

import it.gov.mef.opendata.webformassistenza.service.base.EntiAmministrazioneServiceBaseImpl;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the EntiAmministrazione remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazioneServiceBaseImpl
 * @see it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneServiceUtil
 */
public class EntiAmministrazioneServiceImpl
	extends EntiAmministrazioneServiceBaseImpl {
	
	/** The log. */
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneServiceUtil} to access the EntiAmministrazione remote service.
	 */
	private static Log _log = LogFactoryUtil.getLog(EntiAmministrazioneServiceImpl.class);
	
	
	/* (non-Javadoc)
	 * @see it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneService#getPref()
	 */
	public void getPref() {
		List<PortalPreferences> portletPreferences = PortalPreferencesLocalServiceUtil.getPortalPreferenceses(-1, -1);
		for (PortalPreferences portalPreferences : portletPreferences) {
			_log.info(portalPreferences.toString());
			_log.info(portalPreferences.getPreferences());
		}
	}
	
}