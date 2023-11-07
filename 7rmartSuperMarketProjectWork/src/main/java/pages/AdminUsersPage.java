package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminUsersInfoIcon;
	private @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	private @FindBy(xpath="//input[@id='username']") WebElement usernameFiled;
	private @FindBy(xpath="//input[@id='password']") WebElement passwordField;
	private @FindBy(xpath="//select[@id='user_type']") WebElement userTypeDropDown;
	private @FindBy(xpath="//button[@name='Create']") WebElement saveButton;
	private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertMessage;
	private @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
	private @FindBy(xpath="//table[contains(@class,'table-bordered')]//tr//td") List <WebElement> tableAdminUSer;
	private @FindBy(xpath="//td[text()='Meri']") WebElement tableElement;
	private @FindBy(xpath="//select[@id='ut']") WebElement userTypeDropDownFiled;
	private @FindBy(xpath="//input[@id='un']") WebElement userNameTextFiled;
	private @FindBy(xpath="//button[@name='Search']") WebElement searchAdminUserButton;


	public AdminUsersPage clickOnThedminUsersInfoIncon()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, adminUsersInfoIcon);
		adminUsersInfoIcon.click();
		return this;
	}
	public AdminUsersPage clickOnNewButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", newButton);

		return this;
	}
	public AdminUsersPage enterTheUserName(String userName)
	{

		usernameFiled.sendKeys(userName);
		return this;
	}
	public AdminUsersPage enterThePassword(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public AdminUsersPage clickOnUserType(String userType)
	{
		
		PageUtility pageutility=new PageUtility();
		pageutility.selectOptionFromDropDown(userTypeDropDown, driver);
		pageutility.selectOptionValue(userTypeDropDown, userType);

		return this;
	}

	public AdminUsersPage clickOnSaveButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, saveButton);
		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	public boolean isAlertMessageDisplay()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForVisibilityElement(driver, alertMessage);
		return alertMessage.isDisplayed();
	}
	public AdminUsersPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	public AdminUsersPage enterTheUserNameFiled(String userName)
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, userNameTextFiled);
		userNameTextFiled.click();
		userNameTextFiled.sendKeys(userName);
		return this;
	}
	public AdminUsersPage clickOnUserTypeSearch(String userTypeSearch)
	{
		
		PageUtility pageutility=new PageUtility();
		pageutility.selectOptionFromDropDown(userTypeDropDownFiled, driver);
		pageutility.selectOptionValue(userTypeDropDownFiled, userTypeSearch);

		return this;
	}
	
	public List<WebElement> getAdminUserTableElement()
	{
		return tableAdminUSer;

	}
	public AdminUsersPage listOfAdminUserTableElement()
	{
		List<String> dataTable=new ArrayList<>();
		for(WebElement elementTable:tableAdminUSer)
		{
			String elementInTheTable=elementTable.getText();
			dataTable.add(elementInTheTable);
		}
		return this;
	}
	public boolean isTableElementDisplay()
	{
		return tableElement.isDisplayed();
	}
	public AdminUsersPage clickOnSearchAdminUserButton()
	{
		searchAdminUserButton.click();
		return this;
	}

}
