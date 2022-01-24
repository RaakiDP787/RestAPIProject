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
        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,email,gender,status);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("rocky").email("rockygmail.com").gender("male").status("active").build();
        //2.Act
        usersClient.create(requestBody)
                //3.Assert
                .then()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
