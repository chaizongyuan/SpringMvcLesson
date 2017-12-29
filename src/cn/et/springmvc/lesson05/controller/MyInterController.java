package cn.et.springmvc.lesson05.controller;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson05.service.InterceptorService;

@Controller
public class MyInterController {
	
	
	@RequestMapping(value="/interceptor")
	public String mid(OutputStream os) throws Exception{
		os.write("hello".getBytes());
		return null;
	}
	
	/**
	 * תǮքaction
	 */
	@Autowired
	InterceptorService service;
	@RequestMapping(value="/tm",method=RequestMethod.GET)
	public String transMoney(Integer money,OutputStream os) throws Exception{
		service.updateMoney(money);
		os.write(("lostedmoney is:"+service.selectMoney()).getBytes());
		return null;
	}
}
