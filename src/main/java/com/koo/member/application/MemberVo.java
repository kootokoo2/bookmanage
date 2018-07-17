package com.koo.member.application;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MemberVo {
	@NotNull
	private String userId;
	@NotNull
	private String password;
}
