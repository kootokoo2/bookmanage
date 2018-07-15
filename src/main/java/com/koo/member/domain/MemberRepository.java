package com.koo.member.domain;

import java.util.Optional;

public interface MemberRepository{
	Optional<Member> findByUserId(String userId);
	Optional<Member> findById(Long memberId);
	Member save(Member member);
	void deleteById(Long id);
}
