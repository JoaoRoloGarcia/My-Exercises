package com.example.RestaurantApplication.controller;

import com.example.RestaurantApplication.converter.Converter;
import com.example.RestaurantApplication.dto.MenuDto;
import com.example.RestaurantApplication.model.MenuModel;
import com.example.RestaurantApplication.returns.MenuResponse;
import com.example.RestaurantApplication.service.MenuService;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
	@PostMapping
	@RequestMapping("/addMenu")
	public MenuResponse addMenu(@RequestBody MenuDto menuDto) {
		MenuResponse retValues = new MenuResponse();
		Converter converter = new Converter();
		MenuModel menuModel = new MenuModel();
		try {
			retValues.setStatus("OK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("200");
			retValues.setMsg("Menu added succesfully!");
			retValues.setResValues(menuDto);
			menuService.save(converter.convertDtoToModel(menuDto, menuModel));
			return retValues;

		} catch (Exception e) {
			e.getMessage();
		}
		retValues.setResValues(menuDto);
		return retValues;
	}

	// done
	@PostMapping("/{id}")
	public MenuResponse updateMenu(@PathVariable(value = "id") Integer id, @RequestBody MenuDto menuDto) {
		Optional<MenuModel> menuModelOptional = menuService.findById(id);
		MenuResponse retValues = new MenuResponse();
		Converter converter = new Converter();
		try {
			if (menuModelOptional.isEmpty()) {
				retValues.setStatus("NOK");
				retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
				retValues.setStatusCode("500");
				retValues.setMsg("Menu ID was not found");
			}
			MenuModel menuModel = menuModelOptional.get();
			menuService.save(converter.convertDtoToModel(menuDto, menuModel));

			retValues.setStatus("OK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("200");
			retValues.setMsg("Menu updated succesfully!");
			retValues.setResValues(menuDto);
			return retValues;
		} catch (Exception e) {
			e.getMessage();
		}
		return retValues;
	}

	@DeleteMapping("/{id}")
	public MenuResponse cancelMenu(@PathVariable(value = "id") @RequestBody Integer id) {
		Optional<MenuModel> menuModelOptional = menuService.findById(id);
		MenuResponse retValues = new MenuResponse();
		if (menuModelOptional.isEmpty()) {
			retValues.setStatus("NOK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("500");
			retValues.setMsg("Could not find the ID you provided.");
			return retValues;
		}
		menuService.delete(menuModelOptional.get());
		retValues.setStatus("OK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("200");
		retValues.setMsg("Your menu was succesfully canceled.");
		return retValues;
	}
}