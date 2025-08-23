package dibimbing.tests;

import dibimbing.core.BaseTest;
import dibimbing.core.DriverManager;
import dibimbing.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToSauceDemo();
        loginPage.login("standard_user", "secret_sauce");
    }
}
