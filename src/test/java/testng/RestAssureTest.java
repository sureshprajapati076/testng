package testng;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class RestAssureTest {



    @Test
    public void testDb(){
//        final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "testng", "testng")) {

            if (conn != null) {

//                Statement stat = conn.createStatement();
                PreparedStatement psInsert = conn.prepareStatement("select * from my_school");

                ResultSet rs= psInsert.executeQuery();

                while(rs.next()){
                    System.out.print(rs.getString("school_Name"));
                    System.out.println("\t"+rs.getString("address"));
                }



//                psInsert.setString(1, "sURESH");
//                psInsert.setBigDecimal(2, new BigDecimal(10));
//                psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

                //psInsert.executeQuery();



                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testabc() {
        //  get("https://reqres.in/api/users?page=2").then().statusCode(201);


        Response response = get("https://reqres.in/api/users?page=2");


        JsonPath jsonPath=response.jsonPath();

        System.out.println((String) jsonPath.get("data[0].email"));

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