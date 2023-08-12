package stepdefinition;

import implementation.TestMobile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class StepDefinition {
    @Given("Fill the desired Capabilities and open the application")
    public static void capabilitiesAndOpen() throws MalformedURLException {
        TestMobile.openApplication();
    }
    @Then("Click on SignUp button and Fill the details")
    public static void register() throws InterruptedException {
        TestMobile.signUp();
    }
    @Then("Enter the desired details and login")
    public static void logIn() throws InterruptedException {
        TestMobile.logIn();
    }
    @And("Create a new Expense and fill the details")
    public static void expense(){
        TestMobile.addExpenses();
    }
}
