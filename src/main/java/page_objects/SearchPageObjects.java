package page_objects;

import org.openqa.selenium.By;

import common.DfElement;
import page_constants.SearchPageConstants;

public class SearchPageObjects {
	public interface elements {
		DfElement txtSearchBox = new DfElement(
				By.xpath("//input[starts-with(" 
						+ "@class, '" + SearchPageConstants.klass.search_field_control + "')]"), 
								SearchPageConstants.labels.searchBox);

		DfElement listAutoCompleteSearch = new DfElement(
				By.xpath("//div[starts-with(" 
						+ "@class, '" + SearchPageConstants.klass.search_field_scrollable  + "')]"), 
								SearchPageConstants.labels.autoCompleteSearchList);	
		
		DfElement listAutoCompleteSearchResults = new DfElement(
				By.xpath("//div[starts-with(" 
						+ "@class, '" + SearchPageConstants.klass.search_field_scrollable + "')]"
						+ "//span"), 
								SearchPageConstants.labels.autoCompleteSearchList);

		DfElement searchResults = new DfElement(
				By.xpath("//div[starts-with(" 
						+ "@class, '" + SearchPageConstants.klass.grid_list_column + "')]"), 
								SearchPageConstants.labels.searchResults);	
		
		static DfElement listAutoCompleteSearchResultItem(int row, String key) {			
			return new DfElement(
					By.xpath("//div[starts-with(" 
							+ "@class, '" + SearchPageConstants.klass.search_field_scrollable + "')]"
							+ "/span["+ row +"]"
							+ "/a/text()[contains(translate(.,'"
								+ key.toLowerCase() +"', '" 
								+ key.toUpperCase() + "'),'"
								+ key.toUpperCase() +"')]//ancestor::span"), 
								SearchPageConstants.labels.autoCompleteSearchListItemMatch);
		}		
	}
}
