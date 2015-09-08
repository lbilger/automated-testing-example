package de.dlh.lhind.testing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
public class CalculatorITest {
    @Inject
    private Calculator calculator;

    @Deployment
    public static Archive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsLibraries(Maven.resolver()
                        .resolve("org.assertj:assertj-core:2.2.0",
                                "com.google.guava:guava:14.0.1")
                        .withTransitivity().asFile())
                .addClasses(Calculator.class, Parser.class, CommaSeparatedParser.class);
    }

    @Test
    public void allTheWiringIsDoneByContainer() {
        int result = calculator.calculate("3,1,0");

        assertThat(result).isEqualTo(4);
    }
}
