package com.crm.Organisation;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility1;
import com.crm.ObjectRepository.HomePage1;
import com.crm.ObjectRepository.OrganizationCreationPage1;
import com.crm.ObjectRepository.ValidationAndVerificationPage;




public class CreateOrganizationTest extends BaseClass {
@Test (retryAnalyzer=com.crm.Generic_Utilities.RetryAnalyser.class)
	//@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable
	{
		File_Utility flib=new File_Utility();
	    Excel_Utility elib=new  Excel_Utility();
		WebDriver_Utility1 wlib=new WebDriver_Utility1();
		Java_Utility jlib=new Java_Utility();
		wlib.waitForPageToLoad(driver);
		HomePage1 home=new  HomePage1(driver);
		home.clickOrganizationsLinkText();
			//Assert.assertEquals(true, false);
	OrganizationCreationPage1 org= new OrganizationCreationPage1(driver);

org.clickOrganizationCreateImage();
int ranNum = jlib.getRanDomNum();
String data = elib.getDataFromExcel("Organisation", 0, 0)+ranNum;
org.organizationNamesTextField(data);

//SoftAssert soft=new SoftAssert();
//soft.assertEquals("A","B");
org.saveButton();
ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
validate.organisationValidation(driver, data);
home.signoutLink(driver);
//soft.assertAll();
	}
}
