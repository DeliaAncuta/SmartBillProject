package Pages;

import Objects.LoginObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='id_username']")
    private WebElement emailUser;

    @FindBy(css = "input[id='id_password']")
    private WebElement parolaUser;

    @FindBy(css = "#cloud_login_btn>span")
    private WebElement btnIntraInCont;

    @FindBy(css = "#posponeAccountSecurityBtn")
    private WebElement btnDelay2FA;

    @FindBy(css = "#wSecurityBox  .close")
    private WebElement closeBox2FA;

    @FindBy(css = "#wSecurityBox  .secure-account-notification-warning")
    private WebElement messageBox2FA;

    public void Login(LoginObject loginObject) {
        element.fillElement(emailUser, loginObject.getEmail());
        element.fillElement(parolaUser, loginObject.getPassword());
        element.clickElement(btnIntraInCont);
        try {
            btnDelay2FA.click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

      Assert.assertEquals(messageBox2FA.getText(), loginObject.getMessage());
      element.clickElement(closeBox2FA);

    }
}
