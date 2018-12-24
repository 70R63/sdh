/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.sdh.storefront.renderer;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.acceleratorcms.model.components.ImageMapComponentModel;
import de.hybris.platform.core.model.media.MediaModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockJspWriter;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;


@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ImageMapComponentRendererTest
{
	@Mock
	protected PageContext pageContext;
	@Mock
	protected ImageMapComponentModel component;
	@Mock
	protected MediaModel mediaModel;
	@Mock
	protected ImageMapComponentRenderer imageMapComponentRenderer;

	protected Writer stringWriter;
	protected JspWriter out;

	@Before
	public void setUp()
	{
		stringWriter = new StringWriter();
		out = new MockJspWriter(new PrintWriter(stringWriter));
	}

	@Test
	public void testInputWithNoXSS() throws ServletException, IOException
	{
		String payload = "<area shape='rect' alt='System Tee' title='System Tee' coords='276,44,449,210' "
				+ "href='https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue' target='_self' />";
		createMockExpectations(payload);
		imageMapComponentRenderer.renderComponent(pageContext, component);
		String result = stringWriter.toString();
		StringBuilder expected = new StringBuilder();
		expected.append("<div>");
		expected.append(
				"<img title=\"sometest\" alt=\"sometest\" src=\"https://somesshop-uk.com/dress/image01.jpg\" usemap=\"#map\" />");
		expected.append("<map name=\"map\">");
		expected.append("<area shape=\"rect\" alt=\"System Tee\" coords=\"276,44,449,210\" "
				+ "href=\"https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue\" target=\"_self\" />");
		expected.append("</map></div>");
		Assert.assertEquals(result, expected.toString());
	}

	@Test
	public void testInputWithClosingAreaTagAndContent() throws ServletException, IOException
	{
		String payload = "<area shape='rect' alt='System Tee' title='System Tee' coords='276,44,449,210' "
				+ "href='https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue' target='_self' ><script>alert('attacked')</script></area>";
		createMockExpectations(payload);
		imageMapComponentRenderer.renderComponent(pageContext, component);
		String result = stringWriter.toString();
		StringBuilder expected = new StringBuilder();
		expected.append("<div>");
		expected.append(
				"<img title=\"sometest\" alt=\"sometest\" src=\"https://somesshop-uk.com/dress/image01.jpg\" usemap=\"#map\" />");
		expected.append("<map name=\"map\">");
		expected.append("<area shape=\"rect\" alt=\"System Tee\" coords=\"276,44,449,210\" "
				+ "href=\"https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue\" target=\"_self\" />");
		expected.append("</map></div>");
		Assert.assertEquals(result, expected.toString());
	}

	@Test
	public void testInputWithNonHtmlUrlScheme() throws ServletException, IOException
	{
		String payload = "<area shape='rect' alt='System Tee' title='System Tee' coords='276,44,449,210' "
				+ "href='http01://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue' target='_self' ><script>alert('attacked')</script></area>";
		createMockExpectations(payload);
		when(component.getMedia().getURL()).thenReturn("ftp://10.1.2.3/i.jpg");
		imageMapComponentRenderer.renderComponent(pageContext, component);
		String result = stringWriter.toString();
		StringBuilder expected = new StringBuilder();
		expected.append("<div>");
		expected.append("<img title=\"sometest\" alt=\"sometest\" usemap=\"#map\" />");
		expected.append("<map name=\"map\">");
		expected.append("<area shape=\"rect\" alt=\"System Tee\" coords=\"276,44,449,210\" target=\"_self\" />");
		expected.append("</map></div>");
		Assert.assertEquals(result, expected.toString());
	}

	@Test
	public void testInputWithXSSElement() throws ServletException, IOException
	{
		String payload = "<area shape='rect' alt='System Tee' title='System Tee' coords='276,44,449,210' "
				+ "href='https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue' target='_self' ><img src=a onerror=alert(1)></area>";
		createMockExpectations(payload);
		imageMapComponentRenderer.renderComponent(pageContext, component);
		String result = stringWriter.toString();
		StringBuilder expected = new StringBuilder();
		expected.append("<div>");
		expected.append(
				"<img title=\"sometest\" alt=\"sometest\" src=\"https://somesshop-uk.com/dress/image01.jpg\" usemap=\"#map\" />");
		expected.append("<map name=\"map\">");
		expected.append("<area shape=\"rect\" alt=\"System Tee\" coords=\"276,44,449,210\" "
				+ "href=\"https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue\" target=\"_self\" />");
		expected.append("</map>");
		expected.append("<img src=\"a\" />");
		expected.append("</div>");
		Assert.assertEquals(result, expected.toString());
	}

	@Test
	public void testInputXSSAttrs() throws ServletException, IOException
	{
		String payload = "<area shape='<img src=a onerror=alert(1)>' alt='System Tee' title='System Tee' coords='276,44,449,210' "
				+ "href='https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue' target=\"<script>alert('attacked')</script>\" />";
		createMockExpectations(payload);
		imageMapComponentRenderer.renderComponent(pageContext, component);
		String result = stringWriter.toString();
		StringBuilder expected = new StringBuilder();
		expected.append("<div>");
		expected.append(
				"<img title=\"sometest\" alt=\"sometest\" src=\"https://somesshop-uk.com/dress/image01.jpg\" usemap=\"#map\" />");
		expected.append("<map name=\"map\">");
		expected.append("<area shape=\"&lt;img src&#61;a onerror&#61;alert(1)&gt;\" alt=\"System Tee\" coords=\"276,44,449,210\" "
				+ "href=\"https://somesshop-uk.com/Marken/Streetwear-men/T-Shirts/System-Tee-SS/p/122312_aquatic_blue\" target=\"&lt;script&gt;alert(&#39;attacked&#39;)&lt;/script&gt;\" />");
		expected.append("</map></div>");
		Assert.assertEquals(expected.toString(), result);
	}

	protected void createMockExpectations(String imageMapHTMLPayload) throws ServletException, IOException
	{
		doCallRealMethod().when(imageMapComponentRenderer).renderComponent(pageContext, component);
		when(pageContext.getOut()).thenReturn(out);
		when(component.getMedia()).thenReturn(mediaModel);
		when(component.getImageMapHTML()).thenReturn(imageMapHTMLPayload);
		when(component.getMedia().getAltText()).thenReturn("sometest");
		when(component.getMedia().getURL()).thenReturn("https://somesshop-uk.com/dress/image01.jpg");
	}
}
