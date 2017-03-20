package Katalog;

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

    public void Met_Click(String selector) {
        WebElement tn = driver.findElement(By.xpath(selector));
        tn.click();
    }
}