package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setupChrome(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.smartbill.ro/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clearBrowser(){
        driver.quit();
    }

}
