package com.subrutin.catalog.repository;

import com.subrutin.catalog.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
	public Optional<AppUser> findByUsername(String username);

}
