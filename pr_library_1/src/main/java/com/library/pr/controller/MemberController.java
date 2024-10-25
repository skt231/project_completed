package com.library.pr.controller;

import com.library.pr.dto.LoanDTO;
import com.library.pr.dto.MemberJoinDTO;
import com.library.pr.security.dto.MemberSecurityDTO;
import com.library.pr.service.LoanService;
import com.library.pr.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final LoanService loanService;

    @GetMapping("/login")
    public void loginGET(String logout,Model model){
        log.info("login get..........");
        log.info("logout: " + logout);

        if (logout != null) {
            log.info("user logout.....");
            model.addAttribute("logout", true);
        }
    }

    @GetMapping("/join")
    public void joinGET(){
        log.info("join get...");
    }
    @PostMapping("/join")
    public String joinPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes){
        log.info("join POST.....");
        log.info("memberJoinDTO....");

        try{
            memberService.join(memberJoinDTO);

        } catch (MemberService.IdExistException e) {
            redirectAttributes.addFlashAttribute("errors","username");
            return"redirect:/member/join";
        }
        redirectAttributes.addFlashAttribute("result","success");
        return "redirect:/member/login";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage/loan")
    public String memberLoans(@AuthenticationPrincipal MemberSecurityDTO memberSecurityDTO, Model model) {
        Long memberId = memberSecurityDTO.getMemberId();
        List<LoanDTO> memberLoans = loanService.getLoansByMember(memberId); // 해당 회원의 대출 목록 조회
        model.addAttribute("loans", memberLoans);
        model.addAttribute("mId",memberId);
        return "member/LoansStatus"; // 새로운 HTML 페이지로 전달
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage/info")
    public String getUserInfo(@AuthenticationPrincipal UserDetails userDetails,Model model){
        model.addAttribute("userDetails",userDetails);
        return "member/userinfo";

    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.getSession().invalidate(); // 세션 무효화
        return "redirect:/login?logout";
    }
}
