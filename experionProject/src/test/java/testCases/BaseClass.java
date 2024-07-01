package testCases;

import org.testng.annotations.Test;

import generalUtility.UtilityClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.util.Date;
import org.testng.annotations.BeforeMethod;

public class BaseClass 

{
  WebDriver driver;
  UtilityClass utilobj = new UtilityClass();
  String url ="https://www.saucedemo.com/";
  String browser ="chrome";
  
  @BeforeTest
  public void beforetest()
  {
	 driver = utilobj.browserlaunch(url,browser);
  }
  
  
  @Test(enabled=false)
  public void f()
  {
	  System.out.println("Test method in Base class");
	  
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws Exception
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
	  
		  Date d = new Date();
		  String date = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(source, new File("./Screenshots/"+result.getName()+date));
		  System.out.println("Screenshot taken");
		  
			 
	  }
	  
	  
	  
  }
  
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }
}
