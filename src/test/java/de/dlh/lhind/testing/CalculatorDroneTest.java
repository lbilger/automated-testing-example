package de.dlh.lhind.testing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
public class CalculatorDroneTest {
    @Drone
    private WebDriver browser;

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
    public void webDriverAndUrlAreInjected(@InitialPage CalculatorPage calculatorPage) throws MalformedURLException {
        calculatorPage.typeInput("1,3,0");
        calculatorPage.calculate();

        assertThat(calculatorPage.getResult()).isEqualTo("4");
    }
}
