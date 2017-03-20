package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dima on 15.03.2017.
 */
public class Tests {
    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setUp() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://hotline.ua/");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        synchronized (driver) {
            // driver.wait(100);
        }
        driver.quit();
    }

    @Test
    public void a_LogInTest() throws InterruptedException {
        //Login
        Login.Methods loginM = new Login.Methods(driver);
        Login.Locators loginL = new Login.Locators();
        //Assert_False_#1
        loginM.ProvideEnter(loginL.Vhod);
        loginM.ProvideLogin("ooooohomkadb@gmail.com", loginL.LoginH);
        loginM.ProvidePass("Q36w21@", loginL.PassH);
        loginM.SubmitForm(loginL.Submit);
        Assert.assertFalse(loginM.findElement(loginL.LoginH).equals("assertFalse: #1 e-mail!"));
        Assert.assertFalse(loginM.findElement(loginL.PassH).equals("assertFalse: #1 pass!"));
        //Assert_False_#2
        loginM.Met_ClearForm(loginL.Loc_Clear_Pass);
        loginM.Met_ClearForm(loginL.Loc_Clear_Login);
        loginM.ProvideLogin("homkadb@gmail.com", loginL.LoginH);
        loginM.ProvidePass("Q36w21@@@@@", loginL.PassH);
        loginM.SubmitForm(loginL.Submit);
        Assert.assertFalse(loginM.findElement(loginL.LoginH).equals("assertFalse: #2 e-mail!"));
        Assert.assertFalse(loginM.findElement(loginL.PassH).equals("assertFalse: #2 pass!"));
        //Assert_False_#3
        loginM.Met_ClearForm(loginL.Loc_Clear_Pass);
        loginM.Met_ClearForm(loginL.Loc_Clear_Login);
        loginM.ProvideLogin("aaamkadb.gmail.com", loginL.LoginH);
        loginM.ProvidePass("Q36w21555444444222", loginL.PassH);
        loginM.SubmitForm(loginL.Submit);
        Assert.assertFalse(loginM.findElement(loginL.LoginH).equals("assertFalse: #3 e-mail!"));
        Assert.assertFalse(loginM.findElement(loginL.PassH).equals("assertFalse: #3 pass!"));
        //Assert_True
        loginM.Met_ClearForm(loginL.Loc_Clear_Pass);
        loginM.Met_ClearForm(loginL.Loc_Clear_Login);
        loginM.ProvideLogin("homkadb@gmail.com", loginL.LoginH);
        loginM.ProvidePass("Q36w21@", loginL.PassH);
        loginM.SubmitForm(loginL.Submit);
        Assert.assertTrue(loginM.findElement(loginL.LoginH).isDisplayed(), "assertTrue: The e-mail!");
        Assert.assertTrue(loginM.findElement(loginL.PassH).isDisplayed(), " assertTrue: The login");
        Assert.assertTrue(loginM.findElement(loginL.Submit).isDisplayed(), "assertTrue: The Submit");
        //Login_Quit
        loginM.ProvideEnter(loginL.Loc_Out_Login);
        loginM.ProvideEnter(loginL.Loc_Quit_Login);
    }

    @Test
    public void b_SearchTest() throws InterruptedException {
        //Search_Velik
        Search.Methods SearchM = new Search.Methods(driver);
        Search.Locators SearchL = new Search.Locators();
        SearchM.Met_Click(SearchL.Loc_Click_Search);
        SearchM.Met_Past_Search("Schwinn", SearchL.Loc_Past_Search);
        SearchM.Met_Submit(SearchL.Loc_Vel_Submit);
        SearchM.Met_Click(SearchL.Loc_Vel_Schwinn);
        SearchM.Met_Click(SearchL.Loc_Vel_Cat_CrossCountry);
        SearchM.Met_Click(SearchL.Loc_Vel_Cat_Street);
        Assert.assertTrue(SearchM.findElement(SearchL.Loc_Past_Search).isDisplayed(), "assertTrue: The Schwinn!");
        Assert.assertTrue(SearchM.findElement(SearchL.Loc_Past_Search).isDisplayed(), "assertTrue: The Submit!");
    }

    @Test
    public void c_SearchTest() throws InterruptedException {
        //Search_Tel
        Search.Methods SearchM = new Search.Methods(driver);
        Search.Locators SearchL = new Search.Locators();
        SearchM.Met_Clear(SearchL.Loc_Search_Clear);
        SearchM.Met_Past_Tel_Search("Asus", SearchL.Loc_Past_Tel_Search);
        SearchM.Met_Submit(SearchL.Loc_Tel_Submit);
        SearchM.Met_Click(SearchL.Loc_Asus_ZeneFone);
        SearchM.Met_Click(SearchL.Loc_ObzorA_Img);
        SearchM.Met_Click(SearchL.Loc_Close);
        SearchM.Met_Click(SearchL.Loc_Komenty_Asus);
        SearchM.Met_Click(SearchL.Loc_Back_GeneralPage);
        Assert.assertTrue(SearchM.findElement(SearchL.Loc_Past_Tel_Search).isDisplayed(), "assertTrue: The Asus!");
        Assert.assertTrue(SearchM.findElement(SearchL.Loc_Past_Search).isDisplayed(), "assertTrue: The Submit!");
    }

    @Test
    public void f_KatalogTest() {
        //Foto_Video_Canon
        Katalog.Methods KatalogM = new Katalog.Methods(driver);
        Katalog.Locators KatalogL = new Katalog.Locators();
        KatalogM.Met_Click(KatalogL.Loc_MenuFotoVideo);
        KatalogM.Met_Click(KatalogL.Loc_PodMenuFotoVideo);
        KatalogM.Met_Click(KatalogL.Loc_Foto);
        KatalogM.Met_Click(KatalogL.Loc_Filter_Zerkalka);
        KatalogM.Met_Click(KatalogL.Loc_Filter_Canon);
        KatalogM.Met_Click(KatalogL.Loc_Back_GeneralPage);

    }
}

