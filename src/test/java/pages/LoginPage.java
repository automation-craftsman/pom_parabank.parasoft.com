package pages;

import base.Base;
import org.openqa.selenium.By;
import support.DataFactory;
import support.Utilities;

public class LoginPage extends Base {

    private final By loginUserNameField = By.xpath("//input[@name='username']");
    private final By loginPasswordField = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//input[@value='Log In']");

    Utilities util = new Utilities();
    DataFactory data = new DataFactory();

    private final By registrationLink = By.xpath("//a[normalize-space()='Register']");

    /**
     * Must create a user first using data from DataFactory class
     *
     * @return to the Account Overview Page
     */
    public AccountOverviewPage loginUser(){

        util.getWebElement(loginUserNameField).clear();
        util.getWebElement(loginUserNameField).sendKeys(data.userName);

        util.getWebElement(loginPasswordField).clear();
        util.getWebElement(loginPasswordField).sendKeys(data.password);

        util.getWebElement(loginButton).click();

        return new AccountOverviewPage();
    }

    public RegistrationPage clickOnRegistrationLink(){

        util.getWebElement(registrationLink).click();

        return new RegistrationPage();

    }



}
