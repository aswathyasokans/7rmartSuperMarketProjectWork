package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base {
	@Test
	public void verifyAddNewMobileSlider()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		String category=ExcelUtility.getString(0, 1, "MobilePhoneSlider");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		MobileSliderPage mobileslider=new MobileSliderPage(driver);
		mobileslider.clickOnMobileSliderInfoIcon().clickOnNewButton().clickOnCategoryDropDown(category).clickOnChooseFileUpload().clickOntheSaveButton();
		 boolean isSucessFulMessageDisplay=mobileslider.alertMessageISDisplay();
		 assertTrue(isSucessFulMessageDisplay,"Can't add the new mobile slider");
	
	}

}
