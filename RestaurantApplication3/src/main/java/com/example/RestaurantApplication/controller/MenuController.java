package com.example.RestaurantApplication.controller;

import com.example.RestaurantApplication.model.MenuModel;
import com.example.RestaurantApplication.returns.MenuResponse;
import com.example.RestaurantApplication.service.MenuService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Menu")
public class MenuController {

    @Autowired
    final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // done
    @GetMapping("/getAll")
    public List<MenuModel> getAll() {
        return menuService.getAll();
    }

    // done
    @PostMapping("/addMenu")
    public MenuResponse addMenu(@RequestBody MenuModel menuModel) {
        MenuResponse retValues = new MenuResponse();
        try {
            List<MenuModel> list = new ArrayList<>();
            list.add(menuModel);
            menuService.save(menuModel);
            retValues.setStatus("OK");
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("200");
            retValues.setMsg("Menu added successfully!");

            retValues.setResValues(list);

        } catch (Exception e) {
            retValues.setStatus("NOK");
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("404");
            retValues.setMsg("Could not add the menu: " + e.getMessage());
        }
        return retValues;
    }

    // done
    @PostMapping("/updateMenu")
    public MenuResponse updateMenu(@RequestBody MenuModel menu) {
        MenuResponse retValues = new MenuResponse();
        MenuModel menuModel = menuService.getByDishName(menu);
        List<MenuModel> list = new ArrayList<>();

        try {
            if (!menu.getDish_name().isEmpty()) {

                menuService.save(menu);
                list.add(menu);

                retValues.setStatus("OK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("200");
                retValues.setMsg("Menu updated successfully!");
                retValues.setResValues(list);
            } else {
                retValues.setStatus("NOK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("404");
                retValues.setMsg("Dish Name not found or you can't change those attributes");
                retValues.setResValues(list);
            }

        } catch (Exception e) {

            retValues.setStatus("ERROR: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("500");
            retValues.setMsg("Menu TransactionID was not found");
        }
        return retValues;
    }

	//done
    @GetMapping("/getActiveMenu")
    public MenuResponse getMenu() {
        MenuResponse retValues = new MenuResponse();
        List<MenuModel> list = new ArrayList<MenuModel>();
        try {
            list = menuService.getByActive();
            retValues.setResValues(list);

            retValues.setMsg("This is the Menu for the week: ");
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatus("OK");
            retValues.setStatusCode("200");

        } catch (Exception e) {

            retValues.setMsg("ERROR getting the Active Menu's: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatus("NOK");
            retValues.setStatusCode("400");
        }
        return retValues;
    }

    //Not needed
    @DeleteMapping("/{id}")
    public MenuResponse cancelMenu(@PathVariable(value = "id") @RequestBody Integer id) {
        Optional<MenuModel> menuModelOptional = menuService.findById(id);
        MenuResponse retValues = new MenuResponse();
        if (menuModelOptional.isEmpty()) {
            retValues.setMsg("ERROR");
        }
        menuService.delete(menuModelOptional.get());
        return retValues;
    }
}