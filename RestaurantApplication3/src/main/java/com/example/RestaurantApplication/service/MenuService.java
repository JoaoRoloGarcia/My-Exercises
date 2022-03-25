package com.example.RestaurantApplication.service;

import java.util.Calendar;
import java.util.Date;
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

    public MenuService(MenuRepository menuRepository) {
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

    public List<MenuModel> getByActive() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        return menuRepository.getByWeek(dayOfWeek);
    }

    public Integer checkAvailability(MenuModel menu) {
        return menu.getDish_availability();
    }

    public MenuModel getByDishName(MenuModel menu) {
        return menuRepository.getByDishName(menu.getDish_name());
    }

    // Lógica p checkar quantidade disponível (meals_available) e se for menor return false
    public Integer getDishesQuantity(String dish_name) {
        Integer dishesAvailable = menuRepository.getByDishName(dish_name).getMeals_available();
        return dishesAvailable;
    }



}
