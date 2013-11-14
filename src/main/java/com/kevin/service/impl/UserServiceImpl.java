package com.kevin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kevin.dao.UserDao;
import com.kevin.entity.CntUser;
import com.kevin.entity.User;
import com.kevin.mapper.CntUserMapper;
import com.kevin.mapper.UserMapper;
import com.kevin.page.Page;
import com.kevin.service.UserService;
import com.kevin.utils.HandlerResult;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Resource
	private UserMapper userMapper;

	@Resource
	private CntUserMapper cntUserMapper;

/*	public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public int countAll() {
        return userDao.countAll();
    }
    public List<User> getUsers(Page page){
    	return userMapper.getUsers(page);
    }

    public int countCntAll() {
    	return cntUserMapper.countAll();
    }
    public List<CntUser> getCntUsers(Page page) {
    	return cntUserMapper.getCntUsers(page);
	}

    /**
	 * 采用本地线程的方式分页
	 * @return
	 */
	public HandlerResult list(){

		HandlerResult rs = new HandlerResult();

		//rs.setResultObj(userMapper.getUsers());

		return rs;
	}

}
