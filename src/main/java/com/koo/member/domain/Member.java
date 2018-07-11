package com.koo.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
public class Member {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String userId;
	@Column
	private String password;

	public boolean match(String password) {
		return this.password.equals(password);
	}

	public String makeEncryptionPassword(PasswordEncoder passwordEncoder, String origin) {
		return passwordEncoder.encode(origin);
	}

	@Column
	private LocalDateTime createdAt;
	@Column
	private LocalDateTime modifiedAt;

}
