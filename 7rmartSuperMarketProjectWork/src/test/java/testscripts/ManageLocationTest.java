package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	@Test
	public void verifyAdminAddNewLocation()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(0, 1, "Login");
		String countryName=ExcelUtility.getString(0, 1, "ManageLocation");
		String stateValue=ExcelUtility.getNumeric(1, 1, "ManageLocation");
		String locationName=ExcelUtility.getString(2, 1, "ManageLocation");
		String charge=ExcelUtility.getNumeric(3, 1,"ManageLocation");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageLocationPage managepagelocation=new ManageLocationPage(driver);
		managepagelocation.clickOnTheManageLocationfoIcon().clickOnTheNewButton().selectCountryDropDown(countryName).selectStateDropDown(stateValue).enterTheLocation(locationName).enterTheDeliveryCharge(charge).clickOnTheSaveButton();
		boolean isSucessAlertDisplay=managepagelocation.isAlertMessageDisplay()	;
		assertTrue( isSucessAlertDisplay,"Admin can't add new location");
		
	}

}
