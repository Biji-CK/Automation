package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass 
{
	public SeleniumUtility sUtil = new SeleniumUtility();
	public PropertyFileUtilities pUtil = new PropertyFileUtilities();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver; 
	
	public static WebDriver sdriver; //For Listeners
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("============DaseBase Connection Successful============");
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig() throws Throwable //"String BROWSER" pass this as parameter in this method for doing cross browser execution
	{
		driver = new EdgeDriver();
//		if(BROWSER.equalsIgnoreCase("Edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("Chrome"))
//		{
//			driver = new ChromeDriver();
//		}
		sdriver = driver;
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		String URL = pUtil.ReadDataFroPropertyFile("url");
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
		String USERNAME=pUtil.ReadDataFroPropertyFile("username");
		String PASSWORD=pUtil.ReadDataFroPropertyFile("password");
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("============Login Successful============");

	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("============Logout Successful============");

	}
	
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("============Browser Closed============");

	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("============DB Connection Closed============");

	}

}
