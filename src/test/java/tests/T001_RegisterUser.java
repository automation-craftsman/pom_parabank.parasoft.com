package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.WelcomePage;

public class T001_RegisterUser extends Base {

    LoginPage loginPage;
    WelcomePage welcomePage;

    @Test
    public void registerUser() {
        loginPage = new LoginPage();
        RegistrationPage registrationPage = loginPage.clickOnRegistrationLink();

        registrationPage.fillOutRegistrationForm();
        welcomePage = registrationPage.submitRegistrationForm();

        String accountConfirmationText = welcomePage.getWelcomeText();

        Assert.assertTrue(accountConfirmationText.contains("Your account was created successfully."));
    }


}
