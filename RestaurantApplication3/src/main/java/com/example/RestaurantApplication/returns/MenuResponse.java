package com.example.RestaurantApplication.returns;

import java.util.ArrayList;
import java.util.List;

import com.example.RestaurantApplication.model.MenuModel;

public class MenuResponse extends Response{

private List <MenuModel> resValues = new ArrayList<MenuModel>();

	public List<MenuModel> getResValues() {
		return resValues;
	}

	public void setResValues(List<MenuModel> resValues) {
		this.resValues = resValues;
	}
}

