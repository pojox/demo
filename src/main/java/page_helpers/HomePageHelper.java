package page_helpers;

import common.BrowserHelper;
import common.PagePaths;
import common.WaitHelper;
import page_objects.HomePageObjects;

public class HomePageHelper {

	public static void verifyPageLoaded() {
		WaitHelper.waitPageLoadForElement(HomePageObjects.elements.btnStartEditing.getLocater());
		HomePageObjects.elements.btnStartEditing.verifyDisplayedStatus();
	}
	
	public static void clickLoginButton() {				
		HomePageObjects.elements.btnLogin.clickButton();
	}
	
	public static void verifyLoginPopupDisplayed() {
		// TODO Auto-generated method stub
		
	}

	public static interface loginBox{
		static void verifyLoginPopupDisplayed() {
			WaitHelper.waitPageLoadForElement(HomePageObjects.loginBox.txtUsername.getLocater());
			HomePageObjects.loginBox.txtUsername.verifyDisplayedStatus();
		}
		static void verifyLoginPopupHidden() {
			HomePageObjects.loginBox.txtUsername.verifyHiddenStatus();
		}		
		static void enterUsername(String username) {
			HomePageObjects.loginBox.txtUsername.enterText(username);
		}
		
		static void enterPassword(String password) {
			HomePageObjects.loginBox.txtPassword.enterText(password);
		}
		
		static void clickLoginButton() {
			WaitHelper.waitBackgroundProcess();
			HomePageObjects.loginBox.btnLogin.clickButton();
		}

		static void verifyLoginSuccessful() {
			verifyLoginPopupHidden();
			verifyUserAvatarDisplayed();
			verifySignUpButtonHidden();
		}
	}
	
	public static interface cookieBox{
		static void verifyLoginPopupDisplayed() {
			WaitHelper.waitPageLoadForElement(HomePageObjects.cookieBox.btnAccept.getLocater());
		}		
	}

	public static void verifyUserAvatarDisplayed() {
		HomePageObjects.elements.imgUserAvatar.verifyDisplayedStatus();
	}
	
	public static void verifySignUpButtonDisplayed() {
		HomePageObjects.elements.btnSignUp.verifyDisplayedStatus();
	}
	
	public static void verifySignUpButtonHidden() {
		HomePageObjects.elements.btnSignUp.verifyHiddenStatus();
	}	

	public static void clickPicsartLogo() {
		HomePageObjects.elements.imgPicsartLogo.clickButton();
	}

	public static void verifyCurrentPageUrlIsCreate() {
		BrowserHelper.verifyCurrentUrl(PagePaths.CREATE);
	}

	public static void verifyCurrentPageUrlIsDefault() {
		BrowserHelper.verifyCurrentUrlDefault();
	}
	
	
}
