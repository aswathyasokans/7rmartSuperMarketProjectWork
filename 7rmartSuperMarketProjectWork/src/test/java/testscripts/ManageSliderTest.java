package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManageSliderPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageSliderTest  extends Base{
	@Test(groups = {"regression"},description="Verify an admin enter the slider information",retryAnalyzer=Retry.class)
	public void  verifyAdminEnterSliderInformation() {
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String link=ExcelUtility.getString(0, 1, "ManageSliderPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageSliderPage managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickOnManageSliderInfoIncon().clickOnNewButton().clickOnTheChooseFile().enterTheLinkTextFiled(link).clickOnSaveButton();
		boolean isSucessfulAlertMessageDisplay=managesliderpage.isAlertMessageDisplay();
		assertTrue(isSucessfulAlertMessageDisplay,"Admin can't enter slider information");
	}
	@Test(groups = {"regression"},description="Verify to edit the list slider",retryAnalyzer=Retry.class)
	public void verifyEditInTheListSlider()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String relink=ExcelUtility.getString(1, 1, "ManageSliderPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageSliderPage managesliderpage=new ManageSliderPage(driver);
		managesliderpage.clickOnManageSliderInfoIncon().clickOnEditIconButtonInTheTable().enterTheLinkTextFiled(relink).clickOnUpdateButton();
		boolean isSucessfulSliderChangeAlertMessageDisplay=managesliderpage.alertSliderChangeMessageDiplay();
		assertTrue(isSucessfulSliderChangeAlertMessageDisplay,"Admin can't edit in the List slider page");
	}


}
