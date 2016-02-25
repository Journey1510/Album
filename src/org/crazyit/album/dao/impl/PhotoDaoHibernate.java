package org.crazyit.album.dao.impl;

import java.util.*;

import org.crazyit.album.domain.*;
import org.crazyit.album.dao.*;
import org.crazyit.common.dao.impl.*;

/**
 * Description:
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class PhotoDaoHibernate extends BaseDaoHibernate4<Photo>
	implements PhotoDao
{
	/**
	 * ��ѯ����ָ���û�����Ƭ���ҽ��з�ҳ����
	 * @param user ��ѯ��Ƭ�������û�
	 * @param pageNo ��Ҫ��ѯ��ָ��ҳ
	 * @return ��ѯ������Ƭ
	 */
	public List<Photo> findByUser(User user , int pageNo)
	{
		//���ط�ҳ��ѯ�Ľ��
		return (List<Photo>)findByPage("select b from Photo b where "
			+ "b.user = ?0" , pageNo , PAGE_SIZE , user);
	}
}