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

public class ManageSliderPage {
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") WebElement manageSliderInfoIncon;
	private @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	private @FindBy(xpath="//input[@id='main_img']") WebElement chooseFileButton;
	private @FindBy(xpath="//input[@type='text']") WebElement linkTextFiled;
	private @FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertSucessgulMessage;
	private @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/slider/edit?edit=874&page_ad=1']") WebElement editIconButon;
	private @FindBy(xpath="//input[@value='http:electroniccircuit']") WebElement reLinkTextField;
	private @FindBy(xpath="//button[@name='update']") WebElement updateButton;
	private @FindBy(xpath="//div[contains(@class,' alert-success')]//child::button") WebElement sliderChangeAlert;
	public ManageSliderPage clickOnManageSliderInfoIncon()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, manageSliderInfoIncon);
		manageSliderInfoIncon.click();
		return this;
	}
	public ManageSliderPage clickOnNewButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", newButton);
	    return this;
	}
	public ManageSliderPage clickOnTheChooseFile()
	{
		String filepath=GeneralUtility.FILEUPLOADIMAGECIRCUITBOARD;
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, filepath);
		return this;
	}
	public ManageSliderPage enterTheLinkTextFiled(String link)
	{
		linkTextFiled.clear();
		linkTextFiled.sendKeys(link);
		return this;
	}
	public ManageSliderPage clickOnSaveButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	public boolean isAlertMessageDisplay()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForVisibilityElement(driver, alertSucessgulMessage);
		return alertSucessgulMessage.isDisplayed();
	}
	public ManageSliderPage  clickOnEditIconButtonInTheTable()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, editIconButon);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", editIconButon);
		return this;
	}
	
	public ManageSliderPage clickOnUpdateButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, updateButton);
		return this;
	}
	public  boolean alertSliderChangeMessageDiplay()
	{
		return sliderChangeAlert.isDisplayed();
	}

}
