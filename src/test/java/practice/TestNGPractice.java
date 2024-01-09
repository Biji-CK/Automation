package practice;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGPractice
{
	@Test  
	public void sample()
	{
		SoftAssert sa= new SoftAssert();
		System.out.println("Hello world 1");
		System.out.println("Hello world 1");
		
		sa.assertEquals(true, false);
		System.out.println("Hello world 1");
		System.out.println("Hello world 1");

	}

}
