package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.Utils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        monochrome = false
        /*if you want console output from Cucumber in a readable format*/
        //   tags = "@foo and not @bar"
        /* only run the scenarios specified with specific tags*/
)
public class MyRunnerTest {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams globalParams = new GlobalParams();
        globalParams.initializeGlobalParams();
        /* Creating Logs for this method */
        ThreadContext.put("ROUTINGKEY", globalParams.getPlatformName() + "_" + globalParams.getDeviceName());
        /* Start server */
        new ServerManager().startServer();
        new DriverManager().initializeDriver();
    }

    @AfterClass
    public static void quit() {
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
            Utils.logger().info("Driver Quit!");
        }
        ServerManager serverManager = new ServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
            Utils.logger().info("Appium Server Stopped!");
        }
    }
}

