package com.example.RestaurantApplication.returns;

import java.time.LocalDateTime;
import com.example.RestaurantApplication.dto.MenuDto;

public class MenuResponse extends Response{

	private MenuDto resValues;

	public MenuResponse(String status, LocalDateTime sentOn, String statusCode, String transactionID, String msg) {
		super(status, sentOn, statusCode, transactionID, msg);

	}

	public MenuResponse() {
		super();
	}

	public MenuDto getResValues() {
		return resValues;
	}

	public void setResValues(MenuDto resValues) {
		this.resValues = resValues;
	}

}
