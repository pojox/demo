package common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer{
	int retryCounter = 1;
	int retryMaxLimit  = Integer.valueOf(PropertiesOperations.getPropertyValueByKey("retryCount"));
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCounter <= retryMaxLimit) {
			retryCounter++;
			return true;
		}
		return false;
	}
}
