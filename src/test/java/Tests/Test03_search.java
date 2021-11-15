package Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import common.ListenerImplementation;
import common.ToolbarHelper;
import page_helpers.BlogPageHelper;
import page_helpers.SearchPageHelper;

@Listeners(ListenerImplementation.class)
public class Test03_search extends TestBase {

	@Test(description = "Verify searching for an item in Blogs return desired results.", enabled = true)
	public void verifyGuestUserSearchFunctionality1() {
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();

		BlogPageHelper.hoverOnSearchIcon();
		BlogPageHelper.verifySearchInputFieldDisplayed();

		BlogPageHelper.enterSearchText("picsart");
		BlogPageHelper.clickOnSeaarchButton();

		BlogPageHelper.verifySearchResultsDisplayed("picsart");
		BlogPageHelper.verifyMultipleSearchReesultsDisplayed();
	}

	/**
	 * another search i found - not sure if this is the one but not sure from which
	 * page it is referenced from for now - calling it directly from url - /search
	 */
	@Test(description = "Verify searching for an item return desired results.", enabled = true)
	public void verifyGuestUserSearchFunctionality2() {
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();

		SearchPageHelper.openPage();
		SearchPageHelper.verifyPageLoaded();
		SearchPageHelper.enterSearchText("picsart");
		SearchPageHelper.verifyAutoCompleteSearchListDisplayed();
		SearchPageHelper.verifyAutoCompleteSearchListItemMatchs("picsart");
		SearchPageHelper.verifyMultipleSearchResultsDisplayed();
	}

}
