package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class WelcomePage extends Base {

    private final By welcomeText = By.xpath("//p[contains(text(),'Your account was created successfully.')]");
    private final By homePageButton = By.xpath("//a[normalize-space()='home']");
    private final By logoutButton = By.xpath("//a[normalize-space()='Log Out']");

    Utilities util = new Utilities();

    public String getWelcomeText(){

        return util.getWebElement(welcomeText).getText();
    }

    public Homepage goToHome(){

        util.getWebElement(homePageButton).click();

        return new Homepage();
    }

    public LoginPage logout(){

        util.getWebElement(logoutButton).click();

        return new LoginPage();
    }
}
