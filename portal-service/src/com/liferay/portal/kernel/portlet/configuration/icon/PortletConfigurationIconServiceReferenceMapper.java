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

package com.liferay.portal.kernel.portlet.configuration.icon;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.registry.ServiceReference;
import com.liferay.registry.collections.ServiceReferenceMapper;

/**
 * @author Eudaldo Alonso
 */
public class PortletConfigurationIconServiceReferenceMapper
	implements ServiceReferenceMapper<String, PortletConfigurationIconFactory> {

	@Override
	public void map(
		ServiceReference<PortletConfigurationIconFactory> serviceReference,
		Emitter<String> emitter) {

		String portletId = (String)serviceReference.getProperty(
			"javax.portlet.name");

		if (Validator.isNull(portletId)) {
			portletId = StringPool.STAR;
		}

		emitter.emit(portletId);
	}

}