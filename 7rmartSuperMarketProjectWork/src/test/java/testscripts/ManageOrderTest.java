package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManageOrdersPage;
import utilities.ExcelUtility;

public class ManageOrderTest extends Base{
	@Test
	public void verifySearchListOrders()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		String orderId=ExcelUtility.getNumeric(0, 1, "ManageOrders");
		String date=ExcelUtility.getNumeric(1, 1, "ManageOrders");
		String paymentMode=ExcelUtility.getString(2, 1, "ManageOrders");
		String status=ExcelUtility.getString(3, 1, "ManageOrders");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		ManageOrdersPage manageorderpage=new  ManageOrdersPage(driver);
		manageorderpage.clickOnTheManageOrderInfoIcon().clickOnSearchButton().enterTheOrderId(orderId).selectStartDate(date).selectStatusDropDown(status).clickOnSearchListButton();
		boolean isTableElementDisplay=manageorderpage.isTableElementDisplay();
		assertTrue(isTableElementDisplay,"Can't search the list orders");
	}

}
