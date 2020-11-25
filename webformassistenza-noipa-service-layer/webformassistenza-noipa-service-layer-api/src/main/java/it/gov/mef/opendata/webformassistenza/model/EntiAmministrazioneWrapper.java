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

package it.gov.mef.opendata.webformassistenza.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EntiAmministrazione}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazione
 * @generated
 */
@ProviderType
public class EntiAmministrazioneWrapper implements EntiAmministrazione,
	ModelWrapper<EntiAmministrazione> {
	public EntiAmministrazioneWrapper(EntiAmministrazione entiAmministrazione) {
		_entiAmministrazione = entiAmministrazione;
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

	@Override
	public Object clone() {
		return new EntiAmministrazioneWrapper((EntiAmministrazione)_entiAmministrazione.clone());
	}

	@Override
	public int compareTo(EntiAmministrazione entiAmministrazione) {
		return _entiAmministrazione.compareTo(entiAmministrazione);
	}

	/**
	* Returns the enti ID of this EntiAmministrazione.
	*
	* @return the enti ID of this EntiAmministrazione
	*/
	@Override
	public long getEntiId() {
		return _entiAmministrazione.getEntiId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _entiAmministrazione.getExpandoBridge();
	}

	/**
	* Returns the primary key of this EntiAmministrazione.
	*
	* @return the primary key of this EntiAmministrazione
	*/
	@Override
	public long getPrimaryKey() {
		return _entiAmministrazione.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entiAmministrazione.getPrimaryKeyObj();
	}

	/**
	* Returns the uuid of this EntiAmministrazione.
	*
	* @return the uuid of this EntiAmministrazione
	*/
	@Override
	public String getUuid() {
		return _entiAmministrazione.getUuid();
	}

	@Override
	public int hashCode() {
		return _entiAmministrazione.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _entiAmministrazione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _entiAmministrazione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _entiAmministrazione.isNew();
	}

	@Override
	public void persist() {
		_entiAmministrazione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_entiAmministrazione.setCachedModel(cachedModel);
	}

	/**
	* Sets the enti ID of this EntiAmministrazione.
	*
	* @param entiId the enti ID of this EntiAmministrazione
	*/
	@Override
	public void setEntiId(long entiId) {
		_entiAmministrazione.setEntiId(entiId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_entiAmministrazione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_entiAmministrazione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_entiAmministrazione.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_entiAmministrazione.setNew(n);
	}

	/**
	* Sets the primary key of this EntiAmministrazione.
	*
	* @param primaryKey the primary key of this EntiAmministrazione
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_entiAmministrazione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_entiAmministrazione.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this EntiAmministrazione.
	*
	* @param uuid the uuid of this EntiAmministrazione
	*/
	@Override
	public void setUuid(String uuid) {
		_entiAmministrazione.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EntiAmministrazione> toCacheModel() {
		return _entiAmministrazione.toCacheModel();
	}

	@Override
	public EntiAmministrazione toEscapedModel() {
		return new EntiAmministrazioneWrapper(_entiAmministrazione.toEscapedModel());
	}

	@Override
	public String toString() {
		return _entiAmministrazione.toString();
	}

	@Override
	public EntiAmministrazione toUnescapedModel() {
		return new EntiAmministrazioneWrapper(_entiAmministrazione.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _entiAmministrazione.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntiAmministrazioneWrapper)) {
			return false;
		}

		EntiAmministrazioneWrapper entiAmministrazioneWrapper = (EntiAmministrazioneWrapper)obj;

		if (Objects.equals(_entiAmministrazione,
					entiAmministrazioneWrapper._entiAmministrazione)) {
			return true;
		}

		return false;
	}

	@Override
	public EntiAmministrazione getWrappedModel() {
		return _entiAmministrazione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entiAmministrazione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _entiAmministrazione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_entiAmministrazione.resetOriginalValues();
	}

	private final EntiAmministrazione _entiAmministrazione;
}