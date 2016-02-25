package org.crazyit.album.dao;

import java.util.*;

import org.crazyit.album.domain.*;
import org.crazyit.common.dao.*;


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
public interface UserDao extends BaseDao<User>
{
	/**
	 * 根据用户名查找用户
	 * @param name 需要查找的用户的用户名
	 * @return 查找到的用户
	 */
	User findByName(String name);
}
