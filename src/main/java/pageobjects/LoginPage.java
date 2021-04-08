package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login =  By.name("commit");
	By forgotPassword = By.cssSelector("[href*='password/new']");
	
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	this.driver=driver2;
	
	}

	public WebElement getMail()
	{
		return driver.findElement(email);
	}

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword getForgotPassword()
	{
		driver.findElement(forgotPassword).click();
		ForgotPassword fp = new ForgotPassword();
		return fp;
	}
	
}
