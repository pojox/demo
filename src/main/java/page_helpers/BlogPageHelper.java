package page_helpers;

import common.BrowserHelper;
import common.ExpectationHelper;
import common.PagePaths;
import common.ToolbarHelper;
import common.WaitHelper;
import page_constants.BlogPageConstants;
import page_objects.BlogPageObjects;

public class BlogPageHelper {
	public static void verifyBlogPageLoaded() {
		WaitHelper.waitPageLoadForElement(BlogPageObjects.elements.blogPosts.getLocater());
		ToolbarHelper.verifyHeaderBlogTitleDisplayed(BlogPageConstants.labels.blog);
		BrowserHelper.verifyCurrentUrl(PagePaths.BLOG);
	}
	
	public static void verifyPageLoaded(String title, String path) {
		WaitHelper.waitPageLoadForElement(BlogPageObjects.elements
				.getHeaderTitle(title).getLocater());
		ToolbarHelper.verifyHeaderBlogTitleDisplayed(BlogPageConstants.labels.blog);
		BrowserHelper.verifyCurrentUrl(path);	
	}
	
	public static void verifyNewsPageLoaded() {
		verifyPageLoaded(
				BlogPageConstants.labels.news,
				String.join("/", PagePaths.BLOG, PagePaths.CATEGORY, PagePaths.NEWS)
				);
	}
	
	public static void verifyTrendsPageLoaded() {
		verifyPageLoaded(
				BlogPageConstants.labels.trends,
				String.join("/", PagePaths.BLOG, PagePaths.CATEGORY, PagePaths.TRENDS)
				);
	}
	
	public static void verifyPicsartProPageLoaded() {
		verifyPageLoaded(
				BlogPageConstants.labels.picsartPro,
				String.join("/", PagePaths.BLOG, PagePaths.CATEGORY, PagePaths.PICSART_PRO)
				);
	}	
	
	public static void verifyDesignSchoolPageLoaded() {
		verifyPageLoaded(
				BlogPageConstants.labels.designSchool,
				String.join("/", PagePaths.BLOG, PagePaths.CATEGORY, PagePaths.DESIGN_SCHOOL)
				);
	}	
			
	public static void verifyMultipleBlogPostsDisplayed() {
		BlogPageObjects.elements.blogPosts.verifyMultipleDisplayedStatus();		
	}

	public static void verifyMultipleCategoryPostsDisplayed() {
		BlogPageObjects.elements.categoryPosts.verifyMultipleDisplayedStatus();		
	}
	
	public static void verifyMultipleSearchReesultsDisplayed() {
		verifyMultipleCategoryPostsDisplayed();		
	}	

	public static void hoverOnMainActiveCarousel() {
		BlogPageObjects.elements.mainActiveCarousel.hoverMouseOver();
	}

	public static void verifyOnMainCarouselBothArrowsDisplayed() {
		BlogPageObjects.elements.mainActiveCarouselLeftArrow.verifyDisplayedStatus();
		BlogPageObjects.elements.mainActiveCarouselRightArrow.verifyDisplayedStatus();
	}

	public static void clickOnMainCarouselLeftArrow() {
		BlogPageObjects.elements.mainActiveCarouselLeftArrow.clickButton();
	}
	
	public static void clickOnMainCarouselRightArrow() {
		BlogPageObjects.elements.mainActiveCarouselRightArrow.clickButton();
	}

	public static void verifyOnMainCarouselNavigationToCorrectPost() {		
		hoverOnMainActiveCarousel();
		String hrefOriginal = BlogPageObjects.elements.mainActiveCarouselAnchor.getHref();
		verifyOnMainCarouselBothArrowsDisplayed();		
		clickOnMainCarouselLeftArrow();
		
		hoverOnMainActiveCarousel();
		String hrefLeft = BlogPageObjects.elements.mainActiveCarouselAnchor.getHref();
		verifyOnMainCarouselBothArrowsDisplayed();
		clickOnMainCarouselRightArrow();	
		
		String hrefRight = BlogPageObjects.elements.mainActiveCarouselAnchor.getHref();		
		ExpectationHelper.StringCompareNotEqualIgnoreCase(hrefOriginal, hrefLeft);
		ExpectationHelper.StringCompareIgnoreCase(hrefRight, hrefOriginal);
	}

	public static void verifyOnMainCarouselClickImageOpensCorrectPost() {
		String href = BlogPageObjects.elements.mainActiveCarouselAnchor.getHref();
		BlogPageObjects.elements.mainActiveCarousel.clickButton();
		WaitHelper.waitPageLoadReady();
		String hrefResult = BrowserHelper.getCurrentUrl();
		ExpectationHelper.StringCompareIgnoreCase(href, hrefResult);
	}

	public static void hoverOnSearchIcon() {
		BlogPageObjects.elements.searchIcon.hoverMouseOver();
	}

	public static void clickOnSeaarchButton() {
		BlogPageObjects.elements.searchIcon.clickButton();
	}

	public static void verifySearchInputFieldDisplayed() {
		BlogPageObjects.elements.searchTextBox.verifyDisplayedStatus();
	}

	public static void enterSearchText(String key) {
		BlogPageObjects.elements.searchTextBox.enterTextSlowly(key);
	}

	public static void verifySearchResultsDisplayed(String searchKey) {
		String actualTitle = BlogPageObjects.elements.searchResultTitle.getText();
		ExpectationHelper.StringCompareIgnoreCase(searchKey, actualTitle);
	}
}
