package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

	public static void main(String[] args) throws Throwable 
	{
		//1.launch Browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//2.LOAD THE APPLICATION
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		//3.LOGIN THE APPLICATION
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//4.Click on Calendars link
		driver.findElement(By.xpath("//a[.='Calendar']")).click();
		WebElement ele=driver.findElement(By.className("calAddButton"));
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Call']")).click();
		driver.findElement(By.name("subject")).sendKeys("EVENT HAPPY");
		WebElement startDate=driver.findElement(By.id("jscal_field_date_start"));
		startDate.clear();
		startDate.sendKeys("2023-12-28");
		WebElement endDate=driver.findElement(By.xpath("//input[@id='jscal_field_due_date']"));
		endDate.click();
		endDate.clear();
		Thread.sleep(4000);
		endDate.sendKeys("2024-01-12");
		driver.findElement(By.name("eventsave")).click();
		
		// 8.Validation
				String calendarHeader = driver.findElement(By.className("calendarNav")).getText();
				if (calendarHeader.contains("2023-12-28")) {
					System.out.println(calendarHeader);
					System.out.println("PASS");
				} else {
					System.out.println("FAIL");
				}
				// 9.lOGOUT
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act1 = new Actions(driver);
				act1.moveToElement(element).perform();

				Thread.sleep(1000);

				driver.findElement(By.linkText("Sign Out")).click();

				driver.quit();

		
		
		

	}

}
