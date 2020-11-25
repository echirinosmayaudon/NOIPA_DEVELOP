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

package it.gov.mef.opendata.webformassistenza.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione;
import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazioneModel;
import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazioneSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the EntiAmministrazione service. Represents a row in the &quot;EntiAmministrazione&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link EntiAmministrazioneModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EntiAmministrazioneImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazioneImpl
 * @see EntiAmministrazione
 * @see EntiAmministrazioneModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class EntiAmministrazioneModelImpl extends BaseModelImpl<EntiAmministrazione>
	implements EntiAmministrazioneModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a EntiAmministrazione model instance should use the {@link EntiAmministrazione} interface instead.
	 */
	public static final String TABLE_NAME = "EntiAmministrazione";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "entiId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("entiId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table EntiAmministrazione (uuid_ VARCHAR(75) null,entiId LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table EntiAmministrazione";
	public static final String ORDER_BY_JPQL = " ORDER BY entiAmministrazione.entiId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EntiAmministrazione.entiId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(it.gov.mef.opendata.webformassistenza.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(it.gov.mef.opendata.webformassistenza.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(it.gov.mef.opendata.webformassistenza.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long ENTIID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EntiAmministrazione toModel(EntiAmministrazioneSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EntiAmministrazione model = new EntiAmministrazioneImpl();

		model.setUuid(soapModel.getUuid());
		model.setEntiId(soapModel.getEntiId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EntiAmministrazione> toModels(
		EntiAmministrazioneSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EntiAmministrazione> models = new ArrayList<EntiAmministrazione>(soapModels.length);

		for (EntiAmministrazioneSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(it.gov.mef.opendata.webformassistenza.service.util.ServiceProps.get(
				"lock.expiration.time.it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione"));

	public EntiAmministrazioneModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _entiId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEntiId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entiId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EntiAmministrazione.class;
	}

	@Override
	public String getModelClassName() {
		return EntiAmministrazione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entiId", getEntiId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long entiId = (Long)attributes.get("entiId");

		if (entiId != null) {
			setEntiId(entiId);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getEntiId() {
		return _entiId;
	}

	@Override
	public void setEntiId(long entiId) {
		_columnBitmask = -1L;

		_entiId = entiId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			EntiAmministrazione.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EntiAmministrazione toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EntiAmministrazione)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EntiAmministrazioneImpl entiAmministrazioneImpl = new EntiAmministrazioneImpl();

		entiAmministrazioneImpl.setUuid(getUuid());
		entiAmministrazioneImpl.setEntiId(getEntiId());

		entiAmministrazioneImpl.resetOriginalValues();

		return entiAmministrazioneImpl;
	}

	@Override
	public int compareTo(EntiAmministrazione entiAmministrazione) {
		int value = 0;

		if (getEntiId() < entiAmministrazione.getEntiId()) {
			value = -1;
		}
		else if (getEntiId() > entiAmministrazione.getEntiId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntiAmministrazione)) {
			return false;
		}

		EntiAmministrazione entiAmministrazione = (EntiAmministrazione)obj;

		long primaryKey = entiAmministrazione.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		EntiAmministrazioneModelImpl entiAmministrazioneModelImpl = this;

		entiAmministrazioneModelImpl._originalUuid = entiAmministrazioneModelImpl._uuid;

		entiAmministrazioneModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EntiAmministrazione> toCacheModel() {
		EntiAmministrazioneCacheModel entiAmministrazioneCacheModel = new EntiAmministrazioneCacheModel();

		entiAmministrazioneCacheModel.uuid = getUuid();

		String uuid = entiAmministrazioneCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			entiAmministrazioneCacheModel.uuid = null;
		}

		entiAmministrazioneCacheModel.entiId = getEntiId();

		return entiAmministrazioneCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", entiId=");
		sb.append(getEntiId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append(
			"it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entiId</column-name><column-value><![CDATA[");
		sb.append(getEntiId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = EntiAmministrazione.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			EntiAmministrazione.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _entiId;
	private long _columnBitmask;
	private EntiAmministrazione _escapedModel;
}