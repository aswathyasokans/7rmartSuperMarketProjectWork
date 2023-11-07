package testscripts;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManageOrdersPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageOrderTest extends Base{
	
	@Test(groups = {"regression"},description="Verify to search a list orders",retryAnalyzer=Retry.class)
	
	public void verifySearchListOrders(String username)
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String orderId=ExcelUtility.getNumeric(0, 1, "ManageOrdersPage");
		String date=ExcelUtility.getNumeric(1, 1, "ManageOrdersPage");
		String paymentMode=ExcelUtility.getString(2, 1, "ManageOrdersPage");
		String status=ExcelUtility.getString(3, 1, "ManageOrdersPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageOrdersPage manageorderpage=new  ManageOrdersPage(driver);
		manageorderpage.clickOnTheManageOrderInfoIcon().clickOnSearchButton().enterTheOrderId(orderId).selectStartDate(date).selectStatusDropDown(status).clickOnSearchListButton();
		boolean isTableElementDisplay=manageorderpage.isTableElementDisplay();
		assertTrue(isTableElementDisplay,"Can't search the list orders");
	}
	@Test(groups = {"regression"},description="Verify to reset a list orders",retryAnalyzer=Retry.class)
	public void verifyResetListOrders()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String orderId=ExcelUtility.getNumeric(0, 1, "ManageOrdersPage");
		String date=ExcelUtility.getNumeric(1, 1, "ManageOrdersPage");
		String paymentMode=ExcelUtility.getString(2, 1, "ManageOrdersPage");
		String status=ExcelUtility.getString(3, 1, "ManageOrdersPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageOrdersPage manageorderpage=new  ManageOrdersPage(driver);
		manageorderpage.clickOnTheManageOrderInfoIcon().clickOnSearchButton().enterTheOrderId(orderId).selectStartDate(date).selectStatusDropDown(status).clickOnResetButton();
	}
}
