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

import java.util.List;
import java.util.Map;

import it.gov.mef.opendata.webformassistenza.service.base.AssitenzaNoipaLocalServiceBaseImpl;
import it.gov.mef.shared.dto.assistenza.Tema;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the AssitenzaNoipa local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaLocalServiceBaseImpl
 * @see it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalServiceUtil
 */
public class AssitenzaNoipaLocalServiceImpl
	extends AssitenzaNoipaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalServiceUtil} to access the AssitenzaNoipa local service.
	 */
	
	
	/** The log. */
	private static Log _log = LogFactoryUtil.getLog(AssitenzaNoipaLocalServiceImpl.class);
	
	
	/* (non-Javadoc)
	 * @see it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalService#getAssitenza(long, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Map<Long, List<Tema>> getAssitenza(long groupId, String locale, String ddmStructureKeyT, String ddmStructureKeyR) {
		_log.info("Recupero wizard....");
		return AssistenzaUtils.getAssitenza(groupId, locale, ddmStructureKeyT, ddmStructureKeyR);
	}
	
	
}