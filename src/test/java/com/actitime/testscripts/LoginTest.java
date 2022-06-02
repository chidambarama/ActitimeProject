package com.actitime.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		//		WebDriverManager.firefoxdriver().setup();
		//		WebDriver	driver=new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver	driver=new ChromeDriver();

		driver.get(WebDriverUtils.getDataProperties("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		LoginPage lp=new LoginPage(driver);
		lp.loginOperation(WebDriverUtils.getDataProperties("username"), WebDriverUtils.getDataProperties("password"));


		if(driver.getTitle().contains("actiTIME"))
		{
			Assert.assertTrue(true);

		}

		else
		{
			Assert.assertTrue(false);
			System.out.println("fail");
		}

		driver.close();



	}

}
