package org.crazyit.album.domain;

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
public class Photo
{
	// ��ʶ����
	private Integer id;
	// ����Ƭ������
	private String title;
	// ��Ƭ�ڷ������ϵ��ļ���
	private String fileName;
	// �������Ƭ�������û�
	private User user;

	// �޲����Ĺ�����
	public Photo()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Photo(Integer id , String title
		, String fileName , User user)
	{
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.user = user;
	}

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// title��setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// fileName��setter��getter����
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileName()
	{
		return this.fileName;
	}

	// user��setter��getter����
	public void setUser(User user)
	{
		this.user = user;
	}
	public User getUser()
	{
		return this.user;
	}
}