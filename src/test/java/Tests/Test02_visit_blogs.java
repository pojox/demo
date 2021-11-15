package Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import common.ListenerImplementation;
import common.ToolbarHelper;
import page_helpers.BlogPageHelper;

@Listeners(ListenerImplementation.class)
public class Test02_visit_blogs extends TestBase {

	@Test(description = "Verify click on on button Blog opens correct page.", enabled = true)
	public void verifyGuestNavigateToBlogPage() {
		ToolbarHelper.hoverMouseOverButtonLearn();
		ToolbarHelper.verifyColumnCardsForLearnDisplayed();
		ToolbarHelper.ClickButtonBlog();
		BlogPageHelper.verifyBlogPageLoaded();
		BlogPageHelper.verifyMultipleBlogPostsDisplayed();
	}

	@Test(description = "Verify click on on button Design School opens correct page.", enabled = true)
	public void verifyGuestNavigateToDesignSchoolPage() {
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();
		ToolbarHelper.ClickButtonDesignSchool();
		BlogPageHelper.verifyDesignSchoolPageLoaded();
	}

	@Test(description = "Verify click on on button Trends opens correct page.", enabled = true)
	public void verifyGuestNavigateToTrendsPage() {
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();
		ToolbarHelper.ClickButtonTrends();
		BlogPageHelper.verifyTrendsPageLoaded();
	}

	@Test(description = "Verify click on on button Picsart-Pro opens correct page.", enabled = true)
	public void verifyGuestNavigateToPicsartProPage() {
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();
		ToolbarHelper.ClickButtonPicsartPro();
		BlogPageHelper.verifyPicsartProPageLoaded();
	}

	@Test(description = "Verify click on on button News opens correct page.", enabled = true)
	public void verifyGuestNavigateToNewsPage() {
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();
		ToolbarHelper.ClickButtonNews();
		BlogPageHelper.verifyNewsPageLoaded();
	}

}
