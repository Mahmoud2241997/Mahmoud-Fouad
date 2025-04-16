package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtensionsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ExtensionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By sortDropdown = By.id("input-sort");
    By extensionNames = By.cssSelector("#extension-list a[href*='route=marketplace/extension/info']");
    By priceElements = By.cssSelector("span");
    By productCards = By.cssSelector(".col-xs-6");
    By ratingStars = By.cssSelector("i[class*='star']");
    By marketplaceLink = By.linkText("Marketplace");

    // Actions
    public void navigateAndSetCookies() throws InterruptedException {
        driver.navigate().to("https://www.opencart.com/index.php?route=marketplace/extension&member_token=f07c731065b44b7068f78120f396f3e6");
        driver.manage().addCookie(new Cookie("cf_clearance", "crx35XDPLIgC5E7biV5XDJhPgJbIwhsqQWoZwu50UdU-1744237511-1.2.1.1-BgMfR5xgmfi.s.aXTSN_bWJNL8k8MEMVf.wgo4HkeGQ1a3LZ0DQ8fYetOiwZIbEYap_n5gNUTXYshjVZezXXMgbUdPIhf40l3aVwNm6pxcRP2gPtlMlntMavs0gfQM2.0mmcl5NumTQ_sWWp9TCHifVc5VklwzZCuwRiS1xe6_3BD2joDr17lusbjexvz9YugSsAIT8PvmzIboIhtNXaolA98rerXJw13RZtIe3xn.sVh70gpsbFwoHaeLWXXbv0ZPBcoBbiHRYG8zah7Pdh_R8XNTYN_EjGVFUS9CbaZgi_uLfKsyAlMjmanarapLRSwCodgJcYCDrwAQR35AET.G2B7JwqhgSwFFQCUD8BelhBBnUfzhpTJ5ubxndvtbUc"));
        driver.manage().addCookie(new Cookie("session", "abc12345"));
        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    public Select getSortDropdown() {
        WebElement Market = wait.until(ExpectedConditions.elementToBeClickable(marketplaceLink));
        Market.click();
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        return new Select(dropdown);
    }

    public List<String> fetchExtensionNames() {
        List<WebElement> elements = driver.findElements(extensionNames);
        List<String> names = new ArrayList<>();
        for (WebElement el : elements) {
            names.add(el.getText().trim().toLowerCase());
        }
        return names;
    }

    public List<Double> fetchPrices() {
        List<WebElement> elements = driver.findElements(priceElements);
        List<Double> prices = new ArrayList<>();
        for (WebElement el : elements) {
            String priceText = el.getText().trim();
            if (priceText.equalsIgnoreCase("FREE")) {
                prices.add(0.0);
            } else {
                priceText = priceText.replaceAll("[^\\d.]", "");
                if (!priceText.isEmpty()) {
                    prices.add(Double.parseDouble(priceText));
                }
            }
        }
        return prices;
    }

    public List<Integer> fetchRatings() {
        List<Integer> ratings = new ArrayList<>();
        List<WebElement> products = driver.findElements(By.cssSelector(".col-xs-6")); // غيّر الكلاس حسب تصميم موقعك

        for (WebElement product : products) {
            // عدّ النجوم في كل منتج
            List<WebElement> stars = product.findElements(By.cssSelector(".opencart-icon-star-light"));
            ratings.add(stars.size());
        }

        return ratings;
    }


    public void scrollPageDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
    }

}

