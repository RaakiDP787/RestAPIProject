import org.testng.annotations.BeforeClass;
import users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.create.CreateUserRequestBody;

import java.util.UUID;

public class CreateUserTests {

    //1.Arrange
    private UserClient usersClient;
    @BeforeClass
    public void BeforeClass(){
        usersClient = new UserClient();
    }
    @Test
    public void shouldCreateMaleUser(){
        //1.Arrange
        String email = String.format("%s@gmail.com",UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Rocky").email(email).gender("male").status("active").build();
        //2.Act
        usersClient.createUser(requestBody)
                .then()
                    .log().body()
                //3.Assert
                    .statusCode(201)
                    .body("data.id", Matchers.notNullValue())
                    .body("data.name",Matchers.equalTo("Rocky"))
                    .body("data.email",Matchers.equalTo(email))
                    .body("data.gender",Matchers.equalTo("male"))
                    .body("data.status",Matchers.equalTo("active"));
    }
    @Test
    public void shouldCreateFemaleUser(){
        //1.Arrange
        String email = String.format("%s@gmail.com",UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Pooja").email(email).gender("female").status("active").build();
        //2.Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()
                //3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalTo("Pooja"))
                .body("data.email",Matchers.equalTo(email))
                .body("data.gender",Matchers.equalTo("female"))
                .body("data.status",Matchers.equalTo("active"));
    }

}
