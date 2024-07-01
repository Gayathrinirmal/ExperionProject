package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import generalUtility.UtilityClass;
import pages.ProductPage;
import pages.loginPage;

public class LoginPageTest extends BaseClass

// WebDriver driver; //no need to initialise again as it is already initialised in base class
// This is a class to execute the login page test cases
{
  	
  @Test(priority=1)
  public void invalidUsernameAndPassword()  
  {
	 loginPage loginobj = new loginPage(driver);
	 loginobj.typeUsername("invalid");
	 loginobj.typePassword("wrong");
	 loginobj.click();
	 String actualtext=loginobj.gettexterrormessage();
	 String expectedtext = "Epic sadface: Username and password do not match any user in this service";
	 System.out.println(actualtext);
	 System.out.println(expectedtext);
	 loginobj.usernameClear();
	 loginobj.passwordClear();
	 
	 Assert.assertEquals(actualtext, expectedtext);
	  
	 
  }
  
//Testcase to check invalid login flow with correct Username and Invalid Password
  @Test(priority=2)
  public void correctUsernameAndInvalidPassword() 
  {
		 loginPage loginobj = new loginPage(driver);
		 loginobj.typeUsername("standard_user");
		 loginobj.typePassword("wrong");
		 loginobj.click();
		 String actualtext=loginobj.gettexterrormessage();
		 String expectedtext = "Epic sadface: Username and password do not match any user in this service";
		 System.out.println(actualtext);
		 System.out.println(expectedtext);
		 
		 loginobj.usernameClear();
		 loginobj.passwordClear();
		 
		 Assert.assertEquals(actualtext, expectedtext);	
	  
  }
  
//Testcase to check invalid login flow with invalid Username and correct Password
  @Test(priority=3)
  public void invalidUsernameAndCorrectPassword() 
  {
		 loginPage loginobj = new loginPage(driver);
		 loginobj.typeUsername("tester");
		 loginobj.typePassword("secret_sauce");
		 loginobj.click();
		 String actualtext=loginobj.gettexterrormessage();
		 String expectedtext = "Epic sadface: Username and password do not match any user in this service";
		 System.out.println(actualtext);
		 System.out.println(expectedtext);
		 
		 loginobj.usernameClear();
		 loginobj.passwordClear();
		
		 
		 Assert.assertEquals(actualtext, expectedtext);		
	  
  }
  
  
//Testcase to check invalid login flow with empty Username and  Password
  @Test(priority=4)
  public void emptyUsernameAndPassword() 
  {
	  loginPage loginobj = new loginPage(driver);	  
	  loginobj.click();
	  String actualtext=loginobj.gettexterrormessage2();
	  String expectedtext="Epic sadface: Password is required";
	  System.out.println(actualtext);
	  System.out.println(expectedtext);
	  
	  loginobj.usernameClear();
	  loginobj.passwordClear();
		 
	  Assert.assertEquals(actualtext, expectedtext);
	
  }
  
  
//Testcase to check valid login flow with correct Username and  Password
  @Test(priority=5)
  public void correctUsernameAndPassword() 
  {
		 loginPage loginobj = new loginPage(driver);
		 loginobj.typeUsername("standard_user");
		 loginobj.typePassword("secret_sauce");
		 loginobj.click();
		
	     //utilobj.alertAccept();
		 
         Assert.assertTrue(loginobj.productDisplayed());
	    
		 
	  
  }
  

}
