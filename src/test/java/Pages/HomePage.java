package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".banner-actions-container  #onetrust-accept-btn-handler")
    private WebElement btnCookies;

    @FindBy(css=".menu-btn-autentificare>span")
    private WebElement btnAutentificare;

    public void acceptCookies(){
        element.clickElement(btnCookies);
    }

    public void clickAutentificare(){
        element.clickElement(btnAutentificare);
    }

}
