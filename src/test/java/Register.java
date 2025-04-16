import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Register {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahmoud Fouad\\Pictures\\SELSNIUM\\Selenium\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.opencart.com/index.php?route=account/register");
        driver.manage().addCookie(new Cookie("cf_clearance", "crx35XDPLIgC5E7biV5XDJhPgJbIwhsqQWoZwu50UdU-1744237511-1.2.1.1-BgMfR5xgmfi.s.aXTSN_bWJNL8k8MEMVf.wgo4HkeGQ1a3LZ0DQ8fYetOiwZIbEYap_n5gNUTXYshjVZezXXMgbUdPIhf40l3aVwNm6pxcRP2gPtlMlntMavs0gfQM2.0mmcl5NumTQ_sWWp9TCHifVc5VklwzZCuwRiS1xe6_3BD2joDr17lusbjexvz9YugSsAIT8PvmzIboIhtNXaolA98rerXJw13RZtIe3xn.sVh70gpsbFwoHaeLWXXbv0ZPBcoBbiHRYG8zah7Pdh_R8XNTYN_EjGVFUS9CbaZgi_uLfKsyAlMjmanarapLRSwCodgJcYCDrwAQR35AET.G2B7JwqhgSwFFQCUD8BelhBBnUfzhpTJ5ubxndvtbUc"));
        driver.manage().addCookie(new Cookie("session", "abc12345"));
        driver.navigate().refresh();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // in the case Verify_Registration_with_Valid_Data you must change e-mail in each test cycle
        // in every test case you must solve capatcha manually to complete it
    }
    @Test
    public void Verify_Registration_with_Valid_Data() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username")));
        username.sendKeys("Mahmoud55222");
        Thread.sleep(1000);
        WebElement firstname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        firstname.sendKeys("Mahmoud");
        Thread.sleep(1000);
        WebElement lastname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-lastname")));
        lastname.sendKeys("Fouad");
        Thread.sleep(1000);
        WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        email.sendKeys("ffg2228@gmail.com");
        Thread.sleep(1000);
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-country")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Egypt");
        Thread.sleep(1000);
        WebElement Password1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password")));
        Password1.sendKeys("01100138137");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
        Thread.sleep(6000);
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary')]"));
        registerButton.click();
    }
    @Test
    public void Verify_Registration_with_Existing_Email() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username")));
        username.sendKeys("Mahmoud2522");
        Thread.sleep(1000);
        WebElement firstname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        firstname.sendKeys("Mahmoud");
        Thread.sleep(1000);
        WebElement lastname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-lastname")));
        lastname.sendKeys("Fouad");
        Thread.sleep(1000);
        WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        email.sendKeys("ffgghh2228@gmail.com");
        Thread.sleep(1000);
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-country")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Egypt");
        Thread.sleep(1000);
        WebElement Password1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password")));
        Password1.sendKeys("01100138137");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
        Thread.sleep(6000);
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary')]"));
        registerButton.click();

    }
    @Test
    public void Verify_Registration_with_Invalid_Email_Format() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username")));
        username.sendKeys("Mahmoud2522");
        Thread.sleep(1000);
        WebElement firstname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        firstname.sendKeys("Mahmoud");
        Thread.sleep(1000);
        WebElement lastname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-lastname")));
        lastname.sendKeys("Fouad");
        Thread.sleep(1000);
        WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        email.sendKeys("test@com");
        Thread.sleep(1000);
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-country")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Egypt");
        Thread.sleep(1000);
        WebElement Password1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password")));
        Password1.sendKeys("01100138137");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
        Thread.sleep(6000);
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary')]"));
        registerButton.click();

    }
    @Test
    public void Verify_Registration_with_Week_Password() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username")));
        username.sendKeys("Mahmoud5222");
        Thread.sleep(1000);
        WebElement firstname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        firstname.sendKeys("Mahmoud");
        Thread.sleep(1000);
        WebElement lastname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-lastname")));
        lastname.sendKeys("Fouad");
        Thread.sleep(1000);
        WebElement email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        email.sendKeys("ffg28@gmail.com");
        Thread.sleep(1000);
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-country")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Egypt");
        Thread.sleep(1000);
        WebElement Password1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password")));
        Password1.sendKeys("0");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
        Thread.sleep(6000);
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary')]"));
        registerButton.click();
    }
    @Test
    public void Verify_Registration_with_Empty_fields() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(1000);
        }
        Thread.sleep(6000);
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'btn-primary')]"));
        registerButton.click();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {Thread.sleep(6000);
        if (driver != null) {
            driver.quit();
        }
    }
}


