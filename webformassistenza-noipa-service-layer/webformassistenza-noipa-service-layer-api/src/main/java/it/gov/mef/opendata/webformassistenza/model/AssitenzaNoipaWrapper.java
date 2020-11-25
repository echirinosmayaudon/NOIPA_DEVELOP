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
 * This class is a wrapper for {@link AssitenzaNoipa}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipa
 * @generated
 */
@ProviderType
public class AssitenzaNoipaWrapper implements AssitenzaNoipa,
	ModelWrapper<AssitenzaNoipa> {
	public AssitenzaNoipaWrapper(AssitenzaNoipa assitenzaNoipa) {
		_assitenzaNoipa = assitenzaNoipa;
	}

	@Override
	public Class<?> getModelClass() {
		return AssitenzaNoipa.class;
	}

	@Override
	public String getModelClassName() {
		return AssitenzaNoipa.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("assistenzaId", getAssistenzaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long assistenzaId = (Long)attributes.get("assistenzaId");

		if (assistenzaId != null) {
			setAssistenzaId(assistenzaId);
		}
	}

	@Override
	public Object clone() {
		return new AssitenzaNoipaWrapper((AssitenzaNoipa)_assitenzaNoipa.clone());
	}

	@Override
	public int compareTo(AssitenzaNoipa assitenzaNoipa) {
		return _assitenzaNoipa.compareTo(assitenzaNoipa);
	}

	/**
	* Returns the assistenza ID of this AssitenzaNoipa.
	*
	* @return the assistenza ID of this AssitenzaNoipa
	*/
	@Override
	public long getAssistenzaId() {
		return _assitenzaNoipa.getAssistenzaId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _assitenzaNoipa.getExpandoBridge();
	}

	/**
	* Returns the primary key of this AssitenzaNoipa.
	*
	* @return the primary key of this AssitenzaNoipa
	*/
	@Override
	public long getPrimaryKey() {
		return _assitenzaNoipa.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assitenzaNoipa.getPrimaryKeyObj();
	}

	/**
	* Returns the uuid of this AssitenzaNoipa.
	*
	* @return the uuid of this AssitenzaNoipa
	*/
	@Override
	public String getUuid() {
		return _assitenzaNoipa.getUuid();
	}

	@Override
	public int hashCode() {
		return _assitenzaNoipa.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _assitenzaNoipa.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _assitenzaNoipa.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _assitenzaNoipa.isNew();
	}

	@Override
	public void persist() {
		_assitenzaNoipa.persist();
	}

	/**
	* Sets the assistenza ID of this AssitenzaNoipa.
	*
	* @param assistenzaId the assistenza ID of this AssitenzaNoipa
	*/
	@Override
	public void setAssistenzaId(long assistenzaId) {
		_assitenzaNoipa.setAssistenzaId(assistenzaId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_assitenzaNoipa.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_assitenzaNoipa.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_assitenzaNoipa.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_assitenzaNoipa.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_assitenzaNoipa.setNew(n);
	}

	/**
	* Sets the primary key of this AssitenzaNoipa.
	*
	* @param primaryKey the primary key of this AssitenzaNoipa
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_assitenzaNoipa.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_assitenzaNoipa.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this AssitenzaNoipa.
	*
	* @param uuid the uuid of this AssitenzaNoipa
	*/
	@Override
	public void setUuid(String uuid) {
		_assitenzaNoipa.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AssitenzaNoipa> toCacheModel() {
		return _assitenzaNoipa.toCacheModel();
	}

	@Override
	public AssitenzaNoipa toEscapedModel() {
		return new AssitenzaNoipaWrapper(_assitenzaNoipa.toEscapedModel());
	}

	@Override
	public String toString() {
		return _assitenzaNoipa.toString();
	}

	@Override
	public AssitenzaNoipa toUnescapedModel() {
		return new AssitenzaNoipaWrapper(_assitenzaNoipa.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _assitenzaNoipa.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssitenzaNoipaWrapper)) {
			return false;
		}

		AssitenzaNoipaWrapper assitenzaNoipaWrapper = (AssitenzaNoipaWrapper)obj;

		if (Objects.equals(_assitenzaNoipa,
					assitenzaNoipaWrapper._assitenzaNoipa)) {
			return true;
		}

		return false;
	}

	@Override
	public AssitenzaNoipa getWrappedModel() {
		return _assitenzaNoipa;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _assitenzaNoipa.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _assitenzaNoipa.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_assitenzaNoipa.resetOriginalValues();
	}

	private final AssitenzaNoipa _assitenzaNoipa;
}