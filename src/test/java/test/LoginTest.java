package test;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

//	@Test
//	public void loginTest()
//	{
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"),Constants.waitTime);
//	}

	@Test
	public void checkBoxTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.selectCurrentDate();
		
		//Assert.assertTrue(Verify.verifyElementVisible(driver, loginPage.searchField),"Search Item is not visible");

	}

}
