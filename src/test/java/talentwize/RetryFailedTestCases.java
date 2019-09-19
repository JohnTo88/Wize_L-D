package talentwize;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import Ulties.TestLogger;

public class RetryFailedTestCases implements IRetryAnalyzer {

	private int retryCount = 0;
	private int maxRetry = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < maxRetry) {
			TestLogger.info("Retrying testcase: " + result.getName() + " again in the time " + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}

}
