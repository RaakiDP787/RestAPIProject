import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
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
                .log().body()
                .body("data",Matchers.hasSize(20))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")));
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
                        "    \"email\":\"rocky700@gmail.com\",\n" +
                        "    \"status\":\"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalTo("Rocky"))
                .body("data.email",Matchers.equalTo("rocky700@gmail.com"))
                .body("data.gender",Matchers.equalTo("male"))
                .body("data.status",Matchers.equalTo("active"));
    }
}
