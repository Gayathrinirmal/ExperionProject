package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
	WebDriver driver;
	
	@FindBy(xpath= "//input[@id='user-name']")
    WebElement username;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginbutton;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement errormessage;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement errormessage2;
	
	@FindBy(xpath="//button[@class='error-button']")
	WebElement crossbutton;
	
	@FindBy(xpath="//span[text()='Products']")
	WebElement products;
	


	
	public void typeUsername(String userName) 
	{
		username.sendKeys(userName);
	}
	
	public void usernameClear() 
	{
		username.clear();
	}
	
	public void typePassword(String passWord) 
	{
		password.sendKeys(passWord);
	}
	
	public void passwordClear() 
	{
		password.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		
	}
	
	public void click() 
	{
		loginbutton.click();
	}
	
	public String gettexterrormessage() 
	{
		return errormessage.getText();
		
		
	}
	
	public String gettexterrormessage2() 
	{
		return errormessage2.getText();
	}
	
	public void clickCrossButton() 
	{
		crossbutton.click();
	}
	
	public boolean productDisplayed() 
	{
		boolean val= products.isDisplayed();
		
        return val;
		
	}
	
	public loginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

}
