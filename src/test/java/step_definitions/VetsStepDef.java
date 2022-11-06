package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import support.MyConfig;
import support.SupportFunctions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VetsStepDef {
    private static ResponseBody body;
    private static JSONArray jsonArray;

    @When("^I have the specialties list$")
    public void i_have_the_specialties_list() throws Throwable {
        //Get specialities details
        body = SupportFunctions.get(MyConfig.Endpoint + "api/specialties");
        //System.out.println(body.asString());
        jsonArray = new JSONArray(body.asString()); //-> store it in array
    }

    @Then("^I should create a vet (\\d+) \"([^\"]*)\" \"([^\"]*)\" for each of the specialty$")
    public void i_should_create_a_vet_for_each_of_the_specialty(int id, String firstname, String lastname) throws Throwable {
        JSONObject jsonObject =  jsonArray.getJSONObject(id);

        //Create a json payload
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("firstName", firstname); //--> firstname of vet
        payload.put("lastName", lastname); //--> lastname of vet
        List<Map<String, Object>> specialtiesList = new ArrayList<>(); //--> creating array list for multiple specialities
        Map<String, Object> specialtiesMap = new LinkedHashMap<>(); //--> creating map for specialities
        specialtiesMap.put("id", jsonObject.optInt("id")); //--> speciality id
        specialtiesMap.put("name", jsonObject.optString("name")); //--> speciality name
        specialtiesList.add(specialtiesMap); //--> added speciality map to the specialities list
        payload.put("specialties",specialtiesList); //--> added specialities list to the mail payload

        //Trigger post request
        body = SupportFunctions.post(MyConfig.Endpoint + "api/vets", payload);
        System.out.println(body.asString());
    }



}

