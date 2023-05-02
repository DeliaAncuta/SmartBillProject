package Tests;


import Objects.LoginObject;
import Objects.NIRObject;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NirPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class NIRTest extends Hooks {

    @Test
    public void metodaTest(){

        LoginObject loginObject = new LoginObject(testData);
        NIRObject nirObject = new NIRObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.acceptCookies();
        homePage.clickAutentificare();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.Login(loginObject);
        testReport.attacheReport("pass", "Autentificare cu succes");

        NirPage nirPage = new NirPage(getDriver());
        nirPage.clickMeniuNir();
        testReport.attacheReport("pass", "Accesez meniul Vanzari si achizitii/ Receptie de la furnizor(NIR)");
        nirPage.addNirData(nirObject);
        testReport.attacheReport("pass", "Introduc datele receptiei + Salvez");
        nirPage.salvareNIR(nirObject);
        testReport.attacheReport("pass", "Validez salvarea receptiei");

    }
}
