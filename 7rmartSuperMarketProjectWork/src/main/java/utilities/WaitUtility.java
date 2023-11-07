package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	private static final long FLUENT_WAIT = 20;
	private static final long POLLING_TIME = 30;

	public void waitForVisibilityElement(WebDriver driver, WebElement target)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));

	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement target)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public void waitForAlertPresent(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
		

	}
	
	public void waitForPresentIsAlert(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());

	}
	
	public void waitForElementFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForAlertFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitForElementSelectionFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}
	public void waitForElementToBeClickableFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementToBeSelectedFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitForFrameToBeAvailableFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	public void waitForInvisiblityOfElementFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitForInvisiblityOfElementWithTextFluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementWithText(null, null));
	}
	public void waitForTextToBEPresentInElementluentWait(WebDriver driver,WebElement element, String text)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}
	
	public void waitForVisiblityOfAllElementLocatorFluentWait(WebDriver driver,WebElement element, By loactor)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loactor));
	}
	public void waitForVisiblityOfElementLocatorFluentWait(WebDriver driver,WebElement element, By loactor)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(loactor));
	}
	public void waitForFluentWait(WebDriver driver,WebElement element, String text)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleIs(text));
	}
	public void waitForTitleContainsFluentWait(WebDriver driver,WebElement element, String text)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleContains(text));
	}
	public void waitForVisiblityOfAllElementluentWait(WebDriver driver,WebElement element)
	{
		Wait<WebDriver> fluentWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_TIME))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	

}
