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
@WebServlet(urlPatterns="/showImg")
public class ShowImgServlet extends BaseServlet
{
	public void service(HttpServletRequest request
		, HttpServletResponse response)throws IOException,ServletException
	{
		String img = request.getParameter("img");
		HttpSession session = request.getSession(true);
		// 将用户正在浏览的图片放入HttpSession中。
		session.setAttribute("curImg" , img);
		response.setContentType("text/javascript;charset=gbk");
		// 获取输出流
		PrintWriter out = response.getWriter();
		out.println("$('#show').attr('src' , 'uploadfiles/" + img + "');");
	}
}
