package youtube;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class RestAssureTest {


    @Test
    public void testabc(){
     //  get("https://reqres.in/api/users?page=2").then().statusCode(201);



        Response response=get("https://reqres.in/api/users?page=2");

      //  System.out.println(response.getBody().prettyPrint());
      //  System.out.println(response.body().prettyPrint());



        given().relaxedHTTPSValidation().

                when().
                get("https://reqres.in/api/users?page=2").

                then().

                statusCode(200)
                .body("data[0].email",equalTo("michael.lawson@reqres.in"))
                .body("data[0].email",containsString("@"));


        // For POST method


        Map<String,Object> requestbody=new LinkedHashMap<>();

        Header header = new Header("content-type","application/json");
        Headers headers = new Headers(header);


        given().relaxedHTTPSValidation()
                .when()
                    .body(requestbody) //create request body here
                    .headers(headers)
                .post("/post/url/endpoint/here")
                .then()
                    .body("data.name",equalTo("suresh"))
                    .body("data.email",containsString("@"))
                    .log().all();


    }
}
