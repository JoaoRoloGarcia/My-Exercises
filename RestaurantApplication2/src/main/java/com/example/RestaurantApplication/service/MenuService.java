package com.example.RestaurantApplication.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestaurantApplication.model.MenuModel;
import com.example.RestaurantApplication.repositories.MenuRepository;

@Service
public class MenuService {

	@Autowired
	final MenuRepository menuRepository;
	
	public MenuService (MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	@Transactional
	public MenuModel save(MenuModel menuModel) {
		return menuRepository.saveAndFlush(menuModel);
	}
	
	public List<MenuModel> getAll() {
	return menuRepository.findAll();
	}

	public Optional<MenuModel> findById(Integer id) {
		return menuRepository.findById(id);
	}

	@Transactional
	public void delete(MenuModel menuModel) {
		menuRepository.delete(menuModel);
	}
	
}
