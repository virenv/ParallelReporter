package tests;

import java.lang.reflect.Method;

import interfaces.ITestReporter;
import reporting.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	
	protected ITestReporter testReporter;
	
	@BeforeTest
	public void classSetUp()
	{
		testReporter = Reporter.getTestReporter();
	}
	
	@BeforeMethod
	public synchronized void methodSetup(Method caller)
	{
		testReporter.startTest(getTestName(caller), getTestDescription(caller));
	}
	
	@AfterMethod
	public synchronized void afterMethod()
	{
		testReporter.endTest();
		Reporter.flushReport();
	}

	private String getTestName(Method caller)
	{
		Test testAnnotation = caller.getAnnotation(Test.class);
		if(testAnnotation != null)
		{
			return testAnnotation.testName();
		}
		return "";
	}
	
	private String getTestDescription(Method caller)
	{
		Test testAnnotation = caller.getAnnotation(Test.class);
		if(testAnnotation != null)
		{
			return testAnnotation.description();
		}
		return "";
	}
}
