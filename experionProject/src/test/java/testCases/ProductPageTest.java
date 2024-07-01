package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ProductPage;
import pages.loginPage;

public class ProductPageTest extends BaseClass
{
	
	
  @BeforeTest
  public void login() 
  {
		 loginPage loginobj = new loginPage(driver);
		 loginobj.typeUsername("tester");
		 loginobj.typePassword("secret_sauce");
		 loginobj.click();
		 
  }

  //Testcase to sort the products in ascending order of names
  @Test(priority=1)
  public void sortNameAtoZ() 
  {
	  ProductPage prodobj= new ProductPage(driver);
	  prodobj.selectDropdown("az");
	  String actualtext=prodobj.dropDowngetText();
	  String expectedtext= "Name (A to Z)";
	  
	  Assert.assertEquals(actualtext, expectedtext);  
	  
	  
	  
  }
  
  
  //Testcase to sort the products starting from the lowest to the highest
  @Test(priority=2)
  public void sortPricelowtohigh() 
  {
      ProductPage prodobj= new ProductPage(driver);
      prodobj.selectDropdown("lohi");
      String actualtext=prodobj.dropDowngetText();
      String expectedtext="Price (low to high)";
      
      Assert.assertEquals(actualtext, expectedtext);
      
  }
  
//Testcase to add the products to the cart, verify the added products and verify the final price and price of the added items
  @Test(priority=3)
  public void addToCart() 
  {   String actualtext1="";
      String actualtext2="";
	  ProductPage prodobj= new ProductPage(driver); 
	  
	  prodobj.moveToElement(prodobj.saucelabsbackpack);	  
	  prodobj.clickBackPack();
	  
	  prodobj.moveToElement(prodobj.saucelabsOnesie);
	  prodobj.clickOneSie();
	  prodobj.clickShoppingCart();
	  
	  String expectedtext1="Sauce Labs Onesie";
	  String expectedtext2="Sauce Labs Backpack";
	  
	  boolean value1 =prodobj.oneSievalue();
	  boolean value2=prodobj.backpackvalue();
	  
	  if (value1=true) 
	  {
		 actualtext1=  prodobj.oneSieInCheckOut.getText();
		
	  }
	  
	  if (value2=true) 
	  {
		 actualtext2= prodobj.backPackInCheckOut.getText();
	  }
	  
	  SoftAssert softAssert = new SoftAssert();
	  softAssert.assertEquals(actualtext1, expectedtext1);
	  softAssert.assertEquals(actualtext2, expectedtext2);
	  
	  prodobj.checkOutButtonClick();
	  
	  prodobj.firstNameType("firstname");
	  prodobj.lastNameType("lastname");
	  prodobj.zipCodeType("666666");
	  
	  boolean valueone =prodobj.oneSievalue();
	  boolean valuetwo=prodobj.backpackvalue();
	  
	  if (valueone=true) 
	  {
		 actualtext1=  prodobj.oneSieInCheckOut.getText();
		
	  }
	  
	  if (valuetwo=true) 
	  {
		 actualtext2= prodobj.backPackInCheckOut.getText();
	  }
	  
	  softAssert.assertEquals(actualtext1, expectedtext1);
	  softAssert.assertEquals(actualtext2, expectedtext2);
	  
	  double firstitemprice = prodobj.firstItemPrice();
	  double seconditemprice =prodobj.secondItemPrice();
	  
	  double actualprice= firstitemprice + seconditemprice;
	  double expectedprice =prodobj.totalItemPrice();
	  
	  softAssert.assertEquals(actualprice, expectedprice, 0, null);
	  
	  softAssert.assertAll();
	  
	  
	  
  }
  
}
