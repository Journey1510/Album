package org.crazyit.album.service;

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
public interface AlbumService
{
	/**
	 * ��֤�û���¼�Ƿ�ɹ���
	 * @param name ��¼���û���
	 * @param pass ��¼������
	 * @return �û���¼�Ľ�����ɹ�����true�����򷵻�false
	 */
	boolean userLogin(String name , String pass);

	/**
	 * ע�����û�
	 * @param name ��ע���û����û���
	 * @param pass ��ע���û�������
	 * @return ��ע���û�������
	 */
	int registUser(String name , String pass);


	/**
	 * �����Ƭ
	 * @param user �����Ƭ���û�
	 * @param title �����Ƭ�ı���
	 * @param fileName ������Ƭ�ڷ������ϵ��ļ���
	 * @return �������Ƭ������
	 */
	int addPhoto(String user , String title  , String fileName);

	/**
	 * �����û���ø��û���������Ƭ
	 * @param user ��ǰ�û�
	 * @param pageNo ҳ��
	 * @return �������ڸ��û���ָ��ҳ����Ƭ
	 */
	List<PhotoHolder> getPhotoByUser(String user , int pageNo);

	/**
	 * ��֤�û����Ƿ���ã������ݿ����Ƿ��Ѿ����ڸ��û���
	 * @param name ��ҪУ����û���
	 * @return ������û������ã�����true�����򷵻�false��
	 */
	boolean validateName(String name);
}
