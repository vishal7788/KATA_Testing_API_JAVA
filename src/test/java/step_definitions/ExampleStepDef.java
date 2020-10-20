package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.Pet;
import dto.Pets;
import dto.getEmployeesDTO.GetEmployeesDTO;
import org.junit.Assert;
import support.MyConfig;
import support.SupportFunctions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExampleStepDef {

    private static ResponseBody body;

    @When("^I want to know all the pets in the clinic$")
    public void i_want_to_know_all_the_pets_in_the_clinic() throws Throwable {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
        System.out.println(body.asString());

    }


    @Then("^I should receive 13 pets$")
    public void i_should_receive_pets() throws Throwable {
        Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
        int amountOfPets = petsDTO.length;
        Assert.assertEquals("the amount of pets is 13 | ",13,amountOfPets);
    }

}
