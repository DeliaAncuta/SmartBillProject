package Pages;

import Objects.FacturaObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FacturaPage extends BasePage{
    public FacturaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="li[data-submenu='nir_submenu']")
    private WebElement btnVanzariSiAchizitii;

    @FindBy(css="#nav-emitere-factura-link")
    private WebElement btnFactura;

    @FindBy(css="#client_name")
    private WebElement client;

    @FindBy(css="li[id='19158013']>a")
    private WebElement selectClient;

    @FindBy(css="input[id='product_code']")
    private WebElement codProdus;

    @FindBy(xpath = "//div[@class='ui-dialog-buttonset']/button[2]")
    private WebElement confirmPreluare;

    @FindBy(css="input[id='price']")
    private WebElement pretProdus;

    @FindBy(css = "button[id='add_product_btn']")
    private WebElement adaugareProdus;

    @FindBy(css="div[id='totaluri_tabel']")
    private WebElement Total;

    @FindBy(css="#saveInvoiceBtn")
    private WebElement btnSpreSalvare;

    @FindBy(css="a[id='viewer_save_id']")
    private WebElement btnSalvare;

    @FindBy(css="#show_document_iframe")
    private WebElement iframeCiorna;

    @FindBy(css="#viewer_email_id")
    private WebElement btnTrimitere;

    @FindBy(css="div[class='status']")
    private WebElement statusFactura;

    public void emitereFactura(FacturaObject facturaObject){
        element.clickElement(btnVanzariSiAchizitii);
        element.clickElement(btnFactura);
        element.fillElement(client, facturaObject.getClient());
        element.clickElement(selectClient);

        element.waitElementVisible(codProdus);
        element.fillElement(codProdus, facturaObject.getCodProdus());
        codProdus.sendKeys(Keys.ENTER);
        element.clickElement(confirmPreluare);
        element.fillElement(pretProdus, facturaObject.getPret());

        element.clickElement(adaugareProdus); //l-am trecut de 2ori deoarece o singura data nu-l acceseaza
        element.clickElement(adaugareProdus);

        element.waitElementVisible(Total);

        element.clickElement(btnSpreSalvare);
        frameMethods.switchFrame(iframeCiorna);
        element.clickElement(btnSalvare);

        element.waitElementVisible(btnTrimitere);

        //Validez primul status al facturii
        Assert.assertEquals(statusFactura.getText(), facturaObject.getStatusFactura());
    }
}
