package com.crm.Campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility1;
import com.crm.ObjectRepository.CampaignCreationPage;
import com.crm.ObjectRepository.HomePage1;
import com.crm.ObjectRepository.LoginPage1;
import com.crm.ObjectRepository.ProductCreationPage;




public class CreateCampWithProdTest{
@Test(groups = {"RegressionTest"})

	public void  createCampignWithProductTest() throws Throwable
	{
		File_Utility flib=new File_Utility();
	    Excel_Utility elib=new  Excel_Utility();
		WebDriver_Utility1 wlib=new WebDriver_Utility1();
		Java_Utility jlib=new Java_Utility();
		
		String Key="webdriver.chrome.driver";
	    String value="C:\\Users\\Shobha\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
	
		wlib.waitForPageToLoad(driver);
		
		String URL	=flib.getPropertyKeyValue("url");
		String UserName = flib.getPropertyKeyValue("un");
		String PassWord = flib.getPropertyKeyValue("pw");
	
		driver.get(URL);
		 LoginPage1 log=new  LoginPage1 (driver);
		 log.login(UserName, PassWord);

		//product data
		 HomePage1 home=new HomePage1(driver);
		 home.clickProductLink();
		 ProductCreationPage product=new ProductCreationPage(driver);
	     product.productCreateImage();
	     
	    int ranNum = jlib.getRanDomNum();
       String productdata = elib.getDataFromExcel("Product", 0, 0)+ranNum;
	    
	   driver.findElement(By.name("productname")).sendKeys(productdata);
	   product.saveButton();
	   
	   //Navigate to Campaign
	   home.moreLink(driver);
	    home.campaignLinkText();
	    
	    CampaignCreationPage campaign=new  CampaignCreationPage(driver);
	    campaign.campaignCreateImage();
	    
	    String campaigndata = elib.getDataFromExcel("Campaign", 0, 0)+ranNum;
	  
		driver.findElement(By.name("campaignname")).sendKeys(campaigndata);
		campaign.productSelectionImage();
		
		//Window Switching
		
		wlib.switchToWindow(driver, "Products&action");
		 
	    driver.findElement(By.id("search_txt")).sendKeys(productdata);
	  	driver.findElement(By.name("search")).click();
		
		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
		
		//Switch back Window
		wlib.switchToWindow(driver, "Campaigns&action");
		campaign.saveButton();
	    Thread.sleep(1000);

		String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();

		if(actData.contains(productdata))
		   {
		  	 System.out.println("pass");
		   }
		   else
		   {
		  	 System.out.println("fail");
		   }
		home.signoutLink(driver);
		
	
	}
		}

	


