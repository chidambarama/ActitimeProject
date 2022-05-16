package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.configuration.CommonSetup;

public class LoginPage {

	@FindBy(id="username")private WebElement usr;

	@FindBy(name="pwd")private WebElement pass;

	@FindBy(xpath = "//div[text()='Login ']") private WebElement submit;



	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}


	public void loginOperation(String uname, String passname) throws InterruptedException
	{
		Thread.sleep(2000);
		usr.sendKeys(uname);
		Thread.sleep(2000);
		pass.sendKeys(passname);
		Thread.sleep(2000);
		submit.click();
	}






}
