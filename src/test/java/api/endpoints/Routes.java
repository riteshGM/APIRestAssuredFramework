package api.endpoints;

public class Routes {
	
	
	/**
	 * Project BASE URL
	 */
	public static String BASE_URL = "https://petstore.swagger.io/v2";
	
	/**
	 * User Module REQUEST URLs
	 */
	// Create New User
	public static String USER_POST_URL = BASE_URL+"/user";
	
	//GET Existing User
	public static String USER_GET_URL = BASE_URL+"/user/{username}";
	
	//Update Existing User
	public static String USER_PUT_URL = BASE_URL+"/user/{username}";
	
	//Delete a User
	public static String USER_DELETE_URL = BASE_URL+"/user/{username}";
	
	/**
	 * Further we can this way add as as may module URL's as needed in this class
	 */

}
