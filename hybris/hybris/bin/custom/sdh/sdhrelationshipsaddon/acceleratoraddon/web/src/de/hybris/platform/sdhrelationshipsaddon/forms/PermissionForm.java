/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.sdhrelationshipsaddon.forms;

import java.util.List;


/**
 *
 * PermissionForm for add permission
 */
public class PermissionForm
{
	private String permissionType;
	private List<String> sourcePermissibleItemTypes;
	private List<String> targetPermissibleItemTypes;
	private boolean sameAsSourcePermissibleItemTypes;

	public String getPermissionType()
	{
		return permissionType;
	}

	public void setPermissionType(final String permissionType)
	{
		this.permissionType = permissionType;
	}

	public List<String> getSourcePermissibleItemTypes()
	{
		return sourcePermissibleItemTypes;
	}

	public void setSourcePermissibleItemTypes(final List<String> sourcePermissibleItemTypes)
	{
		this.sourcePermissibleItemTypes = sourcePermissibleItemTypes;
	}

	public List<String> getTargetPermissibleItemTypes()
	{
		return targetPermissibleItemTypes;
	}

	public void setTargetPermissibleItemTypes(final List<String> targetPermissibleItemTypes)
	{
		this.targetPermissibleItemTypes = targetPermissibleItemTypes;
	}

	public boolean isSameAsSourcePermissibleItemTypes()
	{
		return sameAsSourcePermissibleItemTypes;
	}

	public void setSameAsSourcePermissibleItemTypes(final boolean sameAsSourcePermissibleItemTypes)
	{
		this.sameAsSourcePermissibleItemTypes = sameAsSourcePermissibleItemTypes;
	}
}
