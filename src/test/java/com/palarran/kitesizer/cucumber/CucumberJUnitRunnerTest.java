package com.palarran.kitesizer.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty",
        "html:target/cucumber" }, features = "classpath:features/", snippets = SnippetType.CAMELCASE, glue = {
                "com.palarran.kitesizer.cucumber" })
public class CucumberJUnitRunnerTest {
    //noop - just need the runner to execute the Cucumber classes
}