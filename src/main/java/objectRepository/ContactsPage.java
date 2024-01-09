package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//Declaration/Identification
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateContact() {
		return createContactLookUpImg;
	}
	
	//Business Library
	/*
	 * This method will click on Create contacts lookup Image
	 */
	public void clickOnCreateContactLookUpImg()
	{
		createContactLookUpImg.click();
	}
}
