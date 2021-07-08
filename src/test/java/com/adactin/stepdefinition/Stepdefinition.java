package com.adactin.stepdefinition;

import org.openqa.selenium.WebDriver;
import com.adactin.org.BaseClass;
import com.adactin.properties.File_Reader_Manager;
import com.adactin.properties.Page_Object_Manager;
import com.adactin.runner.Runner;
import cucumber.api.java.en.*;

public class Stepdefinition extends BaseClass {

	public static WebDriver driver = Runner.driver;

	Page_Object_Manager pom = new Page_Object_Manager(driver);

	@Given("^User launch the adactin application$")
	public void user_launch_the_adactin_application() throws Throwable {
		String url = File_Reader_Manager.getInstance().getInstanceCR().getUrl();
		getUrl(url);
	}

//	@When("^User enter the valid username$")
//	public void user_enter_the_valid_username() throws Throwable {
//		String username = File_Reader_Manager.getInstance().getInstanceCR().getUsername();
//		inputValueElement(pom.getInstancelogin().getUsername(), username);
//	}
//
//	@When("^User enter the valid password$")
//	public void user_enter_the_valid_password() throws Throwable {  
//		String password = File_Reader_Manager.getInstance().getInstanceCR().getPassword();
//		inputValueElement(pom.getInstancelogin().getPassword(), password);
//	}

	@When("^User enter the \"([^\"]*)\" valid username$")
	public void user_enter_the_valid_username(String arg1) throws Throwable {
		inputValueElement(pom.getInstancelogin().getUsername(), arg1);
	}

	@When("^User enter the \"([^\"]*)\" valid password$")
	public void user_enter_the_valid_password(String arg1) throws Throwable {
		inputValueElement(pom.getInstancelogin().getPassword(), arg1);
	}

	@Then("^User validate the username and password$")
	public void user_validate_the_username_and_password() throws Throwable {
		clickOnElement(pom.getInstancelogin().getLogin());
	}

	@When("^User want to select the location$")
	public void user_want_to_select_the_location() throws Throwable {
		selection(pom.getInstanceSearch().getLocation(), "byVisibleText", "Paris");
	}

	@When("^User want to select the hotel name$")
	public void user_want_to_select_the_hotel_name() throws Throwable {
		selection(pom.getInstanceSearch().getHotels(), "byVisibleText", "Hotel Sunshine");
	}

	@When("^User want to select the room type$")
	public void user_want_to_select_the_room_type() throws Throwable {
		selection(pom.getInstanceSearch().getRoom_type(), "byVisibleText", "Super Deluxe");
	}

	@When("^User want to select the number of rooms$")
	public void user_want_to_select_the_number_of_rooms() throws Throwable {
		selection(pom.getInstanceSearch().getNumer_rooms(), "byValue", "1");
	}

	@When("^User want to clear the check in Date$")
	public void user_want_to_clear_the_check_in_Date() throws Throwable {
		elementClear(pom.getInstanceSearch().getClear_date());
	}

	@When("^User want to select the check in Date$")
	public void user_want_to_select_the_check_in_Date() throws Throwable {
		inputValueElement(pom.getInstanceSearch().getCheck_in_date(), "05/06/2021");
	}

	@When("^User want to clear the check out Date$")
	public void user_want_to_clear_the_check_out_Date() throws Throwable {
		elementClear(pom.getInstanceSearch().getDate_clear());
	}

	@When("^User want to select the check out Date$")
	public void user_want_to_select_the_check_out_Date() throws Throwable {
		inputValueElement(pom.getInstanceSearch().getCheck_out_date(), "12/06/2021");
	}

	@When("^User want to select the Adults per room$")
	public void user_want_to_select_the_Adults_per_room() throws Throwable {
		selection(pom.getInstanceSearch().getAdult_room(), "byValue", "2");
	}

	@When("^User want to selec the Children per room$")
	public void user_want_to_selec_the_Children_per_room() throws Throwable {
		selection(pom.getInstanceSearch().getChild_room(), "byValue", "1");
	}

	@Then("^User click the search  button for verification purpose$")
	public void user_click_the_search_button_for_verification_purpose() throws Throwable {
		clickOnElement(pom.getInstanceSearch().getSearch());
	}

	@When("^User select the list details$")
	public void user_select_the_list_details() throws Throwable {
		explicitWait(pom.getInstanceSelect().getSelect());
		clickOnElement(pom.getInstanceSelect().getSelect());
	}

	@Then("^User click the continue button for the further process$")
	public void user_click_the_continue_button_for_the_further_process() throws Throwable {
		clickOnElement(pom.getInstanceSelect().getContinue());
	}

	@When("^User enter the first name$")
	public void user_enter_the_first_name() throws Throwable {
		inputValueElement(pom.getInstanceBook().getFirstName(), "Vinoth");
	}

	@When("^User enter the last name$")
	public void user_enter_the_last_name() throws Throwable {
		inputValueElement(pom.getInstanceBook().getLastName(), "Kumar");
	}

	@When("^User enter the billing address$")
	public void user_enter_the_billing_address() throws Throwable {
		inputValueElement(pom.getInstanceBook().getAddress(),
				"4960 Confederate Drive , South Otselic , New York-13155");
	}

	@When("^User enter the credit card number$")
	public void user_enter_the_credit_card_number() throws Throwable {
		String creditCard = File_Reader_Manager.getInstance().getInstanceCR().getCreditCard();
		inputValueElement(pom.getInstanceBook().getCardNumber(), creditCard);
	}

	@When("^User select the credit card type$")
	public void user_select_the_credit_card_type() throws Throwable {
		selection(pom.getInstanceBook().getCardType(), "byValue", "AMEX");
	}

	@When("^User Select the expiry month$")
	public void user_Select_the_expiry_month() throws Throwable {
		selection(pom.getInstanceBook().getExpiryMonth(), "byValue", "11");
	}

	@When("^User select the expiry year$")
	public void user_select_the_expiry_year() throws Throwable {
		selection(pom.getInstanceBook().getExpiryYear(), "byValue", "2022");
	}

	@When("^User enter the CVV number$")
	public void user_enter_the_CVV_number() throws Throwable {
		String cvv = File_Reader_Manager.getInstance().getInstanceCR().getCvv();
		inputValueElement(pom.getInstanceBook().getCvv(), cvv);
	}

	@Then("^User click the Book Now button to the Validation$")
	public void user_click_the_Book_Now_button_to_the_Validation() throws Throwable {
		clickOnElement(pom.getInstanceBook().getBook());
	}
}
