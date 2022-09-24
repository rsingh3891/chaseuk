package utilities;

import io.cucumber.java.Before;

/**
 * SetUpTests - Initialisation class that gets triggered before the tests are executed to
 *              instantiate the RestAssuredLibrary class so that the request object is
 *              initialised.
 *
 * @author Raj Singh <I>(22/09/2022)</I>
 */
public class SetUpTests {

    @Before
    public void SetUp() {
        RestAssuredLibrary restAssuredLibrary = new RestAssuredLibrary();
    }
}
