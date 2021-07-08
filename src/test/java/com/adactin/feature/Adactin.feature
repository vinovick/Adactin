Feature: Hotel booking functionality 

Background: User want to login the application 
	Given User launch the adactin application 
	When User enter the "vinovicky" valid username 
	And User enter the "Jan@2020" valid password 
	Then User validate the username and password 
	
@SmokeTest 
Scenario Outline: User want to login the application 
	Given User launch the adactin application 
	When User enter the "<Username>" valid username 
	And User enter the "<Password>" valid password 
	Then User validate the username and password 
	
	Examples: 
	
		|Username|Password|
		|AAA|123|
		|BBB|12345|
		|vinovicky|Jan@2020|
		
		@SanityTest 
		Scenario: User want to searching the hotel room 
			When User want to select the location 
			And User want to select the hotel name 
			And User want to select the room type 
			And User want to select the number of rooms 
			And User want to clear the check in Date 
			And User want to select the check in Date 
			And User want to clear the check out Date 
			And User want to select the check out Date 
			And User want to select the Adults per room 
			And User want to selec the Children per room 
			Then User click the search  button for verification purpose 
			
		@SanityTest 
		Scenario: User checking the updated list 
			When User select the list details 
			Then User click the continue button for the further process 
			
			
		Scenario: User enter the valid details in Book a Hotel 
			When User enter the first name 
			And User enter the last name 
			And User enter the billing address 
			And User enter the credit card number 
			And User select the credit card type 
			And User Select the expiry month 
			And User select the expiry year 
			And User enter the CVV number 
			Then User click the Book Now button to the Validation 
	