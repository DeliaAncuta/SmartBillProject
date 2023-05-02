package Pages;

import Objects.IncasareObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IncasarePage extends BasePage{
    public IncasarePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="li[data-submenu='docemise_submenu']")
    private WebElement btnDocEmis;

    @FindBy(css="div[class='col-xs-12']>a[href='/raport/facturi/']")
    private WebElement btnFacturi;

    @FindBy(css="div[class='show_report_filter']")
    private WebElement btnFiltrare;

    @FindBy(css= "div[id='client_name2_wrapper']>input[id='client_name2']")
    private WebElement cifClient;

    @FindBy(css="li[class='ui-menu-item']>a")
    private WebElement cifSelectat;

    @FindBy(css="button[id='advanced_filter']")
    private WebElement btnFiltrare2;

    @FindBy(css="div[class='actiuni_unelte']>ul")
    private WebElement btnActiuni;

    @FindBy(xpath = "//div[@class='actiuni_unelte']/ul/li/ul/li[4]")
    private WebElement btnIncasare;

    @FindBy(css="div[id='modal_incasare_factura']")
    private WebElement modalIncasare;

    @FindBy(css="a[id='payBtn']")
    private  WebElement btnIncasareFinal;

    @FindBy(css="div[class='status paid']")
    private WebElement statusIncasare;

    public void incasareFactura(IncasareObject incasareObject){
        element.clickElement(btnDocEmis);
        element.clickElement(btnFacturi);
        element.clickElement(btnFiltrare);
        element.fillElement(cifClient, incasareObject.getClient());
        element.clickElement(cifSelectat);
        element.clickElement(btnFiltrare2);
        element.waitElementVisible(btnActiuni);

        try {
            element.clickElement(btnActiuni);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            element.clickElement(btnActiuni);
        }

        element.clickElement(btnIncasare);
        element.waitElementVisible(modalIncasare);
        element.moveToElement(modalIncasare);
        element.clickElement(btnIncasareFinal);

        Assert.assertEquals(statusIncasare.getText(), incasareObject.getStatusFactura());
    }
}
