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
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
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
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try
		{
			if (name != null)
			{
				if (as.validateName(name))
				{
					out.println("alert('��ϲ�������û�����δʹ�ã����ʹ�ø��û�����');");
				}
				else
				{
					out.println("alert('�Բ��𣬸��û����ѱ�����ռ�ã�');");
					out.println("$('#user').val('');");
				}
			}
			else
			{
				out.println("alert('��֤�û��������쳣��������û������ԣ�');");
			}
		}
		catch (AlbumException ex)
		{
			out.println("alert('" + ex.getMessage() + "������û������ԣ�');");
		}
	}
}
