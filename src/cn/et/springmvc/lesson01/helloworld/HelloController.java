package cn.et.springmvc.lesson01.helloworld;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	@RequestMapping("/test")
	public String index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().println("hello springmvc"+request.getParameter("id"));
		return null;
	}
	
	@RequestMapping("/param")
	public String param(User user,HttpServletResponse response) throws IOException{
		response.getWriter().println(user.getId()+"=="+user.getName());
		return null;
	}
	@RequestMapping("/mvc")
	public String mvc(HttpServletRequest request) throws IOException{
		request.setAttribute("name", "zs");
		return "/index.jsp";
	}
}
