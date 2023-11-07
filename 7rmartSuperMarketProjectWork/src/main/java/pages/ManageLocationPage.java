package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	public WebDriver driver;
	public ManageLocationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']") WebElement manageLocationfoIcon;
	private @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	private @FindBy(xpath="//select[@id='country_id']") WebElement countryDropDown;
	private @FindBy(xpath="//select[@id='st_id']") WebElement stateDropDown;
	private @FindBy(xpath="//input[@name='location']") WebElement locationFiled;
	private @FindBy(xpath="//input[@id='delivery']") WebElement deliveryChargeFiled;
	private @FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement locationCreatedAlert;
	
	
	public ManageLocationPage clickOnTheManageLocationfoIcon()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, manageLocationfoIcon);
		
		return this;
	}
	public ManageLocationPage clickOnTheNewButton()
	{
		
		newButton.click();
		return this;
	}
	public  ManageLocationPage selectCountryDropDown(String countryName)
	{
		
		PageUtility pageutility=new PageUtility();
		pageutility.selectOptionByVisibleText(countryDropDown, countryName);
		return this;
	}
	public  ManageLocationPage selectStateDropDown(String  stateValue )
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectOptionFromDropDown(stateDropDown, driver);
		pageutility.selectOptionValue(stateDropDown, stateValue);
		return this;
	}
	
	public  ManageLocationPage  enterTheLocation(String locationName)
	{
		locationFiled.sendKeys(locationName);
		return this;
	}
	public  ManageLocationPage  enterTheDeliveryCharge(String charge)
	{
		deliveryChargeFiled.sendKeys(charge);
		return this;
	}
	public  ManageLocationPage  clickOnTheSaveButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	public boolean isAlertMessageDisplay()
	{
		
		return locationCreatedAlert.isDisplayed();
	}
	
}



