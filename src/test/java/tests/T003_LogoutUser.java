package tests;

import base.Base;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

public class T003_LogoutUser extends Base {

    WelcomePage welcomePage;
    LoginPage loginPage;

    @Test
    public void logoutUser(){

        welcomePage = new WelcomePage();
        loginPage = welcomePage.logout();
    }
}
