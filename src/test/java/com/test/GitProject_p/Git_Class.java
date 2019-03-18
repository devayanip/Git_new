package com.test.GitProject_p;

import org.testng.annotations.Test;
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
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	  
	  driver=new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.get("http://automationpractice.com/index.php");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit(); 
  }

}
