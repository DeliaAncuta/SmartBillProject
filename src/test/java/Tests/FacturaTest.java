package Tests;

import Objects.FacturaObject;
import Objects.LoginObject;
import Pages.FacturaPage;
import Pages.HomePage;
import Pages.LoginPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class FacturaTest extends Hooks {

    @Test
    public void metodaTest(){

        LoginObject loginObject = new LoginObject(testData);
        FacturaObject facturaObject = new FacturaObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.acceptCookies();
        homePage.clickAutentificare();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.Login(loginObject);
        testReport.attacheReport("pass", "Autentificare cu succes");

        FacturaPage facturaPage = new FacturaPage(getDriver());
        facturaPage.emitereFactura(facturaObject);
        testReport.attacheReport("pass", "Emit factura pentru produsul receptionat");
        testReport.attacheReport("pass", "Validez statusul facturii");
    }
}
