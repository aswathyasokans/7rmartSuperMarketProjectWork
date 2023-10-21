package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarketProjectWork.Base;

import pages.LoginPage;
import pages.ManagePagesPage;
import utilities.ExcelUtility;

public class ManagePagesTest extends Base
{
@Test
public void verifyAnAdminUserWantToTheSerachAnValidIitemInTheListPages()
{
	String validUserName=ExcelUtility.getString(0, 1, "Login");
	String validPassword=ExcelUtility.getString(0, 1, "Login");
	String validTitle=ExcelUtility.getString(0, 1, "ManagePages");
	
	LoginPage loginclasspage=new LoginPage(driver);
	loginclasspage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

	ManagePagesPage managepagessearchbuttonpage=new ManagePagesPage(driver);
	managepagessearchbuttonpage.clickOnTheMoreInfoOnTheManagePages().clickOnTheSearchButtonOnTheListPages().anAdminUserSearchAnValidItemInTheTitileFiled(validTitle).clickOntheSearchBarButtonOntheListPages();

	boolean isElementContainsInTheTable=managepagessearchbuttonpage.isElementDisplayInTlistPage();
	assertTrue(isElementContainsInTheTable,"Admin user can't show  the table rows of  "+validTitle + "in the ListPages ");

}
@Test
public void verifyAnAdminUserWantToTheSerachAnInValidIitemInTheListPages()
{
	String validUserName=ExcelUtility.getString(0, 1, "Login");
	String validPassword=ExcelUtility.getString(0, 1, "Login");
	String inValidTitle=ExcelUtility.getString(0, 1, "ManagePages");

	LoginPage loginclasspage=new LoginPage(driver);
	loginclasspage.enterUserNameOnUserNameFiled(validUserName).enterPasswordOnPasswordFiled(validPassword).clickOnTheSignButton();

	ManagePagesPage managepagessearchbuttonpage=new ManagePagesPage(driver);
	managepagessearchbuttonpage.clickOnTheMoreInfoOnTheManagePages().clickOnTheSearchButtonOnTheListPages().anAdminUserSearchAnInValidItemInTheTitileFiled(inValidTitle).clickOntheSearchBarButtonOntheListPages();
	boolean isListTableResultNotFoundIsDisplayed=managepagessearchbuttonpage.resultNotFoundIsDisplayed();
	assertTrue(isListTableResultNotFoundIsDisplayed,"An admin user can search with"+inValidTitle+"in the ListPages");

}

}
