package testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarketProjectWork.Base;
import pages.CategoryPage;
import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	@Test(groups = {"regression"},description="Verify an admin add a new items in category",retryAnalyzer=Retry.class)
	public void verifyAdminAddANewCategoryItems()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
		String categoryItem=ExcelUtility.getString(0, 1, "CategoryPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.clickOnTheMoreInfoIconOnTheCategory().clickOntheNewButton().enterTheCategoryTextFiled(categoryItem).clickDiscountSelectableBox().clickOnThechooseFile().clickOntheSaveButton();
		boolean sucessfulAlertMessageDisplay=categorypage.isAlertMessageDisplay();
		assertTrue(sucessfulAlertMessageDisplay,"An admin user can't add"+categoryItem+"in the 'New' Button ");
	}
	@Test(groups = {"regression"},description="Verify an admin search a valid item",retryAnalyzer=Retry.class)
	public void verifyAdminSearchAValidCategoryItem()
	{
		String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
		String validPassword=ExcelUtility.getString(0, 1, "LoginPage");
		String categoryItem=ExcelUtility.getString(0, 1, "CategoryPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();
		CategoryPage categorypage=new CategoryPage(driver);
		categorypage.clickOnTheMoreInfoIconOnTheCategory().clickOnsearchButton().enterValidCategoryItem(categoryItem).clickOnCategorySearchButton();
		boolean isElementPresentInTheTable=categorypage.isTableElementDisplay();
		assertTrue(isElementPresentInTheTable,"\"Admin user can't show  the table rows of "+categoryItem + "in the List categories ");
	}


}
