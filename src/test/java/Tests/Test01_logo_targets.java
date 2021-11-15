package Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import common.ListenerImplementation;
import data.DataProviderNG;
import page_helpers.CreatePageHelper;
import page_helpers.HomePageHelper;

@Listeners(ListenerImplementation.class)
public class Test01_logo_targets extends TestBase {

	@Test(description = "Verify Guest-User clicking Piscart Logo opens Create Page", enabled = true)
	public void verifyGuestUserLogoClickOpensHomePage() {
		HomePageHelper.clickPicsartLogo();
		HomePageHelper.verifyPageLoaded();
	}

	@Test(description = "Verify Auth-User clicking Piscart Logo opens Home Page", enabled = true, 
			dataProvider = "test-users", dataProviderClass = DataProviderNG.class)
	public void verifySignedInUserLogoClickOpensCreatePage(String username, String password) {
		HomePageHelper.clickLoginButton();
		HomePageHelper.loginBox.verifyLoginPopupDisplayed();

		HomePageHelper.loginBox.enterUsername(username);
		HomePageHelper.loginBox.enterPassword(password);
		HomePageHelper.loginBox.clickLoginButton();
		HomePageHelper.loginBox.verifyLoginSuccessful();

		HomePageHelper.clickPicsartLogo();
		CreatePageHelper.verifyPageLoaded();
	}

}
