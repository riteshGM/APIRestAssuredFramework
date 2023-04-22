package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * This Program only takes input required for Payload or PathParamters and returns Response
 * That's it.
 */
import api.payload.User;

public class UserEndpoints {

	public static Response createUser(User payLoad) {
		Response res =
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payLoad)
				.when()
				.post(Routes.USER_POST_URL);
		return res;
	}

	public static Response getUser(String userName) {
		Response res =
				given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when()
				.get(Routes.USER_GET_URL);
		return res;	
	}

	public static Response updateUser(User payLoad , String userName) {
		Response res =
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payLoad)
				.when()
				.put(Routes.USER_PUT_URL);
		return res;
	}

	public static Response deleteUser(String userName) {
		Response res =
				given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when()
				.delete(Routes.USER_DELETE_URL);
		return res;	
	}

}
