package youtube;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class RestAssureTest {


    @Test
    public void testabc() {
        //  get("https://reqres.in/api/users?page=2").then().statusCode(201);


        Response response = get("https://reqres.in/api/users?page=2");


        //working with jsonPath

        Object wholeObject = response.jsonPath().get();

        System.out.println(wholeObject);

        // same response for further validations...
        response.then().

                statusCode(200)
                .body("data[0].email", equalTo("michael.lawson@reqres.in"))
                .body("data[0].email", containsString("@"));


        //     System.out.println(emailId);

        //  System.out.println(response.getBody().prettyPrint());
        //  System.out.println(response.body().prettyPrint());


        given().relaxedHTTPSValidation().

                when().
                get("https://reqres.in/api/users?page=2").

                then().

                statusCode(200)
                .body("data[0].email", equalTo("michael.lawson@reqres.in"))
                .body("data[0].email", containsString("@"));


        // For POST method


        Map<String, Object> requestbody = new LinkedHashMap<>();

        Header header = new Header("content-type", "application/json");
        Headers headers = new Headers(header);


        given().relaxedHTTPSValidation()
                .when()
                .body(requestbody) //create request body here
                .headers(headers)
                .post("/post/url/endpoint/here")
                .then()
                .body("data.name", equalTo("suresh"))
                .body("data.email", containsString("@"))
                .log().all();


    }
}
