package com.drug.ex;


import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drug.dto.CartDto;
import com.drug.service.ICartService;
import com.drug.service.IOrderService;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/member/*")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private ICartService cartService;
	@Autowired
	private IOrderService orderService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/cart/insert", method = RequestMethod.POST)
	public String insertData(CartDto dto1, Authentication at) throws Exception {
		
		if(at!=null) {
		System.out.println(dto1);
		List<CartDto> dtos = cartService.checkCart(dto1.getPn(),dto1.getId());
		System.out.println(dtos);
		if(dto1.getId().equals(null)) {			
			return "/login/login";
		}
		else {
			if (dtos.size() != 0) {
				System.out.println("update");
				cartService.update(dto1);
			} else {
				cartService.insert(dto1);
			}
		}
		return "redirect:/member/cart/selectAll";
		}else {
			return "/login/login";
		}
	}

	@RequestMapping(value = "/cart/selectAll", method = RequestMethod.GET)
	public String home(Model model, Authentication at) throws Exception {
		System.out.println("selectAll");
		String authority = "";
		if (at != null) {
			authority = at.getAuthorities().toString();
		} else {
			return "/login/login";
		}
		System.out.println(authority);
		
		if(authority.equals("[MEMBER]")||authority.equals("[VIP]")) {
		UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)at;
		String id = upat.getName();
		model.addAttribute("id", id);
		List<CartDto> dto=cartService.selectId(id);
		model.addAttribute("list",dto);
		
		
		
		
		
		return "/member/cart";
		}else if(authority.equals("[ADMIN]")) {
			List<CartDto> dto=cartService.selectAll();
			model.addAttribute("list",dto);
			return "/admin/cart";
		}
		return"/login/login";
	}

	@RequestMapping(value= "/cart/selectId", method = RequestMethod.GET)
	public String selectId(Model model, String id) throws Exception{
		System.out.println(id);
		List<CartDto> dto=cartService.selectId(id);
		System.out.println(dto);
		model.addAttribute("list",dto);
		return "/member/cartDetail";
	}

	
	@ResponseBody
	@RequestMapping(value = "/cart/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, @RequestParam(value="arr[]")List<String> cn, RedirectAttributes rttr) throws Exception {
//		if(request.getParameter("cn")!=null) {
//		System.out.println( request.getParameter("cn"));
//		}
		System.out.println("delete");
		System.out.println(cn);
//		String[] deleteList = cn.split(",");
		
		cartService.delete(cn);
//		List<CartDto> dto=cartService.selectAll();
//		model.addAttribute("list",dto);
		rttr.addFlashAttribute("msg", "deleteSuccess");
		return "redirect:/member/cart/selectAll";

	}

	@RequestMapping(value = "/cart/deleteAll", method = RequestMethod.GET)
	public String deleteAll(Model model, String id, RedirectAttributes rttr) throws Exception {
		System.out.println("deleteAll");
		cartService.deleteAll(id);
		List<CartDto> dto = cartService.selectAll();		
//		model.addAttribute("list",dto);
		model.addAttribute("id", dto);
		rttr.addFlashAttribute("msg", "deleteSuccess");
		return "redirect:/selectAll";
	}

	@RequestMapping(value = "/cart/mypage", method = RequestMethod.GET)
	public String test(Model model) throws Exception {
		System.out.println("test");
		return "/member/mypage";
	}
	

}