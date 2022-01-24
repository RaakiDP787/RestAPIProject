import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

public class CreateUserTests {

    //1.Arrange
    private UserClient usersClient;

    @BeforeClass
    public void BeforeClass() {
        usersClient = new UserClient();
    }

    @Test
    public void shouldCreateMaleUser() {
        //1.Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Rocky").email(email).gender("male").status("active").build();
        //2.Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        //3.Assert
        Assert.assertEquals(createUserResponse.getStatusCode(), 201);
        Assert.assertNotNull(createUserResponse.getData().getId());
        Assert.assertEquals(createUserResponse.getData().getEmail(), requestBody.getEmail());
        Assert.assertEquals(createUserResponse.getData().getGender(), requestBody.getGender());
        Assert.assertEquals(createUserResponse.getData().getStatus(), requestBody.getStatus());
    }

    @Test
    public void shouldCreateFemaleUser() {
        //1.Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Pooja").email(email).gender("female").status("active").build();
        //2.Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        //3.Assert
        Assert.assertEquals(createUserResponse.getStatusCode(), 201);
        Assert.assertNotNull(createUserResponse.getData().getId());
        Assert.assertEquals(createUserResponse.getData().getEmail(), requestBody.getEmail());
        Assert.assertEquals(createUserResponse.getData().getGender(), requestBody.getGender());
        Assert.assertEquals(createUserResponse.getData().getStatus(), requestBody.getStatus());

    }
}
