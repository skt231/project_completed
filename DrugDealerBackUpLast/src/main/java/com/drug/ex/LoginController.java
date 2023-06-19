package com.drug.ex;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drug.dto.UsersDto;
import com.drug.service.IUsersService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/login/*")
public class LoginController {

	@Autowired
	private IUsersService service;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String register() throws Exception {
		return "/login/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String register(UsersDto userDto, RedirectAttributes rttr) throws Exception {
		service.insert(userDto);
		service.insertAuthority(userDto);
		rttr.addFlashAttribute("msg", "create success");
		return "redirect:/login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin() {
		return "/login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(RedirectAttributes rttr, HttpServletRequest sr) throws Exception {
		String id=sr.getParameter("id");
		String pw=sr.getParameter("pw");
		System.out.println(id);
		if(id.equals("admin")) {
			if(pw.equals("admin")) {
				return "redirect:/admin/selectAll";
			}
		}
		return "redirect:/selectAll";
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String userLogout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		return "redirect:/";
//		return "redirect:/selectAll";
	}
	
}