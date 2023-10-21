package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	@Test
	public void verifyAdminAddANewCategoryItems()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(1, 1, "Login");
		String categoryItem=ExcelUtility.getString(0, 1, "Category");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.clickOnTheMoreInfoIconOnTheCategory().clickOntheNewButton().enterTheCategoryTextFiled(categoryItem).clickDiscountSelectableBox().clickOnThechooseFile().clickOntheSaveButton();
		boolean sucessfulAlertMessageDisplay=categorypage.isAlertMessageDisplay();
		assertTrue(sucessfulAlertMessageDisplay,"An admin user can't add"+categoryItem+"in the 'New' Button ");
	}
	@Test
	public void verifyAdminSearchAValidCategoryItem()
	{
		String validUserName=ExcelUtility.getString(0, 1, "Login");
		String validPassword=ExcelUtility.getString(0, 1, "Login");
		String categoryItem=ExcelUtility.getString(0, 1, "Category");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.clickOnTheMoreInfoIconOnTheCategory().clickOnsearchButton().enterValidCategoryItem(categoryItem).clickOnCategorySearchButton();
		boolean isElementPresentInTheTable=categorypage.isTableElementDisplay();
		assertTrue(isElementPresentInTheTable,"\"Admin user can't show  the table rows of "+categoryItem + "in the List categories ");
	}


}
