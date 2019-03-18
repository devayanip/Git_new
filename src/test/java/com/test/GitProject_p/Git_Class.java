package com.test.GitProject_p;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Git_Class 
{
	WebDriver driver;
	ExtentHtmlReporter report;
	ExtentReports e;
	ExtentTest t;
	
  @Test
  public void sign() throws InterruptedException 
  {
	  WebElement signbutton=driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));  
	  signbutton.click();
	  
	  WebElement email=driver.findElement(By.id("email_create"));
	  email.sendKeys("sam@gmail.com");
	  
	  Thread.sleep(3000);
	  
	  WebElement submit=driver.findElement(By.id("SubmitCreate"));
	  submit.click();
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  report=new ExtentHtmlReporter("Resource/makereport.html");
	  report.config().setTheme(Theme.DARK);
	  report.config().setChartVisibilityOnOpen(true);
	  report.setAppendExisting(true);
	  
	  e=new ExtentReports();
	  e.attachReporter(report);
	  
	  t=e.createTest("newtest");
	  t.pass("Started test");
	  
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	  
	  driver=new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.get("http://automationpractice.com/index.php");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  t.info("Finished test");
	  driver.quit(); 
	  e.flush();
  }

}
