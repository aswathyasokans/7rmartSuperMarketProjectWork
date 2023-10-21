package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePagesPage {
	public WebDriver driver;

	public ManagePagesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath="//input[@name='username']") WebElement userNameFiled;
	private @FindBy(xpath="//input[@name='password']") WebElement passwordField;
	private @FindBy(xpath="//button[@type='submit']") WebElement siginButton;
	private @FindBy(xpath="//p[text()='Manage Pages']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") WebElement moreInfoIconManagePages;
	private @FindBy(xpath="//a[@href='javascript:void(0)']") WebElement searchButton;
	private @FindBy(xpath="//input[@class='form-control']") WebElement titleFiled;
	private @FindBy(xpath="//button[@name='Search']") WebElement searchBarButton;
	private @FindAll(@FindBy(xpath="//table[contains(@class,'table-bordered')]//tr//td[1]")) List <WebElement> titleList;
	private @FindBy(xpath="//td[contains(text(),'tomato...')]") WebElement elementTable;
	private @FindBy(xpath="//center[contains(text(),'RESULT')]") WebElement resultNotFound;


	public ManagePagesPage enterUserNameOnTheUserNameFiled(String userName)
	{
		userNameFiled.sendKeys(userName);
		return this;
	}
	public ManagePagesPage enterPasswordOnThePasswordFiled(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	public ManagePagesPage clickOnTheSignButton()
	{
		siginButton.click();
		return this;
	}
	public ManagePagesPage clickOnTheMoreInfoOnTheManagePages()
	{
		moreInfoIconManagePages.click();
		return this;
	}
	public ManagePagesPage clickOnTheSearchButtonOnTheListPages()
	{
		searchButton.click();
		return this;
	}
	public ManagePagesPage anAdminUserSearchAnValidItemInTheTitileFiled(String validTitle)
	{
		titleFiled.sendKeys(validTitle);
		return this;
	}
	public ManagePagesPage anAdminUserSearchAnInValidItemInTheTitileFiled(String inValidTitle)
	{
		titleFiled.sendKeys(inValidTitle);
		return this;
	}
	public ManagePagesPage clickOntheSearchBarButtonOntheListPages()
	{
		searchBarButton.click();
		return this;
	}

	public List<WebElement> getAllElementsInTheListPagesTable()
	{
		return titleList;

	}
	/*public List<WebElement> getTableRowCount()
	{
		return tableRow;
	}*/
	public boolean resultNotFoundIsDisplayed()
	{
		return resultNotFound.isDisplayed();
	}


	public ManagePagesPage listTableElements()
	{
		List<String> dataTable=new ArrayList<>();
		//int actualTableRowCount=titleList.size();
		for(WebElement tableElement:titleList)
		{
			String tableElementsInTheListPage=tableElement.getText();
			dataTable.add(tableElementsInTheListPage);
		}
		return this;
	}
	public boolean isElementDisplayInTlistPage()
	{
		return elementTable.isDisplayed();

	}

}
