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
 * Provides a wrapper for {@link EntiAmministrazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazioneLocalService
 * @generated
 */
@ProviderType
public class EntiAmministrazioneLocalServiceWrapper
	implements EntiAmministrazioneLocalService,
		ServiceWrapper<EntiAmministrazioneLocalService> {
	public EntiAmministrazioneLocalServiceWrapper(
		EntiAmministrazioneLocalService entiAmministrazioneLocalService) {
		_entiAmministrazioneLocalService = entiAmministrazioneLocalService;
	}

	/**
	* Adds the EntiAmministrazione to the database. Also notifies the appropriate model listeners.
	*
	* @param entiAmministrazione the EntiAmministrazione
	* @return the EntiAmministrazione that was added
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione addEntiAmministrazione(
		it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione entiAmministrazione) {
		return _entiAmministrazioneLocalService.addEntiAmministrazione(entiAmministrazione);
	}

	/**
	* Creates a new EntiAmministrazione with the primary key. Does not add the EntiAmministrazione to the database.
	*
	* @param entiId the primary key for the new EntiAmministrazione
	* @return the new EntiAmministrazione
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione createEntiAmministrazione(
		long entiId) {
		return _entiAmministrazioneLocalService.createEntiAmministrazione(entiId);
	}

	/**
	* Deletes the EntiAmministrazione from the database. Also notifies the appropriate model listeners.
	*
	* @param entiAmministrazione the EntiAmministrazione
	* @return the EntiAmministrazione that was removed
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione deleteEntiAmministrazione(
		it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione entiAmministrazione) {
		return _entiAmministrazioneLocalService.deleteEntiAmministrazione(entiAmministrazione);
	}

	/**
	* Deletes the EntiAmministrazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione that was removed
	* @throws PortalException if a EntiAmministrazione with the primary key could not be found
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione deleteEntiAmministrazione(
		long entiId) throws com.liferay.portal.kernel.exception.PortalException {
		return _entiAmministrazioneLocalService.deleteEntiAmministrazione(entiId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _entiAmministrazioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _entiAmministrazioneLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _entiAmministrazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.gov.mef.opendata.webformassistenza.model.impl.EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _entiAmministrazioneLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.gov.mef.opendata.webformassistenza.model.impl.EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _entiAmministrazioneLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _entiAmministrazioneLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _entiAmministrazioneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione fetchEntiAmministrazione(
		long entiId) {
		return _entiAmministrazioneLocalService.fetchEntiAmministrazione(entiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _entiAmministrazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.Map<String, String> getEnti() {
		return _entiAmministrazioneLocalService.getEnti();
	}

	/**
	* Returns the EntiAmministrazione with the primary key.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione
	* @throws PortalException if a EntiAmministrazione with the primary key could not be found
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione getEntiAmministrazione(
		long entiId) throws com.liferay.portal.kernel.exception.PortalException {
		return _entiAmministrazioneLocalService.getEntiAmministrazione(entiId);
	}

	/**
	* Returns a range of all the EntiAmministraziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.gov.mef.opendata.webformassistenza.model.impl.EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EntiAmministraziones
	* @param end the upper bound of the range of EntiAmministraziones (not inclusive)
	* @return the range of EntiAmministraziones
	*/
	@Override
	public java.util.List<it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione> getEntiAmministraziones(
		int start, int end) {
		return _entiAmministrazioneLocalService.getEntiAmministraziones(start,
			end);
	}

	/**
	* Returns the number of EntiAmministraziones.
	*
	* @return the number of EntiAmministraziones
	*/
	@Override
	public int getEntiAmministrazionesCount() {
		return _entiAmministrazioneLocalService.getEntiAmministrazionesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _entiAmministrazioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _entiAmministrazioneLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _entiAmministrazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the EntiAmministrazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param entiAmministrazione the EntiAmministrazione
	* @return the EntiAmministrazione that was updated
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione updateEntiAmministrazione(
		it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione entiAmministrazione) {
		return _entiAmministrazioneLocalService.updateEntiAmministrazione(entiAmministrazione);
	}

	@Override
	public EntiAmministrazioneLocalService getWrappedService() {
		return _entiAmministrazioneLocalService;
	}

	@Override
	public void setWrappedService(
		EntiAmministrazioneLocalService entiAmministrazioneLocalService) {
		_entiAmministrazioneLocalService = entiAmministrazioneLocalService;
	}

	private EntiAmministrazioneLocalService _entiAmministrazioneLocalService;
}