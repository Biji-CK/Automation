package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility
{
	//Initialization/Identification
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement savebtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	//Business Library
	/**
	 * This method will create a new Contact and save it
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		savebtn.click();
	}
	
	/**
	 * This method will create a new contact using Lead Source Drop-Down and save it
	 * @param LASTNAME
	 * @param LEADSOURCEVALUE
	 */
	public void createNewContact(String LASTNAME,String LEADSOURCEVALUE)
	{
		lastNameEdt.sendKeys(LASTNAME);
		handleDropDown(leadSourceDropDown, LEADSOURCEVALUE);
		savebtn.click();
	}
	
}
