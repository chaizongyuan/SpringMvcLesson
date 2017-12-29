package cn.et.springmvc.lesson03.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.et.springmvc.lesson01.helloworld.User;
@SessionAttributes("user")
@Controller
public class SessionController {
	
	@ModelAttribute("user")
	public User getUser(){
		User user = new User();
		return user;
	}

	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user) throws Exception{
		return "redirect:/s2";
	}
	
	
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(Map map,HttpServletResponse res,SessionStatus sessionStatus) throws Exception{
		User user=(User)map.get("user");
		res.getWriter().println(user.getId());
		sessionStatus.setComplete();
		return null;
	}
	
}
