package com.crm.Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener 
{
//ExtentReports report;
//ExtentTest test;
	public void onTestStart(ITestResult result) 
	{
	//	test=report.createTest(result.getMethod().getMethodName());
		}

	public void onTestSuccess(ITestResult result) {
		//test.log(Status.PASS,result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL,result.getMethod().getMethodName());
		//test.log(Status.FAIL,result.getThrowable());
		//String filePath=null;
		try {
			
			//filepath=new WebDriver_Utility1().takeScreenshot(null, filePath)
		} catch (Exception e) {
			
		}
		
		String testname = result.getMethod().getMethodName();
		System.out.println(testname+"=====Execute and I am listening====");
		
EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		try
		{	
File destFile = new File("./com.crm.SeleniumSdet42FrameWork/ScreenShot/"+testname+".png");
FileUtils.copyFile(srcFile, destFile);
		}
		catch (Throwable e) 
		{
			e.printStackTrace();
	}

		}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			}

	public void onTestFailedWithTimeout(ITestResult result) {
		}

	public void onStart(ITestContext context) {
		}

	public void onFinish(ITestContext context) {
			}
	

	
	
}
