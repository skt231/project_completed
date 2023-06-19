package com.drug.ex;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drug.dto.CartDto;
import com.drug.dto.DrugDto;
import com.drug.dto.OrderDto;
import com.drug.dto.OrderPageDto;
import com.drug.service.ICartService;
import com.drug.service.IDrugService;
import com.drug.service.IOrderService;

@Controller
public class OrderController {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IDrugService drugService;	
	@Autowired
	private ICartService cartService;
	
	@RequestMapping(value = "/order/insert", method = RequestMethod.GET)
	public String insert() throws Exception{
		return "order/insert";
	}
	@RequestMapping(value = "/order/insert", method = RequestMethod.POST)
	public String insertData(OrderDto dto,RedirectAttributes rttr) throws Exception{
		System.out.println(dto);
		if(dto.getId().equals(null)) {
			return "redirect:/login/login";
		}
		orderService.insert(dto);		
		rttr.addFlashAttribute("msg","success");
		return "redirect:/order/selectAll";
	}
	@RequestMapping(value = "/order/insertCheck", method = RequestMethod.POST)
	public String insertData_Check(OrderPageDto dto,RedirectAttributes rttr,Model model) throws Exception{		

		for(int i = 0;i<dto.getOrders().size();i++) {
			System.out.println(dto.getOrders().get(i));
			orderService.insert(dto.getOrders().get(i));			
		}
		cartService.deleteAll(dto.getOrders().get(0).getId());
		rttr.addFlashAttribute("msg","success");
		return "redirect:/order/selectAll";
	}
	@RequestMapping(value = "/order/selectAll", method = RequestMethod.GET)
	public String SelectAll(Model model,Authentication at) throws Exception{
		System.out.println("selectAll");
		String authority = "";
		if (at != null) {
			authority = at.getAuthorities().toString();
		} else {
			return "/login/login";
		}
		System.out.println(authority);
		if (authority.equals("[MEMBER]")||authority.equals("[VIP]")) {
			UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)at;
			String id = upat.getName();
			model.addAttribute("id", id);
			ArrayList<OrderDto> dto = orderService.selectId(id);
			model.addAttribute("list", dto);
			return "/member/buy";
		} 
		else if (authority.equals("[ADMIN]")) {
			List<OrderDto> dto = orderService.selectAll();
			model.addAttribute("list", dto);
			return "/admin/buy";
		}
		return "/login/login";
	}
	@RequestMapping(value="/order/selectId",method=RequestMethod.GET)
	public String SelectId(Model model,String id) throws Exception{
		System.out.println("selectId");
		ArrayList<OrderDto> dtos=orderService.selectId(id);
		System.out.println(dtos);		
		model.addAttribute("list",dtos);
		return "buy";
	}
	@RequestMapping(value="/order/selectOne",method=RequestMethod.GET)
	public String SelectId(Model model,int pn) throws Exception{
		System.out.println("selectOne");
		OrderDto dto=orderService.selectOne(pn);
		System.out.println(dto);		
		model.addAttribute("dto",dto);
		return "buy_one";
	}
	@RequestMapping(value="/order/select_pay",method=RequestMethod.GET)
	public String Select_pay(Model model,String id) throws Exception{
		System.out.println("select_pay");
		ArrayList<OrderDto> dtos=orderService.select_pay(id);
		System.out.println(dtos);		
		model.addAttribute("list",dtos);
		return "/member/buy";
	}
	@RequestMapping(value = "/order/delete", method = RequestMethod.GET)
	public String delete(OrderDto dto) throws Exception{
		System.out.println("delete");
		ArrayList<OrderDto> dtos=orderService.selectAll();
		
		for(int i =0;i<dtos.size();i++) {
			System.out.println(dtos.get(i));
			drugService.update_inventory(dtos.get(i).getInventory()-dtos.get(i).getQuantity(), dtos.get(i).getPn());
			orderService.update_pay(dtos.get(i).getOdnum());
		}		
		return "redirect:/order/selectAll";
	}
	@RequestMapping(value = "/order/delete_one", method = RequestMethod.POST)
	public String delete_one(OrderDto dto) throws Exception{
		System.out.println("delete");
		orderService.delete(dto.getOdnum());		
		return "redirect:/order/selectAll";
	}
	@RequestMapping(value = "/order/update",method = RequestMethod.GET)
	public String update(OrderDto dto) {
		System.out.println(dto);
		return "redirect:/order/update";
	}
	@RequestMapping(value = "/order/update_drug",method = RequestMethod.POST)
	public String update_inventory(DrugDto dto) throws Exception {
		System.out.println(dto);
		drugService.update(dto);		
		return "redirect:/selectAll";
	}
	@RequestMapping(value = "/order/update", method = RequestMethod.POST)
	public String updateDB(int odnum) throws Exception{
		System.out.println("update");
		OrderDto dto= orderService.select_dt(odnum);
		Character dt = dto.getDt();
		if(dt.equals('x')) {
			dt='o';			
		}else {
			dt='x';					
		}
		System.out.println(dt);
		orderService.update(odnum, dt);
		return "redirect:/order/selectAll";
	}
}
