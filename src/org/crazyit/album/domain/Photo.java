package org.crazyit.album.domain;

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
public class Photo
{
	// 标识属性
	private Integer id;
	// 该相片的名称
	private String title;
	// 相片在服务器上的文件名
	private String fileName;
	// 保存该相片所属的用户
	private User user;

	// 无参数的构造器
	public Photo()
	{
	}
	// 初始化全部成员变量的构造器
	public Photo(Integer id , String title
		, String fileName , User user)
	{
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.user = user;
	}

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// title的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// fileName的setter和getter方法
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileName()
	{
		return this.fileName;
	}

	// user的setter和getter方法
	public void setUser(User user)
	{
		this.user = user;
	}
	public User getUser()
	{
		return this.user;
	}
}