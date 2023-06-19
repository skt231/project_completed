package com.drug.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drug.dto.NoticeDto;
import com.drug.service.INoticeService;
import com.drug.vo.PageMaker;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private INoticeService ns;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(PageMaker pm, Model model) throws Exception {
		logger.info("listPage");
		System.out.println("--list pm " + pm);
		model.addAttribute("list", ns.listSearchCriteria(pm));
		pm.setTotalCount(ns.listSearchCount(pm));
		// model.addAttribute("pageMaker",pm);
		// return "qna/list";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void writeGet() throws Exception {
		

	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(NoticeDto notice, RedirectAttributes rttr) throws Exception {
		ns.write(notice);
		// rttr.addAttribute("msg","success");
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/notice/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, PageMaker pm, Model model) throws Exception {
		System.out.println("-----read pm" + pm);
		ns.viewCount(bno);
		model.addAttribute("list_read", ns.read(bno));
		System.out.println("test.......");
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") int bno, PageMaker pm, Model model, RedirectAttributes rttr)
			throws Exception {
		ns.remove(bno);
		rttr.addAttribute("page", pm.getPage());
		rttr.addAttribute("perPageNum", pm.getPerPageNum());
		rttr.addAttribute("searchType", pm.getSearchType());
		rttr.addAttribute("keyword", pm.getKeyword());
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/notice/list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGet(@RequestParam("bno") int bno, @RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("writer") String writer, PageMaker pm, Model model)
			throws Exception {
		System.out.println(pm);
		model.addAttribute("bno", bno);
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("writer", writer);
		

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(NoticeDto qna, PageMaker pm, Model model, RedirectAttributes rttr) throws Exception {
		ns.modify(qna);
		
		
		System.out.println(pm);

		rttr.addAttribute("page", pm.getPage());
		rttr.addAttribute("perPageNum", pm.getPerPageNum());
		rttr.addAttribute("searchType", pm.getSearchType());
		rttr.addAttribute("keyword", pm.getKeyword());
		rttr.addFlashAttribute("msg", "success");
	
		return "redirect:/notice/list";
	}

}
