package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 8dd6b8e0fbd43d13478b16a0554af398298160e89fa66891de6db7f93ba99144")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }
}
