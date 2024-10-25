package com.library.pr.controller;

import com.library.pr.domain.LoanStatus;
import com.library.pr.dto.*;
import com.library.pr.service.BookService;
import com.library.pr.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final LoanService loanService;

    @GetMapping("/home")
    public String gethome(){
        return "home";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<BookDTO> responseDTO=bookService.list(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO",responseDTO);
        model.addAttribute("loanService", loanService);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/register")
    public void registerGET() {

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public String registerPost(@Valid BookDTO bookDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("board POST register.......");

        if (bindingResult.hasErrors()) {
            log.info("has errors.......");
            bindingResult.getAllErrors().forEach(error -> log.info(error.toString())); // 오류 메시지 로그 추가
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/book/register";
        }

        log.info(bookDTO);

        Long bid = bookService.register(bookDTO);

        redirectAttributes.addFlashAttribute("result", bid);

        return "redirect:/book/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping({"/read", "/modify"})
    public void read(Long bid, PageRequestDTO pageRequestDTO, Model model) {

        BookDTO bookDTO = bookService.readOne(bid);

        log.info("BookDTO from Service: " + bookDTO); // DTO 확인 로그 추가

        model.addAttribute("dto", bookDTO);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid BookDTO bookDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        log.info("board modify post......." + bookDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors.......");

            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("dto", bookDTO); // bookDTO 추가
            redirectAttributes.addAttribute("bid", bookDTO.getBid());

            return "redirect:/book/modify?" + link;
        }

        bookService.modify(bookDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("bid", bookDTO.getBid());

        return "redirect:/book/read";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/remove")
    public String remove(Long bid, RedirectAttributes redirectAttributes) {

        log.info("remove post.. " + bid);

        bookService.remove(bid);

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/book/list";

    }


}
