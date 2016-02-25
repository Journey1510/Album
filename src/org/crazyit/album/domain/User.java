package org.crazyit.album.domain;

import java.util.Set;
import java.util.HashSet;

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
public class User
{
	// 标识属性
	private Integer id;
	// 该用户的用户名
	private String name;
	// 该用户的密码
	private String pass;
	// 使用Set保存该用户关联的相片
	private Set<Photo> photos
		= new HashSet<Photo>();

	// 无参数的构造器
	public User()
	{
	}
	// 初始化全部成员变量的构造器
	public User(Integer id , String name , String pass)
	{
		this.id = id;
		this.name = name;
		this.pass = pass;
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

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// pass的setter和getter方法
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	// photos的setter和getter方法
	public void setPhotos(Set<Photo> photos)
	{
		this.photos = photos;
	}
	public Set<Photo> getPhotos()
	{
		return this.photos;
	}
}