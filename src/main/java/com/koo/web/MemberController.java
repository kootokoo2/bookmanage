package com.koo.web;

import com.koo.member.application.MemberService;
import com.koo.member.application.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public String signIn(@RequestBody MemberVo memberVo) {
		memberService.signIn(memberVo);
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
