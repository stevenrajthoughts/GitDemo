package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	WebDriver driver;
	
	By fpemail = By.name("email");
	
	By sendInst =  By.name("commit");
	
	
	

	

	public WebElement getEmaiFP()
	{
		return driver.findElement(fpemail);
	}
	
	public WebElement getInstFP()
	{
		return driver.findElement(sendInst);
	}
	
		
}
