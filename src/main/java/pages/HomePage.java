package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.LoggerUtils;

import java.util.function.Consumer;

public class HomePage {

    private final WebDriver driver;
    private final By loginSection = By.xpath("//*[@title='Giriş Yap']");
    private final By loginButton = By.xpath("//*[@data-cy='header-login-button']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginScreenLink() throws InterruptedException {

        Actions action = new Actions(driver);
        Consumer<By> hover = (By by) -> action.moveToElement(driver.findElement(by))
                .click()
                .perform();

        hover.accept(loginSection);
        //giriş yap kısmında hover olabilmesi için sleep gerekmekte
        Thread.sleep(3000);
        hover.accept(loginButton);
        LoggerUtils.logInfo("Giriş ekranı açılıyor", HomePage.class.getName());
        return new LoginPage(driver);
    }

}
