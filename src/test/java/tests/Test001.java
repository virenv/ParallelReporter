package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Test001 extends TestBase {

	@Test(testName = "Test1", description = "This is test01")
	public void Test1() {
		testReporter.log(LogStatus.INFO, "Thread id is " + Thread.currentThread().getId());
		testReporter.log(LogStatus.INFO, "Step1 of test1");
		testReporter.log(LogStatus.INFO, "Step2 of test1");
		testReporter.log(LogStatus.INFO, "Step3 of test1");
		testReporter.log(LogStatus.INFO, "Step4 of test1");
		testReporter.log(LogStatus.INFO, "Step5 of test1");
	}

	@Test(testName = "Test2", description = "This is test02")
	public void Test2() {
		testReporter.log(LogStatus.INFO, "Thread id is " + Thread.currentThread().getId());
		testReporter.log(LogStatus.INFO, "Step1 of test2");
		testReporter.log(LogStatus.INFO, "Step2 of test2");
		testReporter.log(LogStatus.INFO, "Step3 of test2");
		testReporter.log(LogStatus.INFO, "Step4 of test2");
		testReporter.log(LogStatus.INFO, "Step5 of test2");
	}

	@Test(testName = "Test3", description = "This is test03")
	public void Test3() {
		testReporter.log(LogStatus.INFO, "Thread id is " + Thread.currentThread().getId());
		testReporter.log(LogStatus.INFO, "Step1 of test3");
		testReporter.log(LogStatus.INFO, "Step2 of test3");
		testReporter.log(LogStatus.INFO, "Step3 of test3");
		testReporter.log(LogStatus.INFO, "Step4 of test3");
		testReporter.log(LogStatus.INFO, "Step5 of test3");
	}
}
