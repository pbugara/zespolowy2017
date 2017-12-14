package com.projekt.zespolowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projekt.zespolowy.models.UserRole;

@Repository
public interface IRoleRepository extends JpaRepository<UserRole, Long> {

}
