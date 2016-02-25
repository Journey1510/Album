package org.crazyit.album.service.impl;

import org.crazyit.album.domain.*;
import org.crazyit.album.service.*;
import org.crazyit.album.exception.*;
import org.crazyit.album.dao.*;
import org.crazyit.album.vo.*;

import java.util.*;

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
public class AlbumServiceImpl implements AlbumService
{
	//ҵ���߼������������2��DAO���
	private UserDao ud = null;
	private PhotoDao  pd = null;
	//����ע��2��DAO��������setter����
	public void setUserDao(UserDao ud)
	{
		this.ud = ud;
	}
	public void setPhotoDao(PhotoDao pd)
	{
		this.pd = pd;
	}

	/**
	 * ��֤�û���¼�Ƿ�ɹ���
	 * @param name ��¼���û���
	 * @param pass ��¼������
	 * @return �û���¼�Ľ�����ɹ�����true�����򷵻�false
	 */
	public boolean userLogin(String name , String pass)
	{
		try
		{
			//ʹ��UserDao�����û�����ѯ�û�
			User u = ud.findByName(name);
			if (u != null && u.getPass().equals(pass))
			{
				return true;
			}
			return false;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new AlbumException("�����û���¼�����쳣��");
		}
	}

	/**
	 * ע�����û�
	 * @param name ��ע���û����û���
	 * @param pass ��ע���û�������
	 * @return ��ע���û�������
	 */
	public int registUser(String name , String pass)
	{
		try
		{
			//����һ���µ�Userʵ��
			User u = new User();
			u.setName(name);
			u.setPass(pass);
			//�־û�User����
			ud.save(u);
			return u.getId();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new AlbumException("���û�ע������쳣��");
		}
	}

	/**
	 * �����Ƭ
	 * @param user �����Ƭ���û�
	 * @param title �����Ƭ�ı���
	 * @param fileName ������Ƭ�ڷ������ϵ��ļ���
	 * @return �������Ƭ������
	 */
	public int addPhoto(String user , String title  , String fileName)
	{
		try
		{
			//����һ���µ�Photoʵ��
			Photo p = new Photo();
			p.setTitle(title);
			p.setFileName(fileName);
			p.setUser(ud.findByName(user));
			//�־û�Photoʵ��
			pd.save(p);
			return p.getId();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new AlbumException("�����Ƭ�����г����쳣��");
		}
	}

	/**
	 * �����û���ø��û���������Ƭ
	 * @param user ��ǰ�û�
	 * @param pageNo ҳ��
	 * @return �������ڸ��û���ָ��ҳ����Ƭ
	 */
	public List<PhotoHolder> getPhotoByUser(String user , int pageNo)
	{
		try
		{
			List<Photo> pl = pd.findByUser(ud.findByName(user) , pageNo);
			List<PhotoHolder> result = new ArrayList<PhotoHolder>();
			for (Photo p : pl )
			{
				result.add(new PhotoHolder(p.getTitle() , p.getFileName()));
			}
			return result;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new AlbumException("��ѯ��Ƭ�б�Ĺ����г����쳣��");
		}
	}

	/**
	 * ��֤�û����Ƿ���ã������ݿ����Ƿ��Ѿ����ڸ��û���
	 * @param name ��ҪУ����û���
	 * @return ������û������ã�����true�����򷵻�false��
	 */
	public boolean validateName(String name)
	{
		try
		{
			//�����û�����ѯ��Ӧ��Userʵ��
			User u = ud.findByName(name);
			if (u != null)
			{
				return false;
			}
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new AlbumException("��֤�û����Ƿ���ڵĹ����г����쳣��");
		}
	}
}