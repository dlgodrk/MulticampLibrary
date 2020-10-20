package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import biz.book.dao.BookDAO;
import biz.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	@RequestMapping("/booklist.do")
	public String board(HttpServletRequest request) {	
		String library = request.getParameter("library");
		String option = request.getParameter("option");
		String target = request.getParameter("target");
		HttpSession session = request.getSession();
		session.setAttribute("library",library);
		session.setAttribute("option",option);
		session.setAttribute("target",target);
		request.setAttribute("booklist", service.getBookList(library,option, target));
		return "/book/book_list";
	}
	
	@RequestMapping(value = "/book.do", method = RequestMethod.GET)
	public ModelAndView book(int bookKey,int check) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", service.getBook(bookKey));
		mav.addObject("check",check);
		mav.setViewName("/book/book_view");
		return mav;
	}
}