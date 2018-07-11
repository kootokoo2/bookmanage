package com.koo.member.domain;

import java.util.Optional;

public interface MemberRepository{
	Optional<Member> findByUserId(String userId);

	Member save(Member member);
}
