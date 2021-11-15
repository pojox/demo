package page_objects;

import org.openqa.selenium.By;

import common.DfElement;
import page_constants.CommonPageConstants;

public class CommonPageObjects {
	public interface elements {		
		DfElement btnLearn = new DfElement(
				By.xpath("//div[starts-with(" 
							+ "@class, '" + CommonPageConstants.klass.rc_header_dev_navigation_itemHolder + "')]"
							+ "/*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_dev_heading_root + "') "
							+ "and contains(@aria-label,'" + CommonPageConstants.labels.learnNewEditingSkills + "')]"
							+ "/parent::div"),				
							CommonPageConstants.labels.learn);

		DfElement subMenuLearn = new DfElement(
				By.xpath("//div[starts-with(" 
						+ "@class, '" + CommonPageConstants.klass.rc_header_dev_navigation_itemHolder + "')]"
						+ "/*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_dev_heading_root + "') "
						+ "and contains(text(),'" + CommonPageConstants.labels.learn + "')]"
						+ "/parent::div"
						+ "//*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_dev_column_root + "')]"),				
						CommonPageConstants.labels.learnSubMenuCards);		
		
		DfElement btnBlog = new DfElement(
				By.xpath("//div[starts-with(" 
							+ "@class, '" + CommonPageConstants.klass.rc_header_dev_navigation_itemHolder + "')]"
							+ "/*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_dev_drop_down_root + "')]"
							+ "//*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_dev_column_root + "')]"
							+ "//*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_title + "') "
							+ "and contains(text(),'" + CommonPageConstants.labels.blog + "')]"
							+ "/parent::a"),				
							CommonPageConstants.labels.learn);

		static DfElement getLearnSubMenu(String title) {
			return new DfElement(
					By.xpath("//div[starts-with(" 
							+ "@class, '" + CommonPageConstants.klass.rc_header_dev_navigation_itemHolder + "')]"
							+ "/*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_dev_drop_down_root + "')]"
							+ "//*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_dev_column_root + "')]"
							+ "//*[starts-with(@class, '" + CommonPageConstants.klass.rc_header_title + "') "
							+ "and contains(text(),'" + title + "')]"
							+ "/parent::a"),				
							CommonPageConstants.labels.learn);
		}		
		
		static DfElement navListMenu(String name) {
			return new DfElement(
					By.xpath("//ul[starts-with(" 
							+ "@class, '" + CommonPageConstants.klass.navigation_navList + "')]"
							+ "/li[starts-with(@class, '" + CommonPageConstants.klass.menu_navListItem + "')]"
							+ "//a[starts-with(@class, '" + CommonPageConstants.klass.menu_navLin + "') "
							+ "and contains(text(),'" + name + "')]"
							+ "/parent::li"), name);
		}
		
		DfElement btnTrends = new DfElement(
				By.xpath("//ul[starts-with(" 
							+ "@class, '" + CommonPageConstants.klass.navigation_navList + "')]"
							+ "/li[starts-with(@class, '" + CommonPageConstants.klass.menu_navListItem + "')]"
							+ "//a[starts-with(@class, '" + CommonPageConstants.klass.menu_navLin + "') "
							+ "and contains(text(),'" + CommonPageConstants.labels.trends + "')]"
							+ "/parent::li"),				
							CommonPageConstants.labels.trends);		
		
		static DfElement getHeaderTitle(String title) {
			return new DfElement(
					By.xpath("//header//a[starts-with(" 
							+ "@class, '" + CommonPageConstants.klass.header_blogTitle + "') "
							+ "and contains(text(),'" + title + "')]"), 
							CommonPageConstants.labels.headerTitle);
		}

	}
}
