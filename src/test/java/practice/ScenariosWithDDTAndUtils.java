package practice;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class ScenariosWithDDTAndUtils 
{
	public static void main(String[] args) throws IOException, Throwable 
	{
		//Create Object of Required Utility Classes
		PropertyFileUtilities pUtil = new PropertyFileUtilities();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		/* Read Common data From Property File */
		
		String URL = pUtil.ReadDataFroPropertyFile("url"); //inside double quotes should give same name i.e. url like this only its value is stored in properties file
		String USERNAME = pUtil.ReadDataFroPropertyFile("username");
		String PASSWORD = pUtil.ReadDataFroPropertyFile("password");
		
//		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//		Properties p = new Properties();
//		p.load(fisp);
//		String URL = p.getProperty("url");
//		String USERNAME = p.getProperty("username");
//		String PASSWORD = p.getProperty("password");
		
		/* Read Test data From Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
//		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fise);
//		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();

		// 1.Launch the Base Browser
		WebDriver driver = new EdgeDriver();
		sUtil.addImplicitlyWait(driver);
		sUtil.maximizeWindow(driver);
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();

		// 2.Load the Application
		driver.get(URL);

		// 3.Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		// 4.Click On Contact Link
		driver.findElement(By.linkText("Contacts")).click();

		// 5.Click on Create contact look Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// 6.Create a new contact
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);

		// 7.save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// 8.Validation
		String contactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (contactHeader.contains("Vinod")) {
			System.out.println(contactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// 9.lOGOUT
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

		Thread.sleep(1000);

		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

}


