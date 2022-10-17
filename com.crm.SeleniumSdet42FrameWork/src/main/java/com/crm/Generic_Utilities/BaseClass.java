package com.crm.Generic_Utilities;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.LoginPage1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public	WebDriver driver;
	public static WebDriver sDriver;
@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
@BeforeTest(groups = {"smokeTest","regressionTest"})
public void BT()
{
	System.out.println("Execute in Parallel mode");
}

//@Parameters("BROWSER")
@BeforeClass(groups = {"smokeTest","regressionTest"})	
//public void BC(String BROWSER )throws Throwable
//{
public void BC( ) throws Throwable
{
	File_Utility flib=new File_Utility();
	
		
	String BROWSER = flib.getPropertyKeyValue("browser");

	if(BROWSER.equalsIgnoreCase("chrome"))
    {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();

	}
  else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		}
		else
		{
			 driver = new ChromeDriver();
			 
    }
	sDriver=driver;
	
	System.out.println(" Launching the Browser");
}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
public void BM() throws Throwable
{
		File_Utility flib=new File_Utility();
		String URL = flib.getPropertyKeyValue("url");
	      String UserName = flib.getPropertyKeyValue("un");
			String PassWord = flib.getPropertyKeyValue("pw");
			
			driver.get(URL);
			LoginPage1 log=new  LoginPage1 (driver);
			 log.login(UserName, PassWord);
	System.out.println("Login to Application");
}
@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM()
	{
		System.out.println("Logout the Application");
	}
	
@AfterClass(groups = {"smokeTest","regressionTest"})
public void AC()
{
	System.out.println("Close the Browser");
}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("Executed sucessfully");
	}
@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("DataBase Close");
	}
}
