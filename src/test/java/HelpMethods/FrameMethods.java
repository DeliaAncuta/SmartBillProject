package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

   private WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrame(String value){
        driver.switchTo().frame(value);
    }

    public void switchFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchDefault(){
        driver.switchTo().defaultContent();
    }
}
