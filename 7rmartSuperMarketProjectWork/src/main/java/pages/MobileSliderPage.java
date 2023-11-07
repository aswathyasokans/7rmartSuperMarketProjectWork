package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage {
	public WebDriver driver;
	public MobileSliderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']") WebElement mobileSliderInfoIcon;
	private @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	private @FindBy(xpath="//option[text()='IphoneAirpod']//parent::select") WebElement categoryDropDown;
	private @FindBy(xpath="//input[@id='main_img']") WebElement chooseFileButton;
	private @FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertMessage;
	private @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/delete?del=673&page_ad=1']") WebElement deleteIcon;
	private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement deleteAlertMessage;
	
	public MobileSliderPage clickOnMobileSliderInfoIcon()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, mobileSliderInfoIcon);
		mobileSliderInfoIcon.click();
		return this;
	}
	public MobileSliderPage clickOnNewButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", newButton);
	    return this;
	}
	public MobileSliderPage clickOnCategoryDropDown(String category)
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectOptionByVisibleText(categoryDropDown, category);
		
		return this;
	}
	public MobileSliderPage clickOnChooseFileUpload()
	{
		String filepath=GeneralUtility.IMAGEAPPLEAIRPOD;
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, filepath);
		return this;
		
	}

	public MobileSliderPage clickOntheSaveButton()
	{

		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	public boolean   alertMessageISDisplay()
	{
		return alertMessage.isDisplayed();
	}
	public MobileSliderPage clickOnDeleteIcon()
	{
		/*WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver,deleteIcon);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", deleteIcon);*/
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, deleteIcon);
		pageutility.acceptAlert(driver);
		return this;
	}
	
	public boolean   alertDeleteMessageISDisplay()
	{
		return deleteAlertMessage.isDisplayed();
	}
	
}
