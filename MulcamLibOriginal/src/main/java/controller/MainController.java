package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biz.book.service.BookService;

@Controller
public class MainController {
	
	@Autowired
	BookService service;
	
	@RequestMapping("/main/main.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("booklist", service.bookViewList());
		mav.setViewName("/main/main");
		return mav;
	}
	
	@RequestMapping("/about.do")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView();
		
		//mav.addObject("msg","Hello Spring MVC");
		mav.setViewName("/main/about");
		
		return mav;
	}
	
}
