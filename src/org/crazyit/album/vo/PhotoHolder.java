package org.crazyit.album.vo;

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
public class PhotoHolder
{
	//相片的名称
	private String title;
	//相片在服务器上的文件名
	private String fileName;

	//无参数的构造器
	public PhotoHolder()
	{
	}
	//初始化全部属性的构造器
	public PhotoHolder(String title , String fileName)
	{
		this.title = title;
		this.fileName = fileName;
	}

	//title属性的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	//fileName属性的setter和getter方法
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileName()
	{
		return this.fileName;
	}
}