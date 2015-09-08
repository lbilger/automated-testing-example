package de.dlh.lhind.testing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
public class CalculatorDroneTest {
    @Drone
    private WebDriver browser;
    @ArquillianResource
    private URL url;

    @Deployment(testable = false)
    public static Archive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "faces-config.xml")
                .addAsLibraries(Maven.resolver()
                        .resolve("org.assertj:assertj-core:2.2.0",
                                "com.google.guava:guava:14.0.1")
                        .withTransitivity().asFile())
                .addAsWebResource(new File("src/main/webapp/calculator.xhtml"))
                .addClass(CalculatorController.class)
                .addClasses(Calculator.class, Parser.class, CommaSeparatedParser.class);
    }

    @Test
    public void webDriverAndUrlAreInjected() throws MalformedURLException {
        browser.get(new URL(url, "calculator.jsf").toExternalForm());
        CalculatorPage calculatorPage = PageFactory.initElements(browser, CalculatorPage.class);

        calculatorPage.typeInput("1,3,0");
        calculatorPage.calculate();

        assertThat(calculatorPage.getResult()).isEqualTo("4");
    }
}
