package org.crazyit.album.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.util.*;
import java.io.*;

import org.crazyit.album.service.AlbumService;
import org.crazyit.album.exception.AlbumException;
import org.crazyit.album.web.base.BaseServlet;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/validateName")
public class ValidateNameServlet extends BaseServlet
{
	public void service(HttpServletRequest request
		, HttpServletResponse response)throws IOException,ServletException
	{
		String name = request.getParameter("user");
		response.setContentType("text/javascript;charset=gb2312");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try
		{
			if (name != null)
			{
				if (as.validateName(name))
				{
					out.println("alert('恭喜您，该用户名还未使用，你可使用该用户名！');");
				}
				else
				{
					out.println("alert('对不起，该用户名已被他人占用！');");
					out.println("$('#user').val('');");
				}
			}
			else
			{
				out.println("alert('验证用户名出现异常，请更换用户名重试！');");
			}
		}
		catch (AlbumException ex)
		{
			out.println("alert('" + ex.getMessage() + "请更换用户名重试！');");
		}
	}
}
