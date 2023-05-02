package Pages;

import Objects.NIRObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NirPage extends BasePage{

    public NirPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="li[data-submenu='nir_submenu']")
    private WebElement btnVanzariSiAchizitii;

    @FindBy(css = ".col-xs-12>a[id='nav-achizitie-nir-link']")
    private WebElement btnNIR;

    @FindBy(css="input[id='supplier_name']")
    private WebElement furnizor;

    @FindBy(css="li[id='456189']")
    private WebElement furnizor1331;

    @FindBy(css="input[id='acquisition_document_number']")
    private WebElement nrDocFurnizor;

    @FindBy(css="input[id='product_name']")
    private WebElement denumireProdus;

    @FindBy(css="input[id='product_code']")
    private WebElement codProdus;
    @FindBy(css="input[id='measuring_unit']")
    private WebElement umProdus;

    @FindBy(css="input[id='doc_quantity']")
    private WebElement cantDoc;

    @FindBy(css="input[id='quantity']")
    private WebElement cantPrimita;

    @FindBy(css="input[id='price']")
    private WebElement pret;

    @FindBy(css="button[id='add_product_btn']")
    private WebElement btnAdaugare;

    @FindBy(css="#total_value_input")
    private WebElement total;

    @FindBy(css="#saveInvoiceBtn")
    private WebElement btnSave1;

    @FindBy(css=".viewer-buttons-inner  #viewer_save_id")
    private WebElement btnSave2;

    @FindBy(xpath = "//*[@id=\"viewer_print_id\"]")
    private WebElement tipareste;

    @FindBy(css="#show_document_iframe")
    private WebElement iframeCiorna;

    public void clickMeniuNir(){
        element.clickElement(btnVanzariSiAchizitii);
        element.clickElement(btnNIR);
    }

    public void addNirData(NIRObject nirObject){
        element.fillElement(furnizor, nirObject.getFurnizor());
        element.clickElement(furnizor1331);
        element.fillElement(nrDocFurnizor, nirObject.getNrDocFurnizor());
        element.fillElement(denumireProdus, nirObject.getDenumireProdus());
        element.fillElement(codProdus, nirObject.getCodProdus());
        element.fillElement(umProdus, nirObject.getUmProdus());
        element.fillElement(cantDoc, nirObject.getCantDoc());
        element.fillElement(pret, nirObject.getPret());

        element.clickElement(btnAdaugare);
        element.clickElement(btnAdaugare);
        element.waitElementVisible(total);

    }

    public void salvareNIR(NIRObject nirObject){
        element.clickElement(btnSave1);
        frameMethods.switchFrame(iframeCiorna);

        element.clickElement(btnSave2);
        Assert.assertEquals(tipareste.getText(), nirObject.getMessage2());
    }

}
