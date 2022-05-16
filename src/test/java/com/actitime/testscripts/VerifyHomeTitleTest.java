package com.actitime.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.Homepage;

public class VerifyHomeTitleTest extends CommonSetup
{
	@Test	
	public void verifyTitle() throws InterruptedException, IOException
	{

			WebDriverUtils wb=new WebDriverUtils();
		
		Homepage hp	=new Homepage(driver);
		Thread.sleep(3000);
		hp.clickOnTasks();
		
		if (driver.getTitle().contains("actiTIME"))
		{
		Assert.assertTrue(true);
			
		}
		
		else
		{
			wb.FailedScreenShotMethod("verifyTitle", driver);
			Assert.assertTrue(false);
		}

	
	}
}
