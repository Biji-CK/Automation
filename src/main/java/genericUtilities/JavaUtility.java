package genericUtilities;

import java.util.Date;
/**
 * This class consits of reuseable methods related to Java 
 * @author biji
 */
public class JavaUtility 
{
	/**
	 *This method will return the current system date in specified format
	 * @return
	 */
	public String getSystemDate()
	{
	Date d = new Date();
	String[] dArr = d.toString().split(" ");
	String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+" "+dArr[3].replace(":", "-");
	return currentDate;
	}
	
}
