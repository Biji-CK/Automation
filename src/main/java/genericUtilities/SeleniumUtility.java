package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consists of reusable methods related to Selenium tool
 * @author biji
 */
public class SeleniumUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method launch the browser in full screen mode
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will wait for 10 seconds for all the webElements to load
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for a particular webElement to become visible 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 *This method will wait for a particular webElement to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	
	/**
	 * This method will handle dropdown using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown using text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hovering action on a webElement
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();	
	}
	
	/**
	 * This method will perform double click action on a webElement
	 * @param element
	 * @param driver
	 */
	public void doubleClick(WebElement element,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform Right click action on a webElement
	 * @param element
	 * @param driver
	 */
	public void rightClick(WebElement element,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click action on a webElement
	 * @param element
	 * @param driver
	 */
	public void dragAndDrop(WebElement srcEle,WebElement destEle,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle,destEle).perform(); 
	}
	
	/**
	 * This method will will scroll down for 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.ScrollBy(0,500);","");
	}
	
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.ScrollBy(0,-500);","");
	}
	
	/**
	 * This method will Accept the Alert popUp
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * This method will reject the alert popUp
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the alert text and return it back to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
		
	}
	
	/**
	 * This method will handle frame by frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrames(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle frame by frame Id/name
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrames(WebDriver driver,String frameNameId)
	{
		driver.switchTo().frame(frameNameId);
	}
	
	/**
	 * This method will handle frame by frame WebElement
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrames(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method will switch to default/parent frame
	 * @param driver
	 */
	public void defaultFrame(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * This method will capture the screenshot and return the absolute path to the caller for extent report
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShots(WebDriver driver, String screenShotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE); //Temporary location
		File dst = new File(".\\Screenshots\\"+screenShotName+".png"); //createContact-08-12-23-17-56.png
		Files.copy(src,dst);
		
		return dst.getAbsolutePath(); //c://desktop//E4/Screenshots/createcontacts.png
		//Attaching this screenshot to extent reports
		
	}
	/**
	 * This method will switch the control to required window based on the title
	 * @param driver
	 * @param expPartialTitle
	 */
		public void handleWindows(WebDriver driver,String expPartialTitle)
		{
			//Capture all WindowIds
			Set<String> allWinIds = driver.getWindowHandles();
			for (String winId : allWinIds) 
			{
				String actTitle = driver.switchTo().window(winId).getTitle();
				if(actTitle.contains(expPartialTitle))
				{
					break;
				}
			}
		}
	
	
	
	
} 
