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
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
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
		// ��HttpSession�л�ȡϵͳ��ǰ�û�����Ƭ�б�ĵ�ǰҳ��
		String name = (String)session.getAttribute("curUser");
		Object pageObj = session.getAttribute("curPage");
		// ���HttpSession�е�curPageΪnull�������õ�ǰҳΪ��һҳ
		int curPage = pageObj == null ? 1 :(Integer) pageObj;
		response.setContentType("text/javascript;charset=gbk");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try
		{
			List<PhotoHolder> photos = as.getPhotoByUser(name , curPage);
			// ���idΪlist��Ԫ��
			out.println("var list = $('#list').empty();");
			for (PhotoHolder ph : photos)
			{
				// ��ÿ����Ƭ��̬��ӵ�idΪlist��Ԫ����
				out.println("list.append(\"<div align='center'>" +
					"<a href='javascript:void(0)' onclick=\\\"showImg('"
					+ ph.getFileName() + "');\\\">"
					+ ph.getTitle() + "</a></div>\");");
			}
		}
		catch (AlbumException ex)
		{
			out.println("alert('" + ex.getMessage() + "�����ԣ�')");
		}
	}
}
