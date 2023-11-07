package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") WebElement manageDeliveryBoyInfoIncon;
    private @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
    private @FindBy(xpath="//input[@id='name']") WebElement nameTextFiled;
    private @FindBy(xpath="//input[@id='email']") WebElement emailFiled;
    private @FindBy(xpath="//input[@id='phone']") WebElement phoneNumberFiled;
    private @FindBy(xpath="//textarea[@id='address']") WebElement addressTextAreaFiled;
    private @FindBy(xpath="//input[@id='username']") WebElement usernameFiled;
    private @FindBy(xpath="//input[@id='password']") WebElement passwordFiled;
    private @FindBy(xpath="//button[@type='submit']") WebElement saveButton;
    private @FindBy(xpath="//h5[text()=' Alert!']") WebElement alertSucessfulMessage;
    private @FindBy(xpath="(//span[contains(@class,'bg-success')])[6]") WebElement activeButton;
    private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement statusChangedAlertMessage;

    public ManageDeliveryBoyPage clickOnTheMoreInfoOnTheManageDeliveryBoy()
    {
    	WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, manageDeliveryBoyInfoIncon);
		manageDeliveryBoyInfoIncon.click();
		return this;
    }
    public ManageDeliveryBoyPage clickOnNewButton()
    {
    	WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", newButton);
	    return this;
    }
    public ManageDeliveryBoyPage enterTheNameFiled(String name)
    {
    	nameTextFiled.sendKeys(name);
    	return this;
    }
    public ManageDeliveryBoyPage enterTheEmailFiled(String email)
    {
    	emailFiled.sendKeys(email);
    	return this;
    }
    public ManageDeliveryBoyPage enterThePhoneNumberFiled(String phoneNumber)
    {
    	phoneNumberFiled.sendKeys(phoneNumber);
    	return this;
    }
    public ManageDeliveryBoyPage enterTheAddressFiled(String address)
    {
    	addressTextAreaFiled.sendKeys(address);
    	return this;
    }
    public ManageDeliveryBoyPage enterTheUserNameFiled(String userName)
    {
    	passwordFiled.sendKeys(userName);
    	return this;
    }
    public ManageDeliveryBoyPage enterThePasswordFiled(String password)
    {
    	usernameFiled.sendKeys(password);
    	return this;
    }
    public ManageDeliveryBoyPage clickOnTheSaveButton()
    {
    	PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, saveButton);
		return this;
    }
    public boolean isAlertMessageDisplay()
    {
    	WaitUtility waitutility=new WaitUtility();
		waitutility.waitForVisibilityElement(driver, alertSucessfulMessage);
		return alertSucessfulMessage.isDisplayed();
    }
    public ManageDeliveryBoyPage clickOnTheActiveButton()
    {
    	//JavascriptExecutor executor = (JavascriptExecutor) driver;
	   // executor.executeScript("arguments[0].click();", activeButton);   
    	PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, activeButton);
		return this;
    }
    public boolean isStatusChangedAlertMessageDisplay()
    {
    	WaitUtility waitutility=new WaitUtility();
		waitutility.waitForVisibilityElement(driver, statusChangedAlertMessage);
		return statusChangedAlertMessage.isDisplayed();
    }
	
}



