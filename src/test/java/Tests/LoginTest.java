package Tests;

import Objects.LoginObject;
import Pages.HomePage;
import Pages.LoginPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    @Test
    public void metodaTest(){

        LoginObject loginObject = new LoginObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.acceptCookies();
        testReport.attacheReport("pass", "Click accept Cookies");
        homePage.clickAutentificare();
        testReport.attacheReport("pass", "Click autentificare");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.Login(loginObject);

        testReport.attacheReport("pass", "Validez autentificarea in cont");

    }

}
