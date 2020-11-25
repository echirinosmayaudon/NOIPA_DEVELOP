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

package it.gov.mef.opendata.webformassistenza.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.gov.mef.opendata.webformassistenza.service.AssitenzaNoipaServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link AssitenzaNoipaServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssitenzaNoipaServiceSoap
 * @see HttpPrincipal
 * @see AssitenzaNoipaServiceUtil
 * @generated
 */
@ProviderType
public class AssitenzaNoipaServiceHttp {
	public static Object getAssitenzaOld(HttpPrincipal httpPrincipal,
		long groupId, String locale, String ddmStructureKeyT,
		String ddmStructureKeyR) {
		try {
			MethodKey methodKey = new MethodKey(AssitenzaNoipaServiceUtil.class,
					"getAssitenzaOld", _getAssitenzaOldParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					locale, ddmStructureKeyT, ddmStructureKeyR);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getContenutoPrivato(
		HttpPrincipal httpPrincipal, long groupId, String structureId,
		String locale, String areaId) {
		try {
			MethodKey methodKey = new MethodKey(AssitenzaNoipaServiceUtil.class,
					"getContenutoPrivato", _getContenutoPrivatoParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					structureId, locale, areaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getAssitenzaRemota(
		HttpPrincipal httpPrincipal, long groupId, String locale,
		String ddmStructureKeyT, String ddmStructureKeyR) {
		try {
			MethodKey methodKey = new MethodKey(AssitenzaNoipaServiceUtil.class,
					"getAssitenzaRemota", _getAssitenzaRemotaParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					locale, ddmStructureKeyT, ddmStructureKeyR);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AssitenzaNoipaServiceHttp.class);
	private static final Class<?>[] _getAssitenzaOldParameterTypes0 = new Class[] {
			long.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _getContenutoPrivatoParameterTypes1 = new Class[] {
			long.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _getAssitenzaRemotaParameterTypes2 = new Class[] {
			long.class, String.class, String.class, String.class
		};
}