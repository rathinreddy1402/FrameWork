package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1{

	//Initialization
	public LoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passWordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;

	//getter methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	public WebElement getPassWordTextField() {
		return passWordTextField;
	}
    public WebElement getSubmitbutton() {
		return submitbutton;
	}
	//Business logics
	/**
	 * this method is used to login the app
	 * @author Shobha
	 */
	public void login(String userName,String passWord)
	{
		userNameTextField.sendKeys(userName);
		passWordTextField.sendKeys(passWord);
		submitbutton.click();
	}
}
