package com.projekt.zespolowy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.projekt.zespolowy.DTO.UserPrincipalDTO;
import com.projekt.zespolowy.models.User;
import com.projekt.zespolowy.repositories.IUserRespository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private IUserRespository repository;

	@Transactional
	@Override
	@PostMapping
	public UserDetails loadUserByUsername(final String username) {
		return new UserPrincipalDTO(login(username));
	}

	@Transactional
	public User login(String name) {
		User user = repository.findByName(name);
		if (user != null) {
			return user;
		} else
			return null;
	}
}
