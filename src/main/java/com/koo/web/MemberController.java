package com.koo.web;

import com.koo.member.application.MemberService;
import com.koo.member.application.vo.MemberVo;
import com.koo.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/signUp")
	public String singUp(@RequestBody MemberVo memberVo) {
		Member member = memberService.signUp(memberVo);
		return "success" + member.toString();
	}

	@PostMapping("/signIn")
	public String signin(@RequestBody MemberVo memberVo) {
		Member member = memberService.signIn(memberVo);
		return "success" + member.toString();
	}
}
