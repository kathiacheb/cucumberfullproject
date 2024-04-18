package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Commons;

public class Loginpage extends Commons{
	
	WebDriver driver;
	
	@FindBy(id="Email") WebElement emailfield;
	@FindBy(id="Password") WebElement passwordfield;
	@FindBy(xpath="//button[text()='Log in']") WebElement loginbtn;
	
	
	//@FindBy(how = How.ID,using =  )
	
	//action method
	public void provide_email(String email) {
		waitforclickible(emailfield);
		emailfield.click();
		emailfield.clear();
		emailfield.sendKeys(email);
	}
	public void provide_password(String Given_password) {
		waitforclickible(passwordfield);
		passwordfield.click();
		passwordfield.clear();
		passwordfield.sendKeys(Given_password);
	}
	public void click_loginbtn() {
		loginbtn.click();
	}
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
