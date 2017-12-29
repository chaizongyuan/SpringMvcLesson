package cn.et.springmvc.lesson03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModeController {
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map) throws Exception{
		map.put("sex", "girl");
		return "/lesson03/res.jsp";
	}
	
	
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2(Map map) throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/lesson03/res.jsp");
		mav.addObject("sex", "boy");
		return mav;
	}
	
}
