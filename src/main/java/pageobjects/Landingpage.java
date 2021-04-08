	package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {

public WebDriver driver;

public Landingpage(WebDriver d)
{
	this.driver=d;
}
//By nt1 =	By.xpath("//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button");
By nt = By.xpath("//*[text()='NO THANKS']");

//By nt = By.cssSelector("#homepage > div.sumo-form-wrapper.listbuilder-popup > div.listbuilder-popup-content > div > div > div > span > div > div:nth-child(7) > div > div > button");
By signin = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a");

By title = By.cssSelector("#content > div > div > h2");

By menu = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");

//By forgotPassword = By.cssSelector("[href*='password/new']");

public WebElement nothanks()
{
	return driver.findElement(nt);
}

public LoginPage getLogin()
{
	//return driver.findElement(signin);
	
	driver.findElement(signin).click();
	LoginPage lp = new LoginPage(driver);
	 return lp;
}

public WebElement getTitle()
{
	return driver.findElement(title);
			
}


public WebElement getMenu() {
	// TODO Auto-generated method stub
	return driver.findElement(menu);
}
/*
public ForgotPassword getForgotPassword() {
	driver.findElement(forgotPassword).click();
	ForgotPassword fp = new ForgotPassword();
	return fp;
}
*/
}
