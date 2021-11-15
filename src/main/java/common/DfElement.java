package common;

import org.openqa.selenium.By;

public class DfElement implements IDfElement {
	By by;
	String name;
	
	public DfElement(By locater, String name) {
		this.by = locater;
		this.name = name;
	}
	
	public By getLocater() {
		return by;
	}
	
	public String getName() {
		return name;
	}	
	
    public void clickButton() {
        ElementHelper.waitAndClickButton(this);
    }
    
    public void clickButtonJS() {
        ElementHelper.waitAndClickButtonJS(this);
    }
    
    public void verifyDisplayedStatus() {
    	ExpectationHelper.verifyDisplayedStatus(this);    	
    }
    
    public void verifyMultipleDisplayedStatus() {
    	ExpectationHelper.verifyMultipleDisplayedStatus(this);    	
    }
    
	public void verifyHiddenStatus() {
    	ExpectationHelper.verifyHiddenStatus(this);		
	}   
	public void enterText(String value) {
		ElementHelper.sendKeys(this, value);		
	}

	public void enterTextSlowly(String value) {
		ElementHelper.typeSlowly(this, value);
		WaitHelper.sleep(3000);
	}

	public void hoverMouseOver() {
		ElementHelper.hoverMouseOver(this);	
		WaitHelper.sleep(1000);
	}
	
	public void hoverMouseOverAndClick() {
		ElementHelper.hoverMouseOverAndClick(this);		
	}
	
	public String getHref() {
		return ElementHelper.getHref(this);	
	}

	public String getText() {
		return ElementHelper.getText(this);	
	}

}
