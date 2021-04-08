package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Base {
	
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	public WebDriver driver;
	public Properties pro;
	
	public WebDriver initializerDriver() throws IOException
	{
		 pro = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		pro.load(fis);
		
		String browserName = pro.getProperty("Browers"); //get datay from properties
		
		//String browserName = System.getProperty("Browers");
		
		System.out.println(browserName);
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			 driver = new ChromeDriver();
			log.info("--CHROME--browswer initialized-------");	
		}
		else if (browserName.equals("firefox"))
		{
		
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			
	         driver = new FirefoxDriver();	
			
	         log.info("--FIREFOX--browswer initialized-------");
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			
	         driver = new InternetExplorerDriver();
	         log.info("--IE--browswer initialized-------");
		
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinatinFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinatinFile));
	return destinatinFile;
	
}
} 
