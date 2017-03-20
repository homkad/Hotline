package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Dima on 13.03.2017.
 */
public class Methods {
    WebDriver driver;

    public Methods(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String s) {
        return driver.findElement(By.xpath(s));
    }

    public void ProvideEnter(String selector) {
        WebElement tr = driver.findElement(By.xpath(selector));
        tr.click();
    }

    public void ProvideLogin(String mail, String selector) {
        WebElement tr = driver.findElement(By.xpath(selector));
        tr.sendKeys(mail);
    }

    public void ProvidePass(String pass, String selector) {
        WebElement tr = driver.findElement(By.xpath(selector));
        tr.sendKeys(pass);
    }

    public void SubmitForm(String selector) {
        WebElement tr = driver.findElement(By.xpath(selector));
        tr.submit();
    }

    public void Met_ClearForm(String selector) {
        WebElement tr = driver.findElement(By.xpath(selector));
        tr.clear();
    }
}
