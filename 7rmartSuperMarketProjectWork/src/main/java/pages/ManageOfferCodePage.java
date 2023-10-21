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

public class ManageOfferCodePage {
	public WebDriver driver;
	public ManageOfferCodePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']") WebElement manageOfferCodeInfoIcon;
	private @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	private @FindBy(xpath="//input[@id='offer_code']") WebElement offerCodeFiled;
	private @FindBy(xpath="//input[@value='yes']") WebElement radioButtonYes;
	private @FindBy(xpath="//input[@value='no']") WebElement radioButtonNo;
	private @FindBy(xpath="//input[@id='offer_per']") WebElement percentageFiled;
	private @FindBy(xpath="//input[@id='offer_price']") WebElement amountFiled;
	private @FindBy(xpath="//div[contains(@class,'note-editable')]") WebElement descriptionFiled;
	private @FindBy(xpath="//input[@id='main_img']") WebElement chooseFileUploadButton;
	private @FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement offerCreatedMessage;
	private @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
	private @FindBy(xpath="//input[@class='form-control']") WebElement textFieldOfferCode;
	private @FindBy(xpath="//button[@name='Search']") WebElement searchButtonOfferCode;
	private @FindBy(xpath="//table[contains(@class,'table-bordered')]//tr//td") WebElement offerCodeElement;
	
	public ManageOfferCodePage clickOnManageOfferCodeInfoIncon()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, manageOfferCodeInfoIcon);
		manageOfferCodeInfoIcon.click();
		return this;
	}
	public ManageOfferCodePage clickOnNewButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", newButton);
	    return this;
	}
	public ManageOfferCodePage enterTheOfferCode(String offerCode)
	{
		offerCodeFiled.sendKeys(offerCode);
		return this;
		
	}
	public  ManageOfferCodePage clickOnFirstOrderUser()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.radioButton(driver, radioButtonYes);
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, radioButtonYes);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", radioButtonYes);
	    return this;
	}
	public ManageOfferCodePage enterThePercentage(String percentage)
	{
		percentageFiled.sendKeys(percentage);
		return this;
	}
	
	public ManageOfferCodePage enterTheAmount(String amount)
	{
		amountFiled.sendKeys(amount);
		return this;
	}
	public ManageOfferCodePage enterTheDescription(String description)
	{
		descriptionFiled.sendKeys(description);
		return this;
	}
	public ManageOfferCodePage clickOnChooseFile() 
	{
		String filepath=GeneralUtility.FILEUPLOADIMAGECAKE;
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileUploadButton, filepath);
		return this;
	}
	public ManageOfferCodePage clickOnTheSaveButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	public boolean isAlertOfferCodeSuccessful() 
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForVisibilityElement(driver, offerCreatedMessage);
		return offerCreatedMessage.isDisplayed();
	}
	public  ManageOfferCodePage clickOnSearchButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", searchButton);
	    return this;
	}
	public  ManageOfferCodePage enterTheTextFiledOfOfferCode(String offerCode)
	{
		textFieldOfferCode.sendKeys(offerCode);
		return this;
	}
	public  ManageOfferCodePage clickOnSearchButtonOfferCode()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", searchButtonOfferCode);
	    return this;
	}
	public boolean elementPresent()
	{
		return offerCodeElement.isDisplayed();
		
	}

}
