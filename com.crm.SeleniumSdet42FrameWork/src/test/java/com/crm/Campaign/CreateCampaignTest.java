package com.crm.Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.File_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.Generic_Utilities.ListenerImplementationClass.class)
public class CreateCampaignTest extends BaseClass {

	@Test()
	public void  createCampaignTest() throws Throwable
	{

/*String Key="webdriver.chrome.driver";
			String value="C:\\Users\\Shobha\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe";
			System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);*/
		
		File_Utility flib=new File_Utility();
		String BROWSER = flib.getPropertyKeyValue("browser");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	}
	else
	{
		 driver = new ChromeDriver();
	}
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
String URL = flib.getPropertyKeyValue("url");
String UserName = flib.getPropertyKeyValue("un");
String PassWord = flib.getPropertyKeyValue("pw");
driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(UserName);
driver.findElement(By.name("user_password")).sendKeys(PassWord);
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.linkText("More")).click();
driver.findElement(By.linkText("Campaigns")).click();

Assert.assertEquals(false, true);

driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
Random ran =new Random();
int RanNum = ran.nextInt(1000);
FileInputStream fis1=new FileInputStream("./Book2.xlsx");

Workbook book=WorkbookFactory.create(fis1);

Sheet sh = book.getSheet("Campaign");
			
Row row = sh.getRow(0);
	
Cell cel = row.getCell(0);
	
String data = cel.getStringCellValue()+RanNum;
driver.findElement(By.name("campaignname")).sendKeys(data);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
if(actData.contains(data))
   {
  	 System.out.println("pass");
   }
   else
   {
  	 System.out.println("fail");
   }

driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

	}

