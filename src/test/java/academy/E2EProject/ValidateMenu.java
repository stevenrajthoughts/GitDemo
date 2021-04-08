package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import junit.framework.Assert;
import pageobjects.Landingpage;
import resources.Base;

public class ValidateMenu extends Base {
	
	WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializerDriver();
		driver.get(pro.getProperty("url"));
		log.info("--CHROME- VALIDATEMENU CLASS -browswer initialized-------");
	}
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		//two ways to access method or object of other class
		//one id inheritance another is create a object of the class and invoke methods of the class
		
		Landingpage lg = new Landingpage(driver);
		
		//Assert.assertEquals(lg.getTitle().getText(), "FEATURED COURSES111");
		//System.out.println(lg.getTitle().getText());
		
			
		 
		Assert.assertTrue(lg.getMenu().isDisplayed());
		
		log.info("--NAVIGATION MENU BAR IS DISPLAYED--browswer initialized-------");
		
		System.out.println("succuss");
		}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
