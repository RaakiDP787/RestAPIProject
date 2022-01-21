import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;

import static io.restassured.RestAssured.given;

public class GetAllUserTests {

    //1.Arrange
    private UserClient usersClient;

    @BeforeClass
    public void BeforeClass(){
        usersClient = new UserClient();
    }
    @Test
    public void shouldGetAllUsers(){
        //1.Arrange
        usersClient.getAllUsers()
                .then()
                //3.Assert
                .statusCode(200)
                .log().body()
                .body("data",Matchers.hasSize(20))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")));
    }
}
