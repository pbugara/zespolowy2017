package com.projekt.zespolowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekt.zespolowy.models.User;

@Repository
public interface IUserRespository extends JpaRepository<User, Long> {
	User findById(long id);
	User findByName(String name);
}
