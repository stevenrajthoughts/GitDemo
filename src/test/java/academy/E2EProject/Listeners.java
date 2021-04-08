package academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReport;

public class Listeners extends Base implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtentReport.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // this stmt is use to execute in parallel suit tet
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 test=  extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	//test.log(Status.PASS, "----Test Pass------"); // serial execution
	extentTest.get().log(Status.PASS, "----Test Pass------"); // parallel execution
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		// test.fail(result.getThrowable()); //serial exe
		
		extentTest.get().fail(result.getThrowable()); //parallel exe
		
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		
	try {
		driver = 	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
	{
		
	}
	
	try {
		
		extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName()); //take screenshopt to the extent report
		  
		//getScreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		  extent.flush();

	
	}
	
	
	
	

}
