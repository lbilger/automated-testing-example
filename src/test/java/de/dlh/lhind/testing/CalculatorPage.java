package de.dlh.lhind.testing;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page object representing the calculator page.
 */
@Location("calculator.jsf")
public class CalculatorPage {
    @FindBy(how = How.ID, using = "calculatorForm:input")
    private WebElement inputString;
    @FindBy(how = How.ID, using = "calculatorForm:output")
    private WebElement result;

    public void typeInput(String input) {
        inputString.sendKeys(input);
    }

    public String getResult() {
        return result.getText();
    }
}
