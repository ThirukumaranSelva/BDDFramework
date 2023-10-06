package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "summary"},
        /*tell Cucumber to use the two formatter plugins pretty, html & to print code snippets for missing step
        definitions */
        features = "src/test/resources",
        glue = "com/qa/stepdef",
        snippets = CAMELCASE,
        /*The default option for snippets is UNDERSCORE. The way code snippets will be created by Cucumber*/
        dryRun = false,
        /*check all feature file steps have corresponding step definitions*/
        monochrome = true
        /*if you want console output from Cucumber in a readable format*/
     //   tags = "@foo and not @bar"
        /* only run the scenarios specified with specific tags*/
)
public class MyRunnerTest {

}

