package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;

public class LoginPage {

    private final WebDriver driver;
    private final By usernameField = By.id("L-UserNameField");
    private final By passwordField = By.id("L-PasswordField");
    private final By loginButton = By.id("gg-login-enter");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        LoggerUtils.logInfo("Üye adı başarılı bir şekilde girildi", LoginPage.class.getName());
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        LoggerUtils.logInfo("Parola başarılı bir şekilde girildi", LoginPage.class.getName());
    }

    public LoggedInPage clickLoginButton() {
        driver.findElement(loginButton).click();
        LoggerUtils.logInfo("Ana sayfaya giriş yapılmış olarak dönülüyor", LoginPage.class.getName());
        return new LoggedInPage(driver);
    }
}
