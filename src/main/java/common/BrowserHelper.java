package common;

import base.DriverFactory;

public class BrowserHelper {

	public static String  getBaseUrl() {
		return PropertiesOperations.getPropertyValueByKey("url").replaceFirst("/*$", "");
	}
	public static String  getCurrentUrl() {
		return DriverFactory.getDriverInstance().getCurrentUrl().replaceFirst("/*$", "");
	}
	
	public static void verifyCurrentUrl(String pathToAppendToBaseUrl) {
		String actual = getCurrentUrl();
		String expected = getBaseUrl() + "/" + pathToAppendToBaseUrl.replaceFirst("^/", "");;
		ExpectationHelper.StringCompare(actual, expected);
	}

	public static void verifyCurrentUrlDefault() {
		String actual = getCurrentUrl();
		String expected = getBaseUrl();
		ExpectationHelper.StringCompare(actual, expected);
	}

	public static void getUrl(String url) {
		DriverFactory.getDriverInstance().get(url);
	}

}
