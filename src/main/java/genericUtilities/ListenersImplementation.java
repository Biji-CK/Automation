package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * @author biji
 */
public class ListenersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//@Test -Method
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"--- Test Execution Started --- ");
		
		test = report.createTest(methodName);   //createTest helps to identify the @test annotation
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"--- Test Pass --- ");
		
		test.log(Status.PASS, methodName +" --- Test Pass ---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"--- Test Fail --- ");
		System.out.println(result.getThrowable()); 
		
		test.log(Status.FAIL, methodName +"--- Test Fail --- ");
		test.log(Status.INFO, result.getThrowable());
		
		//Will print the Exception for the failure
		//Screenshots
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodName+"-"+j.getSystemDate();
		
		try { 
			String path = s.captureScreenShots(BaseClass.sdriver, screenshotName);
			
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"--- Test Skipped --- ");
		System.out.println(result.getThrowable());      //Will print the Exception for skip
		
		test.log(Status.SKIP, methodName +"--- Test Skipped --- ");
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--- Suite Execution Started ---");
		
		ExtentSparkReporter htmlrep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlrep.config().setDocumentTitle("Execution Report");
		htmlrep.config().setReportName("Vtiger Report");
		htmlrep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("Base Platform","Windows");
		report.setSystemInfo("Base Browser","Edge");
		report.setSystemInfo("Base Env","Test Env");
		report.setSystemInfo("Reporter Name","Biji");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--- Suite Execution Completed ---");
		
		report.flush();
	}
	
	
	
}
