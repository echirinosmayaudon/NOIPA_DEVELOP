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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.gov.mef.opendata.webformassistenza.service.http.EntiAmministrazioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.gov.mef.opendata.webformassistenza.service.http.EntiAmministrazioneServiceSoap
 * @generated
 */
@ProviderType
public class EntiAmministrazioneSoap implements Serializable {
	public static EntiAmministrazioneSoap toSoapModel(EntiAmministrazione model) {
		EntiAmministrazioneSoap soapModel = new EntiAmministrazioneSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEntiId(model.getEntiId());

		return soapModel;
	}

	public static EntiAmministrazioneSoap[] toSoapModels(
		EntiAmministrazione[] models) {
		EntiAmministrazioneSoap[] soapModels = new EntiAmministrazioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EntiAmministrazioneSoap[][] toSoapModels(
		EntiAmministrazione[][] models) {
		EntiAmministrazioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EntiAmministrazioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EntiAmministrazioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EntiAmministrazioneSoap[] toSoapModels(
		List<EntiAmministrazione> models) {
		List<EntiAmministrazioneSoap> soapModels = new ArrayList<EntiAmministrazioneSoap>(models.size());

		for (EntiAmministrazione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EntiAmministrazioneSoap[soapModels.size()]);
	}

	public EntiAmministrazioneSoap() {
	}

	public long getPrimaryKey() {
		return _entiId;
	}

	public void setPrimaryKey(long pk) {
		setEntiId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEntiId() {
		return _entiId;
	}

	public void setEntiId(long entiId) {
		_entiId = entiId;
	}

	private String _uuid;
	private long _entiId;
}