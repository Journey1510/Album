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
@WebServlet(urlPatterns="/turnPage")
public class TurnPageServlet extends BaseServlet
{
	public void service(HttpServletRequest request
		, HttpServletResponse response)throws IOException,ServletException
	{
		String turn = request.getParameter("turn");
		HttpSession session = request.getSession(true);
		String name = (String)session.getAttribute("curUser");
		Object pageObj = session.getAttribute("curPage");
		// ���HttpSession�е�curPageΪnull�������õ�ǰҳΪ��һҳ
		int curPage = pageObj == null ? 1 :(Integer) pageObj;
		response.setContentType("text/javascript;charset=gbk");
		PrintWriter out = response.getWriter();
		if (curPage == 1 && turn.equals("-1"))
		{
			out.println("alert('�����Ѿ��ǵ�һҳ���޷���ǰ��ҳ��')");
		}
		else
		{
			// ִ�з�ҳ���޸�curPage��ֵ��
			curPage += Integer.parseInt(turn);
			try
			{
				List<PhotoHolder> photos = as.getPhotoByUser(name , curPage);
				// ��ҳ��û�м�¼
				if (photos.size() == 0)
				{
					out.println("alert('��ҳ���Ҳ����κ���Ƭ��¼��"
						+ "ϵͳ���Զ�������һҳ')");
					// ���·�����һҳ
					curPage -= Integer.parseInt(turn);
				}
				else
				{
					// ���û����������ҳ�����HttpSession��
					session.setAttribute("curPage" , curPage);
				}
			}
			catch (AlbumException ex)
			{
				out.println("alert('" + ex.getMessage() + "�����ԣ�')");
			}
		}
	}
}
