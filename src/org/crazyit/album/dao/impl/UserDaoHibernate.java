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
public class UserDaoHibernate extends BaseDaoHibernate4<User>
	implements UserDao
{
	/**
	 * 根据用户名查找用户
	 * @param name 需要查找的用户的用户名
	 * @return 查找到的用户
	 */
	public User findByName(String name)
	{
		List<User> users = find("select u from User u where u.name = ?0"
			, name);
		if (users != null && users.size() == 1)
		{
			return users.get(0);
		}
		return null;
	}
}
