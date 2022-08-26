package com.java;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ejercicio6 {
  @Test
  public void f() {
	  /*
	   * Locators:
	   * ID
	   * Name
	   * Link text
	   * Class name
	   * Partial Link Text
	   * Tag name
	   * CSS
	   * Xpath (Absoluto y Relativo)
	   * 
	   */
	  
	  /*
	   * Pausas y sincronizacion
	   * 
	   * 1- Impicit wait - Basicamente este tipo de wait nos ayuda a sincronizar el script con el DOM
	   * 2- Explicit wait: - Enfocado en un elemento en especifico.
	   */
	  
	  /*
	   * Assertions (Afirmaciones)
	   * 
	   * 1- Hard assertion
	   * 2- Soft assertion
	   */
	  
	  
	  // Ejercicio ? - Encontrar el xpath relativo y absoluto de "Create this computer"
	  
	  //Step 1 - Launch browser
	  ChromeOptions chromeOpt = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();	  
	  WebDriver driver = new ChromeDriver(chromeOpt);
	  
	  driver.get("https://computer-database.gatling.io/computers");
	  
	  //id-Computer name
	  //id-Introduced
	  //id-Discontinued
	  ////tbody/tr[1]/td[1]
	  
	//Step2 - Click on "Filter by name"
	  driver.findElement(By.id("add")).click();
	  
	  	  	  
	  //Step2 - Insert computer name in text box
	  driver.findElement(By.id("name")).sendKeys("Ya me salio");
	  driver.findElement(By.id("introduced")).sendKeys("2022-07-26");
	  driver.findElement(By.id("discontinued")).sendKeys("2022-07-27");
	  	  
	  
	  //Step3 - Click on "Filter by name"
	  driver.findElement(By.xpath("//input[@class='btn primary']")).click();
	  
	  //Step4 - Validate computers is displayed in table
	  String actualComputerName = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
	  Assert.assertEquals(actualComputerName, "ACE");
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
