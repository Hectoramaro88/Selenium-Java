package com.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.java.Base;

public class MainPage extends Base{

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	// Objects
	By txtFilterCompName = By.id("searchbox");
	By btnFilterByName = By.id("searchsubmit");
	By tblActualFirstRow = By.xpath("//tbody/tr[1]/td[1]");

	/*
	 * Filter computer by name
	 * @author Ricardo
	 * @date
	 */
	public void filterComputerByName(String computer) {
		verifyTitleContains("Computers");
		verifyVisibilityElement(txtFilterCompName);
		type(txtFilterCompName, computer);
		takeScreenshot("beforeClickFilter");
		click(btnFilterByName);
		takeScreenshot("afterClickFilter");
	}
	
	/*
	 * Verify computer displayed in table after filter
	 * @author Ricardo
	 * @date
	 */
	public boolean verifyComputerTable(String expectedComputer) {
		String actualComputer = getText(tblActualFirstRow);
		takeScreenshot("verifyComputer");
		if(expectedComputer.equals(actualComputer)) {
			return true;
		}else {
			return false;
		}
	}
}
