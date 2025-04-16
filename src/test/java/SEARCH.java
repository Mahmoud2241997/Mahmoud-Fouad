import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
public class SEARCH {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahmoud Fouad\\Pictures\\SELSNIUM\\Selenium\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.opencart.com/index.php?route=marketplace/extension&member_token=f07c731065b44b7068f78120f396f3e6");
        driver.manage().addCookie(new Cookie("cf_clearance", "crx35XDPLIgC5E7biV5XDJhPgJbIwhsqQWoZwu50UdU-1744237511-1.2.1.1-BgMfR5xgmfi.s.aXTSN_bWJNL8k8MEMVf.wgo4HkeGQ1a3LZ0DQ8fYetOiwZIbEYap_n5gNUTXYshjVZezXXMgbUdPIhf40l3aVwNm6pxcRP2gPtlMlntMavs0gfQM2.0mmcl5NumTQ_sWWp9TCHifVc5VklwzZCuwRiS1xe6_3BD2joDr17lusbjexvz9YugSsAIT8PvmzIboIhtNXaolA98rerXJw13RZtIe3xn.sVh70gpsbFwoHaeLWXXbv0ZPBcoBbiHRYG8zah7Pdh_R8XNTYN_EjGVFUS9CbaZgi_uLfKsyAlMjmanarapLRSwCodgJcYCDrwAQR35AET.G2B7JwqhgSwFFQCUD8BelhBBnUfzhpTJ5ubxndvtbUc"));
        driver.manage().addCookie(new Cookie("session", "abc12345"));
        driver.navigate().refresh();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    public void SEARCH_WITH_VALID_MARKETPLACE_ITEMS() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("filter_search")));
        Thread.sleep(2000);
        search.sendKeys("Paypal");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
    }
    @Test
    public void SEARCH_WITH_INVALID_MARKETPLACE_ITEMS() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("filter_search")));
        Thread.sleep(2000);
        search.sendKeys("///////");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {Thread.sleep(6000);
        if (driver != null) {
            driver.quit();
        }
    }
}
