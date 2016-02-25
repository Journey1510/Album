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
@WebServlet(urlPatterns="/proRegist")
public class ProRegistServlet extends BaseServlet
{
	public void service(HttpServletRequest request
		, HttpServletResponse response)throws IOException,ServletException
	{
		String name = request.getParameter("user");
		String pass = request.getParameter("pass");
		response.setContentType("text/javascript;charset=gbk");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try
		{
			out.println("$('#user,#pass').val('');");
			if (name != null && pass != null
				&& as.registUser(name , pass) > 0)
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("curUser" , name);
				out.println("alert('恭喜您，您已经注册成功！');");
				out.println("$('#noLogin').hide(500);");
				out.println("$('#hasLogin').show(500);");
				// 调用获取相片列表的方法
				out.println("onLoadHandler();");
			}
			else
			{
				out.println("alert('您注册出现失败，请选择合适的用户名重试！');");
			}
		}
		catch (AlbumException ex)
		{
			out.println("alert('" + ex.getMessage() + "请更换用户名重试！');");
		}
	}
}
