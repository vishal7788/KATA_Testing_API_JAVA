package com.kss;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:cucumber.json"},
        features = {"src/test/java/com/kss"},
        tags = {"@get_pets, @add_pet, @create_vet"},
        glue = "step_definitions")
public class RunnerClass {
    public RunnerClass(){

    }
}
