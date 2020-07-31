package com.cos.securityex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IOC 빈(beacn)을 등록 (=인스턴스, 객체의 개념보단.)
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소 접근시 권한 및 인증을 미리 체크 // 컨트롤러로 접근 전에 낚아 채서 적용함
public class SecurityConfig extends WebSecurityConfigurerAdapter { // 인터페이스가 아니라 상속이라서 강제성이 없다 원하는 필터 골라서 설정하면 된다는 뜻
	
	@Bean  // Ioc에 등록됨
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}

	@Override // http요청 처리할 수 있음, 로그인 다 들어갈 수 있음

	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable(); // csrf 토큰 비활성화
		http.authorizeRequests().antMatchers("/user/**", "/admin/**").authenticated().anyRequest().permitAll().and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginProc").defaultSuccessUrl("/");

		// ajax 하지말것. 응답2번되서 데이터 꼬인다.

		// 다 열고 잠궈야 될 거 잠구는 것
	}

}
