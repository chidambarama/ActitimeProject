package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerPage
{

	@FindBy(xpath="//span[text()='ASSIGNED USERS (3)']") private WebElement asnguser;
	@FindBy(xpath="//span[text()='MANAGERS (3)']") private WebElement manager;
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']") private WebElement custtname;
	@FindBy(xpath="//div[text()='Create Customer']") private  WebElement createnewcust;
	@FindBy(xpath="(//textarea[@class='textarea'])[9]") private WebElement text;
	
	public CreateCustomerPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewCust(String name)
	{
		custtname.sendKeys(name);
		createnewcust.click();
	}
	
	
	public void createNewCust(String name, String des)
	{
		custtname.sendKeys(name);
		text.sendKeys(des);
		createnewcust.click();
		
	}
		
	
}
