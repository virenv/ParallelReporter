package Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import ReporterImplementations.Reporter;

public class SuiteListener implements ISuiteListener {

	@Override
	public void onFinish(ISuite arg0) {
		Reporter.closeReport();
	}

	@Override
	public void onStart(ISuite arg0) {
		// Start the report here
		Reporter.createReporter("htmlreport.html", true);
	}

	
	
	
}
