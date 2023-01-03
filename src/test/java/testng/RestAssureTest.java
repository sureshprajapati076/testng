package testng;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class RestAssureTest {


    @Test
    public void testDb() {
//        final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "testng", "testng")) {

            if (conn != null) {

//                Statement stat = conn.createStatement();
                PreparedStatement psInsert = conn.prepareStatement("select * from my_school");

                ResultSet rs = psInsert.executeQuery();

                while (rs.next()) {
                    System.out.print(rs.getString("school_Name"));
                    System.out.println("\t" + rs.getString("address"));
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


        JsonPath jsonPath = response.jsonPath();

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

    @Test
    public void testLocalRandomUser() {


        //http://localhost:9596/random/user/getall?pageNo=3
        List<Header> headerList = Arrays.asList(
                new Header("sid", "10111"),
                new Header("sesion", "valid"),
                new Header("active", "true")
        );
        Headers headers = new Headers(headerList);

        Response response =
                given().relaxedHTTPSValidation().baseUri("http://localhost:9596").headers(headers).queryParam("pageNo", "3").when()
                        .get("/random/user/getall");

        Type listType1 = new TypeToken<List<RandomUser>>() {
        }.getType();

        List<RandomUser> results = response
                .then().statusCode(201)
                .header("MyResponseHeader", "MyValue")
                .extract().as(listType1);   // you must have gson or any serializer/de-serializer in class path
                                            // for this example we have gson in classpath, import in maven.

        Assert.assertNotNull(results);
        Assert.assertEquals(results.size(), 5);
        Assert.assertEquals(results.get(0).gender, "female");

        List<LinkedHashMap<String, Object>> result1 = response.jsonPath().get();


        System.out.println(result1.get(0));
        System.out.println(result1.get(1).get("name"));

        LinkedHashMap<String, LinkedHashMap<String, String>> test1 = (LinkedHashMap<String, LinkedHashMap<String, String>>) result1.get(2).get("location");

        System.out.println(test1.get("coordinates").get("latitude"));
        System.out.println(test1.get("coordinates").get("longitude"));


        Gson gson = new Gson();
        Type listType = new TypeToken<List<RandomUser>>() {
        }.getType();
        List<RandomUser> userList = gson.fromJson(response.then().extract().asString(), listType);
        Assert.assertNotNull(userList);
        Assert.assertEquals(userList.size(), 5);
        Assert.assertEquals(userList.get(0).gender, "female");

    }


    @Test
    public void postTest(){
        String jsonString="{\"gender\":\"female\",\"name\":{\"title\":\"Miss\",\"first\":\"Yvette\",\"last\":\"Berens\"},\"location\":{\"street\":{\"number\":9584,\"name\":\"Lindenweg\"},\"city\":\"Homberg (Ohm)\",\"state\":\"Bremen\",\"country\":\"Germany\",\"postcode\":51625,\"coordinates\":{\"latitude\":\"-47.3005\",\"longitude\":\"33.2818\"},\"timezone\":{\"offset\":\"+6:00\",\"description\":\"Almaty, Dhaka, Colombo\"}},\"email\":\"yvette.berens@example.com\",\"login\":{\"uuid\":\"f04cf964-7eca-46e1-bed8-c63a536ea01f\",\"username\":\"orangerabbit472\",\"password\":\"skipper\",\"salt\":\"6XNz5e84\",\"md5\":\"b4afe8d34267613e2fb2ab56eee72205\",\"sha1\":\"6c6cfc05779db023b0ba9e98ba5f74071d84c809\",\"sha256\":\"2bbe569c850cb05d9625e9cb42656e9a921779cfaad81737c9400920578f51c8\"},\"dob\":{\"date\":\"1956-11-09T18:15:58.237Z\",\"age\":66},\"registered\":{\"date\":\"2015-04-26T22:43:37.610Z\",\"age\":7},\"phone\":\"0239-6009797\",\"cell\":\"0173-4321931\",\"id\":{\"name\":\"SVNR\",\"value\":\"58 091156 B 726\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/31.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/31.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/31.jpg\"},\"nat\":\"DE\"}";

        Gson gson =  new Gson();

        RandomUser user= gson.fromJson(jsonString, RandomUser.class);

        System.out.println(user);

        RandomUser response = given().relaxedHTTPSValidation()
                .body(user)
                .headers("content-type","application/json")
                .when()
                .post("http://localhost:9596/random/user/add")
                .then()
                .log().all()
                .statusCode(200)
                .body("name.title",equalTo("Miss"))
                .extract().as(RandomUser.class);


        System.out.println(response);


    }
}
