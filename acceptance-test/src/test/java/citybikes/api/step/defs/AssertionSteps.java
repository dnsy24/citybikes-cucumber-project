package citybikes.api.step.defs;

import citybikes.api.CityBikesResponseDataHandler;

import citybikes.api.entity.Location;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static citybikes.api.CityBikesCucumberApi.getCompanyData;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionSteps extends CityBikesResponseDataHandler {


    @Then("User verifies that Frankfurt located in Germany")
    public void userVerifiesThatCityLocatedInCountry(List<Location> locationData) {
        Location location = locationData.get(0);
        System.out.println("Location: " + location);
        String city = location.getCity();
        String country = location.getCountry();

        JsonPath jsonPath = response.jsonPath();

        String countryFromJson = jsonPath.getString("networks.location.find{it.city == " + "'" + city + "'" + "}.country");
        String cityLatitude = jsonPath.getString("networks.location.find{it.city == " + "'" + city + "'" + "}.latitude");
        String cityLongitude = jsonPath.getString("networks.location.find{it.city == " + "'" + city + "'" + "}.longitude");

        System.out.println(city + " city has latitude " + cityLatitude + " and longitude " + cityLongitude);
        assertEquals(country, countryFromJson, "city doesn't match country");
    }


    @Then("User verifies that {string} located in {string}")
    public void userVerifiesThatCityLocatedInCountry(String city, String country) {
        JsonPath jsonPath = response.jsonPath();

        String countryFromJson = jsonPath.getString("networks.location.find{it.city == " + "'" + city + "'" + "}.country");

        assertEquals(country, countryFromJson, "country doesn't match");
    }


    /**
     * https://extendsclass.com/json-schema-validator.html is used to generate json schema
     */

    @Then("Json response should match schema")
    public void jsonResponseShouldMatchSchema() {
        getCompanyData(companyName)
                .prettyPeek()
                .then()
                .body(matchesJsonSchemaInClasspath("citybikes-schema.json"))
                .body("network.name", is(instanceOf(String.class)))
                .statusCode(200);
    }


    @Then("The location category should have the subcategories expected")
    public void theLocationCategoryShouldHaveTheSubcategoryExpected(List<String> subcategory) {
        JsonPath jsonPath = response.jsonPath();
        Map<String, String> resultMap = jsonPath.getMap("networks.location[0]");
        List<String> locationSubcategoriesFromJson = new ArrayList<>(resultMap.keySet());
        assertEquals(subcategory, locationSubcategoriesFromJson);
    }

}
