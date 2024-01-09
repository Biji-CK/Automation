package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility//Rule no : 1
{
	//Declaration/Identification
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	public WebElement getAdminImage() {
		return adminImage;
	}
	public WebElement getSignOut() {
		return signoutLink;
	}
	
	//Business Library
	/**
	 * This method Will click on Contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLink.click();
	}
	/**
	 * This method will perform Sign-out Operation
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver , adminImage);
		Thread.sleep(1000);
		signoutLink.click();
	}

	
	
	

}
