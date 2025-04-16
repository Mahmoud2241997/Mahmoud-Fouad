package tests;

import Pages.Home_Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Navigation extends TestBase {

    @Test
    public void testFeatures() {
        test = extent.createTest("Navigate to Features Page").assignCategory("Navigation");
        Home_Page navPage = new Home_Page(driver);
        test.info("Clicking on 'Features' link");

        navPage.clickFeatures();
        String actualresult = navPage.getFeaturesPageHeading();
        String EXPECTEDRESULT = "OpenCart Features";

        test.info("Checking page heading");

        try {
            Assert.assertEquals(actualresult, EXPECTEDRESULT);
            test.pass("Successfully navigated to Features page");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testDemo() {
        test = extent.createTest("Navigate to Demo Page").assignCategory("Navigation");
        Home_Page navPage = new Home_Page(driver);
        test.info("Clicking on 'Demo' link");

        navPage.clickDemo();
        String actualresult = navPage.getDemoPageHeading();
        String EXPECTEDRESULT = "OpenCart Demonstration";

        test.info("Checking page heading");

        try {
            Assert.assertEquals(actualresult, EXPECTEDRESULT);
            test.pass("Successfully navigated to Demo page");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testMarketplace() {
        test = extent.createTest("Navigate to Marketplace Page").assignCategory("Navigation");
        Home_Page navPage = new Home_Page(driver);
        test.info("Clicking on 'Marketplace' link");

        navPage.clickMarketplace();
        String actualresult = navPage.getMarketplacePageHeading();
        String EXPECTEDRESULT = "Welcome to OpenCart Extension Store";

        test.info("Checking page heading");

        try {
            Assert.assertEquals(actualresult, EXPECTEDRESULT);
            test.pass("Successfully navigated to Marketplace page");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testBlog() {
        test = extent.createTest("Navigate to Blog Page").assignCategory("Navigation");
        Home_Page navPage = new Home_Page(driver);
        test.info("Clicking on 'Blog' link");

        navPage.clickBlog();
        String actualresult = navPage.BlogPageHeading();
        String EXPECTEDRESULT = "Welcome to OpenCart Ecommerce Blog";

        test.info("Checking page heading");

        try {
            Assert.assertEquals(actualresult, EXPECTEDRESULT);
            test.pass("Successfully navigated to Blog page");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testResources() {
        test = extent.createTest("Navigate to Resources Page").assignCategory("Navigation");
        Home_Page navPage = new Home_Page(driver);
        test.info("Clicking on 'Resources' link");

        navPage.clickResources();
        test.pass("Resources link clicked successfully (no heading check)");
    }

    @Test
    public void testDownload() {
        test = extent.createTest("Navigate to Download Page").assignCategory("Navigation");
        Home_Page navPage = new Home_Page(driver);
        test.info("Clicking on 'Download' link");

        navPage.clickDownload();
        String actualresult = navPage.DownloadPageHeading();
        String EXPECTEDRESULT = "Download & host your own";

        test.info("Checking page heading");

        try {
            Assert.assertEquals(actualresult, EXPECTEDRESULT);
            test.pass("Successfully navigated to Download page");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }
}
