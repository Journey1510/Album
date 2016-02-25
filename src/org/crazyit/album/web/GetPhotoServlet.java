package org.crazyit.album.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.util.*;
import java.io.*;

import org.crazyit.album.service.AlbumService;
import org.crazyit.album.exception.AlbumException;
import org.crazyit.album.web.base.BaseServlet;
import org.crazyit.album.vo.*;

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
@WebServlet(urlPatterns="/getPhoto")
public class GetPhotoServlet extends BaseServlet
{
	public void service(HttpServletRequest request
		, HttpServletResponse response)throws IOException,ServletException
	{
		HttpSession session = request.getSession(true);
		// 从HttpSession中获取系统当前用户、相片列表的当前页码
		String name = (String)session.getAttribute("curUser");
		Object pageObj = session.getAttribute("curPage");
		// 如果HttpSession中的curPage为null，则设置当前页为第一页
		int curPage = pageObj == null ? 1 :(Integer) pageObj;
		response.setContentType("text/javascript;charset=gbk");
		// 获取输出流
		PrintWriter out = response.getWriter();
		try
		{
			List<PhotoHolder> photos = as.getPhotoByUser(name , curPage);
			// 清空id为list的元素
			out.println("var list = $('#list').empty();");
			for (PhotoHolder ph : photos)
			{
				// 将每个相片动态添加到id为list的元素中
				out.println("list.append(\"<div align='center'>" +
					"<a href='javascript:void(0)' onclick=\\\"showImg('"
					+ ph.getFileName() + "');\\\">"
					+ ph.getTitle() + "</a></div>\");");
			}
		}
		catch (AlbumException ex)
		{
			out.println("alert('" + ex.getMessage() + "请重试！')");
		}
	}
}
