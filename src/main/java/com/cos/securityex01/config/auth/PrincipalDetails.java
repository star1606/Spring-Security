package com.cos.securityex01.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.securityex01.model.User;

import lombok.Data;

// Authentication 객체에 저장할 수 있는 유일한 타입


@Data
public class PrincipalDetails implements UserDetails {

	private User user; // 컴포지션 만듬.
	
	
	public PrincipalDetails(User user) {
		super();
		this.user = user;
	}

	
	
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override  //비번 다섯 번 틀리면 false하면됨
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override	// 계정활성화
	public boolean isEnabled() {
		return true;
	}

	@Override // 권한
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	
}
