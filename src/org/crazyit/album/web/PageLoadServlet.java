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
@WebServlet(urlPatterns="/pageLoad")
public class PageLoadServlet extends BaseServlet
{
	public void service(HttpServletRequest request
		, HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/javascript;charset=gbk");
		// 获取输出流
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String name = (String)session.getAttribute("curUser");
		// 如果name不为null，表明用户已经登录
		if (name != null)
		{
			// 隐藏id为noLogin的元素(用户登录面板)
			out.println("$('#noLogin').hide()");
			// 隐藏id为hasLogin的元素(用户控制面板)
			out.println("$('#hasLogin').show()");
			// 调用获取相片列表的方法
			out.println("onLoadHandler();");
			// 取出HttpSession中的curImg属性
			String curImg = (String)session.getAttribute("curImg");
			// 重新显示用户正在浏览的相片
			if (curImg != null)
			{
				out.println("$('#show').attr('src' , 'uploadfiles/"
					+ curImg + "');");
			}
		}
	}
}
