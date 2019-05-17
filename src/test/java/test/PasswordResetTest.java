package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CheckEmailPage;
import page.ResetPasswordPage;
import page.SetNewPasswordPage;
import page.SuccessResetPasswordPage;

public class PasswordResetTest extends BaseTest {

    @Test
    public void successfulPasswordReset() {
        String userName = "engineertestforreset70@gmail.com";
        String newPassword = "Test222)";

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        ResetPasswordPage resetPasswordPage = loginPage.clickForgotPassord();

        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "ResetPassword page is not loaded");

        CheckEmailPage checkEmailPage = resetPasswordPage.ResetPasswordRequest(userName);
        Assert.assertTrue(checkEmailPage.isPageLoaded(), "CheckEmail page is not loaded");

//        SetNewPasswordPage setNewPasswordPage = checkEmailPage.goToGmailForLink();
//        Assert.assertTrue(setNewPasswordPage.isPageLoaded(), "SetNewPassword page is not loaded");
//
//        SuccessResetPasswordPage successResetPasswordPage = setNewPasswordPage.setNewPasswordRequest(newPassword);
//
//        Assert.assertTrue(successResetPasswordPage.isPageLoaded(), "SuccessResetPassword page is not loaded");
//        Assert.assertEquals(successResetPasswordPage.getHeaderText(), "Your password has been changed successfully");
//        Assert.assertTrue(successResetPasswordPage.isGoToHomePageButton(), "GoToHomePage button is not loaded");
    }
}