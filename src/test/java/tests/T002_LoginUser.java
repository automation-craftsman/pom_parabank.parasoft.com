package tests;

import base.Base;
import org.testng.annotations.Test;
import pages.AccountOverviewPage;
import pages.LoginPage;

public class T002_LoginUser extends Base {

    @Test
    public void loginUser(){

        LoginPage loginPage = new LoginPage();
        AccountOverviewPage accountOverviewPage = loginPage.loginUser();
    }
}
