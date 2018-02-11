package com.projekt.zespolowy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.zespolowy.models.DailyMenu;
import com.projekt.zespolowy.models.User;

public interface DailyMenuRepository extends JpaRepository<DailyMenu,Long>{
	
	public List<DailyMenu> findByUser(User user);
	public DailyMenu findById(Long id);
	
}
