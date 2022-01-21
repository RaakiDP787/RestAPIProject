import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUserTests {
    @Test
    public void shouldGetAllUsers(){
        //1.Arrange

        given()
                .when()
                //2.Act
                .get("https://gorest.co.in/public/v1/users")
                .then()
                //3.Assert
                .statusCode(200)
                .log().body()
                .body("data",Matchers.hasSize(20))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")));
    }


}
