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

package it.gov.mef.opendata.webformassistenza.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException;
import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione;
import it.gov.mef.opendata.webformassistenza.model.impl.EntiAmministrazioneImpl;
import it.gov.mef.opendata.webformassistenza.model.impl.EntiAmministrazioneModelImpl;
import it.gov.mef.opendata.webformassistenza.service.persistence.EntiAmministrazionePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the EntiAmministrazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazionePersistence
 * @see it.gov.mef.opendata.webformassistenza.service.persistence.EntiAmministrazioneUtil
 * @generated
 */
@ProviderType
public class EntiAmministrazionePersistenceImpl extends BasePersistenceImpl<EntiAmministrazione>
	implements EntiAmministrazionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EntiAmministrazioneUtil} to access the EntiAmministrazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EntiAmministrazioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneModelImpl.FINDER_CACHE_ENABLED,
			EntiAmministrazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneModelImpl.FINDER_CACHE_ENABLED,
			EntiAmministrazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneModelImpl.FINDER_CACHE_ENABLED,
			EntiAmministrazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneModelImpl.FINDER_CACHE_ENABLED,
			EntiAmministrazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EntiAmministrazioneModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the EntiAmministraziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching EntiAmministraziones
	 */
	@Override
	public List<EntiAmministrazione> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntiAmministrazione> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<EntiAmministrazione> findByUuid(String uuid, int start,
		int end, OrderByComparator<EntiAmministrazione> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<EntiAmministrazione> findByUuid(String uuid, int start,
		int end, OrderByComparator<EntiAmministrazione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<EntiAmministrazione> list = null;

		if (retrieveFromCache) {
			list = (List<EntiAmministrazione>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EntiAmministrazione entiAmministrazione : list) {
					if (!Objects.equals(uuid, entiAmministrazione.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ENTIAMMINISTRAZIONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EntiAmministrazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<EntiAmministrazione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EntiAmministrazione>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first EntiAmministrazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EntiAmministrazione
	 * @throws NoSuchEntiAmministrazioneException if a matching EntiAmministrazione could not be found
	 */
	@Override
	public EntiAmministrazione findByUuid_First(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator)
		throws NoSuchEntiAmministrazioneException {
		EntiAmministrazione entiAmministrazione = fetchByUuid_First(uuid,
				orderByComparator);

		if (entiAmministrazione != null) {
			return entiAmministrazione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEntiAmministrazioneException(msg.toString());
	}

	/**
	 * Returns the first EntiAmministrazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EntiAmministrazione, or <code>null</code> if a matching EntiAmministrazione could not be found
	 */
	@Override
	public EntiAmministrazione fetchByUuid_First(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator) {
		List<EntiAmministrazione> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EntiAmministrazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EntiAmministrazione
	 * @throws NoSuchEntiAmministrazioneException if a matching EntiAmministrazione could not be found
	 */
	@Override
	public EntiAmministrazione findByUuid_Last(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator)
		throws NoSuchEntiAmministrazioneException {
		EntiAmministrazione entiAmministrazione = fetchByUuid_Last(uuid,
				orderByComparator);

		if (entiAmministrazione != null) {
			return entiAmministrazione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEntiAmministrazioneException(msg.toString());
	}

	/**
	 * Returns the last EntiAmministrazione in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EntiAmministrazione, or <code>null</code> if a matching EntiAmministrazione could not be found
	 */
	@Override
	public EntiAmministrazione fetchByUuid_Last(String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EntiAmministrazione> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EntiAmministrazione[] findByUuid_PrevAndNext(long entiId,
		String uuid, OrderByComparator<EntiAmministrazione> orderByComparator)
		throws NoSuchEntiAmministrazioneException {
		EntiAmministrazione entiAmministrazione = findByPrimaryKey(entiId);

		Session session = null;

		try {
			session = openSession();

			EntiAmministrazione[] array = new EntiAmministrazioneImpl[3];

			array[0] = getByUuid_PrevAndNext(session, entiAmministrazione,
					uuid, orderByComparator, true);

			array[1] = entiAmministrazione;

			array[2] = getByUuid_PrevAndNext(session, entiAmministrazione,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EntiAmministrazione getByUuid_PrevAndNext(Session session,
		EntiAmministrazione entiAmministrazione, String uuid,
		OrderByComparator<EntiAmministrazione> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTIAMMINISTRAZIONE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EntiAmministrazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(entiAmministrazione);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EntiAmministrazione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the EntiAmministraziones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EntiAmministrazione entiAmministrazione : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(entiAmministrazione);
		}
	}

	/**
	 * Returns the number of EntiAmministraziones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching EntiAmministraziones
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTIAMMINISTRAZIONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "entiAmministrazione.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "entiAmministrazione.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(entiAmministrazione.uuid IS NULL OR entiAmministrazione.uuid = '')";

	public EntiAmministrazionePersistenceImpl() {
		setModelClass(EntiAmministrazione.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the EntiAmministrazione in the entity cache if it is enabled.
	 *
	 * @param entiAmministrazione the EntiAmministrazione
	 */
	@Override
	public void cacheResult(EntiAmministrazione entiAmministrazione) {
		entityCache.putResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneImpl.class, entiAmministrazione.getPrimaryKey(),
			entiAmministrazione);

		entiAmministrazione.resetOriginalValues();
	}

	/**
	 * Caches the EntiAmministraziones in the entity cache if it is enabled.
	 *
	 * @param entiAmministraziones the EntiAmministraziones
	 */
	@Override
	public void cacheResult(List<EntiAmministrazione> entiAmministraziones) {
		for (EntiAmministrazione entiAmministrazione : entiAmministraziones) {
			if (entityCache.getResult(
						EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
						EntiAmministrazioneImpl.class,
						entiAmministrazione.getPrimaryKey()) == null) {
				cacheResult(entiAmministrazione);
			}
			else {
				entiAmministrazione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all EntiAmministraziones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EntiAmministrazioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the EntiAmministrazione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EntiAmministrazione entiAmministrazione) {
		entityCache.removeResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneImpl.class, entiAmministrazione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EntiAmministrazione> entiAmministraziones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EntiAmministrazione entiAmministrazione : entiAmministraziones) {
			entityCache.removeResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
				EntiAmministrazioneImpl.class,
				entiAmministrazione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new EntiAmministrazione with the primary key. Does not add the EntiAmministrazione to the database.
	 *
	 * @param entiId the primary key for the new EntiAmministrazione
	 * @return the new EntiAmministrazione
	 */
	@Override
	public EntiAmministrazione create(long entiId) {
		EntiAmministrazione entiAmministrazione = new EntiAmministrazioneImpl();

		entiAmministrazione.setNew(true);
		entiAmministrazione.setPrimaryKey(entiId);

		String uuid = PortalUUIDUtil.generate();

		entiAmministrazione.setUuid(uuid);

		return entiAmministrazione;
	}

	/**
	 * Removes the EntiAmministrazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entiId the primary key of the EntiAmministrazione
	 * @return the EntiAmministrazione that was removed
	 * @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	 */
	@Override
	public EntiAmministrazione remove(long entiId)
		throws NoSuchEntiAmministrazioneException {
		return remove((Serializable)entiId);
	}

	/**
	 * Removes the EntiAmministrazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EntiAmministrazione
	 * @return the EntiAmministrazione that was removed
	 * @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	 */
	@Override
	public EntiAmministrazione remove(Serializable primaryKey)
		throws NoSuchEntiAmministrazioneException {
		Session session = null;

		try {
			session = openSession();

			EntiAmministrazione entiAmministrazione = (EntiAmministrazione)session.get(EntiAmministrazioneImpl.class,
					primaryKey);

			if (entiAmministrazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntiAmministrazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(entiAmministrazione);
		}
		catch (NoSuchEntiAmministrazioneException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EntiAmministrazione removeImpl(
		EntiAmministrazione entiAmministrazione) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(entiAmministrazione)) {
				entiAmministrazione = (EntiAmministrazione)session.get(EntiAmministrazioneImpl.class,
						entiAmministrazione.getPrimaryKeyObj());
			}

			if (entiAmministrazione != null) {
				session.delete(entiAmministrazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (entiAmministrazione != null) {
			clearCache(entiAmministrazione);
		}

		return entiAmministrazione;
	}

	@Override
	public EntiAmministrazione updateImpl(
		EntiAmministrazione entiAmministrazione) {
		boolean isNew = entiAmministrazione.isNew();

		if (!(entiAmministrazione instanceof EntiAmministrazioneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(entiAmministrazione.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(entiAmministrazione);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in entiAmministrazione proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EntiAmministrazione implementation " +
				entiAmministrazione.getClass());
		}

		EntiAmministrazioneModelImpl entiAmministrazioneModelImpl = (EntiAmministrazioneModelImpl)entiAmministrazione;

		if (Validator.isNull(entiAmministrazione.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			entiAmministrazione.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (entiAmministrazione.isNew()) {
				session.save(entiAmministrazione);

				entiAmministrazione.setNew(false);
			}
			else {
				entiAmministrazione = (EntiAmministrazione)session.merge(entiAmministrazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EntiAmministrazioneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { entiAmministrazioneModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((entiAmministrazioneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						entiAmministrazioneModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { entiAmministrazioneModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
			EntiAmministrazioneImpl.class, entiAmministrazione.getPrimaryKey(),
			entiAmministrazione, false);

		entiAmministrazione.resetOriginalValues();

		return entiAmministrazione;
	}

	/**
	 * Returns the EntiAmministrazione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EntiAmministrazione
	 * @return the EntiAmministrazione
	 * @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	 */
	@Override
	public EntiAmministrazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntiAmministrazioneException {
		EntiAmministrazione entiAmministrazione = fetchByPrimaryKey(primaryKey);

		if (entiAmministrazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntiAmministrazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return entiAmministrazione;
	}

	/**
	 * Returns the EntiAmministrazione with the primary key or throws a {@link NoSuchEntiAmministrazioneException} if it could not be found.
	 *
	 * @param entiId the primary key of the EntiAmministrazione
	 * @return the EntiAmministrazione
	 * @throws NoSuchEntiAmministrazioneException if a EntiAmministrazione with the primary key could not be found
	 */
	@Override
	public EntiAmministrazione findByPrimaryKey(long entiId)
		throws NoSuchEntiAmministrazioneException {
		return findByPrimaryKey((Serializable)entiId);
	}

	/**
	 * Returns the EntiAmministrazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EntiAmministrazione
	 * @return the EntiAmministrazione, or <code>null</code> if a EntiAmministrazione with the primary key could not be found
	 */
	@Override
	public EntiAmministrazione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
				EntiAmministrazioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EntiAmministrazione entiAmministrazione = (EntiAmministrazione)serializable;

		if (entiAmministrazione == null) {
			Session session = null;

			try {
				session = openSession();

				entiAmministrazione = (EntiAmministrazione)session.get(EntiAmministrazioneImpl.class,
						primaryKey);

				if (entiAmministrazione != null) {
					cacheResult(entiAmministrazione);
				}
				else {
					entityCache.putResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
						EntiAmministrazioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
					EntiAmministrazioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return entiAmministrazione;
	}

	/**
	 * Returns the EntiAmministrazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entiId the primary key of the EntiAmministrazione
	 * @return the EntiAmministrazione, or <code>null</code> if a EntiAmministrazione with the primary key could not be found
	 */
	@Override
	public EntiAmministrazione fetchByPrimaryKey(long entiId) {
		return fetchByPrimaryKey((Serializable)entiId);
	}

	@Override
	public Map<Serializable, EntiAmministrazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EntiAmministrazione> map = new HashMap<Serializable, EntiAmministrazione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EntiAmministrazione entiAmministrazione = fetchByPrimaryKey(primaryKey);

			if (entiAmministrazione != null) {
				map.put(primaryKey, entiAmministrazione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
					EntiAmministrazioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EntiAmministrazione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ENTIAMMINISTRAZIONE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (EntiAmministrazione entiAmministrazione : (List<EntiAmministrazione>)q.list()) {
				map.put(entiAmministrazione.getPrimaryKeyObj(),
					entiAmministrazione);

				cacheResult(entiAmministrazione);

				uncachedPrimaryKeys.remove(entiAmministrazione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EntiAmministrazioneModelImpl.ENTITY_CACHE_ENABLED,
					EntiAmministrazioneImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the EntiAmministraziones.
	 *
	 * @return the EntiAmministraziones
	 */
	@Override
	public List<EntiAmministrazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EntiAmministrazione> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EntiAmministrazione> findAll(int start, int end,
		OrderByComparator<EntiAmministrazione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EntiAmministrazione> findAll(int start, int end,
		OrderByComparator<EntiAmministrazione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EntiAmministrazione> list = null;

		if (retrieveFromCache) {
			list = (List<EntiAmministrazione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ENTIAMMINISTRAZIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENTIAMMINISTRAZIONE;

				if (pagination) {
					sql = sql.concat(EntiAmministrazioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EntiAmministrazione>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EntiAmministrazione>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the EntiAmministraziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EntiAmministrazione entiAmministrazione : findAll()) {
			remove(entiAmministrazione);
		}
	}

	/**
	 * Returns the number of EntiAmministraziones.
	 *
	 * @return the number of EntiAmministraziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENTIAMMINISTRAZIONE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EntiAmministrazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the EntiAmministrazione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EntiAmministrazioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ENTIAMMINISTRAZIONE = "SELECT entiAmministrazione FROM EntiAmministrazione entiAmministrazione";
	private static final String _SQL_SELECT_ENTIAMMINISTRAZIONE_WHERE_PKS_IN = "SELECT entiAmministrazione FROM EntiAmministrazione entiAmministrazione WHERE entiId IN (";
	private static final String _SQL_SELECT_ENTIAMMINISTRAZIONE_WHERE = "SELECT entiAmministrazione FROM EntiAmministrazione entiAmministrazione WHERE ";
	private static final String _SQL_COUNT_ENTIAMMINISTRAZIONE = "SELECT COUNT(entiAmministrazione) FROM EntiAmministrazione entiAmministrazione";
	private static final String _SQL_COUNT_ENTIAMMINISTRAZIONE_WHERE = "SELECT COUNT(entiAmministrazione) FROM EntiAmministrazione entiAmministrazione WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "entiAmministrazione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EntiAmministrazione exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EntiAmministrazione exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EntiAmministrazionePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}