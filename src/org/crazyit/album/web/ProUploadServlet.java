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
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
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
		// 获取输出流
		PrintWriter out = response.getWriter();
		try
		{
			// 使用Uploader处理上传
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = upload.parseRequest(request);
			iter = items.iterator();
			// 遍历每个表单控件对应的内容
			while (iter.hasNext())
			{
				FileItem item = (FileItem)iter.next();
				// 如果该项是普通表单域
				if (item.isFormField())
				{
					String name = item.getFieldName();
					if (name.equals("title"))
					{
						title = item.getString("gbk");
					}
				}
				// 如果是需要上传的文件
				else
				{
					String user = (String)request.getSession()
						.getAttribute("curUser");
					String serverFileName = null;
					// 返回文件名
					String fileName = item.getName();
					// 取得文件后缀
					String suffix = fileName.substring(
						fileName.lastIndexOf("."));
					// 返回文件类型
					String contentType = item.getContentType();
					// 只允许上传jpg、gif、png图片
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
							+ "parent.callback('恭喜你，文件上传成功！')"
							+ "</script>");
					}
					else
					{
						out.write("<script type='text/javascript'>"
							+ "parent.callback('本系统只允许上传"
							+ "JPG、GIF、PNG图片文件，请重试！')</script>");
					}
				}
			}
		}
		catch (FileUploadException fue)
		{
			fue.printStackTrace();
			out.write("<script type='text/javascript'>"
				+ "parent.callback('处理上传文件出现错误，请重试！')"
				+ "</script>");
		}
		catch (AlbumException ex)
		{
			ex.printStackTrace();
		}
	}
}