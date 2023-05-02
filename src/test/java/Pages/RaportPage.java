package Pages;

import Objects.RaportObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class RaportPage extends BasePage{
    public RaportPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="li[data-submenu='rapoarte_submenu']")
    private WebElement btnRapoarte;

    @FindBy(css="div[class='col-xs-12']>a[href='/rapoarte/']")
    private WebElement btnToateRapoartele;

    @FindBy(css="li[data-link='rc-3']")
    private WebElement btnGestStoc;

    @FindBy(css="div[id='rc3-2']")
    private WebElement btnStocLaZi;

    @FindBy(css="div[class='show_report_filter']")
    private WebElement btnFiltrare;

    @FindBy(css="div[id='product-name-wrapper']>input[id='product_name']")
    private WebElement produsul;

    @FindBy(css="button[id='simple_filter']")
    private WebElement btnFiltrare2;

    @FindBy(css="tr[class='lvl_one_row']>td[class='xl-cell']")
    private List<WebElement> rezultateDenProd;



    public void clickRapoarte(RaportObject raportObject){
        element.clickElement(btnRapoarte);
        element.clickElement(btnToateRapoartele);
        element.clickElement(btnGestStoc);

        element.waitElementVisible(btnStocLaZi); //am pus acest wait deoarece au fost cazuri cand a accesat alt raport
        element.clickElement(btnStocLaZi);

        element.clickElement(btnFiltrare);
        element.fillElement(produsul, raportObject.getCodProdus());
        element.clickElement(btnFiltrare2);

        String value = raportObject.getDenumireProdus()+" ("+raportObject.getCodProdus()+")";
        Assert.assertEquals(rezultateDenProd.get(1).getAttribute("innerHTML"), value);

    }
}
