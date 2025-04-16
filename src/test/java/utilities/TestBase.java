package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setUpReport() {
        // إعداد التقرير مرة واحدة فقط في بداية الـ Suite
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        reporter.config().setReportName("OpenCart Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Mahmoud Fouad");
        extent.setSystemInfo("Environment", "QA");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.opencart.com/index.php?route=account/login");

        // الكوكيز
        driver.manage().addCookie(new Cookie("cf_clearance", "4XgSmmqZCnWIhVeDFgL5ezA6iEwFwVvDOS0r2C7y3aA-1744653891-1.2.1.1-USSY5BMm4TKN_.7aTQtvnqSO.crWKbCDQlRYjH7QnngmtVwvC2KTVJJTB732uVXl1x7qgOndVQ1LRD6GopJr56Kg2MQxQ6ENXZRGfGUtUyhlWfSf58OLAH2AVW4okpgL8wcYhnyxX1PqJxzGIVzSOvy8dQa9s9HIBSSGVoLV1v.3JXLS.FkNIiC.XURg2PgHCAk2hAKhNgwORb3_8FJ9AURyYHJZc2K9yQFgLqumDpuxIGaZ9N3ff4c1JffLv3dsWe7CQeHMFOiles2nFIuCtKbDlNu0EghnPwqlD_Xm1syUzQu4ubmQP_aK95DDs2kWgCwf09czNAtMtu.khTv_nMKiqV7vkEY6.dc.1hutJj4ANw2H44dopK2qD8_rm8EW"));
        driver.manage().addCookie(new Cookie("session", "abc12345"));

        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        // حفظ التقرير بعد الانتهاء من كل التستات
        extent.flush();
    }
}
