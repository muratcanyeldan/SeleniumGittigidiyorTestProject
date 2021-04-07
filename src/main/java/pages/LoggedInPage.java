package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;

public class LoggedInPage {

    private final WebDriver driver;
    private final By searchBox = By.name("k");
    private final boolean isLoggedIn;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
        isLoggedIn = driver.findElements(By.xpath("//*[@title='Giriş Yap']")).isEmpty();
        LoggerUtils.logInfo("Başarılı giriş yapıldı mı sorgusuna cevap olarak "+isLoggedIn+" dönmektetir",LoggedInPage.class.getName());
    }

    public SearchPage searchSomething(String searchText){
        driver.findElement(searchBox).click();
        driver.findElement(searchBox).sendKeys(searchText, Keys.ENTER);
        LoggerUtils.logInfo("Ürün arama sayfasına gidiliyor", LoggedInPage.class.getName());
        return new SearchPage(driver);
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

}
