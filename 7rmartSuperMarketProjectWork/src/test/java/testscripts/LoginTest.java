package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import retry.Retry;

import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test(groups = {"regression"},description="Verify whether user is able to login using valid username and password",retryAnalyzer=Retry.class)
	public void verifyAnUserAbleToLoginWithValidCredentials()
	{ 
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginclasspage=new LoginPage(driver);
		loginclasspage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		boolean isHomePageAvilable=loginclasspage.isHomePageDisplayed();
		assertTrue(isHomePageAvilable,"User unable to login with validCrenditals");

	}
	@Test(groups = {"regression"},description="Verify whether user is able to login using invalid username and invalid password",retryAnalyzer = Retry.class)
	public void verifyAnUserUnableToLoginWithInvalidUserNameAndInValidPassword()
	{
		String invalidUserName=ExcelUtility.getString(1, 1, "LoginPage");
		String invalidPassword=ExcelUtility.getString(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(invalidUserName).enterPasswordOnPasswordFiled(invalidPassword).clickOnTheSignButton();
		boolean isAlertMessageAvailable=loginpage.isAlertMessageDisplay();
		assertTrue(isAlertMessageAvailable,"An user can able to login with invalid user name and password");

	}
	@Test(groups = {"smoke"},description="Verify whether user is able to login using valid username and invalid password",retryAnalyzer=Retry.class)
	public void verifyAnUserAbleToLoginWithValidUserNameAndInvalidPassword()
	{
		String validUserName=ExcelUtility.getString(2, 1, "LoginPage");
		String invalidPassword=ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(invalidPassword).clickOnTheSignButton();
		boolean isAlertMessageAvailable=loginpage.isAlertMessageDisplay();
		assertTrue(isAlertMessageAvailable,"An user can able to login with invalid user name and password");
	}
	@Test(dataProvider = "LoginProvider",groups = {"regression","smoke"},description="Verify whether user is able to login using invalid username and password",retryAnalyzer=Retry.class)
	public void verifyAnUserAbleToLoginWithInvalidUserNameAndPassword(String invalidUserName,String validPassword)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(invalidUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		boolean isAlertMessageAvailable=loginpage.isAlertMessageDisplay();
		assertTrue(isAlertMessageAvailable,"An user can able to login with invalid user name and password");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(3, 1, "LoginPage"), ExcelUtility.getString(4, 1, "LoginPage") },
		};
}
}
