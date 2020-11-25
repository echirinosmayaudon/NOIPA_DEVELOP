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

import it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException;
import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione;

/**
 * The persistence interface for the EntiAmministrazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.gov.mef.opendata.webformassistenza.service.persistence.impl.EntiAmministrazionePersistenceImpl
 * @see EntiAmministrazioneUtil
 * @generated
 */
@ProviderType
public interface EntiAmministrazionePersistence extends BasePersistence<EntiAmministrazione> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntiAmministrazioneUtil} to access the EntiAmministrazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the EntiAmministraziones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching EntiAmministraziones
	*/
	public java.util.List<EntiAmministrazione> findByUuid(String uuid);

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
	public java.util.List<EntiAmministrazione> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<EntiAmministrazione> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator);

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
	public java.util.List<EntiAmministrazione> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a matching EntiAmministrazione could not be found
	*/
	public EntiAmministrazione findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator)
		throws NoSuchEntiAmministrazioneException;

	/**
	* Returns the first EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EntiAmministrazione, or <code>null</code> if a matching EntiAmministrazione could not be found
	*/
	public EntiAmministrazione fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator);

	/**
	* Returns the last EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a matching EntiAmministrazione could not be found
	*/
	public EntiAmministrazione findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator)
		throws NoSuchEntiAmministrazioneException;

	/**
	* Returns the last EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EntiAmministrazione, or <code>null</code> if a matching EntiAmministrazione could not be found
	*/
	public EntiAmministrazione fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator);

	/**
	* Returns the EntiAmministraziones before and after the current EntiAmministrazione in the ordered set where uuid = &#63;.
	*
	* @param entiId the primary key of the current EntiAmministrazione
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	*/
	public EntiAmministrazione[] findByUuid_PrevAndNext(long entiId,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator)
		throws NoSuchEntiAmministrazioneException;

	/**
	* Removes all the EntiAmministraziones where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of EntiAmministraziones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching EntiAmministraziones
	*/
	public int countByUuid(String uuid);

	/**
	* Caches the EntiAmministrazione in the entity cache if it is enabled.
	*
	* @param entiAmministrazione the EntiAmministrazione
	*/
	public void cacheResult(EntiAmministrazione entiAmministrazione);

	/**
	* Caches the EntiAmministraziones in the entity cache if it is enabled.
	*
	* @param entiAmministraziones the EntiAmministraziones
	*/
	public void cacheResult(
		java.util.List<EntiAmministrazione> entiAmministraziones);

	/**
	* Creates a new EntiAmministrazione with the primary key. Does not add the EntiAmministrazione to the database.
	*
	* @param entiId the primary key for the new EntiAmministrazione
	* @return the new EntiAmministrazione
	*/
	public EntiAmministrazione create(long entiId);

	/**
	* Removes the EntiAmministrazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione that was removed
	* @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	*/
	public EntiAmministrazione remove(long entiId)
		throws NoSuchEntiAmministrazioneException;

	public EntiAmministrazione updateImpl(
		EntiAmministrazione entiAmministrazione);

	/**
	* Returns the EntiAmministrazione with the primary key or throws a {@link NoSuchEntiAmministrazioneException} if it could not be found.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione
	* @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	*/
	public EntiAmministrazione findByPrimaryKey(long entiId)
		throws NoSuchEntiAmministrazioneException;

	/**
	* Returns the EntiAmministrazione with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entiId the primary key of the EntiAmministrazione
	* @return the EntiAmministrazione, or <code>null</code> if a EntiAmministrazione with the primary key could not be found
	*/
	public EntiAmministrazione fetchByPrimaryKey(long entiId);

	@Override
	public java.util.Map<java.io.Serializable, EntiAmministrazione> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the EntiAmministraziones.
	*
	* @return the EntiAmministraziones
	*/
	public java.util.List<EntiAmministrazione> findAll();

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
	public java.util.List<EntiAmministrazione> findAll(int start, int end);

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
	public java.util.List<EntiAmministrazione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator);

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
	public java.util.List<EntiAmministrazione> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntiAmministrazione> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the EntiAmministraziones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of EntiAmministraziones.
	*
	* @return the number of EntiAmministraziones
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}