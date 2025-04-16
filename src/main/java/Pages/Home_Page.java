package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_Page  {
    WebDriver driver;
    WebDriverWait wait;

    public Home_Page (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By featuresLink = By.linkText("Features");
    private By demoLink = By.linkText("Demo");
    private By marketplaceLink = By.linkText("Marketplace");
    private By blogLink = By.xpath("//a[contains(text(),'Blog')]");
    private By resourcesLink = By.xpath("//a[contains(text(),'Resources')]");
    private By downloadLink = By.linkText("Download");
    private By succsesmassege = By.cssSelector("div.alert.alert-success");
    public void clickFeatures() {
        wait.until(ExpectedConditions.elementToBeClickable(featuresLink)).click();
    }

    public void clickDemo() {
        wait.until(ExpectedConditions.elementToBeClickable(demoLink)).click();
    }

    public void clickMarketplace() {
        wait.until(ExpectedConditions.elementToBeClickable(marketplaceLink)).click();
    }

    public void clickBlog() {
        wait.until(ExpectedConditions.elementToBeClickable(blogLink)).click();
    }

    public void clickResources() {
        wait.until(ExpectedConditions.elementToBeClickable(resourcesLink)).click();
    }

    public void clickDownload() {
        wait.until(ExpectedConditions.elementToBeClickable(downloadLink)).click();
    }
    By FeaturespageHeading = By.xpath("//h1[contains(text(),'OpenCart Features')]");

    public String getFeaturesPageHeading() {
        return driver.findElement(FeaturespageHeading).getText().trim();
    }
    By DemopageHeading = By.xpath("//h1[contains(text(),'OpenCart Demonstration')]");

    public String getDemoPageHeading() {
        return driver.findElement(DemopageHeading).getText().trim();
    }
    By MarketplacepageHeading = By.xpath("//h1[contains(text(),'Welcome to OpenCart Extension Store')]");

    public String getMarketplacePageHeading() {
        return driver.findElement(MarketplacepageHeading).getText().trim();
    }
    By BlogpageHeading = By.xpath("//h1[contains(text(),'Welcome to OpenCart Ecommerce Blog')]");

    public String BlogPageHeading() {
        return driver.findElement(BlogpageHeading).getText().trim();
    }
    By DownloadpageHeading = By.xpath("//h4[text()='Download & host your own']");

    public String DownloadPageHeading() {
        return driver.findElement(DownloadpageHeading).getText().trim();
    }
}

