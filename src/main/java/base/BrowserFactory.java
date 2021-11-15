package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.CommonEnums;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	WebDriver driver;
	//RemoteWebDriver driver;

	public WebDriver createBrowserInstance(CommonEnums.Browsers browserType) {

		switch (browserType) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setAcceptInsecureCerts(true);
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");				
				options.addArguments("--incognito");
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				options.merge(caps);
				
				driver = new ChromeDriver(options);
				/*
				 try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				*/
				break;
				
			case FIREFOX:
				driver = null; 
				break;
				
			case EDGE:
				driver = null;
				break;	
			default:
				driver = null;
		}
		return driver;
	}

}
