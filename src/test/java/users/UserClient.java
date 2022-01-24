package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UserClient {
    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 8dd6b8e0fbd43d13478b16a0554af398298160e89fa66891de6db7f93ba99144")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
        response.
                then()
                    .log().body();

        return response;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.getStatusCode());
        return errorResponse;

    }

    public Response getAllUsers() {
        return given()
                .when()
                //2.Act
                .get("https://gorest.co.in/public/v1/users");
    }
}
