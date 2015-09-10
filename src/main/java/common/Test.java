package common;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@CucumberOptions(features={"src/test/resources/features"}, plugin={"json:target/cucumber/reporteCucumber.json"})
@RunWith(Cucumber.class)
public class Test {

}