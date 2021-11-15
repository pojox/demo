package common;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.ExtentFactory;
import base.LoggerBase;

public class LogHelper {
	/**
	 * com.aventstack.extentreports.ExtentReports
	 * 
	 * @param status
	 * @param message
	 */
	public static void log(Status status, String message) {
		ExtentFactory.getInstance().getExtent().log(status, message);
		Assert.assertTrue(status == Status.PASS ? true : false, message);
	}

	/**
	 * org.apache.logging.log4j
	 * 
	 * @param description
	 */
	public static void log(String description) {
		LoggerBase.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		LoggerBase.info(description);
	}
}
