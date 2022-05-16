package com.actitime.commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class WebDriverUtils
{

	WebDriver driver;
	
	public static String getDataProperties(String key) throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./src/main/resources/LoginData/Logincreds.properties");
		Properties pis=new Properties();
		pis.load(fis);
		return pis.getProperty(key);
		
	}
	
	
	public void FailedScreenShotMethod(String tcname, WebDriver driver) throws IOException
	{
				
			TakesScreenshot	ts	=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File Target=new File(System.getProperty("user.dir")+"\\screenshot\\"+tcname+".png");
			FileUtils.copyFile(src, Target);
			System.out.println("screenshot is taken");
		
		
	}
	
	
    public String readtestdata(String path, String Sheet, int row, int cell) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
    {
 Workbook   book=WorkbookFactory.create(new FileInputStream(path));
 	return	book.getSheet(Sheet).getRow(row).getCell(cell).toString();
    }
	
}
