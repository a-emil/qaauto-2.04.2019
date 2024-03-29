package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LoginTest extends BaseTest{

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"engineertest70@gmail.com", "Test111)"},
                //{"ENGINEERTEST70@gmail.com", "Test111)"}
        };
    }

    @DataProvider
    public Object[][] inValidDataProvider() {
        return new Object[][]{
                {"engineertest70@gmail.com", "Test222)", "", "Hmm, that's not the right password. Please try again or request a new one."},
                {"engineertest71@gmail.com", "Test111)", "Hmm, we don't recognize that email. Please try again.", ""}
        };
    }

    @DataProvider
    public Object[][] EmptyDataProvider() {
        return new Object[][]{
                {"", "Test111)"},
                {"engineertest70@gmail.com", ""}
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not displayed");
        Assert.assertEquals(homePage.getUserProfileName(), "Emilio Carmello", "Wrong profile user name displayed");
    }

    @Test(dataProvider = "inValidDataProvider")
    public void negativeLoginTestWithInvalidData(String userEmail,
                                                 String userPassword,
                                                 String userPasswordValidationMessage,
                                                 String userEmailValidationMessage) {
        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "Login page is not loaded");
        Assert.assertEquals(loginSubmitPage.getUserEmailValidationMessage(), userEmailValidationMessage, "Wrong validation message on user email");
        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationMessage(), userPasswordValidationMessage, "Wrong validation message on user password");
    }

    @Test(dataProvider = "EmptyDataProvider")
    public void negativeLoginTestWithEmptyFields(String userEmail, String userPassword) {
        loginPage.login(userEmail, userPassword);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not displayed");
    }
}