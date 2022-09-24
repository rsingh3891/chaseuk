package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import java.util.HashMap;
import utilities.DataFromJSONFile;
import utilities.RestAssuredLibrary;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * CommentsSteps - Step definition class which follows the Arrange Act Assert design pattern
 *                 by holding the Assertions in this class. For simplicity, all step definitions
 *                 are stored in this class (which could be tidied up by moving relevant
 *                 methods to PostsSteps and UsersSteps classes).
 *
 * @author Raj Singh <I>(21/09/2022)</I>
 */
public class CommentsSteps {

    private String parameterType;
    private String parameterValue;
    private static ResponseOptions<Response> response;
    private String jsonFileContents;

    @Given("^I have a \"([^\"]*)\" with the value \"([^\"]*)\"$")
    public void i_have_a_parameter_type_with_the_value(String parameterTypeIn, String parameterValueIn) throws Throwable {
        parameterType = parameterTypeIn;
        parameterValue = parameterValueIn;
    }

    @Given("^I have setup my contents for the post body in the JSON file ([^\"]*).json$")
    public void i_have_setup_my_contents_for_the_post_body(String fileName) {
        DataFromJSONFile dataFromJSONFile = new DataFromJSONFile(fileName);
        jsonFileContents = dataFromJSONFile.getJSONFileContents();
    }

    @When("^I make a GET call to the \"([^\"]*)\" endpoint$")
    public void i_make_a_GET_call_to_the_endpoint(String endpoint) throws Throwable {
         HashMap<String, String> parameters = new HashMap<>();
         parameters.put(parameterType, parameterValue);
         response = RestAssuredLibrary.GetCallWithParameter(endpoint, parameters);
    }

    @When("^I make a POST call to the \"([^\"]*)\" endpoint$")
    public void i_make_a_POST_call_to_the_endpoint(String endpoint) throws Throwable {
        response = RestAssuredLibrary.PostCallWithBody(endpoint, jsonFileContents);
    }

    @Then("^a (\\d+) response code is received$")
    public void a_response_code_is_received(int responseCode) throws Throwable {
        assertThat(response.statusCode(), equalTo(responseCode));
    }

    @Then("^the BS is ([^\"]*)$")
    public void the_bs_is(String bs) throws Throwable {
        assertThat(response.getBody().jsonPath().get("company.bs"), hasItems(bs));
    }
    @Then("^the Body is ([^\"]*)$")
    public void the_body_is(String body) throws Throwable {
        assertThat(response.getBody().jsonPath().get("body"), hasItems(body));
    }

    @Then("^the Catchphrase is ([^\"]*)$")
    public void the_catchphrase_is(String catchphrase) throws Throwable {
        assertThat(response.getBody().jsonPath().get("company.catchphrase"), hasItems(catchphrase));
    }

    @Then("^the City is ([^\"]*)$")
    public void the_city_is(String city) throws Throwable {
        assertThat(response.getBody().jsonPath().get("address.city"), hasItems(city));
    }

    @Then("^the Company Name is ([^\"]*)$")
    public void the_company_name_is(String companyName) throws Throwable {
        assertThat(response.getBody().jsonPath().get("company.name"), hasItems(companyName));
    }

    @Then("^the Email is ([^\"]*)$")
    public void the_email_is(String email) throws Throwable {
        assertThat(response.getBody().jsonPath().get("email"), hasItems(email));
    }

    @Then("^the Geo Lat is (.*)$")
    public void the_geo_lat_is(double geoLat) throws Throwable {
        assertThat(response.getBody().jsonPath().get("address.geo.lat"), hasItems(geoLat));
    }

    @Then("^the Geo Lng is (.*)$")
    public void the_geo_lng_is(double geoLng) throws Throwable {
        assertThat(response.getBody().jsonPath().get("address.geo.lng"), hasItems(geoLng));
    }

    @Then("^the Id is (\\d+)$")
    public void the_id_is(int id) throws Throwable {
        assertThat(response.getBody().jsonPath().get("id"), hasItems(id));
    }

    @Then("^the Id is (.*)$")
    public void the_id_is(String id) throws Throwable {
        assertThat(response.getBody().jsonPath().get("id"), hasItems(id));
    }

    @Then("^the Name is ([^\"]*)$")
    public void the_name_is(String name) throws Throwable {
        assertThat(response.getBody().jsonPath().get("name"), hasItems(name));
    }

    @Then("^the Phone is ([^\"]*)$")
    public void the_phone_is(String phone) throws Throwable {
        assertThat(response.getBody().jsonPath().get("phone"), hasItems(phone));
    }

    @Then("^the PostId is (\\d+)$")
    public void the_postId_is(int postId) throws Throwable {
        assertThat(response.getBody().jsonPath().get("postId"), hasItems(postId));
    }

    @Then("^the PostId is (.*)$")
    public void the_postId_is(String postId) throws Throwable {
        assertThat(response.getBody().jsonPath().get("postId"), hasItems(postId));
    }

    @Then("^the Street is ([^\"]*)$")
    public void the_street_is(String street) throws Throwable {
        assertThat(response.getBody().jsonPath().get("address.street"), hasItems(street));
    }

    @Then("^the Suite is ([^\"]*)$")
    public void the_suite_is(String suite) throws Throwable {
        assertThat(response.getBody().jsonPath().get("address.suite"), hasItems(suite));
    }

    @Then("^the Title is ([^\"]*)$")
    public void the_title_is(String title) throws Throwable {
        assertThat(response.getBody().jsonPath().get("title"), hasItems(title));
    }

    @Then("^the UserId is (\\d+)$")
    public void the_userId_is(int userId) throws Throwable {
        assertThat(response.getBody().jsonPath().get("userId"), hasItems(userId));
    }

    @Then("^the UserId is (.*)$")
    public void the_userId_is(String userId) throws Throwable {
        assertThat(response.getBody().jsonPath().get("userId"), hasItems(userId));
    }

    @Then("^the Username is ([^\"]*)$")
    public void the_username_is(String username) throws Throwable {
        assertThat(response.getBody().jsonPath().get("username"), hasItems(username));
    }

    @Then("^the Website is ([^\"]*)$")
    public void the_website_is(String website) throws Throwable {
        assertThat(response.getBody().jsonPath().get("website"), hasItems(website));
    }

    @Then("^the Zipcode is ([^\"]*)$")
    public void the_zipcode_is(String zipcode) throws Throwable {
        assertThat(response.getBody().jsonPath().get("address.zipcode"), hasItems(zipcode));
    }
}
