package org.crazyit.album.exception;

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
public class AlbumException extends RuntimeException
{
	//提供一个无参数的构造器
	public AlbumException()
	{
	}
	//提供一个带字符串参数的构造器
	public AlbumException(String msg)
	{
		super(msg);
	}
}
