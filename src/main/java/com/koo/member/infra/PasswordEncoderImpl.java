package com.koo.member.infra;

import com.koo.member.domain.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl extends BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String value) {
		return super.encode(value);
	}

}
