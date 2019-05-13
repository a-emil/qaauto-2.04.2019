package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CheckEmailPage;
import page.ResetPasswordPage;

import java.util.concurrent.Callable;

public class PasswordResetTest extends BaseTest {

    @Test
    public void successfulPasswordReset() {
        String userName = "engineertest70@gmail.com";

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        ResetPasswordPage resetPasswordPage = loginPage.clickForgotPassord();

        Assert.assertTrue(resetPasswordPage.isPageLoaded(), "ResetPassword page is not loaded");

        CheckEmailPage checkEmailPage = resetPasswordPage.ResetPasswordRequest(userName);
        Assert.assertTrue(checkEmailPage.isPageLoaded(), "CheckEmail page is not loaded");

        checkEmailPage.goToGmailForLink();
    }
}
