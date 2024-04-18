package pageobjectmodel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.Commons;

public class Dashboard_page extends Commons {
	
	public Dashboard_page (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//diferent locator
	By CustomersMenu= By.xpath("//a[@href='#']//p[contains(text(), 'Customers')]");
	
	By customerbtn= By.xpath("(//a[@class='nav-link']//p[contains(text(),' Customers')])[1]");

	//action method
	public void clickoncustomermenu() throws InterruptedException {
		driver.findElement(CustomersMenu).click();
		Thread.sleep(3000);
	}
	public void clickcustumerbtn() throws InterruptedException {
		driver.findElement(customerbtn).click();
		Thread.sleep(2000);
	}
}
