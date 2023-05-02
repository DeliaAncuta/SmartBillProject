package Tests;

import Objects.LoginObject;
import Objects.RaportObject;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RaportPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class RaportTest extends Hooks {

    @Test
    public void metodaTest(){

        LoginObject loginObject = new LoginObject(testData);
        RaportObject raportObject = new RaportObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.acceptCookies();
        homePage.clickAutentificare();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.Login(loginObject);
        testReport.attacheReport("pass", "Autentificare cu succes");

        RaportPage raportPage = new RaportPage(getDriver());
        raportPage.clickRapoarte(raportObject);
        testReport.attacheReport("pass", "Accesez meniul Rapoarte/ Stoc la zi");
        testReport.attacheReport("pass", "Validez existenta produsului receptionat");

    }


}
