package citybikes.api.step.defs;


import citybikes.api.CityBikesResponseDataHandler;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import java.util.List;
import java.util.Random;

import static citybikes.api.CityBikesCucumberApi.getAllNetworkData;

public class ModalSteps extends CityBikesResponseDataHandler {

    @When("User makes api call to get network data")
    public void userMakesApiCallToGetNetworkData() {
        response = getAllNetworkData();
    }

    @When("User gets json response for a single company by random id")
    public void userGetJsonResponseForASingleCompanyByRandomId() {
        response = getAllNetworkData();

        JsonPath jsonPath = response.jsonPath();
        List<Object> listOfId = jsonPath.getList("networks.id");
        companyName = listOfId.get(new Random().nextInt(listOfId.size())).toString();

    }
}

