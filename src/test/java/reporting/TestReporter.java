package reporting;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import interfaces.ITestReporter;

public class TestReporter implements ITestReporter {

	private Map<Long, ExtentTest> testReporters = new ConcurrentHashMap<Long, ExtentTest>();
	private ExtentReports reporter;

	public TestReporter(ExtentReports reporter) {
		this.reporter = reporter;
	}

	public void startTest(String testName) {
		Long threadId = Thread.currentThread().getId();
		if (!testReporters.containsKey(threadId))
			testReporters.put(threadId, reporter.startTest(testName));
	}

	public void startTest(String testName, String testDescription) {
		Long threadId = Thread.currentThread().getId();
		if (!testReporters.containsKey(threadId))
			testReporters.put(threadId, reporter.startTest(testName, testDescription));
	}

	public void endTest() {
		Long threadId = Thread.currentThread().getId();
		if (testReporters.containsKey(threadId)) {
			reporter.endTest(getTestReporter());
			testReporters.remove(threadId);
		}
	}

	@Override
	public void log(LogStatus logStatus, String stepName, String details) {
		getTestReporter().log(logStatus, stepName, details);
	}

	@Override
	public void log(LogStatus logStatus, String details) {
		getTestReporter().log(logStatus, details);
	}

	@Override
	public void log(LogStatus logStatus, String stepName, Throwable t) {
		getTestReporter().log(logStatus, stepName, t);
	}

	@Override
	public void log(LogStatus logStatus, Throwable t) {
		getTestReporter().log(logStatus, t);
	}

	@Override
	public void setDescription(String description) {
		getTestReporter().setDescription(description);
	}

	@Override
	public String getDescription() {
		return getTestReporter().getDescription();
	}

	@Override
	public void setStartedTime(Date startedTime) {
		getTestReporter().setStartedTime(startedTime);
	}

	@Override
	public Date getStartedTime() {
		return getTestReporter().getStartedTime();
	}

	@Override
	public void setEndedTime(Date endedTime) {
		getTestReporter().setEndedTime(endedTime);
	}

	@Override
	public Date getEndedTime() {
		return getTestReporter().getEndedTime();
	}

	@Override
	public String addScreenCapture(String imgPath) {
		return getTestReporter().addScreenCapture(imgPath);
	}

	@Override
	public String addBase64ScreenShot(String base64) {
		return getTestReporter().addBase64ScreenShot(base64);
	}

	@Override
	public String addScreencast(String screencastPath) {
		return getTestReporter().addScreencast(screencastPath);
	}

	@Override
	public ExtentTest assignCategory(String... categories) {
		return getTestReporter().assignCategory(categories);
	}

	@Override
	public ExtentTest assignAuthor(String... authors) {
		return getTestReporter().assignAuthor(authors);
	}

	@Override
	public ExtentTest appendChild(ExtentTest node) {
		return getTestReporter().appendChild(node);
	}

	@Override
	public LogStatus getRunStatus() {
		return getTestReporter().getRunStatus();
	}

	@Override
	public ITest getTest() {
		return getTestReporter().getTest();
	}

	private ExtentTest getTestReporter() {
		Long threadId = Thread.currentThread().getId();
		if (testReporters.containsKey(threadId)) {
			return testReporters.get(threadId);
		}
		throw new Error("Trying to get an extent test which is not yet created. ThreadId: " + threadId);
	}

}
