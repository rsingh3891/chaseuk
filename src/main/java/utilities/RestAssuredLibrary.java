package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * RestAssuredLibrary - Class containing the actions that can be performed using RestAssured.
 *                      Using the Arrange Act Assert design pattern where Act and Assert
 *                      methods are defined here.
 *
 * @author Raj Singh <I>(22/09/2022)</I>
 */
public class RestAssuredLibrary {

    private final DataFromPropertiesFile dataFromPropertiesFile = new DataFromPropertiesFile("url");
    private final String url = dataFromPropertiesFile.getPropertyValue("url");
    public static RequestSpecification request;
    public static ResponseOptions<Response> response;

    /**
     * Constructor which sets the URL and Content Type at initialisation to the requestSpecBuilder
     * and creates the Request object with the methods in the RequestSpecification class.
     */
    public RestAssuredLibrary() {
        // Arrange
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url);
        requestSpecBuilder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = requestSpecBuilder.build();
        request = RestAssured.given().spec(requestSpec);
    }

    /**
     * GetCall - makes a GET call to the endpoint that is passed in
     * @param endpoint
     * @return
     */
    public static ResponseOptions<Response> GetCall(String endpoint) {
        // Act
        try {
            response = request.get(new URI(endpoint));
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * GetCallWithParameter - makes a GET call to the endpoint with a path parameter passed in
     * @param endpoint
     * @param parameters
     * @return ResponseOption<Response> response
     */
    public static ResponseOptions<Response> GetCallWithParameter(String endpoint, HashMap<String, String> parameters) {
        // Act
        request.pathParams(parameters);
        response = GetCall(endpoint);
        return response;
    }

    /**
     * PostCallWithBody - makes a POST call to the endpoint passed in with a body's content as string
     * @param endpoint
     * @param jsonBodyAsString
     * @return ResponseOption<Response> response
     */
    public static ResponseOptions<Response> PostCallWithBody(String endpoint, String jsonBodyAsString) {
        // Act
        response = request.body(jsonBodyAsString).when().post(endpoint);
        return response;
    }
}
