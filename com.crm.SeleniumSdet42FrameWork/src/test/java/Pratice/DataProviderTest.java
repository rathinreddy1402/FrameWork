package Pratice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class DataProviderTest  {
		 @Test(dataProvider="dataProvider_test")
		
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
			public Object[][] dataProvider_test()
			{
				Object[][] objArr=new Object[3][3];
				objArr[0][0]="AAA";
				objArr[0][1]="9845555258";
				objArr[0][2]="sfgjhg@gmail.com";
				
				objArr[1][0]="BBB";
				objArr[1][1]="983596544";
				objArr[1][2]="hgfug@gamil.com";
				
				objArr[2][0]="CCC";
				objArr[2][1]="6652445643";
				objArr[2][2]="ehfjefkjb@gmail.com";
				
				return objArr;
		
			}
		}


