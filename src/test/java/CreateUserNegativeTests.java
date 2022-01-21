import users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateUserNegativeTests {
    @Test
    public void shouldnotCreateUserwithInvalidEmailId(){
        //1.Arrange
        //2.Act
        //3.Assert
        String body = "{\n" +
                "    \"name\":\"Pooja\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"email\":\"poojagmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";
        new UserClient().createUser(body)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
}
