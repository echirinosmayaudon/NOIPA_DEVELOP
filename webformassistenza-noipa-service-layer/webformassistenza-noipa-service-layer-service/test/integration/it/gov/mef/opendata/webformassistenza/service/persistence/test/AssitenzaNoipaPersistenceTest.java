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

package it.gov.mef.opendata.webformassistenza.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import it.gov.mef.opendata.webformassistenza.exception.NoSuchAssitenzaNoipaException;
import it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa;
import it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalServiceUtil;
import it.gov.mef.opendata.webformassistenza.service.persistence.AssitenzaNoipaPersistence;
import it.gov.mef.opendata.webformassistenza.service.persistence.AssitenzaNoipaUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AssitenzaNoipaPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"it.gov.mef.opendata.webformassistenza.service"));

	@Before
	public void setUp() {
		_persistence = AssitenzaNoipaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AssitenzaNoipa> iterator = _assitenzaNoipas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AssitenzaNoipa assitenzaNoipa = _persistence.create(pk);

		Assert.assertNotNull(assitenzaNoipa);

		Assert.assertEquals(assitenzaNoipa.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AssitenzaNoipa newAssitenzaNoipa = addAssitenzaNoipa();

		_persistence.remove(newAssitenzaNoipa);

		AssitenzaNoipa existingAssitenzaNoipa = _persistence.fetchByPrimaryKey(newAssitenzaNoipa.getPrimaryKey());

		Assert.assertNull(existingAssitenzaNoipa);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAssitenzaNoipa();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AssitenzaNoipa newAssitenzaNoipa = _persistence.create(pk);

		newAssitenzaNoipa.setUuid(RandomTestUtil.randomString());

		_assitenzaNoipas.add(_persistence.update(newAssitenzaNoipa));

		AssitenzaNoipa existingAssitenzaNoipa = _persistence.findByPrimaryKey(newAssitenzaNoipa.getPrimaryKey());

		Assert.assertEquals(existingAssitenzaNoipa.getUuid(),
			newAssitenzaNoipa.getUuid());
		Assert.assertEquals(existingAssitenzaNoipa.getAssistenzaId(),
			newAssitenzaNoipa.getAssistenzaId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AssitenzaNoipa newAssitenzaNoipa = addAssitenzaNoipa();

		AssitenzaNoipa existingAssitenzaNoipa = _persistence.findByPrimaryKey(newAssitenzaNoipa.getPrimaryKey());

		Assert.assertEquals(existingAssitenzaNoipa, newAssitenzaNoipa);
	}

	@Test(expected = NoSuchAssitenzaNoipaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<AssitenzaNoipa> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("AssitenzaNoipa", "uuid",
			true, "assistenzaId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AssitenzaNoipa newAssitenzaNoipa = addAssitenzaNoipa();

		AssitenzaNoipa existingAssitenzaNoipa = _persistence.fetchByPrimaryKey(newAssitenzaNoipa.getPrimaryKey());

		Assert.assertEquals(existingAssitenzaNoipa, newAssitenzaNoipa);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AssitenzaNoipa missingAssitenzaNoipa = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAssitenzaNoipa);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		AssitenzaNoipa newAssitenzaNoipa1 = addAssitenzaNoipa();
		AssitenzaNoipa newAssitenzaNoipa2 = addAssitenzaNoipa();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAssitenzaNoipa1.getPrimaryKey());
		primaryKeys.add(newAssitenzaNoipa2.getPrimaryKey());

		Map<Serializable, AssitenzaNoipa> assitenzaNoipas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, assitenzaNoipas.size());
		Assert.assertEquals(newAssitenzaNoipa1,
			assitenzaNoipas.get(newAssitenzaNoipa1.getPrimaryKey()));
		Assert.assertEquals(newAssitenzaNoipa2,
			assitenzaNoipas.get(newAssitenzaNoipa2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AssitenzaNoipa> assitenzaNoipas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(assitenzaNoipas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		AssitenzaNoipa newAssitenzaNoipa = addAssitenzaNoipa();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAssitenzaNoipa.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AssitenzaNoipa> assitenzaNoipas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, assitenzaNoipas.size());
		Assert.assertEquals(newAssitenzaNoipa,
			assitenzaNoipas.get(newAssitenzaNoipa.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AssitenzaNoipa> assitenzaNoipas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(assitenzaNoipas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		AssitenzaNoipa newAssitenzaNoipa = addAssitenzaNoipa();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAssitenzaNoipa.getPrimaryKey());

		Map<Serializable, AssitenzaNoipa> assitenzaNoipas = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, assitenzaNoipas.size());
		Assert.assertEquals(newAssitenzaNoipa,
			assitenzaNoipas.get(newAssitenzaNoipa.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AssitenzaNoipaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AssitenzaNoipa>() {
				@Override
				public void performAction(AssitenzaNoipa assitenzaNoipa) {
					Assert.assertNotNull(assitenzaNoipa);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AssitenzaNoipa newAssitenzaNoipa = addAssitenzaNoipa();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssitenzaNoipa.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("assistenzaId",
				newAssitenzaNoipa.getAssistenzaId()));

		List<AssitenzaNoipa> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AssitenzaNoipa existingAssitenzaNoipa = result.get(0);

		Assert.assertEquals(existingAssitenzaNoipa, newAssitenzaNoipa);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssitenzaNoipa.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("assistenzaId",
				RandomTestUtil.nextLong()));

		List<AssitenzaNoipa> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		AssitenzaNoipa newAssitenzaNoipa = addAssitenzaNoipa();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssitenzaNoipa.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"assistenzaId"));

		Object newAssistenzaId = newAssitenzaNoipa.getAssistenzaId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("assistenzaId",
				new Object[] { newAssistenzaId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAssistenzaId = result.get(0);

		Assert.assertEquals(existingAssistenzaId, newAssistenzaId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssitenzaNoipa.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"assistenzaId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("assistenzaId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected AssitenzaNoipa addAssitenzaNoipa() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AssitenzaNoipa assitenzaNoipa = _persistence.create(pk);

		assitenzaNoipa.setUuid(RandomTestUtil.randomString());

		_assitenzaNoipas.add(_persistence.update(assitenzaNoipa));

		return assitenzaNoipa;
	}

	private List<AssitenzaNoipa> _assitenzaNoipas = new ArrayList<AssitenzaNoipa>();
	private AssitenzaNoipaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}