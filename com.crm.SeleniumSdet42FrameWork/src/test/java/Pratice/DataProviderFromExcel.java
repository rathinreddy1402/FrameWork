package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFromExcel {



	@Test(dataProvider="getData")
	
	public void companyDetails(String name,String phnum,String email) throws Throwable
	{
	String Key="webdriver.chrome.driver";
	String value="C:\\Users\\Shobha\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe";
	System.setProperty(Key, value);
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

driver.get("http://localhost:8888/");
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	driver.findElement(By.name("accountname")).sendKeys(name);
	driver.findElement(By.id("phone")).sendKeys(phnum);
	driver.findElement(By.id("email1")).sendKeys(email);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
driver.quit();
Thread.sleep(2000);
	}
	
	@DataProvider
	
	public String[][] getData() throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./Book2.xlsx");
        Workbook book=WorkbookFactory.create(fis1);
       
        Sheet sh = book.getSheet("DataProvider");
      int numrow = sh.getPhysicalNumberOfRows();//num of rows
      int numcel = sh.getRow(0).getLastCellNum();
      
      String[][] data=new String[numrow-1][numcel];
      for(int i=0;i<numrow;i++)
      {
    	  for(int j=0;j<numcel;j++)
    	  {
    		  DataFormatter format=new DataFormatter();
    		  data[i][j]=format.formatCellValue(sh.getRow(i+1).getCell(j));
    	  }
      }
      
		return data;
		
	}
}
