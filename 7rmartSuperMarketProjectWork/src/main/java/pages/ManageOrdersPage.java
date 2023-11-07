package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOrdersPage {
	public WebDriver driver;
	public ManageOrdersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']") WebElement manageOrderInfoIcon;
	private @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
	private @FindBy(xpath="//input[@id='od']") WebElement orderId;
	private @FindBy(xpath="//input[@id='sd']") WebElement dateStart;
	private @FindBy(xpath="//select[@id='pt']") WebElement paymentModeDropDown;
	private @FindBy(xpath="//select[@id='st']") WebElement statusDropDown;
	private @FindBy(xpath="//button[@name='Search']") WebElement searchListButton;
	private @FindBy(xpath="//table[contains(@class,'table-bordered')]//tr//td[text()='283']") WebElement tableElement;
	private @FindBy(xpath="//button[text()='Reset']") WebElement resetButton;
	
	public ManageOrdersPage clickOnTheManageOrderInfoIcon()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, manageOrderInfoIcon);
		manageOrderInfoIcon.click();
		return this;
	}
	public ManageOrdersPage clickOnSearchButton()
	{
		
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, searchButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", searchButton);
	    return this;
	}
	public ManageOrdersPage enterTheOrderId(String orderId)
	{
		  dateStart.sendKeys(orderId);
		return this;
	}
	
	public ManageOrdersPage selectStartDate(String date)
	{
		  dateStart.sendKeys(date);
		return this;
	}
	public  ManageOrdersPage selectPaymentModeDropDown(String paymentMode )
	{
		PageUtility pageutility=new PageUtility();
		 pageutility.selectOptionByVisibleText(tableElement, paymentMode);
		return this;
	}
	public  ManageOrdersPage selectStatusDropDown(String status )
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectOptionFromDropDown(statusDropDown, driver);
		pageutility.selectOptionValue(statusDropDown,  status);
		return this;
	}
	public ManageOrdersPage clickOnSearchListButton()
	{
		
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, searchListButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", searchListButton);
		return this;
		
	}
	public boolean isTableElementDisplay()
	{
		return tableElement.isDisplayed();
		}
	public ManageOrdersPage clickOnResetButton()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, resetButton);
		
		return this;
		
	}
}
