package page_objects;

import org.openqa.selenium.By;

import common.DfElement;
import page_constants.CreatePageConstants;

public class CreatePageObjects {
	public interface elements {
		DfElement btnNewProject = new DfElement(
				By.xpath("//button/span[" 
							+ "normalize-space()='" + CreatePageConstants.labels.newProject + "']"), 
							CreatePageConstants.labels.newProject);		
	}
}
