package Search;

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

    public void Met_Past_Search(String Schwinn, String selector) {
        WebElement tn = driver.findElement(By.xpath(selector));
        tn.sendKeys(Schwinn);
    }

    public void Met_Clear(String selector) {
        WebElement tn = driver.findElement(By.xpath(selector));
        tn.clear();
    }

    public void Met_Past_Tel_Search(String Asus, String selector) {
        WebElement tn = driver.findElement(By.xpath(selector));
        tn.sendKeys(Asus);
    }

    public void Met_Submit(String selector) {
        WebElement tn = driver.findElement(By.xpath(selector));
        tn.submit();
    }

    public void Met_Click(String selector) {
        WebElement tn = driver.findElement(By.xpath(selector));
        tn.click();

    }
}