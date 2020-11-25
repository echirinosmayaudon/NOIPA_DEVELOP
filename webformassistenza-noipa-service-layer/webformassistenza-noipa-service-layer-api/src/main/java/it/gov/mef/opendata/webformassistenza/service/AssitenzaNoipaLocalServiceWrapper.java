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
 * Provides a wrapper for {@link AssitenzaNoipaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaLocalService
 * @generated
 */
@ProviderType
public class AssitenzaNoipaLocalServiceWrapper
	implements AssitenzaNoipaLocalService,
		ServiceWrapper<AssitenzaNoipaLocalService> {
	public AssitenzaNoipaLocalServiceWrapper(
		AssitenzaNoipaLocalService assitenzaNoipaLocalService) {
		_assitenzaNoipaLocalService = assitenzaNoipaLocalService;
	}

	/**
	* Adds the AssitenzaNoipa to the database. Also notifies the appropriate model listeners.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	* @return the AssitenzaNoipa that was added
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa addAssitenzaNoipa(
		it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa assitenzaNoipa) {
		return _assitenzaNoipaLocalService.addAssitenzaNoipa(assitenzaNoipa);
	}

	/**
	* Creates a new AssitenzaNoipa with the primary key. Does not add the AssitenzaNoipa to the database.
	*
	* @param assistenzaId the primary key for the new AssitenzaNoipa
	* @return the new AssitenzaNoipa
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa createAssitenzaNoipa(
		long assistenzaId) {
		return _assitenzaNoipaLocalService.createAssitenzaNoipa(assistenzaId);
	}

	/**
	* Deletes the AssitenzaNoipa from the database. Also notifies the appropriate model listeners.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	* @return the AssitenzaNoipa that was removed
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa deleteAssitenzaNoipa(
		it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa assitenzaNoipa) {
		return _assitenzaNoipaLocalService.deleteAssitenzaNoipa(assitenzaNoipa);
	}

	/**
	* Deletes the AssitenzaNoipa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa that was removed
	* @throws PortalException if a AssitenzaNoipa with the primary key could not be found
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa deleteAssitenzaNoipa(
		long assistenzaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assitenzaNoipaLocalService.deleteAssitenzaNoipa(assistenzaId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assitenzaNoipaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _assitenzaNoipaLocalService.dynamicQuery();
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
		return _assitenzaNoipaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.gov.mef.opendata.webformassistenza.model.impl.AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _assitenzaNoipaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.gov.mef.opendata.webformassistenza.model.impl.AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _assitenzaNoipaLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _assitenzaNoipaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _assitenzaNoipaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa fetchAssitenzaNoipa(
		long assistenzaId) {
		return _assitenzaNoipaLocalService.fetchAssitenzaNoipa(assistenzaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _assitenzaNoipaLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.Map<Long, java.util.List<it.gov.mef.shared.dto.assistenza.Tema>> getAssitenza(
		long groupId, String locale, String ddmStructureKeyT,
		String ddmStructureKeyR) {
		return _assitenzaNoipaLocalService.getAssitenza(groupId, locale,
			ddmStructureKeyT, ddmStructureKeyR);
	}

	/**
	* Returns the AssitenzaNoipa with the primary key.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa
	* @throws PortalException if a AssitenzaNoipa with the primary key could not be found
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa getAssitenzaNoipa(
		long assistenzaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assitenzaNoipaLocalService.getAssitenzaNoipa(assistenzaId);
	}

	/**
	* Returns a range of all the AssitenzaNoipas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.gov.mef.opendata.webformassistenza.model.impl.AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of AssitenzaNoipas
	* @param end the upper bound of the range of AssitenzaNoipas (not inclusive)
	* @return the range of AssitenzaNoipas
	*/
	@Override
	public java.util.List<it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa> getAssitenzaNoipas(
		int start, int end) {
		return _assitenzaNoipaLocalService.getAssitenzaNoipas(start, end);
	}

	/**
	* Returns the number of AssitenzaNoipas.
	*
	* @return the number of AssitenzaNoipas
	*/
	@Override
	public int getAssitenzaNoipasCount() {
		return _assitenzaNoipaLocalService.getAssitenzaNoipasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _assitenzaNoipaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _assitenzaNoipaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _assitenzaNoipaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the AssitenzaNoipa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	* @return the AssitenzaNoipa that was updated
	*/
	@Override
	public it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa updateAssitenzaNoipa(
		it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa assitenzaNoipa) {
		return _assitenzaNoipaLocalService.updateAssitenzaNoipa(assitenzaNoipa);
	}

	@Override
	public AssitenzaNoipaLocalService getWrappedService() {
		return _assitenzaNoipaLocalService;
	}

	@Override
	public void setWrappedService(
		AssitenzaNoipaLocalService assitenzaNoipaLocalService) {
		_assitenzaNoipaLocalService = assitenzaNoipaLocalService;
	}

	private AssitenzaNoipaLocalService _assitenzaNoipaLocalService;
}