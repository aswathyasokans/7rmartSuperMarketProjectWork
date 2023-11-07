package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.MobileSliderPage;
import retry.Retry;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base {
	@Test(groups = {"regression"},description="Verify to add a new mobile slider",retryAnalyzer=Retry.class)
	public void verifyAddNewMobileSlider()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String category=ExcelUtility.getString(0, 1, "MobilePhoneSliderPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		MobileSliderPage mobileslider=new MobileSliderPage(driver);
		mobileslider.clickOnMobileSliderInfoIcon().clickOnNewButton().clickOnCategoryDropDown(category).clickOnChooseFileUpload().clickOntheSaveButton();
		 boolean isSucessFulMessageDisplay=mobileslider.alertMessageISDisplay();
		 assertTrue(isSucessFulMessageDisplay,"Can't add the new mobile slider");
	
	}
	@Test(groups = {"regression"},description="Verify to delete a item in the mobile silder",retryAnalyzer=Retry.class)
	public void verifyDeleteItemInMobileSlider()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		MobileSliderPage mobileslider=new MobileSliderPage(driver);
		mobileslider.clickOnMobileSliderInfoIcon().clickOnDeleteIcon();
		 boolean isSucessFulDeleteMessageDisplay=mobileslider.alertDeleteMessageISDisplay();
		 assertTrue(isSucessFulDeleteMessageDisplay,"Can't delete an item in the  mobile slider");
	}

}
