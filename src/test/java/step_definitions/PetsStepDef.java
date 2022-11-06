package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.Owner;
import dto.Pet;
import dto.Pets;
import dto.Type;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import support.MyConfig;
import support.SupportFunctions;

import java.io.IOException;
import java.util.*;

public class PetsStepDef {

    private static ResponseBody body;
    private static ResponseBody ownerResponse;
    private static ResponseBody petResponse;
    Owner owner = new Owner();
    Pet pet = new Pet();
    Type type = new Type();

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

    @When("^I have Owner and Pet details$")
    public void i_have_Owner_and_Pet_details() throws Throwable {
        //Get last owner details
        ownerResponse = SupportFunctions.get(MyConfig.Endpoint + "api/owners");
        JSONArray ownerJsonArray = new JSONArray(ownerResponse.asString());
        JSONObject ownerJsonObject = ownerJsonArray.getJSONObject(ownerJsonArray.length() - 1);
        //System.out.println(ownerJsonObject);
        //Setting up last owner's details in Owner class properties to be used in add pet request body payload
        owner.setId(ownerJsonObject.optInt("id"));
        owner.setFirstName(ownerJsonObject.optString("firstName"));
        owner.setLastName(ownerJsonObject.optString("lastName"));
        owner.setAddress(ownerJsonObject.optString("address"));
        owner.setCity(ownerJsonObject.optString("city"));
        owner.setTelephone(ownerJsonObject.optString("telephone"));

        //Get last pet details
        petResponse = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
        JSONArray petJsonArray = new JSONArray(petResponse.asString());
        JSONObject petJsonObject = petJsonArray.getJSONObject(petJsonArray.length() - 1);
        //System.out.println(petJsonObject);
        //Setting up last pet details in Pet class properties to be used in add pet request body payload
        pet.setId(petJsonObject.optInt("id"));
        pet.setName(petJsonObject.optString("name"));
        pet.setBirthDate(petJsonObject.optString("birthDate"));
        type.setId(petJsonObject.getJSONObject("type").optInt("id"));
        type.setName(petJsonObject.getJSONObject("type").optString("name"));

    }

    @Then("^I should add a pet to owner$")
    public void i_should_add_a_pet_to_owner() throws Throwable {
        //Create a json payload
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("name", pet.getName()); //--> pet name
        payload.put("birthDate", pet.getBirthDate()); //--> pet birthdate
        Map<String, Object> typeMap = new LinkedHashMap<>();
        typeMap.put("name", type.getName()); //--> pet type name
        typeMap.put("id", type.getId()); //--> pet type id
        payload.put("type", typeMap);
        payload.put("id", pet.getId()); //--> pet id
        payload.put("ownerId", owner.getId()); //--> owner id
        ArrayList<String> visitsList = new ArrayList<>();
        payload.put("visits", visitsList);

        //trigger post request
        body = SupportFunctions.post(MyConfig.Endpoint + "api/owners/"+owner.getId()+"/pets", payload);
        System.out.println(body.asString());
    }

}

