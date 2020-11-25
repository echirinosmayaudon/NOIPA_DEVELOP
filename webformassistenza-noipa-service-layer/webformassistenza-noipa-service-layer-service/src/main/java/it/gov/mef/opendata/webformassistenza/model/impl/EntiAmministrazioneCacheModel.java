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

import it.gov.mef.opendata.webformassistenza.model.EntiAmministrazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EntiAmministrazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EntiAmministrazione
 * @generated
 */
@ProviderType
public class EntiAmministrazioneCacheModel implements CacheModel<EntiAmministrazione>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntiAmministrazioneCacheModel)) {
			return false;
		}

		EntiAmministrazioneCacheModel entiAmministrazioneCacheModel = (EntiAmministrazioneCacheModel)obj;

		if (entiId == entiAmministrazioneCacheModel.entiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entiId=");
		sb.append(entiId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EntiAmministrazione toEntityModel() {
		EntiAmministrazioneImpl entiAmministrazioneImpl = new EntiAmministrazioneImpl();

		if (uuid == null) {
			entiAmministrazioneImpl.setUuid("");
		}
		else {
			entiAmministrazioneImpl.setUuid(uuid);
		}

		entiAmministrazioneImpl.setEntiId(entiId);

		entiAmministrazioneImpl.resetOriginalValues();

		return entiAmministrazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entiId = objectInput.readLong();
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

		objectOutput.writeLong(entiId);
	}

	public String uuid;
	public long entiId;
}