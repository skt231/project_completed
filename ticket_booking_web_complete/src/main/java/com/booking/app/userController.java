package com.booking.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.booking.dto.userDto;
import com.booking.service.userService;

@Controller
@RequestMapping("/user/**")
public class userController {
	private static final Logger logger = LoggerFactory.getLogger(userController.class);
	@Autowired
	private userService service;

	@RequestMapping(value = "/linkRegister", method = RequestMethod.GET)
	public String registerUserGet() throws Exception {
		logger.info("register get user...");
		return "/user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerUserGet(userDto user, Model model) throws Exception {
		logger.info("register get user...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUserPost(userDto user, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("register post user");
		logger.info(user.getUsername());
		service.addUser(user);
		service.getAuthority(user.getUsername(), "ROLE_USER");
		logger.info(user.getUsername());
		rttr.addFlashAttribute("msg", "success");
		return "home";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		logger.info("show all list...");
		model.addAttribute("users", service.getAllUsers());
		return "/user/userList";
	}

	@RequestMapping(value = "/userDetailed", method = RequestMethod.GET)
	public void read(@RequestParam("id") int id, Model model) throws Exception {

		logger.info("read......" + id);
		userDto user = service.getUserById(id);
		model.addAttribute("user", user);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("id") int id, RedirectAttributes rttr) throws Exception {
		service.deleteUser(id);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/user/listAll";
	}

	@RequestMapping(value = "/userModify", method = RequestMethod.GET)
	public void modifyGET(int id, Model model) throws Exception {
		logger.info("mod GET..." + id);
		model.addAttribute(service.getUserById(id));
	}

	@RequestMapping(value = "/userModify", method = RequestMethod.POST)
	public String modifyPOST(userDto user, RedirectAttributes rttr, Model model) throws Exception {
		logger.info("mod post..." + user);
		service.updateUser(user);
		model.addAttribute("user", user);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() throws Exception {
		return "/user/login";
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * loginUserPOST(userDto userses, String username, String password,
	 * HttpServletRequest request, RedirectAttributes rttr) throws Exception {
	 * userses = service.loginUser(username, password);
	 * 
	 * if (userses != null) { // 로그인 성공 System.out.println(userses); HttpSession
	 * session = request.getSession(); session.setAttribute("userses", userses);
	 * return "redirect:/"; // 로그인 성공 시 대시보드 페이지로 이동 } else { // 로그인 실패
	 * rttr.addFlashAttribute("msg", "failure"); return "redirect:/user/login"; //
	 * 로그인 실패 시 홈 페이지로 리다이렉트 } }
	 */

	/*
	 * @RequestMapping(value = "/dashboard", method = RequestMethod.GET) public
	 * String dashboardPage() throws Exception { return "/dashboard"; // JSP 파일명
	 * (확장자 없이) }
	 */

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		/*
		 * // 세션에서 사용자 정보 삭제 HttpSession session = request.getSession();
		 * session.removeAttribute("userses");
		 * 
		 * // 로그아웃 후 홈 페이지로 리다이렉트
		 */ return "redirect:/";
	}
}
