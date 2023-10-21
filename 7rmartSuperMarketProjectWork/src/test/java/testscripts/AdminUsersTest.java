package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test
	public void verifyAdminAddNewInformation()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(0, 1, "Login");

		String userName=ExcelUtility.getString(0, 1, "AdminUsers");
		String password=ExcelUtility.getString(1, 1, "AdminUsers");
		String userType=ExcelUtility.getString(2, 1, "AdminUsers");

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

		AdminUsersPage adminuserpage=new AdminUsersPage(driver);

		adminuserpage.clickOnThedminUsersInfoIncon().clickOnNewButton().enterTheUserName(userName).enterThePassword(password).clickOnUserType(userType).clickOnSaveButton();
		boolean alertSucessfullMessageDisplay=adminuserpage.isAlertMessageDisplay();
		assertTrue(alertSucessfullMessageDisplay,"Admin can't add new information");
	}
	
	@Test
	public void verifyToSearchAdminUesrs()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(0, 1, "Login");

		String userName=ExcelUtility.getString(0, 1, "AdminUsers");
		String userType=ExcelUtility.getString(2, 1, "AdminUsers");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

		AdminUsersPage adminuserpage=new AdminUsersPage(driver);
		adminuserpage.clickOnThedminUsersInfoIncon().clickOnSearchButton().enterTheUserNameFiled(userName).clickOnUserType(userType).clickOnSearchAdminUserButton();

		boolean isTableElementDisplayed=adminuserpage.isTableElementDisplay();
		assertTrue(isTableElementDisplayed,"Can't search the admin users");
	
	}
}

