package com.actitime.configuration;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.pages.Homepage;
import com.actitime.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonSetup {
	public static WebDriver driver;
	public String url="https://demo.actitime.com/login.do";

	@BeforeClass
	@Parameters("browser")
	public void Setup(String browser) throws InterruptedException
	{
		if (browser.equalsIgnoreCase("firefox")){
			
		
		//firefox driver
		WebDriverManager.firefoxdriver().setup();

		//chrome driver
		//WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
		
		}
		
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
	}
	
	
	@BeforeMethod
	public void loginSetup() throws InterruptedException, IOException
	{
		driver.get(WebDriverUtils.getDataProperties("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		LoginPage lp=new LoginPage(driver);
		lp.loginOperation(WebDriverUtils.getDataProperties("username"), WebDriverUtils.getDataProperties("password"));
		Thread.sleep(5000);
		
		
		
	}
	
	
	@AfterMethod
	
	public void logout() throws InterruptedException
	{
		Homepage hp=new Homepage(driver);
		Thread.sleep(1000);
		hp.logout();
	}
	

	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
}
