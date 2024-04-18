package step_definitions;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageobjectmodel.CustomerPage;
import pageobjectmodel.Dashboard_page;
import pageobjectmodel.Loginpage;
import pageobjectmodel.Page;
import utilities.Commons;

public class Yourstore_Step_definition extends Page{
	
	@Given("user launches {string} with {string}")
	public void user_launches_with(String browser, String url) throws InterruptedException {
	   log.info("****** starting browser and heading url******");
		browser(browser, url);
	}

	@Then("user navigated to the {string}")
	public void user_navigated_to_the(String loginpagetitle) {
		log.info("******loginpagetitle verified");
		Verifypagetitle(loginpagetitle);
	}

	@Then("user enters validcredential email as {string} and password as {string}")
	public void user_enters_validcredential_email_as_and_password_as(String email, String password) throws InterruptedException {
	 log.info("*****puting valid credential*****");
	 loginpage= new Loginpage(driver);
	 loginpage.provide_email(email);
	 loginpage.provide_password(password);
	 Thread.sleep(2000);
		
	}

	@Then("click login button")
	public void click_login_button() throws InterruptedException {
		log.info("*****login button is logged*********");
		loginpage.click_loginbtn();
		Thread.sleep(2000);
	   
	}

	@Then("user lands on {string}")
	public void user_lands_on(String expectedtitle) {
		log.info("******verify page title*****");
		Verifypagetitle(expectedtitle);
	    
	}
	@Then("user click on {string} menu")
	public void user_click_on_menu(String menuitem) throws InterruptedException {
		log.info("*****clicking on customer menu**");
		dashbordpage= new Dashboard_page(driver);
		dashbordpage.clickoncustomermenu();
		Thread.sleep(2000);
		
	   
	}

	@Then("user click on Customer Button")
	public void user_click_on_customer_button() throws InterruptedException {
		log.info("****click in customerbtn****");
		dashbordpage.clickcustumerbtn();
		Thread.sleep(2000);
	  
	}
	
	@Then("click on {string} field")
	public void click_on_field(String string) {
	   
	}

	@Then("insert {string} as email")
	public void insert_as_email(String expectedEmail) throws InterruptedException {
		log.info("**insert email***");
		customerpage= new CustomerPage(driver);
		customerpage.insert_searchEmail();
		Thread.sleep(2000);
	    	}

	@Then("click on search button")
	public void click_on_search_button() throws InterruptedException {
		customerpage.search_customerbtn();
		Thread.sleep(2000);

	    
	}

	@Then("Email should be visible")
	public void email_should_be_visible() {
		Assert.assertTrue(customerpage.searchcustomerbyemail("james_pan@nopCommerce.com"), "email ID is present");
	   
	}





}
