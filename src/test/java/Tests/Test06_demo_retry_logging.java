package Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.LoggerBase;
import common.ListenerImplementation;
import common.LogHelper;
import common.TestRetryAnalyzer;

@Listeners(ListenerImplementation.class)
public class Test06_demo_retry_logging {
	@Test(description = "Verify Test Retry Mechanism - 3 retries", enabled = true, retryAnalyzer = TestRetryAnalyzer.class)
	public void verifyTestRetryMechanism() {
		 Assert.assertTrue(false);
		 /**
		  * retries 3 times manageable from config
		  * also runs via testng.xml / mvn
		  */
	}
	
	@Test
	public void verifyLoggerMechanism() {
		LogHelper.log("Verify Logger Mecahanism");
		/**
		 * writes to console
		 * write to log file created in /logs
		 */
	}
}

