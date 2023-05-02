package Tests;

import Objects.IncasareObject;
import Objects.LoginObject;
import Pages.HomePage;
import Pages.IncasarePage;
import Pages.LoginPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class IncasareTest extends Hooks {

    @Test
    public void metodaTest(){

        LoginObject loginObject = new LoginObject(testData);
        IncasareObject incasareObject = new IncasareObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.acceptCookies();
        homePage.clickAutentificare();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.Login(loginObject);
        testReport.attacheReport("pass", "Autentificare cu succes");

        IncasarePage incasarePage = new IncasarePage(getDriver());
        incasarePage.incasareFactura(incasareObject);
        testReport.attacheReport("pass", "Accesez meniul Documente emise/ Facturi");
        testReport.attacheReport("pass", "Incasez factura emisa");
        testReport.attacheReport("pass", "Validez statusul facturii");
    }
}
