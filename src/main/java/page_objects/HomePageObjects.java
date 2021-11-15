package page_objects;

import org.openqa.selenium.By;

import common.DfElement;
import page_constants.HomePageConstants;

public class HomePageObjects {

	public interface elements {
		DfElement btnStartEditing = new DfElement(
				By.xpath("//span[starts-with(" 
							+ "@class, '" + HomePageConstants.klass.button_text + "') "
							+ "and contains(text(),'" + HomePageConstants.labels.startEditing + "')]"), 
							HomePageConstants.labels.startEditing);		
		
		DfElement btnLogin = new DfElement(
				By.xpath("//button[starts-with(" 
							+ "@class, '" + HomePageConstants.klass.rc_header_dev_button_root + "') "
							+ "and contains(text(),'" + HomePageConstants.labels.logIn + "')]"), 
							HomePageConstants.labels.logIn);
		
		DfElement imgUserAvatar = new DfElement(
				By.xpath("//img[" 
						+ "@title = '" + HomePageConstants.labels.userAvatar + "']"),
							HomePageConstants.labels.userAvatar);

		DfElement btnSignUp = new DfElement(
				By.xpath("//button[starts-with(" 
						+ "@class, '" + HomePageConstants.klass.rc_header_dev_button_root + "') "
						+ "and contains(text(),'" + HomePageConstants.labels.signUp + "')]"), 
						HomePageConstants.labels.signUp);

		DfElement imgPicsartLogo = new DfElement(
				By.xpath("//img[" 
						+ "@title = '" + HomePageConstants.labels.picsart + "']"),
							HomePageConstants.labels.picsart);
	}
	
	public interface loginBox {		
		DfElement txtUsername = new DfElement(
				By.xpath("//input[" 
						+ "@name = '" + HomePageConstants.name.username + "']"),
							HomePageConstants.labels.enterUsernameOrEmail);
		
		DfElement txtPassword = new DfElement(
				By.xpath("//input[" 
						+ "@name = '" + HomePageConstants.name.password + "']"),
							HomePageConstants.labels.enterPassword);
		
		DfElement btnLogin = new DfElement(
				By.xpath("//button[starts-with(" 
							+ "@class, '" + HomePageConstants.klass.btn + "') "
							+ "and contains(text(),'" + HomePageConstants.labels.logIn + "')]"), 
							HomePageConstants.labels.logIn);	
	}
	
	public interface cookieBox{
		DfElement btnAccept = new DfElement(
				By.xpath("//button["
						+ "@id = '" + HomePageConstants.id.onetrust_accept_btn_handler + "' " 
						+ "and contains(text(),'" + HomePageConstants.labels.accept + "')]"),
							HomePageConstants.labels.accept);
	}
	
	
}
