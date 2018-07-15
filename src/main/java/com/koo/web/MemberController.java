package com.koo.web;

import com.koo.member.application.MemberService;
import com.koo.member.application.MemberVo;
import com.koo.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/member/signUp")
	public String singUp(@RequestBody MemberVo memberVo) {
		memberService.signUp(memberVo);
		return "success";
	}

	@PostMapping("/member/signIn")
	public String signIn(@RequestBody MemberVo memberVo, HttpServletResponse response) {
		Member member = memberService.signIn(memberVo);
		Cookie memberIdCookie = new Cookie("memberId", String.valueOf(member.getId()));
		memberIdCookie.setPath("/");
		memberIdCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(memberIdCookie);

		Cookie newCookie = new Cookie("testCookie", "testCookieValue");
		newCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(newCookie);

		return "success";
	}

	@GetMapping("/signin")
	public ModelAndView signInView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/signin");
		return modelAndView;
	}

	@GetMapping("/signup")
	public ModelAndView signupView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/signup");
		return modelAndView;
	}

}
