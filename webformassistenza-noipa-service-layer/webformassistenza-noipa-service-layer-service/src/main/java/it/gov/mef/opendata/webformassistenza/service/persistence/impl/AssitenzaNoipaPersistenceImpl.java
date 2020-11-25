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

import it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException;
import it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa;
import it.gov.mef.opendata.webformassistenza.model.impl.AssitenzaNoipaImpl;
import it.gov.mef.opendata.webformassistenza.model.impl.AssitenzaNoipaModelImpl;
import it.gov.mef.opendata.webformassistenza.service.persistence.AssitenzaNoipaPersistence;

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
 * The persistence implementation for the AssitenzaNoipa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaPersistence
 * @see it.gov.mef.opendata.webformassistenza.service.persistence.AssitenzaNoipaUtil
 * @generated
 */
@ProviderType
public class AssitenzaNoipaPersistenceImpl extends BasePersistenceImpl<AssitenzaNoipa>
	implements AssitenzaNoipaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AssitenzaNoipaUtil} to access the AssitenzaNoipa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AssitenzaNoipaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaModelImpl.FINDER_CACHE_ENABLED,
			AssitenzaNoipaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaModelImpl.FINDER_CACHE_ENABLED,
			AssitenzaNoipaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaModelImpl.FINDER_CACHE_ENABLED,
			AssitenzaNoipaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaModelImpl.FINDER_CACHE_ENABLED,
			AssitenzaNoipaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AssitenzaNoipaModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the AssitenzaNoipas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching AssitenzaNoipas
	 */
	@Override
	public List<AssitenzaNoipa> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AssitenzaNoipa> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AssitenzaNoipa> findByUuid(String uuid, int start, int end,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AssitenzaNoipa> findByUuid(String uuid, int start, int end,
		OrderByComparator<AssitenzaNoipa> orderByComparator,
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

		List<AssitenzaNoipa> list = null;

		if (retrieveFromCache) {
			list = (List<AssitenzaNoipa>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AssitenzaNoipa assitenzaNoipa : list) {
					if (!Objects.equals(uuid, assitenzaNoipa.getUuid())) {
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

			query.append(_SQL_SELECT_ASSITENZANOIPA_WHERE);

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
				query.append(AssitenzaNoipaModelImpl.ORDER_BY_JPQL);
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
					list = (List<AssitenzaNoipa>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AssitenzaNoipa>)QueryUtil.list(q,
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
	 * Returns the first AssitenzaNoipa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching AssitenzaNoipa
	 * @throws NoSuchAssitenzaNoipaException if a matching AssitenzaNoipa could not be found
	 */
	@Override
	public AssitenzaNoipa findByUuid_First(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws NoSuchAssitenzaNoipaException {
		AssitenzaNoipa assitenzaNoipa = fetchByUuid_First(uuid,
				orderByComparator);

		if (assitenzaNoipa != null) {
			return assitenzaNoipa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAssitenzaNoipaException(msg.toString());
	}

	/**
	 * Returns the first AssitenzaNoipa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching AssitenzaNoipa, or <code>null</code> if a matching AssitenzaNoipa could not be found
	 */
	@Override
	public AssitenzaNoipa fetchByUuid_First(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		List<AssitenzaNoipa> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last AssitenzaNoipa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching AssitenzaNoipa
	 * @throws NoSuchAssitenzaNoipaException if a matching AssitenzaNoipa could not be found
	 */
	@Override
	public AssitenzaNoipa findByUuid_Last(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws NoSuchAssitenzaNoipaException {
		AssitenzaNoipa assitenzaNoipa = fetchByUuid_Last(uuid, orderByComparator);

		if (assitenzaNoipa != null) {
			return assitenzaNoipa;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchAssitenzaNoipaException(msg.toString());
	}

	/**
	 * Returns the last AssitenzaNoipa in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching AssitenzaNoipa, or <code>null</code> if a matching AssitenzaNoipa could not be found
	 */
	@Override
	public AssitenzaNoipa fetchByUuid_Last(String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AssitenzaNoipa> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AssitenzaNoipa[] findByUuid_PrevAndNext(long assistenzaId,
		String uuid, OrderByComparator<AssitenzaNoipa> orderByComparator)
		throws NoSuchAssitenzaNoipaException {
		AssitenzaNoipa assitenzaNoipa = findByPrimaryKey(assistenzaId);

		Session session = null;

		try {
			session = openSession();

			AssitenzaNoipa[] array = new AssitenzaNoipaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, assitenzaNoipa, uuid,
					orderByComparator, true);

			array[1] = assitenzaNoipa;

			array[2] = getByUuid_PrevAndNext(session, assitenzaNoipa, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AssitenzaNoipa getByUuid_PrevAndNext(Session session,
		AssitenzaNoipa assitenzaNoipa, String uuid,
		OrderByComparator<AssitenzaNoipa> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSITENZANOIPA_WHERE);

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
			query.append(AssitenzaNoipaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(assitenzaNoipa);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AssitenzaNoipa> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the AssitenzaNoipas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AssitenzaNoipa assitenzaNoipa : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(assitenzaNoipa);
		}
	}

	/**
	 * Returns the number of AssitenzaNoipas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching AssitenzaNoipas
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ASSITENZANOIPA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "assitenzaNoipa.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "assitenzaNoipa.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(assitenzaNoipa.uuid IS NULL OR assitenzaNoipa.uuid = '')";

	public AssitenzaNoipaPersistenceImpl() {
		setModelClass(AssitenzaNoipa.class);

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
	 * Caches the AssitenzaNoipa in the entity cache if it is enabled.
	 *
	 * @param assitenzaNoipa the AssitenzaNoipa
	 */
	@Override
	public void cacheResult(AssitenzaNoipa assitenzaNoipa) {
		entityCache.putResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaImpl.class, assitenzaNoipa.getPrimaryKey(),
			assitenzaNoipa);

		assitenzaNoipa.resetOriginalValues();
	}

	/**
	 * Caches the AssitenzaNoipas in the entity cache if it is enabled.
	 *
	 * @param assitenzaNoipas the AssitenzaNoipas
	 */
	@Override
	public void cacheResult(List<AssitenzaNoipa> assitenzaNoipas) {
		for (AssitenzaNoipa assitenzaNoipa : assitenzaNoipas) {
			if (entityCache.getResult(
						AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
						AssitenzaNoipaImpl.class, assitenzaNoipa.getPrimaryKey()) == null) {
				cacheResult(assitenzaNoipa);
			}
			else {
				assitenzaNoipa.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all AssitenzaNoipas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AssitenzaNoipaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the AssitenzaNoipa.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AssitenzaNoipa assitenzaNoipa) {
		entityCache.removeResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaImpl.class, assitenzaNoipa.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AssitenzaNoipa> assitenzaNoipas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AssitenzaNoipa assitenzaNoipa : assitenzaNoipas) {
			entityCache.removeResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
				AssitenzaNoipaImpl.class, assitenzaNoipa.getPrimaryKey());
		}
	}

	/**
	 * Creates a new AssitenzaNoipa with the primary key. Does not add the AssitenzaNoipa to the database.
	 *
	 * @param assistenzaId the primary key for the new AssitenzaNoipa
	 * @return the new AssitenzaNoipa
	 */
	@Override
	public AssitenzaNoipa create(long assistenzaId) {
		AssitenzaNoipa assitenzaNoipa = new AssitenzaNoipaImpl();

		assitenzaNoipa.setNew(true);
		assitenzaNoipa.setPrimaryKey(assistenzaId);

		String uuid = PortalUUIDUtil.generate();

		assitenzaNoipa.setUuid(uuid);

		return assitenzaNoipa;
	}

	/**
	 * Removes the AssitenzaNoipa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assistenzaId the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa that was removed
	 * @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	 */
	@Override
	public AssitenzaNoipa remove(long assistenzaId)
		throws NoSuchAssitenzaNoipaException {
		return remove((Serializable)assistenzaId);
	}

	/**
	 * Removes the AssitenzaNoipa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa that was removed
	 * @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	 */
	@Override
	public AssitenzaNoipa remove(Serializable primaryKey)
		throws NoSuchAssitenzaNoipaException {
		Session session = null;

		try {
			session = openSession();

			AssitenzaNoipa assitenzaNoipa = (AssitenzaNoipa)session.get(AssitenzaNoipaImpl.class,
					primaryKey);

			if (assitenzaNoipa == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAssitenzaNoipaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(assitenzaNoipa);
		}
		catch (NoSuchAssitenzaNoipaException nsee) {
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
	protected AssitenzaNoipa removeImpl(AssitenzaNoipa assitenzaNoipa) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(assitenzaNoipa)) {
				assitenzaNoipa = (AssitenzaNoipa)session.get(AssitenzaNoipaImpl.class,
						assitenzaNoipa.getPrimaryKeyObj());
			}

			if (assitenzaNoipa != null) {
				session.delete(assitenzaNoipa);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (assitenzaNoipa != null) {
			clearCache(assitenzaNoipa);
		}

		return assitenzaNoipa;
	}

	@Override
	public AssitenzaNoipa updateImpl(AssitenzaNoipa assitenzaNoipa) {
		boolean isNew = assitenzaNoipa.isNew();

		if (!(assitenzaNoipa instanceof AssitenzaNoipaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(assitenzaNoipa.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(assitenzaNoipa);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in assitenzaNoipa proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AssitenzaNoipa implementation " +
				assitenzaNoipa.getClass());
		}

		AssitenzaNoipaModelImpl assitenzaNoipaModelImpl = (AssitenzaNoipaModelImpl)assitenzaNoipa;

		if (Validator.isNull(assitenzaNoipa.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			assitenzaNoipa.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (assitenzaNoipa.isNew()) {
				session.save(assitenzaNoipa);

				assitenzaNoipa.setNew(false);
			}
			else {
				assitenzaNoipa = (AssitenzaNoipa)session.merge(assitenzaNoipa);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AssitenzaNoipaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { assitenzaNoipaModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((assitenzaNoipaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						assitenzaNoipaModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { assitenzaNoipaModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
			AssitenzaNoipaImpl.class, assitenzaNoipa.getPrimaryKey(),
			assitenzaNoipa, false);

		assitenzaNoipa.resetOriginalValues();

		return assitenzaNoipa;
	}

	/**
	 * Returns the AssitenzaNoipa with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa
	 * @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	 */
	@Override
	public AssitenzaNoipa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAssitenzaNoipaException {
		AssitenzaNoipa assitenzaNoipa = fetchByPrimaryKey(primaryKey);

		if (assitenzaNoipa == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAssitenzaNoipaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return assitenzaNoipa;
	}

	/**
	 * Returns the AssitenzaNoipa with the primary key or throws a {@link NoSuchAssitenzaNoipaException} if it could not be found.
	 *
	 * @param assistenzaId the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa
	 * @throws NoSuchAssitenzaNoipaException if a AssitenzaNoipa with the primary key could not be found
	 */
	@Override
	public AssitenzaNoipa findByPrimaryKey(long assistenzaId)
		throws NoSuchAssitenzaNoipaException {
		return findByPrimaryKey((Serializable)assistenzaId);
	}

	/**
	 * Returns the AssitenzaNoipa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa, or <code>null</code> if a AssitenzaNoipa with the primary key could not be found
	 */
	@Override
	public AssitenzaNoipa fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
				AssitenzaNoipaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AssitenzaNoipa assitenzaNoipa = (AssitenzaNoipa)serializable;

		if (assitenzaNoipa == null) {
			Session session = null;

			try {
				session = openSession();

				assitenzaNoipa = (AssitenzaNoipa)session.get(AssitenzaNoipaImpl.class,
						primaryKey);

				if (assitenzaNoipa != null) {
					cacheResult(assitenzaNoipa);
				}
				else {
					entityCache.putResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
						AssitenzaNoipaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
					AssitenzaNoipaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return assitenzaNoipa;
	}

	/**
	 * Returns the AssitenzaNoipa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param assistenzaId the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa, or <code>null</code> if a AssitenzaNoipa with the primary key could not be found
	 */
	@Override
	public AssitenzaNoipa fetchByPrimaryKey(long assistenzaId) {
		return fetchByPrimaryKey((Serializable)assistenzaId);
	}

	@Override
	public Map<Serializable, AssitenzaNoipa> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AssitenzaNoipa> map = new HashMap<Serializable, AssitenzaNoipa>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AssitenzaNoipa assitenzaNoipa = fetchByPrimaryKey(primaryKey);

			if (assitenzaNoipa != null) {
				map.put(primaryKey, assitenzaNoipa);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
					AssitenzaNoipaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AssitenzaNoipa)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ASSITENZANOIPA_WHERE_PKS_IN);

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

			for (AssitenzaNoipa assitenzaNoipa : (List<AssitenzaNoipa>)q.list()) {
				map.put(assitenzaNoipa.getPrimaryKeyObj(), assitenzaNoipa);

				cacheResult(assitenzaNoipa);

				uncachedPrimaryKeys.remove(assitenzaNoipa.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AssitenzaNoipaModelImpl.ENTITY_CACHE_ENABLED,
					AssitenzaNoipaImpl.class, primaryKey, nullModel);
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
	 * Returns all the AssitenzaNoipas.
	 *
	 * @return the AssitenzaNoipas
	 */
	@Override
	public List<AssitenzaNoipa> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AssitenzaNoipa> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AssitenzaNoipa> findAll(int start, int end,
		OrderByComparator<AssitenzaNoipa> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AssitenzaNoipa> findAll(int start, int end,
		OrderByComparator<AssitenzaNoipa> orderByComparator,
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

		List<AssitenzaNoipa> list = null;

		if (retrieveFromCache) {
			list = (List<AssitenzaNoipa>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ASSITENZANOIPA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSITENZANOIPA;

				if (pagination) {
					sql = sql.concat(AssitenzaNoipaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AssitenzaNoipa>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AssitenzaNoipa>)QueryUtil.list(q,
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
	 * Removes all the AssitenzaNoipas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AssitenzaNoipa assitenzaNoipa : findAll()) {
			remove(assitenzaNoipa);
		}
	}

	/**
	 * Returns the number of AssitenzaNoipas.
	 *
	 * @return the number of AssitenzaNoipas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ASSITENZANOIPA);

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
		return AssitenzaNoipaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the AssitenzaNoipa persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AssitenzaNoipaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ASSITENZANOIPA = "SELECT assitenzaNoipa FROM AssitenzaNoipa assitenzaNoipa";
	private static final String _SQL_SELECT_ASSITENZANOIPA_WHERE_PKS_IN = "SELECT assitenzaNoipa FROM AssitenzaNoipa assitenzaNoipa WHERE assistenzaId IN (";
	private static final String _SQL_SELECT_ASSITENZANOIPA_WHERE = "SELECT assitenzaNoipa FROM AssitenzaNoipa assitenzaNoipa WHERE ";
	private static final String _SQL_COUNT_ASSITENZANOIPA = "SELECT COUNT(assitenzaNoipa) FROM AssitenzaNoipa assitenzaNoipa";
	private static final String _SQL_COUNT_ASSITENZANOIPA_WHERE = "SELECT COUNT(assitenzaNoipa) FROM AssitenzaNoipa assitenzaNoipa WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "assitenzaNoipa.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AssitenzaNoipa exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AssitenzaNoipa exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AssitenzaNoipaPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}