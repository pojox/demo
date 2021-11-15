package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.CommonEnums;
import common.PropertiesOperations;
import common.WaitHelper;
import page_helpers.HomePageHelper;

public class TestBase {

	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	public void LaunchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = PropertiesOperations.getPropertyValueByKey("url");
		int default_timeout_ms = Integer.parseInt(PropertiesOperations.getPropertyValueByKey("default_timeout_ms"));

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(CommonEnums.Browsers.CHROME));
		WebDriver driver = DriverFactory.getDriverInstance();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(default_timeout_ms));
		driver.navigate().to(url);
		WaitHelper.waitPageLoadReady();
		/**
		 * revisit home page loader - in the end - workaround - now waits for cookie
		 */
		//HomePageHelper.cookieBox.verifyLoginPopupDisplayed();
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}

}
