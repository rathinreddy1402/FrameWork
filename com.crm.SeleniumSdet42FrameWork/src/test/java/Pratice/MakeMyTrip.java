package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws Throwable {
		String Key="webdriver.chrome.driver";
	    String value="C:\\Users\\Shobha\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();       
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
		FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url1");
		driver.get(URL);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		//from
		String srcCity = "New Delhi, India";
		
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		src.sendKeys("'"+srcCity+"'");
		driver.findElement(By.xpath("//p[text()='"+srcCity+"']")).click();
		
		//To
	   String desCity = "Mumbai, India";
		WebElement des = driver.findElement(By.xpath("//input[@id='toCity']"));
		des.sendKeys("'"+desCity+"'");
		driver.findElement(By.xpath("//p[text()='"+desCity+"']")).click();
		
		
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	Thread.sleep(1000);
	
	String month = "September 2022";
	String date = "30";
	
	//Dynamic Xpath
	 WebElement data = driver.findElement(By.xpath("//div[text()='"+month+"']"
				+ "/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
		
	data.click();
	
	//return
	
	
		
	//div[text()='October 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']
		
		
		
		
		
		
		
		
		
		
	}

}
