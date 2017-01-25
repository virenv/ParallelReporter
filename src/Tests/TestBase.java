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
	public void methodSetup(Method caller)
	{
		testReporter.startTest(getTestName(caller), getTestDescription(caller));
	}
	
	@AfterMethod
	public void afterMethod()
	{
		testReporter.endTest();
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
