package tests;

import Pages.ExtensionsPage;
import utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort extends TestBase {

    ExtensionsPage extensionsPage;

    @Test(priority = 2)
    public void testChangingSortToRatingUpdates() throws InterruptedException {
        test = extent.createTest("Change Sort to Rating").assignCategory("Extensions");
        extensionsPage = new ExtensionsPage(driver);
        extensionsPage.navigateAndSetCookies();

        test.info("Getting product names before sorting");
        List<String> namesBefore = extensionsPage.fetchExtensionNames();

        test.info("Changing sort option to 'Rating'");
        extensionsPage.getSortDropdown().selectByVisibleText("Name");
        extensionsPage.scrollPageDown();

        // إضافة انتظار بسيط للتأكد إن التغيير تم (اختياري لكن مفيد)
        Thread.sleep(2000);

        List<String> namesAfter = extensionsPage.fetchExtensionNames();

        test.info("Checking that product list changed after sorting");

        try {
            boolean listsAreEqual = namesBefore.equals(namesAfter);
            Assert.assertNull(listsAreEqual, "❌ Product list did not change after sorting!");
            test.pass("✅ Product list changed successfully after sorting by Rating");
        } catch (AssertionError e) {
            test.fail("❌ Assertion failed: " + e.getMessage());
            throw e;
        }

        test.info("Verifying ratings fetched correctly");
        List<Integer> ratings = extensionsPage.fetchRatings();

        try {
            Assert.assertTrue(ratings.size() > 0, "❌ No products found after changing sort to Rating!");
            test.pass("✅ Ratings successfully fetched after sorting by 'Rating'");
        } catch (AssertionError e) {
            test.fail("❌ Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 1)
    public void testDefaultSortOption() throws InterruptedException {
        test = extent.createTest("Check Default Sort Option").assignCategory("Extensions");
        extensionsPage = new ExtensionsPage(driver);
        extensionsPage.navigateAndSetCookies();

        String actual = extensionsPage.getSortDropdown().getFirstSelectedOption().getText();
        test.info("Default selected sort option is: " + actual);

        try {
            Assert.assertEquals(actual, "Recently Updated", "❌ Default sort option is incorrect!");
            test.pass("Default sort option verified successfully");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void testSortingByName() throws InterruptedException {
        test = extent.createTest("Sort Extensions by Name").assignCategory("Extensions");
        extensionsPage = new ExtensionsPage(driver);
        extensionsPage.navigateAndSetCookies();

        test.info("Sorting extensions by name");
        extensionsPage.getSortDropdown().selectByVisibleText("Name");
        extensionsPage.scrollPageDown();

        List<String> actualNames = extensionsPage.fetchExtensionNames();
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        test.info("Comparing actual and expected name sorting");

        try {
            Assert.assertEquals(actualNames, expectedNames, "❌ Names are not sorted alphabetically!");
            test.pass("Extensions sorted correctly by name");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4)
    public void testSortingByPrice() throws InterruptedException {
        test = extent.createTest("Sort Extensions by Price").assignCategory("Extensions");
        extensionsPage = new ExtensionsPage(driver);
        extensionsPage.navigateAndSetCookies();

        test.info("Sorting extensions by price");
        extensionsPage.getSortDropdown().selectByVisibleText("Price");
        Thread.sleep(2000); // Allow sorting to complete
        extensionsPage.scrollPageDown();

        List<Double> actualPrices = extensionsPage.fetchPrices();
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        test.info("Comparing actual and expected price sorting");

        try {
            Assert.assertEquals(actualPrices, expectedPrices, "❌ Prices are not sorted from low to high!");
            test.pass("Extensions sorted correctly by price");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 5)
    public void testSortingByRating() throws InterruptedException {
        test = extent.createTest("Sort Extensions by Rating").assignCategory("Extensions");
        extensionsPage = new ExtensionsPage(driver);
        extensionsPage.navigateAndSetCookies();

        test.info("Sorting extensions by rating");
        extensionsPage.getSortDropdown().selectByVisibleText("Rating");
        extensionsPage.scrollPageDown();

        // إعطاء وقت بسيط لتطبيق الفلتر
        Thread.sleep(2000);

        List<Integer> actualRatings = extensionsPage.fetchRatings();

        // طباعة النتائج للمراجعة اليدوية (اختياري)
        System.out.println("Actual Ratings: " + actualRatings);

        test.info("Verifying that ratings are sorted in descending order");

        try {
            for (int i = 0; i < actualRatings.size() - 1; i++) {
                Assert.assertFalse(
                        actualRatings.get(i) >= actualRatings.get(i + 1),
                        "❌ Ratings not sorted at index " + i + ": "
                                + actualRatings.get(i) + " < " + actualRatings.get(i + 1)
                );
            }
            test.pass("✅ Ratings are correctly sorted from high to low");
        } catch (AssertionError e) {
            test.fail("❌ Assertion failed: " + e.getMessage());
            throw e;
        }
    }
}
