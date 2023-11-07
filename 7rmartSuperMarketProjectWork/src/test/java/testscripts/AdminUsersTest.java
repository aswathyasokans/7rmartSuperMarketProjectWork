package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.AdminUsersPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test(groups = {"regression"},description="Verify admin add a new information",retryAnalyzer=Retry.class)
	public void verifyAdminAddNewInformation()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(0, 1, "LoginPage");

		String userName=ExcelUtility.getString(0, 1, "AdminUsersPage");
		String password=ExcelUtility.getString(1, 1, "AdminUsersPage");
		String userType=ExcelUtility.getString(2, 1, "AdminUsersPage");

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

		AdminUsersPage adminuserpage=new AdminUsersPage(driver);

		adminuserpage.clickOnThedminUsersInfoIncon().clickOnNewButton().enterTheUserName(userName).enterThePassword(password).clickOnUserType(userType).clickOnSaveButton();
		boolean alertSucessfullMessageDisplay=adminuserpage.isAlertMessageDisplay();
		assertTrue(alertSucessfullMessageDisplay,"Admin can't add new information");
	}
	
	@Test(groups = {"regression"},description="Verify to search an admin users",retryAnalyzer=Retry.class)
	public void verifyToSearchAdminUesrs()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(0, 1, "LoginPage");

		String userName=ExcelUtility.getString(0, 1, "AdminUsersPage");
		String userType=ExcelUtility.getString(2, 1, "AdminUsersPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

		AdminUsersPage adminuserpage=new AdminUsersPage(driver);
		adminuserpage.clickOnThedminUsersInfoIncon().clickOnSearchButton().enterTheUserNameFiled(userName).clickOnUserType(userType).clickOnSearchAdminUserButton();

		boolean isTableElementDisplayed=adminuserpage.isTableElementDisplay();
		assertTrue(isTableElementDisplayed,"Can't search the admin users");
	
	}
}

