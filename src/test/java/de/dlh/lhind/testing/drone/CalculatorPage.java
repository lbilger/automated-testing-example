package de.dlh.lhind.testing.drone;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;

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
        // Type character by character because each character will cause an ajax call - typing all at once will cause 
        // multiple ajax calls, but only the first one is waited for.
        for (char c : input.toCharArray()) {
            guardAjax(inputString).sendKeys(String.valueOf(c));
        }
    }

    public String getResult() {
        return result.getText();
    }
}
