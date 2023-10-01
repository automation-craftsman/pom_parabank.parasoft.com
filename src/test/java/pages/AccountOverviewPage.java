package pages;

import base.Base;
import org.openqa.selenium.By;
import support.Utilities;

public class AccountOverviewPage extends Base {

    private final By accountID = By.xpath("//tbody/tr[1]/td[1]");
    private final By accountBalance = By.xpath("//tbody/tr[1]/td[2]");
    private final By availableAmount = By.xpath("//tbody/tr[1]/td[3]");
    private final By totalBalance = By.xpath("//tbody/tr[2]/td[2]");

    Utilities util = new Utilities();

    public void getAccountInfo(){

        System.out.println("Account Number: " + util.getWebElement(accountID).getText());
        System.out.println("Balance: " + util.getWebElement(accountBalance).getText());
        System.out.println("Available Amount: " + util.getWebElement(availableAmount).getText());
        System.out.println("Total Balance: " + util.getWebElement(totalBalance).getText());

    }


}
