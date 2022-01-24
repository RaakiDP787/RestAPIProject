import org.testng.annotations.BeforeClass;
import users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.create.CreateUserRequestBody;

import java.util.UUID;

public class CreateUserNegativeTests {

    //1.Arrange
    private UserClient usersClient;
    @BeforeClass
    public void BeforeClass(){
        usersClient = new UserClient();
    }
    @Test
    public void shouldnotCreateUserwithInvalidEmailId(){
        String name = "rocky";
        String email = "rockygmailcom";
        String gender = "male";
        String status = "active";
        CreateUserRequestBody requestBody = new CreateUserRequestBody(name,email,gender,status);
        //2.Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()
                //3.Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
