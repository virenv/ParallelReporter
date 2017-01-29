package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import reporting.Reporter;

public class SuiteListener implements ISuiteListener {

	public static final String OUTPUT_FOLDER = "build/reports/";

	@Override
	public void onFinish(ISuite arg0) {
		Reporter.closeReport();
	}

	@Override
	public void onStart(ISuite arg0) {
		// Start the report here
		Reporter.createReporter(OUTPUT_FOLDER + "extent/HtmlReport.html", true);
	}

}
