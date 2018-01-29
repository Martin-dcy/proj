package priv.dcy.html.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import priv.dcy.html.dao.UserDao;
import priv.dcy.html.pojo.User;
import priv.dcy.html.service.UserService;

@Service 
@Transactional  
public class UserServiceImpl implements UserService{  
    // 注入dao接口实现类实例  
    // @Resource、@Autowired两种注入方式都可以  
	@Autowired(required=true)
    public UserDao userDao;  
	@Override
    public boolean getUser(String username,String password) { 

        User user = userDao.getUser(username,password);
        if(user != null ) {
        	return true;
        }
        return false;
    }
	
	@Override
	public String getUsersAll() {
		List<User> userList = userDao.getUsersAll();
        JSONArray listArray=JSONArray.fromObject(userList);
		return listArray.toString();
	}  
}
 
