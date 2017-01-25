package Tests;

import java.lang.reflect.Method;

import org.testng.annotations.*;

import Interfaces.ITestReporter;
import ReporterImplementations.Reporter;

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
		Test testAnnotation = (Test) caller.getAnnotation(Test.class);
		if(testAnnotation != null)
		{
			return testAnnotation.testName();
		}
		return "";
	}
	
	private String getTestDescription(Method caller)
	{
		Test testAnnotation = (Test) caller.getAnnotation(Test.class);
		if(testAnnotation != null)
		{
			return testAnnotation.description();
		}
		return "";
	}
}
