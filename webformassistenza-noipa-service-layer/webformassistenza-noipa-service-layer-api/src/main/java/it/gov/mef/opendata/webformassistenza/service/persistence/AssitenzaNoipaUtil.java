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

package it.gov.mef.opendata.webformassistenza.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the AssitenzaNoipa service. This utility wraps {@link it.gov.mef.opendata.webformassistenza.service.persistence.impl.AssitenzaNoipaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaPersistence
 * @see it.gov.mef.opendata.webformassistenza.service.persistence.impl.AssitenzaNoipaPersistenceImpl
 * @generated
 */
@ProviderType
public class AssitenzaNoipaUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AssitenzaNoipa assitenzaNoipa) {
		getPersistence().clearCache(assitenzaNoipa);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AssitenzaNoipa> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AssitenzaNoipa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AssitenzaNoipa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AssitenzaNoipa update(AssitenzaNoipa assitenzaNoipa) {
		return getPersistence().update(assitenzaNoipa);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AssitenzaNoipa update(AssitenzaNoipa assitenzaNoipa,
		ServiceContext serviceContext) {
		return getPersistence().update(assitenzaNoipa, serviceContext);
	}

	/**
	* Returns all the AssitenzaNoipas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the AssitenzaNoipas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of AssitenzaNoipas
	* @param end the upper bound of the range of AssitenzaNoipas (not inclusive)
	* @return the range of matching AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the AssitenzaNoipas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of AssitenzaNoipas
	* @param end the upper bound of the range of AssitenzaNoipas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findByUuid(String uuid, int start,
		int end, OrderByComparator<AssitenzaNoipa> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the AssitenzaNoipas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of AssitenzaNoipas
	* @param end the upper bound of the range of AssitenzaNoipas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findByUuid(String uuid, int start,
		int end, OrderByComparator<AssitenzaNoipa> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a matching AssitenzaNoipa could not be found
	*/
	public static AssitenzaNoipa findByUuid_First(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching AssitenzaNoipa, or <code>null</code> if a matching AssitenzaNoipa could not be found
	*/
	public static AssitenzaNoipa fetchByUuid_First(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a matching AssitenzaNoipa could not be found
	*/
	public static AssitenzaNoipa findByUuid_Last(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching AssitenzaNoipa, or <code>null</code> if a matching AssitenzaNoipa could not be found
	*/
	public static AssitenzaNoipa fetchByUuid_Last(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the AssitenzaNoipas before and after the current AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param assistenzaId the primary key of the current AssitenzaNoipa
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	*/
	public static AssitenzaNoipa[] findByUuid_PrevAndNext(long assistenzaId,
		String uuid, OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException {
		return getPersistence()
				   .findByUuid_PrevAndNext(assistenzaId, uuid, orderByComparator);
	}

	/**
	* Removes all the AssitenzaNoipas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of AssitenzaNoipas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching AssitenzaNoipas
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the AssitenzaNoipa in the entity cache if it is enabled.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	*/
	public static void cacheResult(AssitenzaNoipa assitenzaNoipa) {
		getPersistence().cacheResult(assitenzaNoipa);
	}

	/**
	* Caches the AssitenzaNoipas in the entity cache if it is enabled.
	*
	* @param assitenzaNoipas the AssitenzaNoipas
	*/
	public static void cacheResult(List<AssitenzaNoipa> assitenzaNoipas) {
		getPersistence().cacheResult(assitenzaNoipas);
	}

	/**
	* Creates a new AssitenzaNoipa with the primary key. Does not add the AssitenzaNoipa to the database.
	*
	* @param assistenzaId the primary key for the new AssitenzaNoipa
	* @return the new AssitenzaNoipa
	*/
	public static AssitenzaNoipa create(long assistenzaId) {
		return getPersistence().create(assistenzaId);
	}

	/**
	* Removes the AssitenzaNoipa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa that was removed
	* @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	*/
	public static AssitenzaNoipa remove(long assistenzaId)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException {
		return getPersistence().remove(assistenzaId);
	}

	public static AssitenzaNoipa updateImpl(AssitenzaNoipa assitenzaNoipa) {
		return getPersistence().updateImpl(assitenzaNoipa);
	}

	/**
	* Returns the AssitenzaNoipa with the primary key or throws a {@link NoSuchAssitenzaNoipaException} if it could not be found.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	*/
	public static AssitenzaNoipa findByPrimaryKey(long assistenzaId)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException {
		return getPersistence().findByPrimaryKey(assistenzaId);
	}

	/**
	* Returns the AssitenzaNoipa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa, or <code>null</code> if a AssitenzaNoipa with the primary key could not be found
	*/
	public static AssitenzaNoipa fetchByPrimaryKey(long assistenzaId) {
		return getPersistence().fetchByPrimaryKey(assistenzaId);
	}

	public static java.util.Map<java.io.Serializable, AssitenzaNoipa> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the AssitenzaNoipas.
	*
	* @return the AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the AssitenzaNoipas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of AssitenzaNoipas
	* @param end the upper bound of the range of AssitenzaNoipas (not inclusive)
	* @return the range of AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the AssitenzaNoipas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of AssitenzaNoipas
	* @param end the upper bound of the range of AssitenzaNoipas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findAll(int start, int end,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the AssitenzaNoipas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AssitenzaNoipaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of AssitenzaNoipas
	* @param end the upper bound of the range of AssitenzaNoipas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of AssitenzaNoipas
	*/
	public static List<AssitenzaNoipa> findAll(int start, int end,
		OrderByComparator<AssitenzaNoipa> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the AssitenzaNoipas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of AssitenzaNoipas.
	*
	* @return the number of AssitenzaNoipas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AssitenzaNoipaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AssitenzaNoipaPersistence, AssitenzaNoipaPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AssitenzaNoipaPersistence.class);

		ServiceTracker<AssitenzaNoipaPersistence, AssitenzaNoipaPersistence> serviceTracker =
			new ServiceTracker<AssitenzaNoipaPersistence, AssitenzaNoipaPersistence>(bundle.getBundleContext(),
				AssitenzaNoipaPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}