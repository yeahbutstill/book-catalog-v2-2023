package com.subrutin.catalog.web;

import com.subrutin.catalog.dto.UserDetailResponseDTO;
import com.subrutin.catalog.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserResource {

	private final AppUserService appUserService;
	
	@GetMapping("/detail")
	public ResponseEntity<UserDetailResponseDTO> findUserDetail(){
		return ResponseEntity.ok(appUserService.findUserDetail());
		
	}
}
