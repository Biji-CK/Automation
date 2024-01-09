package contactsTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactsTest extends BaseClass
{
	@Test(groups={"RegressionSuite","SmokeSuite"})
	public void createContactsWithMandatoryField() throws Throwable 
	{
		
		/* Read Test data From Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		// 1.Click On Contact Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// 2.Click on Create contact look Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		// 3.Create a new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//Assert.fail();
		
		// 4.Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
			

	}


}
