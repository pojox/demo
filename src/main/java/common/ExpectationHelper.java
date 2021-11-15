package common;

import com.aventstack.extentreports.Status;

import base.DriverFactory;

public class ExpectationHelper {
	
    public static void verifyDisplayedStatus(DfElement element) {    	
    	Boolean flag = false;
    	String message = ValidationTextHelper.elementDisplayed(element.getName());
    	try {
    		flag = DriverFactory.getDriverInstance().findElement(element.getLocater()).isDisplayed();
    		LogHelper.log(flag ? Status.PASS : Status.FAIL, message);
    	}
    	catch (Exception e) {
			LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
		}    	
    }

    public static void verifyMultipleDisplayedStatus(DfElement element) {    	
    	Boolean flag = false;
    	String message = ValidationTextHelper.elementDisplayed(element.getName());
    	try {
    		flag = DriverFactory.getDriverInstance().findElements(element.getLocater()).size() > 1;
    		LogHelper.log(flag ? Status.PASS : Status.FAIL, message);
    	}
    	catch (Exception e) {
			LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
		}    	
    }
    
	public static void verifyHiddenStatus(DfElement element) {
    	Boolean flag = false;
    	String message = ValidationTextHelper.elementHidden(element.getName());    	
    	try {
    		flag = DriverFactory.getDriverInstance().findElement(element.getLocater()).isDisplayed();
    		LogHelper.log(flag ? Status.PASS : Status.FAIL, message);
    	}
    	catch (Exception e) {
    		LogHelper.log(flag ? Status.PASS : Status.FAIL, message + ".  Exception is: "+e);
		}
    	
	}

	public static void StringCompare(String actual, String expected) {
		Boolean flag = false;
		String message = ValidationTextHelper.stringEqual(actual, expected);
		flag = actual.equals(expected);
		LogHelper.log(flag ? Status.PASS : Status.FAIL, message);
	}
	
	public static void StringCompareIgnoreCase(String actual, String expected) {
		Boolean flag = false;
		String message = ValidationTextHelper.stringEqual(actual, expected);
		flag = actual.equalsIgnoreCase(expected);
		LogHelper.log(flag ? Status.PASS : Status.FAIL, message);
	} 
	
	public static void StringCompareNotEqual(String actual, String expected) {
		Boolean flag = false;
		String message = ValidationTextHelper.stringNotEqual(actual, expected);
		flag = actual.equals(expected);
		LogHelper.log(flag ? Status.FAIL : Status.PASS, message);
	}
	
	public static void StringCompareNotEqualIgnoreCase(String actual, String expected) {
		Boolean flag = false;
		String message = ValidationTextHelper.stringNotEqual(actual, expected);
		flag = actual.equalsIgnoreCase(expected);
		LogHelper.log(flag ? Status.FAIL : Status.PASS, message);
	}  	
    
}
