package page_helpers;

import common.WaitHelper;
import page_objects.CreatePageObjects;

public class CreatePageHelper {
	
	public static void verifyPageLoaded() {
		WaitHelper.waitPageLoadForElement(CreatePageObjects.elements.btnNewProject.getLocater());
		CreatePageObjects.elements.btnNewProject.verifyDisplayedStatus();
	}
}
