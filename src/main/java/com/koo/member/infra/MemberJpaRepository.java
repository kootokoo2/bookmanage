package com.koo.member.infra;

import com.koo.member.domain.Member;
import com.koo.member.domain.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long>, MemberRepository {
}
