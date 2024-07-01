package generalUtility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;



public class UtilityClass 
{
	WebDriver driver;
	public WebDriver browserlaunch(String url, String browsername) 
	{   
		if(browsername.equalsIgnoreCase("edge"))
		{
		    System.setProperty("webdriver.edge.driver", "C:\\Users\\u727186\\eclipse-workspace\\experionProject\\drivers\\msedgedriver.exe");
			 this.driver = new EdgeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("chrome"))
		{
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\u727186\\eclipse-workspace\\experionProject\\drivers\\chromedriver.exe");
			this.driver = new ChromeDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;
		
	

}
	
	 public void alertAccept() 
		{
			Alert objectalert = driver.switchTo().alert();
			objectalert.accept();
		}
	 
	 public void alertDismiss() 
	 {
		 Alert objectalert = driver.switchTo().alert();
		 objectalert.dismiss();
	 }
	 
	 public String alertGetText() 
	 {
		 Alert objectalert = driver.switchTo().alert();
		 String alerttext= objectalert.getText();
		 return alerttext;
		 
		 
	 }
	 

}
