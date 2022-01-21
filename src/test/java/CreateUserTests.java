import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateUser(){
        //1.Arrange
        String body = "{\n" +
                "    \"name\":\"Rocky\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"rocky702@gmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";

        //2.Act
        createUser(body)

                .then()
                    .log().body()
                //3.Assert
                    .statusCode(201)
                    .body("data.id", Matchers.notNullValue())
                    .body("data.name",Matchers.equalTo("Rocky"))
                    .body("data.email",Matchers.equalTo("rocky702@gmail.com"))
                    .body("data.gender",Matchers.equalTo("male"))
                    .body("data.status",Matchers.equalTo("active"));
    }
    @Test
    public void shouldCreateMaleUser(){
        //1.Arrange
        String body = "{\n" +
                "    \"name\":\"Raaki\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"Raaki2@gmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";
        //2.Act
        createUser(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalTo("Raaki"))
                .body("data.email",Matchers.equalTo("Raaki2@gmail.com"))
                .body("data.gender",Matchers.equalTo("male"))
                .body("data.status",Matchers.equalTo("active"));
    }
    @Test
    public void shouldCreateFemaleUser(){
        //1.Arrange
        //2.Act
        //3.Assert
        String body = "{\n" +
                "    \"name\":\"Pooja\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"email\":\"pooja12@gmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";
        createUser(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalTo("Pooja"))
                .body("data.email",Matchers.equalTo("pooja12@gmail.com"))
                .body("data.gender",Matchers.equalTo("female"))
                .body("data.status",Matchers.equalTo("active"));
    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 8dd6b8e0fbd43d13478b16a0554af398298160e89fa66891de6db7f93ba99144")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }
}
