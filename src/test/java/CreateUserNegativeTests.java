import org.testng.annotations.BeforeClass;
import users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

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
        String body = "{\n" +
                "    \"name\":\"Pooja\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"email\":\"poojagmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";
        //2.Act
        usersClient.createUser(body)
                .then()
                .log().body()
                //3.Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
