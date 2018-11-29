package org.crazyit.album.dao;

import java.util.*;

import org.crazyit.album.domain.*;
import org.crazyit.common.dao.*;

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
public interface PhotoDao extends BaseDao<Photo>
{
	//�Գ�������ÿҳ��ʾ����Ƭ��  ++++++
	final int PAGE_SIZE = 3;
	/**
	 * ��ѯ����ָ���û�����Ƭ���ҽ��з�ҳ����
	 * @param user ��ѯ��Ƭ�������û�
	 * @param pageNo ��Ҫ��ѯ��ָ��ҳ
	 * @return ��ѯ������Ƭ
	 */
	List<Photo> findByUser(User user , int pageNo);
}
