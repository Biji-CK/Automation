package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void analyser() {
		Assert.fail();
		System.out.println("HAI");
	}
}
