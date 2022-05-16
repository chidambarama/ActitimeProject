package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	@FindBy(xpath="//div[.='Tasks']") private WebElement tasks;

	@FindBy(xpath = "//div[.='Reports']") private WebElement Reports;

	@FindBy(xpath= "//div[.='Users']")  private WebElement Users;
	
	@FindBy(xpath="//a[.='Logout']") private  WebElement logout;



	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	
	
	public void clickOnTasks()
	{	
		tasks.click();
	}
	
	public void clickOnReports()
	{
		Reports.click();
	}
	
	public void clickOnUsers()
	{
		Users.click();
	}
	

	
	public void logout()
	{
		logout.click();
	}
	

	
	
}