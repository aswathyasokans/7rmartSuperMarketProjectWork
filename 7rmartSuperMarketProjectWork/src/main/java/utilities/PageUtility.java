package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void clickAndHoldOnElement(WebElement element, WebDriver driver)

	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();

	}
	public void moveToElement(WebElement element,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void doubleClickOnElement(WebElement element,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void javaScriptExecutorForClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void selectOptionFromDropDown(WebElement element,WebDriver driver)

	{
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}
	public void selectOptionValue( WebElement element,String optionValue)
	{
		Select select=new Select(element);
		select.selectByValue(optionValue);
	}
	public void selectOptionByVisibleText(WebElement element ,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void rightClickOnElement(WebElement element,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element);
	}
	public void clickCheckBox(WebElement element,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.click(element).perform();
	}
	public void clickUnCheckBox(WebElement element,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.click(element).perform();
	}
	public void switchToFrameWork(WebElement element,WebDriver driver)
	{
		driver.switchTo().frame(element);
	}
	public void acceptAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void dragAndDropElement(WebDriver driver,WebElement sourceElement,WebElement targetElement)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).build().perform();

	}
	public void getSizeButton(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void getTextElement(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void getAxisOfElement(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void renameText(WebDriver driver,WebElement element,String newname)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void radioButton(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.click(element);
		
	}
	public void disableButton(WebDriver driver, WebElement button) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('disabled', true);", button);
	}

}
