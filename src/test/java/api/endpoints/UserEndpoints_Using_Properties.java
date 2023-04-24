package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

/**
 * This Program only takes input required for Payload or PathParamters and returns Response
 * That's it.
 */
import api.payload.User;

public class UserEndpoints_Using_Properties {

	private static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response createUser(User payLoad) {
		String user_post_url = getURL().getString("post_url");
		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payLoad).when()
				.post(user_post_url);
		return res;
	}

	public static Response getUser(String userName) {
		String user_get_url = getURL().getString("get_url");
		Response res = given().accept(ContentType.JSON).pathParam("username", userName).when().get(user_get_url);
		return res;
	}

	public static Response updateUser(User payLoad, String userName) {
		String user_put_url = getURL().getString("update_url");
		Response res = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName)
				.body(payLoad).when().put(user_put_url);
		return res;
	}

	public static Response deleteUser(String userName) {
		String user_delete_url = getURL().getString("delete_url");
		Response res = given().accept(ContentType.JSON).pathParam("username", userName).when().delete(user_delete_url);
		return res;
	}

}
