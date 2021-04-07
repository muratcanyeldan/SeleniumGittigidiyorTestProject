package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.LoggerUtils;

import java.util.List;
import java.util.Random;

public class SearchPage {

    private final WebDriver driver;
    private final By pageTwoLink = By.xpath("(//*[@href = '/arama/?k=" + Constants.SEARCH_KEYWORD + "&sf=2'])[1]");
    private String currentURL;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage goToPageTwo() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(pageTwoLink).click();
        LoggerUtils.logInfo("İkinci sayfaya başarılı bir şekilde gidildi", SearchPage.class.getName());
        currentURL = driver.getCurrentUrl();
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='gg-uw-6 gg-w-8 gg-d-8 gg-t-8 gg-m-24 gg-mw-12 catalog-seem-cell srp-item-list  browser']"));
        LoggerUtils.logInfo("İkinci sayfada bulunan ürünler başarılı bir şekilde alındı", SearchPage.class.getName());
        int randomProductID = new Random().nextInt(products.size());
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[3]/div[2]/ul/li[" + randomProductID + "]")).click();
        LoggerUtils.logInfo("Ürün sayfasına gidiliyor", SearchPage.class.getName());
        return new ProductPage(driver);
    }

    public String getCurrentURL() {
        return currentURL;
    }

}
