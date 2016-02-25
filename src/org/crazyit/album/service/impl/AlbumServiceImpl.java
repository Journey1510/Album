package org.crazyit.album.service.impl;

import org.crazyit.album.domain.*;
import org.crazyit.album.service.*;
import org.crazyit.album.exception.*;
import org.crazyit.album.dao.*;
import org.crazyit.album.vo.*;

import java.util.*;

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
public class AlbumServiceImpl implements AlbumService
{
	//业务逻辑组件所依赖的2个DAO组件
	private UserDao ud = null;
	private PhotoDao  pd = null;
	//依赖注入2个DAO组件所需的setter方法
	public void setUserDao(UserDao ud)
	{
		this.ud = ud;
	}
	public void setPhotoDao(PhotoDao pd)
	{
		this.pd = pd;
	}

	/**
	 * 验证用户登录是否成功。
	 * @param name 登录的用户名
	 * @param pass 登录的密码
	 * @return 用户登录的结果，成功返回true，否则返回false
	 */
	public boolean userLogin(String name , String pass)
	{
		try
		{
			//使用UserDao根据用户名查询用户
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
			throw new AlbumException("处理用户登录出现异常！");
		}
	}

	/**
	 * 注册新用户
	 * @param name 新注册用户的用户名
	 * @param pass 新注册用户的密码
	 * @return 新注册用户的主键
	 */
	public int registUser(String name , String pass)
	{
		try
		{
			//创建一个新的User实例
			User u = new User();
			u.setName(name);
			u.setPass(pass);
			//持久化User对象
			ud.save(u);
			return u.getId();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new AlbumException("新用户注册出现异常！");
		}
	}

	/**
	 * 添加照片
	 * @param user 添加相片的用户
	 * @param title 添加相片的标题
	 * @param fileName 新增相片在服务器上的文件名
	 * @return 新添加相片的主键
	 */
	public int addPhoto(String user , String title  , String fileName)
	{
		try
		{
			//创建一个新的Photo实例
			Photo p = new Photo();
			p.setTitle(title);
			p.setFileName(fileName);
			p.setUser(ud.findByName(user));
			//持久化Photo实例
			pd.save(p);
			return p.getId();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new AlbumException("添加相片过程中出现异常！");
		}
	}

	/**
	 * 根据用户获得该用户的所有相片
	 * @param user 当前用户
	 * @param pageNo 页码
	 * @return 返回属于该用户、指定页的相片
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
			throw new AlbumException("查询相片列表的过程中出现异常！");
		}
	}

	/**
	 * 验证用户名是否可用，即数据库里是否已经存在该用户名
	 * @param name 需要校验的用户名
	 * @return 如果该用户名可用，返回true，否则返回false。
	 */
	public boolean validateName(String name)
	{
		try
		{
			//根据用户名查询对应的User实例
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
			throw new AlbumException("验证用户名是否存在的过程中出现异常！");
		}
	}
}