package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.dlh.lhind.testing.Calculator;
import de.dlh.lhind.testing.CommaSeparatedParser;
import org.needle4j.NeedleTestcase;
import org.needle4j.annotation.ObjectUnderTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.needle4j.injection.InjectionProviders.providerForInstance;

public class CalculatorSteps {
    @ObjectUnderTest
    private Calculator calculator;

    private String input;
    private Integer output;

    public CalculatorSteps() throws Exception {
        new NeedleTestcase(providerForInstance(new CommaSeparatedParser())) {
            {
                initTestcase(CalculatorSteps.this);
            }
        };
    }

    @Given("^an empty String$")
    public void an_empty_String() throws Throwable {
        input = "";
    }

    @Given("^the String \"([^\"]*)\"$")
    public void the_String(String input) throws Throwable {
        this.input = input;
    }

    @When("^passing it to the calculator$")
    public void passing_it_to_the_calculator() throws Throwable {
        output = calculator.calculate(input);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(int expected) throws Throwable {
        assertThat(output).isEqualTo(expected);
    }
}
