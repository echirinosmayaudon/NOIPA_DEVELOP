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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.gov.mef.opendata.webformassistenza.model.AssitenzaNoipa;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AssitenzaNoipa in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipa
 * @generated
 */
@ProviderType
public class AssitenzaNoipaCacheModel implements CacheModel<AssitenzaNoipa>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssitenzaNoipaCacheModel)) {
			return false;
		}

		AssitenzaNoipaCacheModel assitenzaNoipaCacheModel = (AssitenzaNoipaCacheModel)obj;

		if (assistenzaId == assitenzaNoipaCacheModel.assistenzaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, assistenzaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", assistenzaId=");
		sb.append(assistenzaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AssitenzaNoipa toEntityModel() {
		AssitenzaNoipaImpl assitenzaNoipaImpl = new AssitenzaNoipaImpl();

		if (uuid == null) {
			assitenzaNoipaImpl.setUuid("");
		}
		else {
			assitenzaNoipaImpl.setUuid(uuid);
		}

		assitenzaNoipaImpl.setAssistenzaId(assistenzaId);

		assitenzaNoipaImpl.resetOriginalValues();

		return assitenzaNoipaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		assistenzaId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(assistenzaId);
	}

	public String uuid;
	public long assistenzaId;
}