package org.crazyit.album.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

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
@WebServlet(urlPatterns="/proUpload")
public class ProUploadServlet extends BaseServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response) throws IOException,ServletException
	{
		Iterator iter = null;
		String title = null;
		response.setContentType("text/html;charset=gbk");
		// ��ȡ�����
		PrintWriter out = response.getWriter();
		try
		{
			// ʹ��Uploader�����ϴ�
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = upload.parseRequest(request);
			iter = items.iterator();
			// ����ÿ�����ؼ���Ӧ������
			while (iter.hasNext())
			{
				FileItem item = (FileItem)iter.next();
				// �����������ͨ����
				if (item.isFormField())
				{
					String name = item.getFieldName();
					if (name.equals("title"))
					{
						title = item.getString("gbk");
					}
				}
				// �������Ҫ�ϴ����ļ�
				else
				{
					String user = (String)request.getSession()
						.getAttribute("curUser");
					String serverFileName = null;
					// �����ļ���
					String fileName = item.getName();
					// ȡ���ļ���׺
					String suffix = fileName.substring(
						fileName.lastIndexOf("."));
					// �����ļ�����
					String contentType = item.getContentType();
					// ֻ�����ϴ�jpg��gif��pngͼƬ
					if (contentType.equals("image/pjpeg")
						|| contentType.equals("image/gif")
						|| contentType.equals("image/jpeg")
						|| contentType.equals("image/png"))
					{
						InputStream input = item.getInputStream();
						serverFileName =  UUID.randomUUID().toString();
						FileOutputStream output = new FileOutputStream(
							getServletContext().getRealPath("/")
							+ "uploadfiles\\" + serverFileName + suffix);
						byte[] buffer = new byte[1024];
						int len = 0;
						while((len = input.read(buffer)) > 0 )
						{
							output.write(buffer , 0 , len);
						}
						input.close();
						output.close();
						as.addPhoto(user , title , serverFileName + suffix);
						out.write("<script type='text/javascript'>"
							+ "parent.callback('��ϲ�㣬�ļ��ϴ��ɹ���')"
							+ "</script>");
					}
					else
					{
						out.write("<script type='text/javascript'>"
							+ "parent.callback('��ϵͳֻ�����ϴ�"
							+ "JPG��GIF��PNGͼƬ�ļ��������ԣ�')</script>");
					}
				}
			}
		}
		catch (FileUploadException fue)
		{
			fue.printStackTrace();
			out.write("<script type='text/javascript'>"
				+ "parent.callback('�����ϴ��ļ����ִ��������ԣ�')"
				+ "</script>");
		}
		catch (AlbumException ex)
		{
			ex.printStackTrace();
		}
	}
}