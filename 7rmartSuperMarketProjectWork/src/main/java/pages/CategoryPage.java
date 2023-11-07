package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement categoryInfoIcon;
	private @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	private @FindBy(xpath="//input[@id='category']") WebElement categoryTextFiled;
	private @FindBy(xpath="//li[@id='134-selectable']") WebElement discountSelectionBox;
	private @FindBy(xpath="//input[contains(@id,'img')]") WebElement chooseFileUpload;
	private @FindBy(xpath="//input[@name='top_menu']//preceding::label[text()='Show On Top Menu']") WebElement showMenuTopRadioButtonNo;
	private @FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	private @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertSucessfulBox;
	private @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButton;
	private @FindBy(xpath="//input[@class='form-control']") WebElement categoryFiled;
	private @FindBy(xpath="//button[@name='Search']") WebElement searchCategoryButton;
	private @FindBy(xpath="//table[contains(@class,'table-bordered')]//tr//td") List <WebElement> tableList;
	private @FindBy(xpath="//td[text()='IphoneAirpod']") WebElement tableElement;

	public CategoryPage clickOnTheMoreInfoIconOnTheCategory()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, categoryInfoIcon);
		categoryInfoIcon.click();
		 return this;
	}
	public CategoryPage clickOntheNewButton()
	{
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newButton);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", newButton);

		 return this;
	}
	public CategoryPage enterTheCategoryTextFiled(String categoryItem )
	{
		categoryTextFiled.sendKeys(categoryItem);
		return this;
	}
	public CategoryPage clickDiscountSelectableBox()
	{

		discountSelectionBox.click();
		return this;

	}
	public CategoryPage clickOnThechooseFile()
	{
		String filepath=GeneralUtility.IMAGEAPPLEAIRPOD;
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileUpload, filepath);

		return this;
	}

	public CategoryPage clickOntheSaveButton()
	{

		PageUtility pageutility=new PageUtility();
		pageutility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	public boolean isAlertMessageDisplay()
	{
		//WaitUtility waitutility=new WaitUtility();
		//waitutility.waitForVisibilityElement(driver, alertSucessfulBox);
		return alertSucessfulBox.isDisplayed();

	}
	public CategoryPage clickOnsearchButton()
	{
		searchButton.click();
		return this;
	}
	public CategoryPage enterValidCategoryItem(String categoryItem)
	{
		categoryFiled.sendKeys(categoryItem);
		return this;
	}
	public CategoryPage clickOnCategorySearchButton()
	{
		searchCategoryButton.click();
		return this;
	}
	public List<WebElement> getTheElementsInCategoriesListTable()
	{
		return tableList;

	}
	public CategoryPage listTableElement()
	{
		List<String> dataTable=new ArrayList<>();
		for(WebElement elementTable:tableList)
		{
			String elementInTheTable=elementTable.getText();
			dataTable.add(elementInTheTable);
		}
		return this;
	}
	public boolean isTableElementDisplay()
	{
		return tableElement.isDisplayed();

	}

}
