package practice;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtilities;
import genericUtilities.SeleniumUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadPropertyFromGenericUtilities {

	public static void main(String[] args) throws Throwable 
	{
		PropertyFileUtilities pUtil = new PropertyFileUtilities();
		String value = pUtil.ReadDataFroPropertyFile("url");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Contacts", 1, 1);
		System.out.println(data);
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		
		SeleniumUtility sUtil = new SeleniumUtility();
		WebDriver driver = new EdgeDriver();
		sUtil.fullScreenWindow(driver);
	}
	
}
