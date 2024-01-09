package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	//Declaration/Identification
	@FindBy(className="dvHeaderText")
	private WebElement contactHeaderText;
	
	//Initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactHeader() {
		return contactHeaderText;
	}
	
	//BusinessLibrary
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	public String captureHeaderText()
	{
		return contactHeaderText.getText();
	}
}
