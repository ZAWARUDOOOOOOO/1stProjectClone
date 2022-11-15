package com.example.demo.cucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.demo.cucumberTests.glue", "com.example.demo.cucumberTests.hooks"},
        tags = "~@actualSwitching or ~@business or ~@main", //также в других версиях вероятно будет доступно через and
        snippets = CucumberOptions.SnippetType.UNDERSCORE
)
public class CucumberRunnerTest {
}
