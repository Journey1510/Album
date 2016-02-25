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
	 * 查询属于指定用户的相片，且进行分页控制
	 * @param user 查询相片所属的用户
	 * @param pageNo 需要查询的指定页
	 * @return 查询到的相片
	 */
	public List<Photo> findByUser(User user , int pageNo)
	{
		//返回分页查询的结果
		return (List<Photo>)findByPage("select b from Photo b where "
			+ "b.user = ?0" , pageNo , PAGE_SIZE , user);
	}
}