package Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import common.ListenerImplementation;
import common.ToolbarHelper;
import page_helpers.BlogPageHelper;

@Listeners(ListenerImplementation.class)
public class Test04_carousel extends TestBase{
	
	@Test (description = "Verify Image Carousel Left-Right Arrows shown on hover.", enabled = true)
	public void verifyGuestUserImageCarouselShowLeftRightArrowsOnHover() {	
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();
		
		BlogPageHelper.hoverOnMainActiveCarousel();
		BlogPageHelper.verifyOnMainCarouselBothArrowsDisplayed();
	}
	
	@Test (description = "Verify Image Carousel Left-Right navigation works.", enabled = true)
	public void verifyGuestUserImageCarouselLeftRightNavigation() {	
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();
			
		BlogPageHelper.verifyOnMainCarouselNavigationToCorrectPost();
	}
	
	@Test (description = "Verify clicking Image in Carousel opens the correct post.", enabled = true)
	public void verifyGuestUserImageCarouselOpenPost() {	
		ToolbarHelper.openBlogsPage();
		BlogPageHelper.verifyBlogPageLoaded();
			
		BlogPageHelper.verifyOnMainCarouselClickImageOpensCorrectPost();
	}	

}
