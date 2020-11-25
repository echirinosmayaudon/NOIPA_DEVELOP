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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * Provides the remote service interface for AssitenzaNoipa. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaServiceUtil
 * @see it.gov.mef.opendata.webformassistenza.service.base.AssitenzaNoipaServiceBaseImpl
 * @see it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=noipa", "json.web.service.context.path=AssitenzaNoipa"}, service = AssitenzaNoipaService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AssitenzaNoipaService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssitenzaNoipaServiceUtil} to access the AssitenzaNoipa remote service. Add custom service methods to {@link it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Object getAssitenzaOld(long groupId, String locale,
		String ddmStructureKeyT, String ddmStructureKeyR);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getAssitenzaRemota(long groupId, String locale,
		String ddmStructureKeyT, String ddmStructureKeyR);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getContenutoPrivato(long groupId, String structureId,
		String locale, String areaId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();
}