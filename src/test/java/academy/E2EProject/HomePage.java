package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageobjects.ForgotPassword;
import pageobjects.Landingpage;
import pageobjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	
	WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializerDriver();
		driver.get(pro.getProperty("url"));
		log.info("--CHROME--browswer initialized-------");
	}
	
	
	/*	
	@Test
	public void basePageNavigation() throws IOException
	{
		driver = initializerDriver();
		driver.get("http://qaclickacademy.com/");
		
		//two ways to access method or object of other class
		//one id inheritance another is create a object of the class and invoke methods of the class
		
		Landingpage lg = new Landingpage(driver);
		
		lg.nothanks().click();
		
		lg.getLogin().click();
	
		LoginPage lp = new LoginPage(driver);
		
		lp.getMail().sendKeys("abc@qw.com");
		lp.getPassword().sendKeys("123456");
		lp.getLogin().click();
	}

*/

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username,String password, String text) throws IOException
	{
		//driver = initializerDriver();
		//driver.get(pro.getProperty("url"));
		
		log.info("--URL--browswer initialized-------");
		//two ways to access method or object of other class
		//one id inheritance another is create a object of the class and invoke methods of the class
		
		Landingpage lg = new Landingpage(driver);
		
		lg.nothanks().click();
		
		
		LoginPage lp = lg.getLogin();
		
		//lg.getLogin().click();
	
		//LoginPage lp = new LoginPage(driver);
		
		lp.getMail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		//System.out.println(text);
		log.info(text);
	
		
	ForgotPassword fp	=lp.getForgotPassword();
	
	fp.getEmaiFP().sendKeys("abc@gmail.com");
	fp.getInstFP().click();
	}

	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		Object[][] data = new Object[2][3];
		
		//0 th row
		
		data[0][0] =  "nonsrestricuser@qw.com";
		data[0][1] =  "nonsrestricuser@qw.com";
		data[0][2] =  "nonsrestricuser@qw.com";
		
		//1st row
	
		data[1][0] =  "srestricuser@qw.com";
		data[1][1] =  "srestricuser@qw.com";
		data[1][2] =  "srestricuser@qw.com";   
		
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		
		log.info("--CLOSED HOMEPAGE CLASS--browswer initialized-------");
	}
		
	
}
