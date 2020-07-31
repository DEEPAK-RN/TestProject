package Test;


import org.testng.annotations.Test;

import Generic.BaseTest;

import org.testng.Assert;
import org.testng.Reporter;

public class Demo extends BaseTest 
{
	@Test
	public void testA()
	{
		Reporter.log("Hii",true);
		Assert.fail();
	}
}
