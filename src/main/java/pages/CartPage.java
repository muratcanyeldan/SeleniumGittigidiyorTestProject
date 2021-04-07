package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;

public class CartPage {

    private final WebDriver driver;
    private final By productPriceText = By.xpath("//*[@class='new-price']");
    private String productPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage increaseAmount(){
        productPrice = driver.findElement(productPriceText).getText();
        LoggerUtils.logInfo("Ürünlerin sepetteki fiyatı = "+productPrice,CartPage.class.getName());
        driver.findElement(By.xpath("(//*[@class='img-container-grid gg-w-3 gg-d-3 gg-t-3 gg-m-6 pl0'])[1]")).click();
        return new ProductPage(driver);
    }

    public void emptyCart() throws InterruptedException {
        driver.findElement(By.xpath("(//*[@class='gg-icon gg-icon-bin-medium'])[1]")).click();
        LoggerUtils.logInfo("Sepet boşaltıldı",CartPage.class.getName());

        //Sepetin boşaldığının görünmesi açısından bekleme verilmiştir.
        Thread.sleep(5000);
    }

    public String getProductPrice() {
        return productPrice;
    }

    public boolean isCartEmpty() {
        return driver.findElements(By.xpath("//*[@class='empty-cart-info gg-w-24 gg-d-21 gg-t-24 gg-m-24']")).isEmpty();
    }
}
