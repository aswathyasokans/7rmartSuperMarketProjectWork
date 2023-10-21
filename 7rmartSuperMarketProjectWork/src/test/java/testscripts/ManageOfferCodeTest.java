package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base {
	@Test
	public void verifyAddNewOfferInformation()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		String offerCode=ExcelUtility.getString(0, 1, "ManageOfferCode");
		String percentage=ExcelUtility.getNumeric(1, 1, "ManageOfferCode");
		String amount=ExcelUtility.getNumeric(2,1,"ManageOfferCode");
		String description=ExcelUtility.getString(3, 1, "ManageOfferCode");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageOfferCodePage manageoffercodepage=new  ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferCodeInfoIncon().clickOnNewButton().enterTheOfferCode(offerCode).enterThePercentage(percentage).enterTheAmount(amount).enterTheDescription(description).clickOnChooseFile().clickOnTheSaveButton();
		boolean isSucessFulCodeOfferAlertDisplay=manageoffercodepage.isAlertOfferCodeSuccessful();
		assertTrue(isSucessFulCodeOfferAlertDisplay,"Admin can't add new offer information");
	}
	@Test
	public void verifySearchListOfferCodes()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		String offerCode=ExcelUtility.getString(0, 1, "ManageOfferCode");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageOfferCodePage manageoffercodepage=new  ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferCodeInfoIncon().clickOnSearchButton().enterTheTextFiledOfOfferCode(offerCode).clickOnSearchButtonOfferCode();
		boolean isElementPresentInTheTable=manageoffercodepage.elementPresent();
		assertTrue(isElementPresentInTheTable,"can't search the list of offer codes");
	}


}
