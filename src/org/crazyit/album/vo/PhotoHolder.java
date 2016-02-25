package org.crazyit.album.vo;

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
public class PhotoHolder
{
	//��Ƭ������
	private String title;
	//��Ƭ�ڷ������ϵ��ļ���
	private String fileName;

	//�޲����Ĺ�����
	public PhotoHolder()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public PhotoHolder(String title , String fileName)
	{
		this.title = title;
		this.fileName = fileName;
	}

	//title���Ե�setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	//fileName���Ե�setter��getter����
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileName()
	{
		return this.fileName;
	}
}