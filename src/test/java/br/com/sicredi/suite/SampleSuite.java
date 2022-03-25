package br.com.sicredi.suite;

import static io.restassured.RestAssured.*;

import br.com.sicredi.environment.EnvironmentSettings;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(
        description = "Sample test suite for use in new APIs",
        enabled = true,
        groups = {"TAG_FOR","GROUPING_TESTS"}
)
public class SampleSuite {

    private EnvironmentSettings environment;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetup(){
        System.out.println("### Preparing environment for " + this.getClass().getSimpleName() + " execution.");
        environment = new EnvironmentSettings("./src/test/resources/.env");
        baseURI= environment.get("baseURI");
        Reporter.log(baseURI);
    }

    @AfterSuite(alwaysRun = true)
    public void suiteTearDown(){
        System.out.println("### Cleaning data from suite " + this.getClass().getSimpleName() + " execution.");
    }

    @Test(groups = {"TAG_FOR", "GROUPING_SCENARIOS"})
    public void scenario01() throws Exception{
        given().get("/").then().statusCode(200).log().all(true);
    }

}
