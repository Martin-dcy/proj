package priv.dcy.html.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import priv.dcy.html.pojo.User;
@Repository("userDao")
public interface UserDao {  
	public User getUser(@Param("username")String username,@Param("password")String password);
	public List<User> getUsersAll();  
}  
