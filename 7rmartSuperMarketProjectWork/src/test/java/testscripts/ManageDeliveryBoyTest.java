package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends  Base {
	@Test
	public void verifyAdminAddNewDeliveryDetails()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		String name=ExcelUtility.getString(0, 1, "ManageDeliveryBoy");
		String email=ExcelUtility.getString(1, 1, "ManageDeliveryBoy");
	    String phoneNumber=ExcelUtility.getNumeric(2, 1, "ManageDeliveryBoy");
		String address=ExcelUtility.getString(3, 1, "ManageDeliveryBoy");
		String userName=ExcelUtility.getString(4, 1, "ManageDeliveryBoy");
		String password=ExcelUtility.getString(5, 1, "ManageDeliveryBoy");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageDeliveryBoyPage managedeliveryboy=new ManageDeliveryBoyPage(driver);
		managedeliveryboy.clickOnTheMoreInfoOnTheManageDeliveryBoy().clickOnNewButton().enterTheNameFiled(name).enterTheEmailFiled(email).enterThePhoneNumberFiled(phoneNumber).enterTheAddressFiled(address).enterTheUserNameFiled(userName).enterThePasswordFiled(password).clickOnTheSaveButton();
		boolean isAlertSucessfullMessageDisplay=managedeliveryboy.isAlertMessageDisplay();
		assertTrue(isAlertSucessfullMessageDisplay,"can't add the new delivery boy details");
	}
	@Test
	public void verifyWhetherClickOnTheActiveButton()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageDeliveryBoyPage managedeliveryboy=new ManageDeliveryBoyPage(driver);
		managedeliveryboy.clickOnTheMoreInfoOnTheManageDeliveryBoy().clickOnTheActiveButton();
		boolean isDeliveryBoyStatusChangedSucessfully=managedeliveryboy.isStatusChangedAlertMessageDisplay();
		assertTrue(isDeliveryBoyStatusChangedSucessfully,"Admin can't activated the button");
	}


}
