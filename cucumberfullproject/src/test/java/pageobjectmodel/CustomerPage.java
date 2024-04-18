package pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Commons;

public class CustomerPage extends Commons {
	
	//constractor
	public CustomerPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	//locators 3ways
	
	@FindBy(how = How.ID,using = "SearchEmail")WebElement searchEmail_field;
	@FindBy(how = How.ID,using = "search-customers")WebElement searchCustomer_btn;
	@FindBy(how = How.XPATH,using = "//table[@id='customers-grid']")WebElement search_table; //this is the table that contains all element inside it.
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr")List<WebElement>tablerow;// this is to locate the row.
	@FindBy(how = How.XPATH,using="//table[@id='customers-grid']/tbody/tr/td[2]")List<WebElement>tablecolumn;
	
	
	//action method
	public void insert_searchEmail() {
		searchEmail_field.click();
		searchEmail_field.clear();
		searchEmail_field.sendKeys("james_pan@nopCommerce.com");
	}	
		
	public void search_customerbtn(){
		searchCustomer_btn.click();
		
	}
	
	public int getnumberofrows() {
		return (tablerow.size());
		
	}
	
	public boolean searchcustomerbyemail(String expected_email) {
		boolean flag= false;
		for (int i=1;i<=getnumberofrows();i++) {
			String ActualEmailID=search_table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(ActualEmailID);
			
			if(ActualEmailID.equals(expected_email)) {
				flag=true;
				
				System.out.println("**************************element found ********************");
				
						
			}}
		return flag;
	}
		
		
	}



