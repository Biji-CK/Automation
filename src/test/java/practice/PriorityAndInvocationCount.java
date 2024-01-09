package practice;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityAndInvocationCount 
{
	@Test(priority=0)
	public void create()
	{
		Assert.fail();
		System.out.println("CREATE 1");
	}
	@Test(priority=1,dependsOnMethods="create")
	public void modify()
	{
		System.out.println("MODIFY 2");
	}
	@Test(priority=2)
	public void delete()
	{
		System.out.println("DELETE 3");
	}

}
