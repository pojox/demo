package base;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

	private ExtentFactory() {
		
	}
	
	private static ExtentFactory instance  = new ExtentFactory();
	
	public static ExtentFactory getInstance() {
		return instance;
	}
		
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	
	public ExtentTest getExtent() {
		return extent.get();
	}
	
	public void setExtent(ExtentTest extentParm) {
		extent.set(extentParm);
	}
	
	public void removeExtentObject() {
		extent.remove();
	}
}
