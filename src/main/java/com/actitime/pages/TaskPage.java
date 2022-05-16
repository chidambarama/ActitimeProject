package com.actitime.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskPage 
{
	
	@FindBy(xpath="//div[text()='Add New']") private WebElement addnew;
	@FindBy(xpath="//div[text()='+ New Customer']") private WebElement newcust;
	@FindBy(xpath="//div[text()='+ New Project']") private WebElement newprj;
	@FindBy(xpath="//div[text()='+ New Tasks']") private WebElement newtask;
	@FindBy(xpath="//div[text()='Import Tasks from CSV']") private WebElement Imp;
	
	
	public TaskPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void AddNewCust()
	{
		addnew.click();
		newcust.click();
	}
	

	
	public void Addewprj()
	{
		addnew.click();
		newprj.click();
	}
	
	public void Createnewtask()
	{
		addnew.click();
		newtask.click();
	}
	
	
	public void Importtask()
	{
		addnew.click();
		Imp.click();
	}
	
	
	

}
