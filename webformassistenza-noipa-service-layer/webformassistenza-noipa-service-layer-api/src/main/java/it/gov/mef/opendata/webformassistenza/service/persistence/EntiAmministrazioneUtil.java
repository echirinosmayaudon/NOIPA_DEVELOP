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

import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the EntiAmministrazione service. This utility wraps {@link it.gov.mef.opendata.webformassistenza.service.persistence.impl.EntiAmministrazionePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazionePersistence
 * @see it.gov.mef.opendata.webformassistenza.service.persistence.impl.EntiAmministrazionePersistenceImpl
 * @generated
 */
@ProviderType
public class EntiAmministrazioneUtil {
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
	public static void clearCache(EntiAmministrazione entiAmministrazione) {
		getPersistence().clearCache(entiAmministrazione);
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
	public static List<EntiAmministrazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EntiAmministrazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EntiAmministrazione> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EntiAmministrazione> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EntiAmministrazione update(
		EntiAmministrazione entiAmministrazione) {
		return getPersistence().update(entiAmministrazione);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EntiAmministrazione update(
		EntiAmministrazione entiAmministrazione, ServiceContext serviceContext) {
		return getPersistence().update(entiAmministrazione, serviceContext);
	}

	/**
	* Returns all the EntiAmministraziones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the EntiAmministraziones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of EntiAmministraziones
	* @param end the upper bound of the range of EntiAmministraziones (not inclusive)
	* @return the range of matching EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the EntiAmministraziones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of EntiAmministraziones
	* @param end the upper bound of the range of EntiAmministraziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findByUuid(String uuid, int start,
		int end, OrderByComparator<EntiAmministrazione> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the EntiAmministraziones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of EntiAmministraziones
	* @param end the upper bound of the range of EntiAmministraziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findByUuid(String uuid, int start,
		int end, OrderByComparator<EntiAmministrazione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a matching EntiAmministrazione could not be found
	*/
	public static EntiAmministrazione findByUuid_First(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EntiAmministrazione, or <code>null</code> if a matching EntiAmministrazione could not be found
	*/
	public static EntiAmministrazione fetchByUuid_First(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a matching EntiAmministrazione could not be found
	*/
	public static EntiAmministrazione findByUuid_Last(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EntiAmministrazione, or <code>null</code> if a matching EntiAmministrazione could not be found
	*/
	public static EntiAmministrazione fetchByUuid_Last(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the EntiAmministraziones before and after the current EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param entiId the primary key of the current EntiAmministrazione
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	*/
	public static EntiAmministrazione[] findByUuid_PrevAndNext(long entiId,
		String uuid, OrderByComparator<EntiAmministrazione> orderByComparator)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException {
		return getPersistence()
				   .findByUuid_PrevAndNext(entiId, uuid, orderByComparator);
	}

	/**
	* Removes all the EntiAmministraziones where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of EntiAmministraziones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching EntiAmministraziones
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the EntiAmministrazione in the entity cache if it is enabled.
	*
	* @param entiAmministrazione the EntiAmministrazione
	*/
	public static void cacheResult(EntiAmministrazione entiAmministrazione) {
		getPersistence().cacheResult(entiAmministrazione);
	}

	/**
	* Caches the EntiAmministraziones in the entity cache if it is enabled.
	*
	* @param entiAmministraziones the EntiAmministraziones
	*/
	public static void cacheResult(
		List<EntiAmministrazione> entiAmministraziones) {
		getPersistence().cacheResult(entiAmministraziones);
	}

	/**
	* Creates a new EntiAmministrazione with the primary key. Does not add the EntiAmministrazione to the database.
	*
	* @param entiId the primary key for the new EntiAmministrazione
	* @return the new EntiAmministrazione
	*/
	public static EntiAmministrazione create(long entiId) {
		return getPersistence().create(entiId);
	}

	/**
	* Removes the EntiAmministrazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione that was removed
	* @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	*/
	public static EntiAmministrazione remove(long entiId)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException {
		return getPersistence().remove(entiId);
	}

	public static EntiAmministrazione updateImpl(
		EntiAmministrazione entiAmministrazione) {
		return getPersistence().updateImpl(entiAmministrazione);
	}

	/**
	* Returns the EntiAmministrazione with the primary key or throws a {@link NoSuchEntiAmministrazioneException} if it could not be found.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	*/
	public static EntiAmministrazione findByPrimaryKey(long entiId)
		throws it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException {
		return getPersistence().findByPrimaryKey(entiId);
	}

	/**
	* Returns the EntiAmministrazione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione, or <code>null</code> if a EntiAmministrazione with the primary key could not be found
	*/
	public static EntiAmministrazione fetchByPrimaryKey(long entiId) {
		return getPersistence().fetchByPrimaryKey(entiId);
	}

	public static java.util.Map<java.io.Serializable, EntiAmministrazione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the EntiAmministraziones.
	*
	* @return the EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the EntiAmministraziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EntiAmministraziones
	* @param end the upper bound of the range of EntiAmministraziones (not inclusive)
	* @return the range of EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the EntiAmministraziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EntiAmministraziones
	* @param end the upper bound of the range of EntiAmministraziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findAll(int start, int end,
		OrderByComparator<EntiAmministrazione> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the EntiAmministraziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntiAmministrazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EntiAmministraziones
	* @param end the upper bound of the range of EntiAmministraziones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of EntiAmministraziones
	*/
	public static List<EntiAmministrazione> findAll(int start, int end,
		OrderByComparator<EntiAmministrazione> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the EntiAmministraziones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of EntiAmministraziones.
	*
	* @return the number of EntiAmministraziones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EntiAmministrazionePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EntiAmministrazionePersistence, EntiAmministrazionePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EntiAmministrazionePersistence.class);

		ServiceTracker<EntiAmministrazionePersistence, EntiAmministrazionePersistence> serviceTracker =
			new ServiceTracker<EntiAmministrazionePersistence, EntiAmministrazionePersistence>(bundle.getBundleContext(),
				EntiAmministrazionePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}