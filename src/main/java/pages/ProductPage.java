package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;


public class ProductPage {

    private final WebDriver driver;
    private final By addToBasketButton = By.xpath("//button[@id='add-to-basket']");
    private final By cartButton = By.xpath("(//*[@href='https://www.gittigidiyor.com/sepetim'])[1]");
    private String price;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToBasket()  {

        price = driver.findElement(By.xpath("//*[@property='og:price:amount']")).getAttribute("content");
        LoggerUtils.logInfo("Ürün sepete eklendi fiyatı = " + price,ProductPage.class.getName());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(addToBasketButton).click();
        jse.executeScript("window.scrollTo(0,0)");
    }

    public CartPage goToCartPage() {
        driver.findElement(cartButton).click();
        LoggerUtils.logInfo("Sepete gidiliyor",ProductPage.class.getName());
        return new CartPage(driver);
    }

    public String getPrice() {
        return price;
    }
}
