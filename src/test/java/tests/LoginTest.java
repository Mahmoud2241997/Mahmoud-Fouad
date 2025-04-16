package tests;

import Pages.Account_page;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;
import utilities.TestBase;

public class LoginTest extends TestBase {
    Account_page Account_page;

    @Test(priority = 1)
    public void testValidLogin() throws InterruptedException {
        test = extent.createTest("Valid Login Test").assignCategory("Login");
        LoginPage login = new LoginPage(driver);
        test.info("Trying to log in with valid credentials");

        login.login("ffgghh2228@gmail.com", "01100138137");
        Account_page = login.enter_pin("2213");

        Thread.sleep(2000);
        String actualresult = Account_page.getsuccsesmassege();
        String EXPECTEDRESULT = "Welcome to OpenCart!";

        try {
            Assert.assertTrue(actualresult.contains(EXPECTEDRESULT));
            test.pass("Valid login succeeded");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4)
    public void testLoginWithEmptyFields() {
        test = extent.createTest("Login With Empty Fields").assignCategory("Login");
        LoginPage login = new LoginPage(driver);
        test.info("Trying to log in with empty email and password");

        login.login("", "");
        String actualresult = login.geterormassege();
        String EXPECTEDRESULT = "No match for E-Mail and/or Password.";

        try {
            Assert.assertTrue(actualresult.contains(EXPECTEDRESULT));
            test.pass("Proper error message appeared for empty fields");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 2)
    public void invalidLoginWrongPassword() {
        test = extent.createTest("Login With Wrong Password").assignCategory("Login");
        LoginPage login = new LoginPage(driver);
        test.info("Trying to log in with correct email but wrong password");

        login.login("ffgghh2228@gmail.com", "011138137");
        String actualresult = login.geterormassege();
        String EXPECTEDRESULT = "No match for E-Mail and/or Password.";

        try {
            Assert.assertTrue(actualresult.contains(EXPECTEDRESULT));
            test.pass("Error message displayed correctly for wrong password");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void invalidLoginWrongEmail() throws InterruptedException {
        test = extent.createTest("Login With Wrong Email").assignCategory("Login");
        LoginPage login = new LoginPage(driver);
        test.info("Trying to log in with wrong email");

        login.login("ffgg2228@gmail.com", "01100138137");
        Thread.sleep(1000);
        String actualresult = login.geterormassege();
        String EXPECTEDRESULT = "No match for E-Mail and/or Password.";

        try {
            Assert.assertTrue(actualresult.contains(EXPECTEDRESULT));
            test.pass("Error message displayed correctly for wrong email");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 5)
    public void loginWithUnregisteredEmail() {
        test = extent.createTest("Login With Unregistered Email").assignCategory("Login");
        LoginPage login = new LoginPage(driver);
        test.info("Trying to log in with unregistered email");

        login.login("mm2254@gmail.com", "01100138137");
        String actualresult = login.geterormassege().trim();
        String EXPECTEDRESULT = "No match for E-Mail and/or Password.";

        try {
            Assert.assertTrue(actualresult.contains(EXPECTEDRESULT));
            test.pass("Error displayed correctly for unregistered email");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 7)
    public void forgotPasswordFunctionality() {
        test = extent.createTest("Forgot Password Test").assignCategory("Account Recovery");
        LoginPage login = new LoginPage(driver);
        test.info("Testing forgot password with valid email");

        login.clickForgotPassword();
        login.resetPassword("ffgghh2228@gmail.com");
        String actualresult = login.getsuccsesmassege();
        String EXPECTEDRESULT = "Success: An email with a reset link has been sent your email address!";

        try {
            Assert.assertTrue(actualresult.contains(EXPECTEDRESULT));
            test.pass("Reset password message appeared correctly");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 6)
    public void loginWithoutVerifyingAccount() {
        test = extent.createTest("Login Without Verifying Account").assignCategory("Login");
        LoginPage login = new LoginPage(driver);
        test.info("Trying to log in with unverified account");

        login.login("foush514@gmail.com", "01100138137");
        String actualresult = login.geterormassege();
        String EXPECTEDRESULT = "Account has not been verified yet!";

        try {
            Assert.assertTrue(actualresult.contains(EXPECTEDRESULT));
            test.pass("Proper message appeared for unverified account");
        } catch (AssertionError e) {
            test.fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 8)
    public void loginLogoutFunctionality() {
        test = extent.createTest("Login and Logout Functionality").assignCategory("Login");
        LoginPage login = new LoginPage(driver);
        test.info("Logging in");

        login.login("ffgghh2228@gmail.com", "01100138137");
        Account_page = login.enter_pin("2213");

        test.info("Logging out");
        login.logout();

        try {
            test.pass("Logged in and out successfully");
        } catch (Exception e) {
            test.fail("Logout failed: " + e.getMessage());
            throw e;
        }
    }
}
