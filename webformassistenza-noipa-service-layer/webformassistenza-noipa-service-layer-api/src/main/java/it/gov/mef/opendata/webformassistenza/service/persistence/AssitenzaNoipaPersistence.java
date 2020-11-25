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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException;
import it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa;

/**
 * The persistence interface for the AssitenzaNoipa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.gov.mef.opendata.webformassistenza.service.persistence.impl.AssitenzaNoipaPersistenceImpl
 * @see AssitenzaNoipaUtil
 * @generated
 */
@ProviderType
public interface AssitenzaNoipaPersistence extends BasePersistence<AssitenzaNoipa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AssitenzaNoipaUtil} to access the AssitenzaNoipa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the AssitenzaNoipas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching AssitenzaNoipas
	*/
	public java.util.List<AssitenzaNoipa> findByUuid(String uuid);

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
	public java.util.List<AssitenzaNoipa> findByUuid(String uuid, int start,
		int end);

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
	public java.util.List<AssitenzaNoipa> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator);

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
	public java.util.List<AssitenzaNoipa> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a matching AssitenzaNoipa could not be found
	*/
	public AssitenzaNoipa findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws NoSuchAssitenzaNoipaException;

	/**
	* Returns the first AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching AssitenzaNoipa, or <code>null</code> if a matching AssitenzaNoipa could not be found
	*/
	public AssitenzaNoipa fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator);

	/**
	* Returns the last AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a matching AssitenzaNoipa could not be found
	*/
	public AssitenzaNoipa findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws NoSuchAssitenzaNoipaException;

	/**
	* Returns the last AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching AssitenzaNoipa, or <code>null</code> if a matching AssitenzaNoipa could not be found
	*/
	public AssitenzaNoipa fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator);

	/**
	* Returns the AssitenzaNoipas before and after the current AssitenzaNoipa in the ordered set where uuid = &#63;.
	*
	* @param assistenzaId the primary key of the current AssitenzaNoipa
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	*/
	public AssitenzaNoipa[] findByUuid_PrevAndNext(long assistenzaId,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws NoSuchAssitenzaNoipaException;

	/**
	* Removes all the AssitenzaNoipas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of AssitenzaNoipas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching AssitenzaNoipas
	*/
	public int countByUuid(String uuid);

	/**
	* Caches the AssitenzaNoipa in the entity cache if it is enabled.
	*
	* @param assitenzaNoipa the AssitenzaNoipa
	*/
	public void cacheResult(AssitenzaNoipa assitenzaNoipa);

	/**
	* Caches the AssitenzaNoipas in the entity cache if it is enabled.
	*
	* @param assitenzaNoipas the AssitenzaNoipas
	*/
	public void cacheResult(java.util.List<AssitenzaNoipa> assitenzaNoipas);

	/**
	* Creates a new AssitenzaNoipa with the primary key. Does not add the AssitenzaNoipa to the database.
	*
	* @param assistenzaId the primary key for the new AssitenzaNoipa
	* @return the new AssitenzaNoipa
	*/
	public AssitenzaNoipa create(long assistenzaId);

	/**
	* Removes the AssitenzaNoipa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa that was removed
	* @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	*/
	public AssitenzaNoipa remove(long assistenzaId)
		throws NoSuchAssitenzaNoipaException;

	public AssitenzaNoipa updateImpl(AssitenzaNoipa assitenzaNoipa);

	/**
	* Returns the AssitenzaNoipa with the primary key or throws a {@link NoSuchAssitenzaNoipaException} if it could not be found.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa
	* @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	*/
	public AssitenzaNoipa findByPrimaryKey(long assistenzaId)
		throws NoSuchAssitenzaNoipaException;

	/**
	* Returns the AssitenzaNoipa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param assistenzaId the primary key of the AssitenzaNoipa
	* @return the AssitenzaNoipa, or <code>null</code> if a AssitenzaNoipa with the primary key could not be found
	*/
	public AssitenzaNoipa fetchByPrimaryKey(long assistenzaId);

	@Override
	public java.util.Map<java.io.Serializable, AssitenzaNoipa> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the AssitenzaNoipas.
	*
	* @return the AssitenzaNoipas
	*/
	public java.util.List<AssitenzaNoipa> findAll();

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
	public java.util.List<AssitenzaNoipa> findAll(int start, int end);

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
	public java.util.List<AssitenzaNoipa> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator);

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
	public java.util.List<AssitenzaNoipa> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AssitenzaNoipa> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the AssitenzaNoipas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of AssitenzaNoipas.
	*
	* @return the number of AssitenzaNoipas
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}