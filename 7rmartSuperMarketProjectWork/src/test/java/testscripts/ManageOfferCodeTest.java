package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base {
	@Test(groups = {"regression"},description="Verify an admin add a new offer information",retryAnalyzer=Retry.class)
	public void verifyAddNewOfferInformation()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String offerCode=ExcelUtility.getString(0, 1, "ManageOfferCodePage");
		String percentage=ExcelUtility.getNumeric(1, 1, "ManageOfferCodePage");
		String amount=ExcelUtility.getNumeric(2,1,"ManageOfferCodePage");
		String description=ExcelUtility.getString(3, 1, "ManageOfferCodePage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageOfferCodePage manageoffercodepage=new  ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferCodeInfoIncon().clickOnNewButton().enterTheOfferCode(offerCode).enterThePercentage(percentage).enterTheAmount(amount).enterTheDescription(description).clickOnChooseFile().clickOnTheSaveButton();
		boolean isSucessFulCodeOfferAlertDisplay=manageoffercodepage.isAlertOfferCodeSuccessful();
		assertTrue(isSucessFulCodeOfferAlertDisplay,"Admin can't add new offer information");
	}
	@Test(groups = {"regression"},description="Verify to search a list offer codes",retryAnalyzer=Retry.class)
	public void verifySearchListOfferCodes()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String offerCode=ExcelUtility.getString(0, 1, "ManageOfferCodePage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageOfferCodePage manageoffercodepage=new  ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferCodeInfoIncon().clickOnSearchButton().enterTheTextFiledOfOfferCode(offerCode).clickOnSearchButtonOfferCode();
		boolean isElementPresentInTheTable=manageoffercodepage.elementPresent();
		assertTrue(isElementPresentInTheTable,"can't search the list of offer codes");
	}


}
