package com.booking.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.dto.RsvDto;
import com.booking.service.RsvService;

@Controller
@RequestMapping("/reservation/**")
public class ReservationController {
	private static final Logger logger = LoggerFactory.getLogger(userController.class);

	@Autowired
	private RsvService service;

	@RequestMapping(value = "/rsv", method = RequestMethod.GET)
	public String goReservation() {
		return "reservation/reservation";
	}

	// 게시판 목록 보기
	@RequestMapping(value = "/seat", method = RequestMethod.GET)
	public String getSeat() throws Exception {
		return "reservation/reservation_seats";
	}

	@RequestMapping(value = "/seat", method = RequestMethod.POST)
	public String postSeat(@RequestParam("mt20id") String mt20id,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") String date,
			@RequestParam("location") String location, @RequestParam("time") String time,
			@RequestParam("title") String title, RsvDto rsvdto, Model model) throws Exception {

		List<String> seatsList = service.RsvSeats(mt20id, time, date);

		model.addAttribute("mt20id", mt20id);
		model.addAttribute("date", date);
		model.addAttribute("location", location);
		model.addAttribute("time", time);
		model.addAttribute("title", title);
		model.addAttribute("seatsList", seatsList);

		System.out.println(seatsList);
		return "reservation/reservation_seats";
	}

	@RequestMapping(value = "/payDetail", method = RequestMethod.POST)
	public String posPayDetail(@RequestParam("title") String title, @RequestParam("mt20id") String mt20id,
			@RequestParam("date") String date, @RequestParam("location") String location,
			@RequestParam("time") String time, @RequestParam("totalAmount") int totalAmount,
			@RequestParam("selectedSeats") String selectedSeats, @RequestParam("username") String username,
			@RequestParam("userid") String userid, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("mt20id", mt20id);
		model.addAttribute("date", date);
		model.addAttribute("location", location);
		model.addAttribute("time", time);
		model.addAttribute("totalAmount", totalAmount);
		model.addAttribute("selectedSeats", selectedSeats);
		model.addAttribute("username", username);
		model.addAttribute("userid", userid);
		return "reservation/pay_detail";
	}

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String PostPay(RsvDto rsv, Model model) throws Exception {
		service.RsvInsert(rsv);
		return "home";
	}

	@RequestMapping(value = "/readId", method = RequestMethod.GET)
	public String read(@RequestParam("userid") Integer userid, Model model) throws Exception {
		logger.info("reservation...reading...id..." + userid);
		List<RsvDto> rsv = service.getRsvId(userid);
		model.addAttribute("userid", userid);
		model.addAttribute("rsv", rsv);

		return "reservation/reservation_completed";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteRsv(@RequestParam("userid") Integer userid,
			@RequestParam("re_selectedSeats") List<String> re_selectedSeats,
			@RequestParam("re_mt20id") String re_mt20id) throws Exception {
		System.out.println("userid:" + userid + " selectedSeats:" + re_selectedSeats + " mt20id:" + re_mt20id);
		service.deleteRsv(userid, re_selectedSeats, re_mt20id);
		System.out.println("completely delete");
		return "redirect:/reservation/readId?userid=" + userid;
	}

}
