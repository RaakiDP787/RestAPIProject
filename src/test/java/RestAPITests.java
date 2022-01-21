import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAPITests {
    @Test
    public void shouldGetAllUsers(){
        //1.Arrange
        //2.Act
        //3.Assert

        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void shouldCreateUser(){
        //1.Arrange
        //2.Act
        //3.Assert
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 8dd6b8e0fbd43d13478b16a0554af398298160e89fa66891de6db7f93ba99144")
                .body("{\n" +
                        "    \"name\":\"Rocky\",\n" +
                        "    \"gender\":\"male\",\n" +
                        "    \"email\":\"rocky455@gmail.com\",\n" +
                        "    \"status\":\"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .log().body()
                .statusCode(201)
        ;


    }
}
