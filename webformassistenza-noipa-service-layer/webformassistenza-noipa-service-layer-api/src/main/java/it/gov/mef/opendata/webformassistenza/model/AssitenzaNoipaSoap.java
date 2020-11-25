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
 * This class is used by SOAP remote services, specifically {@link it.gov.mef.opendata.webformassistenza.service.http.AssitenzaNoipaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.gov.mef.opendata.webformassistenza.service.http.AssitenzaNoipaServiceSoap
 * @generated
 */
@ProviderType
public class AssitenzaNoipaSoap implements Serializable {
	public static AssitenzaNoipaSoap toSoapModel(AssitenzaNoipa model) {
		AssitenzaNoipaSoap soapModel = new AssitenzaNoipaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAssistenzaId(model.getAssistenzaId());

		return soapModel;
	}

	public static AssitenzaNoipaSoap[] toSoapModels(AssitenzaNoipa[] models) {
		AssitenzaNoipaSoap[] soapModels = new AssitenzaNoipaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AssitenzaNoipaSoap[][] toSoapModels(AssitenzaNoipa[][] models) {
		AssitenzaNoipaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AssitenzaNoipaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AssitenzaNoipaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AssitenzaNoipaSoap[] toSoapModels(List<AssitenzaNoipa> models) {
		List<AssitenzaNoipaSoap> soapModels = new ArrayList<AssitenzaNoipaSoap>(models.size());

		for (AssitenzaNoipa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AssitenzaNoipaSoap[soapModels.size()]);
	}

	public AssitenzaNoipaSoap() {
	}

	public long getPrimaryKey() {
		return _assistenzaId;
	}

	public void setPrimaryKey(long pk) {
		setAssistenzaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAssistenzaId() {
		return _assistenzaId;
	}

	public void setAssistenzaId(long assistenzaId) {
		_assistenzaId = assistenzaId;
	}

	private String _uuid;
	private long _assistenzaId;
}