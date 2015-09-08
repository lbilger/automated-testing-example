package de.dlh.lhind.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        browser.findElement(By.id("calculatorForm:input")).sendKeys("1,3,0");
        browser.findElement(By.id("calculatorForm:calculate")).click();

        assertThat(browser.findElement(By.id("calculatorForm:output")).getText()).isEqualTo("4");
    }
}
