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

package it.gov.mef.opendata.webformassistenza.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa;
import it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalService;
import it.gov.mef.opendata.webformassistenza.service.persistence.AssitenzaNoipaPersistence;
import it.gov.mef.opendata.webformassistenza.service.persistence.EntiAmministrazionePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the AssitenzaNoipa local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.gov.mef.opendata.webformassistenza.service.impl.AssitenzaNoipaLocalServiceImpl
 * @see it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AssitenzaNoipaLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AssitenzaNoipaLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaLocalServiceUtil} to access the AssitenzaNoipa local service.
	 */

	/**
	 * Adds the AssitenzaNoipa to the database. Also notifies the appropriate model listeners.
	 *
	 * @param assitenzaNoipa the AssitenzaNoipa
	 * @return the AssitenzaNoipa that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AssitenzaNoipa addAssitenzaNoipa(AssitenzaNoipa assitenzaNoipa) {
		assitenzaNoipa.setNew(true);

		return assitenzaNoipaPersistence.update(assitenzaNoipa);
	}

	/**
	 * Creates a new AssitenzaNoipa with the primary key. Does not add the AssitenzaNoipa to the database.
	 *
	 * @param assistenzaId the primary key for the new AssitenzaNoipa
	 * @return the new AssitenzaNoipa
	 */
	@Override
	@Transactional(enabled = false)
	public AssitenzaNoipa createAssitenzaNoipa(long assistenzaId) {
		return assitenzaNoipaPersistence.create(assistenzaId);
	}

	/**
	 * Deletes the AssitenzaNoipa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assistenzaId the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa that was removed
	 * @throws PortalException if a AssitenzaNoipa with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AssitenzaNoipa deleteAssitenzaNoipa(long assistenzaId)
		throws PortalException {
		return assitenzaNoipaPersistence.remove(assistenzaId);
	}

	/**
	 * Deletes the AssitenzaNoipa from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assitenzaNoipa the AssitenzaNoipa
	 * @return the AssitenzaNoipa that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AssitenzaNoipa deleteAssitenzaNoipa(AssitenzaNoipa assitenzaNoipa) {
		return assitenzaNoipaPersistence.remove(assitenzaNoipa);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AssitenzaNoipa.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return assitenzaNoipaPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return assitenzaNoipaPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return assitenzaNoipaPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return assitenzaNoipaPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return assitenzaNoipaPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AssitenzaNoipa fetchAssitenzaNoipa(long assistenzaId) {
		return assitenzaNoipaPersistence.fetchByPrimaryKey(assistenzaId);
	}

	/**
	 * Returns the AssitenzaNoipa with the primary key.
	 *
	 * @param assistenzaId the primary key of the AssitenzaNoipa
	 * @return the AssitenzaNoipa
	 * @throws PortalException if a AssitenzaNoipa with the primary key could not be found
	 */
	@Override
	public AssitenzaNoipa getAssitenzaNoipa(long assistenzaId)
		throws PortalException {
		return assitenzaNoipaPersistence.findByPrimaryKey(assistenzaId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(assitenzaNoipaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AssitenzaNoipa.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("assistenzaId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(assitenzaNoipaLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AssitenzaNoipa.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"assistenzaId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(assitenzaNoipaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AssitenzaNoipa.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("assistenzaId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return assitenzaNoipaLocalService.deleteAssitenzaNoipa((AssitenzaNoipa)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return assitenzaNoipaPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<AssitenzaNoipa> getAssitenzaNoipas(int start, int end) {
		return assitenzaNoipaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of AssitenzaNoipas.
	 *
	 * @return the number of AssitenzaNoipas
	 */
	@Override
	public int getAssitenzaNoipasCount() {
		return assitenzaNoipaPersistence.countAll();
	}

	/**
	 * Updates the AssitenzaNoipa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param assitenzaNoipa the AssitenzaNoipa
	 * @return the AssitenzaNoipa that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AssitenzaNoipa updateAssitenzaNoipa(AssitenzaNoipa assitenzaNoipa) {
		return assitenzaNoipaPersistence.update(assitenzaNoipa);
	}

	/**
	 * Returns the AssitenzaNoipa local service.
	 *
	 * @return the AssitenzaNoipa local service
	 */
	public AssitenzaNoipaLocalService getAssitenzaNoipaLocalService() {
		return assitenzaNoipaLocalService;
	}

	/**
	 * Sets the AssitenzaNoipa local service.
	 *
	 * @param assitenzaNoipaLocalService the AssitenzaNoipa local service
	 */
	public void setAssitenzaNoipaLocalService(
		AssitenzaNoipaLocalService assitenzaNoipaLocalService) {
		this.assitenzaNoipaLocalService = assitenzaNoipaLocalService;
	}

	/**
	 * Returns the AssitenzaNoipa persistence.
	 *
	 * @return the AssitenzaNoipa persistence
	 */
	public AssitenzaNoipaPersistence getAssitenzaNoipaPersistence() {
		return assitenzaNoipaPersistence;
	}

	/**
	 * Sets the AssitenzaNoipa persistence.
	 *
	 * @param assitenzaNoipaPersistence the AssitenzaNoipa persistence
	 */
	public void setAssitenzaNoipaPersistence(
		AssitenzaNoipaPersistence assitenzaNoipaPersistence) {
		this.assitenzaNoipaPersistence = assitenzaNoipaPersistence;
	}

	/**
	 * Returns the EntiAmministrazione local service.
	 *
	 * @return the EntiAmministrazione local service
	 */
	public it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneLocalService getEntiAmministrazioneLocalService() {
		return entiAmministrazioneLocalService;
	}

	/**
	 * Sets the EntiAmministrazione local service.
	 *
	 * @param entiAmministrazioneLocalService the EntiAmministrazione local service
	 */
	public void setEntiAmministrazioneLocalService(
		it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneLocalService entiAmministrazioneLocalService) {
		this.entiAmministrazioneLocalService = entiAmministrazioneLocalService;
	}

	/**
	 * Returns the EntiAmministrazione persistence.
	 *
	 * @return the EntiAmministrazione persistence
	 */
	public EntiAmministrazionePersistence getEntiAmministrazionePersistence() {
		return entiAmministrazionePersistence;
	}

	/**
	 * Sets the EntiAmministrazione persistence.
	 *
	 * @param entiAmministrazionePersistence the EntiAmministrazione persistence
	 */
	public void setEntiAmministrazionePersistence(
		EntiAmministrazionePersistence entiAmministrazionePersistence) {
		this.entiAmministrazionePersistence = entiAmministrazionePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService getAssetTagLocalService() {
		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService) {
		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(AssetTagPersistence assetTagPersistence) {
		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa",
			assitenzaNoipaLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AssitenzaNoipaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AssitenzaNoipa.class;
	}

	protected String getModelClassName() {
		return AssitenzaNoipa.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = assitenzaNoipaPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AssitenzaNoipaLocalService.class)
	protected AssitenzaNoipaLocalService assitenzaNoipaLocalService;
	@BeanReference(type = AssitenzaNoipaPersistence.class)
	protected AssitenzaNoipaPersistence assitenzaNoipaPersistence;
	@BeanReference(type = it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneLocalService.class)
	protected it.gov.mef.opendata.webformassistenza.service.EntiAmministrazioneLocalService entiAmministrazioneLocalService;
	@BeanReference(type = EntiAmministrazionePersistence.class)
	protected EntiAmministrazionePersistence entiAmministrazionePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetEntryLocalService.class)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService;
	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetTagLocalService.class)
	protected com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService;
	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}