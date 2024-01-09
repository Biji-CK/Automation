package contactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest {
	
	@Test
	public void createContactsWithMandatoryField() throws Throwable 
	{
		SeleniumUtility sUtil = new SeleniumUtility();
		PropertyFileUtilities pUtil = new PropertyFileUtilities();
		ExcelFileUtility eUtil = new ExcelFileUtility();

		/* Read Common data From Property File */
		String URL = pUtil.ReadDataFroPropertyFile("url");
		String USERNAME = pUtil.ReadDataFroPropertyFile("username");
		String PASSWORD = pUtil.ReadDataFroPropertyFile("password");
		
		/* Read Test data From Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		// 1.Launch the Base Browser
		WebDriver driver = new EdgeDriver();
		sUtil.addImplicitlyWait(driver);
		sUtil.maximizeWindow(driver);

		// 2.Load the Application
		driver.get(URL);

		// 3.Login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// 4.Click On Contact Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// 5.Click on Create contact look Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		// 6.Create a new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);

		// 7.Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureHeaderText();
		
		if (contactHeader.contains(LASTNAME)) {
			System.out.println(contactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// 8.lOGOUT
		hp.logoutOfApp(driver);
		
		//9.close Browser
		driver.quit();
	}

}
