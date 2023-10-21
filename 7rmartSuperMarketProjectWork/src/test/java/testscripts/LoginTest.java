package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	public void verifyAnUserAbleToLoginWithValidCredentials()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		LoginPage loginclasspage=new LoginPage(driver);
		loginclasspage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		boolean isHomePageAvilable=loginclasspage.isHomePageDisplayed();
		assertTrue(isHomePageAvilable,"User unable to login with validCrenditals");

	}
	@Test
	public void verifyAnUserUnableToLoginWithInvalidUserNameAndPassword()
	{
		String invalidUserName=ExcelUtility.getString(1, 1, "Login");
		String invalidPassword=ExcelUtility.getString(2, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(invalidUserName).enterPasswordOnPasswordFiled(invalidPassword).clickOnTheSignButton();
		boolean isAlertMessageAvailable=loginpage.isAlertMessageDisplay();
		assertTrue(isAlertMessageAvailable,"An user can able to login with invalid user name and password");

	}
	@Test
	public void verifyAnUserAbleToLoginWithValidUserNameAndInvalidPassword()
	{
		String validUserName=ExcelUtility.getString(2, 1, "Login");
		String invalidPassword=ExcelUtility.getString(3, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(invalidPassword).clickOnTheSignButton();
		boolean isAlertMessageAvailable=loginpage.isAlertMessageDisplay();
		assertTrue(isAlertMessageAvailable,"An user can able to login with invalid user name and password");
	}
	@Test
	public void verifyAnUserAbleToLoginWithInvalidUserNameAndPassword()
	{
		String invalidUserName=ExcelUtility.getString(3, 1, "Login");
		String validPassword=ExcelUtility.getString(4, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(invalidUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		boolean isAlertMessageAvailable=loginpage.isAlertMessageDisplay();
		assertTrue(isAlertMessageAvailable,"An user can able to login with invalid user name and password");
	}
}
