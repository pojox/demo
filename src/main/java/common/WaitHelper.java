package common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class WaitHelper {
	
	static int max_page_load_ms = Integer.parseInt(PropertiesOperations
			.getPropertyValueByKey("max_page_load_ms"));
	static int default_timeout_ms = Integer.parseInt(PropertiesOperations
			.getPropertyValueByKey("default_timeout_ms"));
	
	public static void waitPageLoadReady() {
		waitPageLoadReady(max_page_load_ms);
	}
	
	public static void waitPageLoadReady(int timeoutMS) {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		waitBackgroundProcess();
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver)
                        		.executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeoutMS));
        wait.until(pageLoadCondition);	
	}
	
	public static void waitBackgroundProcess() {
		long endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(10, TimeUnit.MILLISECONDS);
		while ( System.nanoTime() < endTime ){
	        Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)DriverFactory.getInstance()
	        		.getDriver()).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
	        if (ajaxIsComplete){
	            break;
	        }
	        sleep(2000);
	    }			
	}
	
	public static void waitPageLoadForElement(By by) {
		waitPageLoadReady();
		waitForElementToBeVisible(by);
	}
	
	public static void waitForElementToBeClickable(By by) {
		int default_timeout_ms = Integer.parseInt(PropertiesOperations.getPropertyValueByKey("default_timeout_ms"));
		waitForElementToBeClickable(by, default_timeout_ms);
	}
	
	public static void waitForElementToBeClickable(By by, int timeMS) {		
		WebDriver driver = DriverFactory.getDriverInstance();
		WebElement el = driver.findElement(by);
		new WebDriverWait(driver, Duration.ofMillis(timeMS)).until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public static void waitForElementToBeVisible(By by) {
		int default_timeout_ms = Integer.parseInt(PropertiesOperations.getPropertyValueByKey("default_timeout_ms"));
		waitForElementToBeVisible(by, default_timeout_ms);
	}
	
	public static void waitForElementToBeVisible(By by, int timeMS) {
		WebDriver driver = DriverFactory.getDriverInstance();
		WebElement el = driver.findElement(by);
		new WebDriverWait(driver, Duration.ofMillis(timeMS)).until(ExpectedConditions.visibilityOf(el));
	}	
	
	public static void waitForElementToBeHidden(By by) {
		int default_timeout_ms = Integer.parseInt(PropertiesOperations.getPropertyValueByKey("default_timeout_ms"));
		waitForElementToBeHidden(by, default_timeout_ms);
	}
	
	public static void waitForElementToBeHidden(By by, int timeMS) {
		WebDriver driver = DriverFactory.getDriverInstance();
		WebElement el = driver.findElement(by);
		new WebDriverWait(driver, Duration.ofMillis(timeMS)).until(ExpectedConditions.invisibilityOf(el));
	}
	
	public static void sleep(int timeMS){
		try {
			Thread.sleep(timeMS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



}
