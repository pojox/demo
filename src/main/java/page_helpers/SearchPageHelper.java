package page_helpers;

import org.openqa.selenium.By;

import base.DriverFactory;
import common.BrowserHelper;
import common.PagePaths;
import common.WaitHelper;
import page_objects.SearchPageObjects;

public class SearchPageHelper {

	public static void openPage() {
		/* i cannot locate the search button - so, for now - will navigate to url directly */
		BrowserHelper.getUrl(BrowserHelper.getBaseUrl() + "/" + PagePaths.SEARCH);
	}

	public static void verifyPageLoaded() {
		WaitHelper.waitPageLoadForElement(SearchPageObjects.elements.txtSearchBox.getLocater());
		SearchPageObjects.elements.txtSearchBox.verifyDisplayedStatus();
	}

	public static void enterSearchText(String value) {
		SearchPageObjects.elements.txtSearchBox.enterTextSlowly(value);
	}

	public static void verifyAutoCompleteSearchListDisplayed() {		
		WaitHelper.waitPageLoadForElement(SearchPageObjects.elements.listAutoCompleteSearch.getLocater());
		SearchPageObjects.elements.listAutoCompleteSearch.verifyDisplayedStatus();
	}

	public static void verifyAutoCompleteSearchListItemMatchs(String key) {
		By by = SearchPageObjects.elements.listAutoCompleteSearchResults.getLocater();
		int size = DriverFactory.getDriverInstance().findElements(by).size();
		System.out.println(size);		
		int max_size = size > 5 ? 5 : size; /*comparing only top 5 items */
		for (int i=1; i <= max_size ; i++ ) {
			System.out.println(SearchPageObjects.elements.listAutoCompleteSearchResultItem(i, key).getLocater().toString());
			SearchPageObjects.elements.listAutoCompleteSearchResultItem(i, key).verifyDisplayedStatus();
		}
	}

	public static void verifyMultipleSearchResultsDisplayed() {
		SearchPageObjects.elements.searchResults.verifyMultipleDisplayedStatus();
	}	
}
