package com.adactin.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.adactin.pom.Book_Hotel;
import com.adactin.pom.Login_Page;
import com.adactin.pom.Search_Hotel;
import com.adactin.pom.Select_Hotel;

public class Page_Object_Manager {

	public static WebDriver driver;

	private Login_Page login;

	private Search_Hotel search;

	private Select_Hotel select;

	private Book_Hotel book;

	public Page_Object_Manager(WebDriver Adriver) {
		this.driver = Adriver;
		PageFactory.initElements(Adriver, this);
	}

	public Login_Page getInstancelogin() {
		login = new Login_Page(driver);
		return login;
	}

	public Search_Hotel getInstanceSearch() {
		search = new Search_Hotel(driver);
		return search;
	}

	public Select_Hotel getInstanceSelect() {
		select = new Select_Hotel(driver);
		return select;
	}
	
	public Book_Hotel getInstanceBook() {
		book = new Book_Hotel(driver);
		return book;
	}

}
