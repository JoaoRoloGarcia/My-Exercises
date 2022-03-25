package com.example.RestaurantApplication.returns;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Response { 
	
private String status;
private LocalDateTime sentOn;
private String statusCode;
private String transactionID = UUID.randomUUID().toString();;
private String msg;

public Response() {}

public String getStatus() {
	return status;
} public void setStatus(String status) {
	this.status = status;
} public LocalDateTime getSentOn() {
	return sentOn;
} public void setSentOn(LocalDateTime localDateTime) {
	this.sentOn = localDateTime;
} public String getStatusCode() {
	return statusCode;
} public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
} public String getTransactionID() {
	return transactionID;
} public void setTransactionID(String transactionID) {
	this.transactionID = transactionID;
} public String getMsg() {
	return msg;
} public void setMsg(String msg) {
	this.msg = msg;
}

}

