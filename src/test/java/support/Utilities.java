package support;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utilities extends Base {

    public WebElement getWebElement(By locator){

        return driver.findElement(locator);
    }

    public void readTableData(By tableLocator){

        // get the target table
        WebElement table = driver.findElement(tableLocator);
        // find all the rows
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));


        // iterate through rows
        for (WebElement elem : tableRows) {

            // find all the columns in each rows
            List<WebElement> tableColumns = elem.findElements(By.tagName("td"));

            // iterate through rows and get the data in each cell
            for (WebElement data : tableColumns) {
                System.out.print(data.getText() + " ");
            }

            System.out.println(" ");

        }

    }

}
