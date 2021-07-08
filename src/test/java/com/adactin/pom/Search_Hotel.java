package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Hotel {

	public static WebDriver driver;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "room_type")
	private WebElement room_type;

	@FindBy(id = "room_nos")
	private WebElement numer_rooms;

	@FindBy(id = "datepick_in")
	private WebElement clear_date;

	@FindBy(id = "datepick_in")
	private WebElement check_in_date;

	@FindBy(id = "datepick_out")
	private WebElement date_clear;

	@FindBy(id = "datepick_out")
	private WebElement check_out_date;

	@FindBy(id = "adult_room")
	private WebElement adult_room;

	@FindBy(id = "child_room")
	private WebElement child_room;
	
	@FindBy (id = "Submit")
	private WebElement search;

	public Search_Hotel(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoom_type() {
		return room_type;
	}

	public WebElement getNumer_rooms() {
		return numer_rooms;
	}

	public WebElement getClear_date() {
		return clear_date;
	}

	public WebElement getCheck_in_date() {
		return check_in_date;
	}

	public WebElement getDate_clear() {
		return date_clear;
	}

	public WebElement getCheck_out_date() {
		return check_out_date;
	}

	public WebElement getAdult_room() {
		return adult_room;
	}

	public WebElement getChild_room() {
		return child_room;
	}

	public WebElement getSearch() {
		return search;
	}
}
