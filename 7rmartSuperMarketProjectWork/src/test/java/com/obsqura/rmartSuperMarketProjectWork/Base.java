  package com.obsqura.rmartSuperMarketProjectWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.GeneralUtility;
import utilities.ScreenShotUtility;

public class Base {
	public ScreenShotUtility scrshot;
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fs;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{	
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(GeneralUtility.CONFIGFILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=WebDriverManager.chromedriver().create();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=WebDriverManager.firefoxdriver().create();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver=WebDriverManager.edgedriver().create();
		}
		else
		{
			
			throw new Exception("Browser is not corrected");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void browserClose(ITestResult iTestResult) throws IOException
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE)

		{
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

	
}
