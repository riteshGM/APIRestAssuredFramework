package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviderUtils;
import io.restassured.response.Response;

/**
 * 
 * @author Ritesh Mansukhani Test Data Driven Test Cases
 *
 */
public class UsersTest_TDD extends TestBase {
	public Logger log;
	
	@BeforeClass
	public void setupBeforClass() {
		log = LogManager.getLogger(this.getClass());
	}
	/**
	 * Test Data Driven Test Execution. Here we have got 5 different data payload
	 * supplied from Dataproviders Using Faker to generate data at Run Time
	 * 
	 * @param data
	 */
	@Test(priority = 1, dataProvider = "payloads", dataProviderClass = DataProviderUtils.class)
	public void createUser_UsingDataProvider_PojoPayload_Faker(User data) {
		log.info("**************Creating User*****************");
		System.out.println("Creating User with User Name: " + data.getUsername());
		Response res = UserEndpoints.createUser(data);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		log.info("**************User Created*****************");
	}

	/**
	 * Test Data Driven Test Execution Here we read Application Test Data from Excel
	 * from resources As many rows supplied this test will repeat those many times
	 * 
	 * @param data
	 */
	@Test(priority = 2, dataProvider = "payLoadFromExcel", dataProviderClass = DataProviderUtils.class)
	public void createUser_UsingDataProvider_PojoPayload_UsingExcel(User data) {
		log.info("**************Creating User*****************");
		System.out.println("Creating User with User Name: " + data.getUsername());
		Response res = UserEndpoints.createUser(data);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		log.info("**************User Created*****************");
	}

}
