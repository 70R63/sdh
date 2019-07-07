/**
 *
 */
package de.hybris.sdh.core.customBreadcrumbs;

import java.util.List;


/**
 * ResourceBreadcrumbBuilder builds a list of breadcrumbs based on a resource key
 */
public interface ResourceBreadcrumbBuilder
{
	List<Breadcrumb> getBreadcrumbs(String resourceKey);
}
