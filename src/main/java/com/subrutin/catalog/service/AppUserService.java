package com.subrutin.catalog.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.subrutin.catalog.domain.UserDetailResponseDTO;

public interface AppUserService extends UserDetailsService {

	public UserDetailResponseDTO findUserDetail();
}
