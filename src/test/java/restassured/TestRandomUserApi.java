package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestRandomUserApi {




    @Test
    public void testRandomApi(){

        RandomApi randomApi =given(). relaxedHTTPSValidation()
                .queryParam("results",10)
                .when().get("https://randomuser.me/api/")
                .then()
                .statusCode(200)
                .extract().as(RandomApi.class); // you must have gson or any serializer/de-serializer in class path
                                               // for this example we have gson in classpath, import in maven.


        Assert.assertNotNull(randomApi);
        Assert.assertNotNull(randomApi.results);
        Assert.assertEquals(randomApi.results.size(),10);





    }

    @Test
    public void testPathParam(){
        given()
                .relaxedHTTPSValidation()
                .header("content-type","application/json")
                .pathParam("path1","api")
                .queryParam("results","3")
                .when()
                .get("https://randomuser.me/{path1}")
                .then()
                .log().all()
                .statusCode(200);
    }





}
