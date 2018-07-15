package com.koo.member.application;

import com.koo.member.application.exception.ExistUserException;
import com.koo.member.application.exception.UserNotFoundException;
import com.koo.member.domain.Member;
import com.koo.member.domain.MemberRepository;
import com.koo.member.domain.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Member signIn(MemberVo memberVo) {
		String userId = memberVo.getUserId();
		return memberRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("조회되는 유저가 없습니다"));
	}

	@Transactional
	public Member signUp(MemberVo memberVo) {
		String userId = memberVo.getUserId();
		String password = memberVo.getPassword();

		checkExistUserId(userId);
		Member member = convertToMember(userId, password);
		return memberRepository.save(member);
	}

	private void checkExistUserId(String userId) {
		Optional<Member> foundMember = memberRepository.findByUserId(userId);
		if (foundMember.isPresent()) {
			throw new ExistUserException("userId가 존재 합니다.");
		}

	}

	private Member convertToMember(String userId, String password) {
		Member member = new Member();
		String encrypted = member.makeEncryptionPassword(passwordEncoder, password);
		member.setUserId(userId);
		member.setPassword(encrypted);
		return member;
	}

}
