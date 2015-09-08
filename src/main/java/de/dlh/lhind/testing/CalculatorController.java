package de.dlh.lhind.testing;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controller for the calculator example page.
 */
@Named
@SessionScoped
public class CalculatorController implements Serializable {
    @Inject
    private Calculator calculator;

    private String input;
    private Integer output;

    public void calculate() {
        output = calculator.calculate(input);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getOutput() {
        return output;
    }
}
