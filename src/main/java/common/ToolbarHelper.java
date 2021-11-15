package common;

import page_constants.CommonPageConstants;
import page_objects.CommonPageObjects;

public class ToolbarHelper {

	public static void hoverMouseOverButtonLearn() {
		CommonPageObjects.elements.btnLearn.hoverMouseOver();
	}
	
	public static void verifyColumnCardsForLearnDisplayed() {
		CommonPageObjects.elements.subMenuLearn.verifyDisplayedStatus();
	}
	
	public static void ClickButtonBlog() {	
		CommonPageObjects.elements.btnBlog.hoverMouseOverAndClick();
	}

	public static void ClickDesignSchoolBlog() {	
		CommonPageObjects.elements.getLearnSubMenu(CommonPageConstants.labels.designSchool).hoverMouseOverAndClick();
	}	

	public static void verifyHeaderBlogTitleDisplayed(String title) {
		CommonPageObjects.elements.getHeaderTitle(title).verifyDisplayedStatus();
	}

	public static void openBlogsPage() {
		hoverMouseOverButtonLearn();
		verifyColumnCardsForLearnDisplayed();
		ClickButtonBlog();				
	}

	public static void ClickButtonDesignSchool() {
		CommonPageObjects.elements.navListMenu(CommonPageConstants.labels.designSchool).hoverMouseOverAndClick();
	}
	
	public static void ClickButtonTrends() {
		CommonPageObjects.elements.navListMenu(CommonPageConstants.labels.trends).hoverMouseOverAndClick();
	}
	
	public static void ClickButtonPicsartPro() {
		CommonPageObjects.elements.navListMenu(CommonPageConstants.labels.picsartPro).hoverMouseOverAndClick();
	}
	
	public static void ClickButtonNews() {
		CommonPageObjects.elements.navListMenu(CommonPageConstants.labels.news).hoverMouseOverAndClick();
	}

}
