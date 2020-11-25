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
 * Provides the local service utility for AssitenzaNoipa. This utility wraps
 * {@link it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaLocalService
 * @see it.gov.mef.opendata.webformassistenza.service.base.AssitenzaNoipaLocalServiceBaseImpl
 * @see it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaLocalServiceImpl
 * @generated
 */
@ProviderType
public class AssitenzaNoipaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the AssitenzaNoipa to the database. Also notifies the appropriate model listeners.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	* @return the AssitenzaNoipa that was added
	*/
	public static it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa addAssitenzaNoipa(
		it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa assitenzaNoipa) {
		return getService().addAssitenzaNoipa(assitenzaNoipa);
	}

	/**
	* Creates a new AssitenzaNoipa with the primary key. Does not add the AssitenzaNoipa to the database.
	*
	* @param assistenzaId the primary key for the new AssitenzaNoipa
	* @return the new AssitenzaNoipa
	*/
	public static it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa createAssitenzaNoipa(
		long assistenzaId) {
		return getService().createAssitenzaNoipa(assistenzaId);
	}

	/**
	* Deletes the AssitenzaNoipa from the database. Also notifies the appropriate model listeners.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	* @return the AssitenzaNoipa that was removed
	*/
	public static it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa deleteAssitenzaNoipa(
		it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa assitenzaNoipa) {
		return getService().deleteAssitenzaNoipa(assitenzaNoipa);
	}

	/**
	* Deletes the AssitenzaNoipa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa that was removed
	* @throws PortalException if a AssitenzaNoipa with the primary key could not be found
	*/
	public static it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa deleteAssitenzaNoipa(
		long assistenzaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAssitenzaNoipa(assistenzaId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa fetchAssitenzaNoipa(
		long assistenzaId) {
		return getService().fetchAssitenzaNoipa(assistenzaId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.Map<Long, java.util.List<it.gov.mef.shared.dto.assistenza.Tema>> getAssitenza(
		long groupId, String locale, String ddmStructureKeyT,
		String ddmStructureKeyR) {
		return getService()
				   .getAssitenza(groupId, locale, ddmStructureKeyT,
			ddmStructureKeyR);
	}

	/**
	* Returns the AssitenzaNoipa with the primary key.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa
	* @throws PortalException if a AssitenzaNoipa with the primary key could not be found
	*/
	public static it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa getAssitenzaNoipa(
		long assistenzaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAssitenzaNoipa(assistenzaId);
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
	public static java.util.List<it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa> getAssitenzaNoipas(
		int start, int end) {
		return getService().getAssitenzaNoipas(start, end);
	}

	/**
	* Returns the number of AssitenzaNoipas.
	*
	* @return the number of AssitenzaNoipas
	*/
	public static int getAssitenzaNoipasCount() {
		return getService().getAssitenzaNoipasCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the AssitenzaNoipa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	* @return the AssitenzaNoipa that was updated
	*/
	public static it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa updateAssitenzaNoipa(
		it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa assitenzaNoipa) {
		return getService().updateAssitenzaNoipa(assitenzaNoipa);
	}

	public static AssitenzaNoipaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AssitenzaNoipaLocalService, AssitenzaNoipaLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AssitenzaNoipaLocalService.class);

		ServiceTracker<AssitenzaNoipaLocalService, AssitenzaNoipaLocalService> serviceTracker =
			new ServiceTracker<AssitenzaNoipaLocalService, AssitenzaNoipaLocalService>(bundle.getBundleContext(),
				AssitenzaNoipaLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}