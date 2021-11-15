package page_objects;

import org.openqa.selenium.By;

import common.DfElement;
import page_constants.BlogPageConstants;

public class BlogPageObjects {
	public interface elements {		
	
		DfElement blogPosts = new DfElement(
				By.xpath("//div[starts-with(" 
						+ "@class, '" + BlogPageConstants.klass.post_list_root + "')]"
						+ "/div[starts-with(@class, '" + BlogPageConstants.klass.post_item_root + "')]"),				
							BlogPageConstants.labels.blogPosts);		

		DfElement categoryPosts = new DfElement(
				By.xpath("//div[starts-with(" 
						+ "@class, '" + BlogPageConstants.klass.masonry_vertical_row + "')]"
						+ "/div[starts-with(@class, '" + BlogPageConstants.klass.masonry_vertical_column + "')]"),				
							BlogPageConstants.labels.categoryPosts);	

		DfElement headerTitle_REMOVE = new DfElement(
				By.xpath("//h2[starts-with(" 
						+ "@class, '" + BlogPageConstants.klass.top_bar_header + "') "
						+ "and contains(text(), '" + BlogPageConstants.labels.designSchool + "')]"),				
							BlogPageConstants.labels.designSchool);
		
		DfElement mainActiveCarousel = new DfElement(
				By.cssSelector("div[class*='" + BlogPageConstants.klass.main_carousel_items + "']"
						+ ">div[class*='" + BlogPageConstants.klass.main_carousel_item_root + "']"
						+ "[class*='" + BlogPageConstants.klass.active + "']"),
						BlogPageConstants.labels.mainActiveCarousel);
		
		DfElement mainActiveCarouselAnchor = new DfElement(
				By.cssSelector("div[class*='" + BlogPageConstants.klass.main_carousel_items + "']"
						+ ">div[class*='" + BlogPageConstants.klass.main_carousel_item_root + "']"
						+ "[class*='" + BlogPageConstants.klass.active + "']>a"),
						BlogPageConstants.labels.mainActiveCarouselLeftArrow);	

		DfElement mainActiveCarouselRightArrow = new DfElement(
				By.cssSelector("div[class*='" + BlogPageConstants.klass.main_carousel_items + "']"
						+ ">button[class*='" + BlogPageConstants.klass.main_carousel_arrow_root + "']"
						+ "[class*='" + BlogPageConstants.klass.right + "']"),
						BlogPageConstants.labels.mainActiveCarouselRightArrow);
		
		DfElement mainActiveCarouselLeftArrow = new DfElement(
				By.cssSelector("div[class*='" + BlogPageConstants.klass.main_carousel_items + "']"
						+ ">button[class*='" + BlogPageConstants.klass.main_carousel_arrow_root + "']"
						+ "[class*='" + BlogPageConstants.klass.left + "']"),
						BlogPageConstants.labels.mainActiveCarouselLeftArrow);

		DfElement searchIcon = new DfElement(
				By.cssSelector("form[class*='" + BlogPageConstants.klass.search_form_form + "']"
						+ ">button[class*='" + BlogPageConstants.klass.search_form_searchButton + "']"),
						BlogPageConstants.labels.searchIcon);

		DfElement searchTextBox = new DfElement(
				By.cssSelector("form[class*='" + BlogPageConstants.klass.search_form_form + "']"
						+ ">input[class*='" + BlogPageConstants.klass.search_form_searchInput + "']"),
						BlogPageConstants.labels.searchTextbox);

		DfElement searchResultTitle = new DfElement(
				By.cssSelector("div[class*='" + BlogPageConstants.klass.top_bar_root + "']"
						+ ">h2[class*='" + BlogPageConstants.klass.top_bar_header + "']"),
						BlogPageConstants.labels.searchResultTitle);
		
		DfElement searchResultCount = new DfElement(
				By.cssSelector("div[class*='" + BlogPageConstants.klass.top_bar_root + "']"
						+ ">div[class*='" + BlogPageConstants.klass.top_bar_subtitle + "']"),
						BlogPageConstants.labels.searchResultCount);		
		
		static DfElement getHeaderTitle(String title) {
			return new DfElement(
					By.xpath("//h2[starts-with(" 
							+ "@class, '" + BlogPageConstants.klass.top_bar_header + "') "
							+ "and contains(text(), '" + title + "')]"), title);
		}
		
		

		
	}
	
	
}
