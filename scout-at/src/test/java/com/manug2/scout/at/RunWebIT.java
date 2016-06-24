package com.manug2.scout.at;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "target/test-classes/features",
        format = {"json:target/integration_cucumber.json", "html:target/cuke"},
        tags = {"@login"},
        glue = {"com.manug2.scout.glue"}
)

public class RunWebIT {
}