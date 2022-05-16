package com.actitime.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.CreateCustomerPage;
import com.actitime.pages.Homepage;
import com.actitime.pages.TaskPage;


public class CreateCustomerPageTest1 extends CommonSetup {

	WebDriverUtils	ut=new  WebDriverUtils();

	@Test(priority = 1)
	public void createnewccustomerwithname() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{

		Homepage hp=new Homepage(driver);
		Thread.sleep(3000);
		hp.clickOnTasks();
		TaskPage tp=new TaskPage(driver);
		Thread.sleep(2000);
		tp.AddNewCust();
		CreateCustomerPage cp=	new CreateCustomerPage(driver);
		String name	=ut.readtestdata("./TestData/chidu.xlsx","Sheet1", 1, 0);
		cp.createNewCust(name);

	}


	@Test(priority = 2)
	public void createnewCustomerWithNameAndDescription() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException, InterruptedException
	{
		String name	=ut.readtestdata("./TestData/chidu.xlsx","Sheet1", 2, 0);

		String name1=ut.readtestdata("./TestData/chidu.xlsx","Sheet1", 2, 1);
		Homepage hp=new Homepage(driver);
		Thread.sleep(3000);
		hp.clickOnTasks();
		TaskPage tp=new TaskPage(driver);
		Thread.sleep(2000);
		tp.AddNewCust();
		CreateCustomerPage cp=	new CreateCustomerPage(driver);
		cp.createNewCust(name, name1);
	}

}
