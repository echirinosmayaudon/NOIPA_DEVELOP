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

import it.gov.mef.opendata.webformassistenza.exception.NoSuchEntiAmministrazioneException;
import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione;
import it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneLocalServiceUtil;
import it.gov.mef.opendata.webformassistenza.service.persistence.EntiAmministrazionePersistence;
import it.gov.mef.opendata.webformassistenza.service.persistence.EntiAmministrazioneUtil;

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
public class EntiAmministrazionePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"it.gov.mef.opendata.webformassistenza.service"));

	@Before
	public void setUp() {
		_persistence = EntiAmministrazioneUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EntiAmministrazione> iterator = _entiAmministraziones.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntiAmministrazione entiAmministrazione = _persistence.create(pk);

		Assert.assertNotNull(entiAmministrazione);

		Assert.assertEquals(entiAmministrazione.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EntiAmministrazione newEntiAmministrazione = addEntiAmministrazione();

		_persistence.remove(newEntiAmministrazione);

		EntiAmministrazione existingEntiAmministrazione = _persistence.fetchByPrimaryKey(newEntiAmministrazione.getPrimaryKey());

		Assert.assertNull(existingEntiAmministrazione);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEntiAmministrazione();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntiAmministrazione newEntiAmministrazione = _persistence.create(pk);

		newEntiAmministrazione.setUuid(RandomTestUtil.randomString());

		_entiAmministraziones.add(_persistence.update(newEntiAmministrazione));

		EntiAmministrazione existingEntiAmministrazione = _persistence.findByPrimaryKey(newEntiAmministrazione.getPrimaryKey());

		Assert.assertEquals(existingEntiAmministrazione.getUuid(),
			newEntiAmministrazione.getUuid());
		Assert.assertEquals(existingEntiAmministrazione.getEntiId(),
			newEntiAmministrazione.getEntiId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EntiAmministrazione newEntiAmministrazione = addEntiAmministrazione();

		EntiAmministrazione existingEntiAmministrazione = _persistence.findByPrimaryKey(newEntiAmministrazione.getPrimaryKey());

		Assert.assertEquals(existingEntiAmministrazione, newEntiAmministrazione);
	}

	@Test(expected = NoSuchEntiAmministrazioneException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<EntiAmministrazione> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("EntiAmministrazione",
			"uuid", true, "entiId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EntiAmministrazione newEntiAmministrazione = addEntiAmministrazione();

		EntiAmministrazione existingEntiAmministrazione = _persistence.fetchByPrimaryKey(newEntiAmministrazione.getPrimaryKey());

		Assert.assertEquals(existingEntiAmministrazione, newEntiAmministrazione);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntiAmministrazione missingEntiAmministrazione = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEntiAmministrazione);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		EntiAmministrazione newEntiAmministrazione1 = addEntiAmministrazione();
		EntiAmministrazione newEntiAmministrazione2 = addEntiAmministrazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntiAmministrazione1.getPrimaryKey());
		primaryKeys.add(newEntiAmministrazione2.getPrimaryKey());

		Map<Serializable, EntiAmministrazione> entiAmministraziones = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, entiAmministraziones.size());
		Assert.assertEquals(newEntiAmministrazione1,
			entiAmministraziones.get(newEntiAmministrazione1.getPrimaryKey()));
		Assert.assertEquals(newEntiAmministrazione2,
			entiAmministraziones.get(newEntiAmministrazione2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EntiAmministrazione> entiAmministraziones = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(entiAmministraziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		EntiAmministrazione newEntiAmministrazione = addEntiAmministrazione();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntiAmministrazione.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EntiAmministrazione> entiAmministraziones = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, entiAmministraziones.size());
		Assert.assertEquals(newEntiAmministrazione,
			entiAmministraziones.get(newEntiAmministrazione.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EntiAmministrazione> entiAmministraziones = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(entiAmministraziones.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		EntiAmministrazione newEntiAmministrazione = addEntiAmministrazione();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntiAmministrazione.getPrimaryKey());

		Map<Serializable, EntiAmministrazione> entiAmministraziones = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, entiAmministraziones.size());
		Assert.assertEquals(newEntiAmministrazione,
			entiAmministraziones.get(newEntiAmministrazione.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = EntiAmministrazioneLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<EntiAmministrazione>() {
				@Override
				public void performAction(
					EntiAmministrazione entiAmministrazione) {
					Assert.assertNotNull(entiAmministrazione);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		EntiAmministrazione newEntiAmministrazione = addEntiAmministrazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntiAmministrazione.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("entiId",
				newEntiAmministrazione.getEntiId()));

		List<EntiAmministrazione> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		EntiAmministrazione existingEntiAmministrazione = result.get(0);

		Assert.assertEquals(existingEntiAmministrazione, newEntiAmministrazione);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntiAmministrazione.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("entiId",
				RandomTestUtil.nextLong()));

		List<EntiAmministrazione> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		EntiAmministrazione newEntiAmministrazione = addEntiAmministrazione();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntiAmministrazione.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entiId"));

		Object newEntiId = newEntiAmministrazione.getEntiId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("entiId",
				new Object[] { newEntiId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEntiId = result.get(0);

		Assert.assertEquals(existingEntiId, newEntiId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntiAmministrazione.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entiId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("entiId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EntiAmministrazione addEntiAmministrazione()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntiAmministrazione entiAmministrazione = _persistence.create(pk);

		entiAmministrazione.setUuid(RandomTestUtil.randomString());

		_entiAmministraziones.add(_persistence.update(entiAmministrazione));

		return entiAmministrazione;
	}

	private List<EntiAmministrazione> _entiAmministraziones = new ArrayList<EntiAmministrazione>();
	private EntiAmministrazionePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}