package data;

import org.testng.annotations.DataProvider;

import common.PropertiesOperations;

public class DataProviderNG {
	@DataProvider(name = "test-users")
	public static Object[][] createData() {				
		Object[][] data = {
			{
				PropertiesOperations.getPropertyValueByKey("username"),
				PropertiesOperations.getPropertyValueByKey("password")
			}
		};
        return data;
	}
}
