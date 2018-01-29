package priv.dcy.html.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import priv.dcy.html.pojo.User;
import priv.dcy.html.service.UserService;
  
@Controller  
@RequestMapping("/user")  
public class IndexController { 
	
	// 注入userService 对象  
    @Autowired 
    private UserService userService;
    
	@RequestMapping("/index") 
    public String index(){  
        return "login"; 
    }
	
	@RequestMapping("/test") 
    public String test(){  
		return "test";
    }
	
	@RequestMapping("/getAllUsers")
	@ResponseBody
    public String getAllUsers(){  
		return userService.getUsersAll(); 

    }
	
	@RequestMapping("/main") 
    public String main(){  
		return "main";   
    }
	
	@RequestMapping("/login") 
	@ResponseBody
    public int login(HttpServletRequest request,HttpServletResponse resp){ 
		String username = String.valueOf(request.getParameter("username"));
		String password = String.valueOf(request.getParameter("password"));
		boolean flag = userService.getUser(username,password);
		int loginMessage = 0;
		if (flag == false) {
			loginMessage = 0;
		} else {
			loginMessage = 1;
		}
		return loginMessage;
		
    }
}
