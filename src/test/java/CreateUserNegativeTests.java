import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

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
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);
                //3.Assert
             Assert.assertEquals(errorResponse.getStatusCode(),422);
             errorResponse.assertHasError("email","is invalid");
    }
}
