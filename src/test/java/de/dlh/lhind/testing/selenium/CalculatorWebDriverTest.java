package de.dlh.lhind.testing.selenium;

import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorWebDriverTest {
    private WebDriver browser;

    @Before
    public void createDriver() {
        browser = new ChromeDriver();
    }

    @After
    public void quitDriver() {
        browser.quit();
    }

    @Test
    public void testCalculation() throws InterruptedException {
        browser.get("http://localhost:8080/automated-testing-example-1.0-SNAPSHOT/calculator.jsf");
        final CalculatorPage calculatorPage = PageFactory.initElements(browser, CalculatorPage.class);

        calculatorPage.typeInput("1,3,0");
        new WebDriverWait(browser, 5).until(new Predicate<WebDriver>() {
            public boolean apply(WebDriver input) {
                return calculatorPage.getResult().equals("4");
            }
        });
        
        assertThat(calculatorPage.getResult()).isEqualTo("4");
    }
}
