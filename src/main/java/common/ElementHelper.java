package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import base.DriverFactory;

public class ElementHelper {
	public static void waitAndClickButton(DfElement element) {
    	String message = ValidationTextHelper.elementClicked(element.getName());
        WaitHelper.waitForElementToBeClickable(element.getLocater());
        try {
        	DriverFactory.getDriverInstance().findElement(element.getLocater()).click();
            LogHelper.log(Status.PASS, message);
        } catch (Exception e) {
        	LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
        }
	}

	public static void waitAndClickButtonJS(DfElement element) {
		String message = ValidationTextHelper.elementClicked(element.getName());
        WaitHelper.waitForElementToBeClickable(element.getLocater());
        try {
        	JavascriptExecutor ex = (JavascriptExecutor) DriverFactory.getDriverInstance();
        	ex.executeScript("arguments[0].click()", DriverFactory.getDriverInstance().findElement(element.getLocater()));        	
            LogHelper.log(Status.PASS, message);
        } catch (Exception e) {
        	LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
        }
	}

	public static void sendKeys(DfElement element, String value) {
		String message = ValidationTextHelper.elementTypeText(element.getName());
		WaitHelper.waitForElementToBeClickable(element.getLocater());		
		try {
			clearText(element);
			DriverFactory.getDriverInstance().findElement(element.getLocater()).click();
			DriverFactory.getDriverInstance().findElement(element.getLocater()).sendKeys(value);
			LogHelper.log(Status.PASS, message);
		}catch (Exception e) {
			System.out.println("sendKeys - ERROR ERROR ERROR ERROR ERROR ");
        	LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
        }
	}

	private static void clearText(DfElement element) {
		DriverFactory.getDriverInstance().findElement(element.getLocater()).clear();		
	}

	public static void typeSlowly(DfElement element, String value) {
		int delayMS = 500;
		typeSlowly(element, value, delayMS);
	}
	
	public static void typeSlowly(DfElement element, String value, int delayMS) {
		String message = ValidationTextHelper.elementTypeText(element.getName());
		WaitHelper.waitForElementToBeClickable(element.getLocater());
		try {
			clearText(element);
			DriverFactory.getDriverInstance().findElement(element.getLocater()).click();
			for (int i = 0; i < value.length(); i++) {
				DriverFactory.getDriverInstance().findElement(element.getLocater())
						.sendKeys(String.valueOf(value.charAt(i)));
		        WaitHelper.sleep(delayMS);
		    }				
			LogHelper.log(Status.PASS, message);
		}catch (Exception e) {
			System.out.println("sendKeys - ERROR ERROR ERROR ERROR ERROR ");
        	LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
        }		
	}

	public static void hoverMouseOver(DfElement element) {
		String message = ValidationTextHelper.elementHoverOver(element.getName());
		WaitHelper.waitForElementToBeVisible(element.getLocater());
		try{
			WebElement el = DriverFactory.getDriverInstance().findElement(element.getLocater()); 
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriverInstance();
			executor.executeScript("arguments[0].scrollIntoView(true);", el);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());		
			actions.moveToElement(el).build().perform();
			LogHelper.log(Status.PASS, message);
			Thread.sleep(1000);
		}catch(Exception e){
			LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
		}
	}
	
	public static void hoverMouseOverAndClick(DfElement element) {
		String message = ValidationTextHelper.elementHoverOverAndClick(element.getName());
		WaitHelper.waitForElementToBeVisible(element.getLocater());
		try{
			WebElement el = DriverFactory.getDriverInstance().findElement(element.getLocater()); 
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriverInstance();
			executor.executeScript("arguments[0].scrollIntoView(true);", el);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());		
			actions.moveToElement(el).click().build().perform();
			LogHelper.log(Status.PASS, message);
			Thread.sleep(1000);
		}catch(Exception e){
			LogHelper.log(Status.FAIL, message + ".  Exception is: "+e);
		}
	}
	
	public static String getHref(DfElement element) {
		return DriverFactory.getDriverInstance().findElement(element.getLocater()).getAttribute("href");
	}

	public static String getText(DfElement element) {
		return DriverFactory.getDriverInstance().findElement(element.getLocater()).getText();
	}
	
}
