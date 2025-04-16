package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By pinField = By.name("pin");
    By forgotPasswordLink = By.linkText("Forgot your password?");
    By emailForgotPassword = By.name("email");
    By logoutButton = By.cssSelector(".btn.btn-black.navbar-btn");
    By errormassege = By.cssSelector("div.alert.alert-danger");
    By succsesmassege = By.cssSelector("div.alert.alert-success");
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password + Keys.ENTER);
    }

    public Account_page enter_pin(String pin) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Pin = wait.until(ExpectedConditions.visibilityOfElementLocated(pinField));
        Pin.sendKeys(pin);
        Pin.sendKeys(Keys.ENTER);
        return new Account_page(driver);
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void resetPassword(String email) {
        driver.findElement(emailForgotPassword).sendKeys(email + Keys.ENTER);
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logout);
        logout.click();
    }

    public String geterormassege() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errormassege));

        // استنى فعليًا لما يبقى فيه نص
        wait.until(driver -> !error.getText().trim().isEmpty());

        String errorText = error.getText().trim();
        System.out.println("🚨 Error message: [" + errorText + "]");
        return errorText;
    }


    public String getsuccsesmassege() {
        return driver.findElement(succsesmassege).getText();

    }
}
