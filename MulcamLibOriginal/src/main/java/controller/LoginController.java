package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import biz.user.service.UserService;
import biz.user.vo.UserVO;


@Controller
public class LoginController {
	
	@Autowired
	UserService service;
	
//	@RequestMapping("/jsonlist.do")
//	@ResponseBody
//	public List<UserVO> jsonlist() {
//		return service.getUserList();
//	}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(@RequestParam("userid") String id,
			                @RequestParam("userpwd") String pw, 
			                HttpServletRequest req) {
		System.out.println(id+":"+pw); 
		UserVO vo =  service.login(id, pw);
		System.out.println("로그인 : "+vo);
		HttpSession session = req.getSession();
		
		if(vo != null) {
		    session.setAttribute("login", vo);
		    session.setAttribute("user", vo);
		    session.setAttribute("id", vo.getUserid());
		    //return "redirect:user/list.do";
		    return "redirect:index.jsp";
		}else {
			req.setAttribute("msg","로그인 실패");
			return "login/login";
		}
		
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/signup.do")
	public String signup(HttpServletRequest req) {
		req.getSession().invalidate();
		
		return "login/signup";
	}
	
	
	@RequestMapping("/userlist.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users",service.getUserList());
		mav.setViewName("user/user_list");
		return mav;
	}
	
	@RequestMapping(value = "/idcheck.do", method = RequestMethod.POST)
	@ResponseBody
	public int idcheck(String userid) {
		System.out.println(userid + "  id_check.do");
		int result = 0;
		UserVO vo = service.getUser(userid);
		System.out.println(vo);
		if(vo != null) {
			result = 1;
			
		}else {
			System.out.println("아이디 사용 가능");
		}
		
		return result;
		
	}
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signUser(UserVO vo) throws Exception{
		System.out.println(vo);
		service.addUser(vo);
		return "redirect:/main/main.do";
	}
}








