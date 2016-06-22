package com.manug2.scout.at;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",//path to the features
        format = {"json:target/integration_cucumber.json"},//what formatters to use
        tags = {"@web-common"})//what tags to include(@)/exclude(@~)

public class RunTests {
}