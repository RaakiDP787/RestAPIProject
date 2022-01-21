import users.UserClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateUserTests {
    @Test
    public void shouldCreateUser(){
        //1.Arrange
        String body = "{\n" +
                "    \"name\":\"Rocky\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"rocky602@gmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";

        //2.Act
        new UserClient().createUser(body)
                .then()
                    .log().body()
                //3.Assert
                    .statusCode(201)
                    .body("data.id", Matchers.notNullValue())
                    .body("data.name",Matchers.equalTo("Rocky"))
                    .body("data.email",Matchers.equalTo("rocky602@gmail.com"))
                    .body("data.gender",Matchers.equalTo("male"))
                    .body("data.status",Matchers.equalTo("active"));
    }
    @Test
    public void shouldCreateMaleUser(){
        //1.Arrange
        String body = "{\n" +
                "    \"name\":\"Raaki\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"Raaki3@gmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";
        //2.Act
        new UserClient().createUser(body)
                .then()
                .log().body()
                //3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalTo("Raaki"))
                .body("data.email",Matchers.equalTo("Raaki3@gmail.com"))
                .body("data.gender",Matchers.equalTo("male"))
                .body("data.status",Matchers.equalTo("active"));
    }


    @Test
    public void shouldCreateFemaleUser(){
        //1.Arrange
        String body = "{\n" +
                "    \"name\":\"Pooja\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"email\":\"pooja13@gmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";
        //2.Act
        new UserClient().createUser(body)
                .then()
                .log().body()
                //3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.name",Matchers.equalTo("Pooja"))
                .body("data.email",Matchers.equalTo("pooja13@gmail.com"))
                .body("data.gender",Matchers.equalTo("female"))
                .body("data.status",Matchers.equalTo("active"));
    }

}
