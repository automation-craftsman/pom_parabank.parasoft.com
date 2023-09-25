package pages;

import base.Base;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import support.DataFactory;
import support.Utilities;

import java.util.Random;

public class RegistrationPage extends Base {

    private final By firstNameField = By.xpath("//input[@id='customer.firstName']");
    private final By lastNameField = By.xpath("//input[@id='customer.lastName']");
    private final By addressStreetField = By.xpath("//input[@id='customer.address.street']");
    private final By cityField = By.xpath("//input[@id='customer.address.city']");
    private final By addressStateField = By.xpath("//input[@id='customer.address.state']");
    private final By addressZipCodeField = By.xpath("//input[@id='customer.address.zipCode']");
    private final By phoneNumberField = By.xpath("//input[@id='customer.phoneNumber']");
    private final By ssnFiled = By.xpath("//input[@id='customer.ssn']");
    private final By userName = By.xpath("//input[@id='customer.username']");
    private final By passwordField = By.xpath("//input[@id='customer.password']");
    private final By confirmPasswordField = By.xpath("//input[@id='repeatedPassword']");

    private final By registerButton = By.xpath("//input[@value='Register']");


    DataFactory data = new DataFactory();
    Utilities util = new Utilities();

    public void fillOutRegistrationForm(){

        util.getWebElement(firstNameField).sendKeys(data.firstName);
        util.getWebElement(lastNameField).sendKeys(data.lastName);
        util.getWebElement(addressStreetField).sendKeys(data.streetName);
        util.getWebElement(cityField).sendKeys(data.city);
        util.getWebElement(addressStateField).sendKeys(data.state);
        util.getWebElement(addressZipCodeField).sendKeys(data.zipCode);
        util.getWebElement(phoneNumberField).sendKeys(data.phoneNumber);
        util.getWebElement(ssnFiled).sendKeys(data.ssnNumber);

        util.getWebElement(userName).sendKeys(data.userName);
        util.getWebElement(passwordField).sendKeys(data.password);
        util.getWebElement(confirmPasswordField).sendKeys(data.password);
    }

    public WelcomePage submitRegistrationForm(){

        util.getWebElement(registerButton).click();

        return new WelcomePage();
    }


}
