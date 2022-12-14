package com.computers.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;
import com.selenium.poc.MainPage;

public class MainPOMTests {

	// POM

	WebDriver driver;
	Base base;
	MainPage mainPage;
	String expectedComputer;
	ExtentReports extent;
	ExtentTest logger;
	private String className = this.getClass().getSimpleName();

	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverCon();
		mainPage = new MainPage(driver);
		expectedComputer = base.getJSONValue("tc001", "computer");

		// Set up Extend reports
		extent = new ExtentReports(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.REPORT_PATH, true);
		extent.addSystemInfo(GlobalVariables.EXTENT_QA_URL, GlobalVariables.QA_URL);
		extent.loadConfig(new File(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.CONFIG_EXTENT));
	}

	@Test
	public void tc001() {

		// Extent report start test
		logger = extent.startTest(className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// Step 1 - Launch browser
		base.launchBrowser(GlobalVariables.QA_URL);

		// Step 2 - Insert computer name in text box
		// Step 3 - Click on "Filter by name"
		mainPage.filterComputerByName(expectedComputer);

		// Step 4 - Validate computers is displayed in table
		Assert.assertTrue(mainPage.verifyComputerTable(expectedComputer));

		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successfully");
	}

	@Test
	public void tc002() {

		// Extent report start test
		logger = extent.startTest(className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// Step 1 - Launch browser
		base.launchBrowser(GlobalVariables.QA_URL);

		// Step 2 - Insert computer name in text box
		// Step 3 - Click on "Filter by name"
		mainPage.filterComputerByName(expectedComputer);

		// Step 4 - Validate computers is displayed in table
		Assert.assertTrue(mainPage.verifyComputerTable(expectedComputer));

		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successfully");
	}
	
	@Test
	public void tc003() {

		// Extent report start test
		logger = extent.startTest(className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		// Step 1 - Launch browser
		base.launchBrowser(GlobalVariables.QA_URL);

		// Step 2 - Insert computer name in text box
		// Step 3 - Click on "Filter by name"
		mainPage.filterComputerByName(expectedComputer);

		// Step 4 - Validate computers is displayed in table
		Assert.assertTrue(false);

		// Log Extent Report
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successfully");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(base.takeScreenshot("fail")));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);

	}

	@AfterTest
	public void afterTest() {
		// Close Extend report
		extent.flush();
		extent.close();
		base.closeBrowser();
	}

}
