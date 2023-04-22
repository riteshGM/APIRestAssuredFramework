package api.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviderUtils;
import io.restassured.response.Response;

/**
 * 
 * @author Ritesh Mansukhani
 * Test Data Driven Test Cases
 *
 */
public class UsersTest_TDD {
	
	@Test (priority=1, dataProvider ="payloads" , dataProviderClass = DataProviderUtils.class )
	public void createUser(User data) {
		
		System.out.println("Creating User with User Name: "+data.getUsername());
		Response res = UserEndpoints.createUser(data);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}
	

}
