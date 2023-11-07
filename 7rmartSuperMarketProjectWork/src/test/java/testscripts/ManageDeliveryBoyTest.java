package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends  Base {
	@Test(groups = {"regression"},description="Verify an admin add a new delivery boy details",retryAnalyzer=Retry.class)
	public void verifyAdminAddNewDeliveryDetails()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String name=ExcelUtility.getString(0, 1, "ManageDeliveryBoyPage");
		String email=ExcelUtility.getString(1, 1, "ManageDeliveryBoyPage");
	    String phoneNumber=ExcelUtility.getNumeric(2, 1, "ManageDeliveryBoyPage");
		String address=ExcelUtility.getString(3, 1, "ManageDeliveryBoyPage");
		String userName=ExcelUtility.getString(4, 1, "ManageDeliveryBoyPage");
		String password=ExcelUtility.getString(5, 1, "ManageDeliveryBoyPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageDeliveryBoyPage managedeliveryboy=new ManageDeliveryBoyPage(driver);
		managedeliveryboy.clickOnTheMoreInfoOnTheManageDeliveryBoy().clickOnNewButton().enterTheNameFiled(name).enterTheEmailFiled(email).enterThePhoneNumberFiled(phoneNumber).enterTheAddressFiled(address).enterTheUserNameFiled(userName).enterThePasswordFiled(password).clickOnTheSaveButton();
		boolean isAlertSucessfullMessageDisplay=managedeliveryboy.isAlertMessageDisplay();
		assertTrue(isAlertSucessfullMessageDisplay,"can't add the new delivery boy details");
	}
	@Test(groups = {"regression"},description="Verify to whether an admin click on the active button",retryAnalyzer=Retry.class)
	public void verifyWhetherClickOnTheActiveButton()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageDeliveryBoyPage managedeliveryboy=new ManageDeliveryBoyPage(driver);
		managedeliveryboy.clickOnTheMoreInfoOnTheManageDeliveryBoy().clickOnTheActiveButton();
		boolean isDeliveryBoyStatusChangedSucessfully=managedeliveryboy.isStatusChangedAlertMessageDisplay();
		assertTrue(isDeliveryBoyStatusChangedSucessfully,"Admin can't activated the button");
	}


}
