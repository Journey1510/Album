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
public interface PhotoDao extends BaseDao<Photo>
{
	//以常量控制每页显示的相片数  ++++++
	final int PAGE_SIZE = 3;
	/**
	 * 查询属于指定用户的相片，且进行分页控制
	 * @param user 查询相片所属的用户
	 * @param pageNo 需要查询的指定页
	 * @return 查询到的相片
	 */
	List<Photo> findByUser(User user , int pageNo);
}
