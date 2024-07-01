package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage 
{
	WebDriver driver;
	
	@FindAll({
	    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name ")
	    
	})
	List<WebElement> elements;
	
	WebElement dropdown = driver.findElement(By.className("product_sort_container"));

	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-onesie']")
	public WebElement saucelabsOnesie;
	
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']")
	public WebElement saucelabsbackpack;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public WebElement shoppingcart;
	
	@FindBy(xpath="//div[text()='Sauce Labs Onesie']")
	public WebElement oneSieInCheckOut;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	public WebElement backPackInCheckOut;
	
	@FindBy(xpath="//button[@id='checkout']")
	public WebElement checkoutbutton;
	
	@FindBy(xpath="//input[@id='first-name']")
	public WebElement firstname;
	
	@FindBy(xpath="//input[@id='last-name']")
	public WebElement lastname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	public WebElement zipcode;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement continuebutton;
	
	@FindBy(xpath="//div[@class='inventory_item_price'][1]")
	public WebElement firstitemprice;
	
	@FindBy(xpath="//div[@class='inventory_item_price'][2]")
	public WebElement seconditemprice;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	public WebElement totalpricewithoutax;
	
	public void clickOneSie() 
	{
		saucelabsOnesie.click();
	}
	
	public void clickBackPack() 
	{
		saucelabsbackpack.click();
	}
	
	public void selectDropdown(String val) 
	{
		Select select = new Select(dropdown);
		select.selectByValue(val);
	}
	
	public String dropDowngetText() 
	{
		String text= dropdown.getText();
		return text;
	}
	
   public void moveToElement(WebElement element) 
   {
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element).build().perform();
   }
	
   public void clickShoppingCart() 
   {
	   shoppingcart.click();
   }
	
   public boolean oneSievalue() 
   {   
	  boolean val=oneSieInCheckOut.isDisplayed();
	  return val;	      
	   
   }
   
   
   public boolean backpackvalue() 
   {
	   boolean val=backPackInCheckOut.isDisplayed();
	   return val;
			   
   }
   
   public void checkOutButtonClick()
   {
	   checkoutbutton.click();
	   
   }
	
   public void firstNameType(String firstnametext) 
   {
	   firstname.sendKeys(firstnametext);
   }
   
   public void lastNameType(String lastnametext) 
   {
	   lastname.sendKeys(lastnametext);
   }
   
   public void zipCodeType(String zipcodetext) 
   {
	   zipcode.sendKeys(zipcodetext);
   }
   
   
   public void clickContinueButton() 
   {
	   continuebutton.click();
   }
   
   public double firstItemPrice() 
   {
       String item1fulltext=firstitemprice.getText();
       String[] parts=item1fulltext.split("\\$");
       String item1pricetext= parts[1];
       double item1price= Double.parseDouble(item1pricetext);
       return item1price;
   }
   
   public double secondItemPrice() 
   {
	   String item2fulltext=seconditemprice.getText();
	   String[] parts= item2fulltext.split("\\$");
	   String item2pricetext=parts[1];
	   double item2price=Double.parseDouble(item2pricetext);
	   return item2price;
   }
   
   public double totalItemPrice() 
   {
	   String totalpricefulltext=totalpricewithoutax.getText();
	   String[] parts=totalpricefulltext.split("\\$");
	   String totalpricetext=parts[1];
	   double totalprice=Double.parseDouble(totalpricetext);
	   return totalprice;
   }

     
	public ProductPage(WebDriver driver) 
	{
		this.driver=driver;
	    PageFactory.initElements(driver, this);
	}

}
