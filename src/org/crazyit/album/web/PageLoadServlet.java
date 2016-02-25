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
@WebServlet(urlPatterns="/pageLoad")
public class PageLoadServlet extends BaseServlet
{
	public void service(HttpServletRequest request
		, HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/javascript;charset=gbk");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String name = (String)session.getAttribute("curUser");
		// ���name��Ϊnull�������û��Ѿ���¼
		if (name != null)
		{
			// ����idΪnoLogin��Ԫ��(�û���¼���)
			out.println("$('#noLogin').hide()");
			// ����idΪhasLogin��Ԫ��(�û��������)
			out.println("$('#hasLogin').show()");
			// ���û�ȡ��Ƭ�б�ķ���
			out.println("onLoadHandler();");
			// ȡ��HttpSession�е�curImg����
			String curImg = (String)session.getAttribute("curImg");
			// ������ʾ�û������������Ƭ
			if (curImg != null)
			{
				out.println("$('#show').attr('src' , 'uploadfiles/"
					+ curImg + "');");
			}
		}
	}
}
