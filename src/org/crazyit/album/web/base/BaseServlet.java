package org.crazyit.album.web.base;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.context.*;
import org.springframework.web.context.support.*;


import org.crazyit.album.service.AlbumService;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BaseServlet extends HttpServlet
{
	protected AlbumService as;
	// �����ʼ�����������Spring����������
	public void init(ServletConfig config)
		throws ServletException
	{
		super.init(config);
		ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
		as = (AlbumService)ctx.getBean("albumService");
	}
}
