package com.subrutin.catalog.service.impl;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subrutin.catalog.domain.UserDetailResponseDTO;
import com.subrutin.catalog.exception.ResourceNotFoundException;
import com.subrutin.catalog.repository.AppUserRepository;
import com.subrutin.catalog.service.AppUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

	private AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return appUserRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("invalid.username"));
	}

	@Override
	public UserDetailResponseDTO findUserDetail() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		UserDetailResponseDTO dto = new UserDetailResponseDTO();
		String username = ctx.getAuthentication().getName();
		dto.setUsername(username);
		return dto;
	}

}
