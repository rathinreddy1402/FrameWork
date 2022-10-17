package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage {

	public CampaignCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignCreateImage;

	public WebElement getCampaignCreateImage() {
		return campaignCreateImage;
	}
    @FindBy(xpath="//input[@id='search_txt']")
	private WebElement productTextField;

	@FindBy(css="input[name='search']")
	private WebElement searchProductButton;

	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productSelectionImage;
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignTextField;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
//getter methods
	public WebElement getProductSelectionImage() {
		return productSelectionImage;
	}

	public WebElement getProductTextField() {
		return productTextField;
	}
	public WebElement getSearchProductButton() {
		return searchProductButton;
	}

	public WebElement getCampaignTextField() {
		return campaignTextField;
	} 
	public WebElement getSaveButton() {
		return saveButton;
	}
	//Business logics
   public void campaignCreateImage()
	{
		campaignCreateImage.click();	
	}
	
	public void campaignTextField(String campaignName)
	{
		campaignTextField.sendKeys(campaignName);
	}
	
	public void saveButton()
	{
		saveButton.click();	
	}
	
	public void productSelectionImage()
	{
//		Actions act=new Actions(driver);
//		act.moveToElement(productSelectionImage).perform();
		productSelectionImage.click();
		}
	
	public void productTextField(String ProductName)
	{
		productTextField.sendKeys(ProductName);
	}
	
	public void searchProductButton(WebDriver driver,String productName)
	{
		searchProductButton.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	}
}
