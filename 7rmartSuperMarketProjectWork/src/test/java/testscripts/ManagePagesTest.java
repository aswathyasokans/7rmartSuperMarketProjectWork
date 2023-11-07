package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManagePagesPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManagePagesTest extends Base
{
@Test(groups = {"regression"},description="Verify an admin search valid items",retryAnalyzer=Retry.class)
public void verifyAnAdminUserWantToTheSerachAnValidIitemInTheListPages()
{
	String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
	String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
	String validTitle=ExcelUtility.getString(0, 1, "ManagePagesPage");
	
	LoginPage loginclasspage=new LoginPage(driver);
	loginclasspage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

	ManagePagesPage managepagessearchbuttonpage=new ManagePagesPage(driver);
	managepagessearchbuttonpage.clickOnTheMoreInfoOnTheManagePages().clickOnTheSearchButtonOnTheListPages().anAdminUserSearchAnValidItemInTheTitileFiled(validTitle).clickOntheSearchBarButtonOntheListPages();

	boolean isElementContainsInTheTable=managepagessearchbuttonpage.isElementDisplayInTlistPage();
	assertTrue(isElementContainsInTheTable,"Admin user can't show  the table rows of  "+validTitle + "in the ListPages ");

}
@Test(groups = {"regression"},description="Verify to search an  invalid items",retryAnalyzer=Retry.class)
public void verifyAnAdminUserWantToTheSerachAnInValidIitemInTheListPages()
{
	String validUserName=ExcelUtility.getString(0, 1, "LoginPage");
	String validPassword=ExcelUtility.getString(1, 1, "LoginPage");
	String inValidTitle=ExcelUtility.getString(1, 1, "ManagePagesPage");

	LoginPage loginclasspage=new LoginPage(driver);
	loginclasspage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

	ManagePagesPage managepagessearchbuttonpage=new ManagePagesPage(driver);
	managepagessearchbuttonpage.clickOnTheMoreInfoOnTheManagePages().clickOnTheSearchButtonOnTheListPages().anAdminUserSearchAnInValidItemInTheTitileFiled(inValidTitle).clickOntheSearchBarButtonOntheListPages();
	boolean isListTableResultNotFoundIsDisplayed=managepagessearchbuttonpage.resultNotFoundIsDisplayed();
	assertTrue(isListTableResultNotFoundIsDisplayed,"An admin user can search with"+inValidTitle+"in the ListPages");

}

}
