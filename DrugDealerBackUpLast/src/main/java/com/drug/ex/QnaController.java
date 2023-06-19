package com.drug.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drug.dto.QnaDto;
import com.drug.service.IQnaService;
import com.drug.vo.PageMaker;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@Autowired
	private IQnaService bs;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(PageMaker pm, Model model) throws Exception {
		logger.info("listPage");
		System.out.println("--list pm " + pm);
		// PageMaker [page=2, perPageNum=10, searchType=t, keyword=888, totalCount=0,
		// startPage=0, endPage=0, prev=false, next=false]
		model.addAttribute("list", bs.listSearchCriteria(pm));
		pm.setTotalCount(bs.listSearchCount(pm));
		// model.addAttribute("pageMaker",pm);
		// return "qna/list";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGet(Authentication at,Model model) throws Exception {
		// return "/qna/write
		if(at!=null) {
		UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)at;
		String id = upat.getName();
		System.out.println(id);
		model.addAttribute("writer", id);
		return "/qna/write";
		}else {
			return "/login/login";
		}
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(QnaDto qna, RedirectAttributes rttr) throws Exception {
		bs.write(qna);
		// rttr.addAttribute("msg","success");
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/qna/list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @RequestParam("indent") int indent,
			@RequestParam("depthno") int depthno, PageMaker pm, Model model) throws Exception {
		System.out.println("-----read pm" + pm);
		bs.viewCount(bno);
		model.addAttribute("list_read", bs.read(bno, indent, depthno));
		// return "/qna/read
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") int bno, PageMaker pm, Model model, RedirectAttributes rttr)
			throws Exception {
		bs.remove(bno);
		rttr.addAttribute("page", pm.getPage());
		rttr.addAttribute("perPageNum", pm.getPerPageNum());
		rttr.addAttribute("searchType", pm.getSearchType());
		rttr.addAttribute("keyword", pm.getKeyword());
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/qna/list";
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
	public String modifyPost(QnaDto qna, PageMaker pm, Model model, RedirectAttributes rttr) throws Exception {
		bs.modify(qna);
		
		
		System.out.println(pm);

		rttr.addAttribute("page", pm.getPage());
		rttr.addAttribute("perPageNum", pm.getPerPageNum());
		rttr.addAttribute("searchType", pm.getSearchType());
		rttr.addAttribute("keyword", pm.getKeyword());
		rttr.addFlashAttribute("msg", "success");
	
		return "redirect:/qna/list";
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public void replyGet(QnaDto dto, PageMaker pm, Model model,Authentication at)
			throws Exception {
		System.out.println(pm);
		System.out.println(dto);
		model.addAttribute("bno", dto.getBno());
		model.addAttribute("title", dto.getTitle());	
		model.addAttribute("indent", dto.getIndent());
		model.addAttribute("depthno", dto.getdepthno());
		UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken)at;
		String id = upat.getName();
		System.out.println(id);
		model.addAttribute("writer", id);		
		
	}
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String replyPost(QnaDto dto, RedirectAttributes rttr) throws Exception {
		System.out.println(dto);
		bs.reply_update(dto);
		bs.reply_insert(dto);
		// rttr.addAttribute("msg","success");		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/qna/list";
	}

	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq() {
		return "/qna/faq";
	}

}
