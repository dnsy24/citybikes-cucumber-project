package citybikes.api;

import citybikes.api.owner.ConfigurationProvider;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CityBikesCucumberApi {
    final static String URI = ConfigurationProvider.getInstance().getConfiguration().baseUrl();
//    final static String URI = "http://api.citybik.es";
    final static String PATH = ConfigurationProvider.getInstance().getConfiguration().basePath();
//    final static String PATH = "/v2/networks/";

    public static Response getAllNetworkData() {
        return given()
                .baseUri(URI)
                .basePath(PATH)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get();
    }

    public static Response getCompanyData(String companyName) {
        return given()
                .baseUri(URI)
                .basePath(PATH + companyName)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get();
    }
}
