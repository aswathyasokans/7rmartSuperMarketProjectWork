package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//input[@name='username']") WebElement userNameFiled;
	private @FindBy(xpath="//input[@name='password']") WebElement passwordFiled;
	private @FindBy(xpath="//button[@type='submit']")  WebElement signinButton;
	private @FindBy(xpath="//div[@class='container-fluid']//following::p[text()='Manage Pages']") WebElement  managePagesOnHomePage;
	private @FindBy(xpath="//div[contains(@class,'alert-danger')]//child::h5[text()=' Alert!']") WebElement alertMessageBox;

	public LoginPage enterUserNameOnUserNameFiled(String userName)
	{
		userNameFiled.sendKeys(userName);
		return this;
	}
	public LoginPage enterPasswordOnPasswordFiled(String password)
	{
		passwordFiled.sendKeys( password);
		return this;
	}
	public LoginPage clickOnTheSignButton()
	{
		signinButton.click();
		return this;
	}
	public boolean isHomePageDisplayed()
	{
		return  managePagesOnHomePage.isDisplayed();
	}
	 public boolean isAlertMessageDisplay()
	 {
		 return alertMessageBox.isDisplayed();
	 }

}
