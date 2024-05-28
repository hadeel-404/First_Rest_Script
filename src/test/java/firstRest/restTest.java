package firstRest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class restTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    @Test
    public void validate_response_code_testcase() {
        given().get("https://jsonplaceholder.typicode.com/posts/1").then()
               .assertThat().statusCode(200);
    }
    @Test
    public void validate_response_data_testcase() {
        given()
            .get("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .assertThat()
            .body("userId", equalTo(1))
            .and()
            .body("id", equalTo(1))
            .and()
            .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
            .and()
            .body("body", equalTo("quia et suscipit\n" +
                    "suscipit recusandae consequuntur expedita et cum\n" +
                    "reprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto"));
    }
    @Test
    public void create_post_testcase() {
        given()
            .header("Content-type", "application/json")
            .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
        .when()
            .post("https://jsonplaceholder.typicode.com/posts")
        .then()
            .assertThat()
            .statusCode(201)
            .and()
            .body("title", equalTo("foo"))
            .and()
            .body("body", equalTo("bar"))
            .and()
            .body("userId", equalTo(1));
    }

    @Test
    public void update_post_testcase() {
        given()
            .header("Content-type", "application/json")
            .body("{ \"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
        .when()
            .put("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .assertThat()
            .statusCode(200)
            .and()
            .body("title", equalTo("foo"))
            .and()
            .body("title", equalTo("foo"))
            .and()
            .body("body", equalTo("bar"))
            .and()
            .body("userId", equalTo(1));
    }

    @Test
    public void delete_post_testcase() {
        when()
            .delete("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .assertThat()
            .statusCode(200);
    }

    
}


