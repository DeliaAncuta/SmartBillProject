package HelpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    private WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSpecificTabW(Integer index){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(index));
    }

    public void closeCurentTabW(){
        driver.close();
    }
}
