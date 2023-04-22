package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	User payLoad;
	Faker faker;
	@BeforeClass
	public void setup() {
		faker = new Faker();
		payLoad = new User();
		payLoad.setId(faker.idNumber().hashCode());
		payLoad.setFirstName(faker.name().firstName());
		payLoad.setEmail(faker.internet().emailAddress());
		payLoad.setLastName(faker.name().lastName());
		payLoad.setPassword(faker.internet().password());
		payLoad.setPhone(faker.phoneNumber().cellPhone());
		payLoad.setUsername(faker.name().username());
	}

	@Test (priority=1)
	public void createUser() {
		System.out.println("Creating User with User Name: "+payLoad.getUsername());
		Response res = UserEndpoints.createUser(payLoad);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
	}

	@Test (priority=2)
	public void getUserTest() {
		Response res = UserEndpoints.getUser(payLoad.getUsername());
		Assert.assertEquals(res.statusCode(),200);
		res.then().log().all();

	}

	@Test (priority =3)
	public void updateUserTest() {
		payLoad.setFirstName(faker.name().firstName());
		payLoad.setEmail(faker.internet().emailAddress());
		payLoad.setLastName(faker.name().lastName());

		System.out.println("Updating User with User Name: "+payLoad.getUsername());
		Response res = UserEndpoints.updateUser(payLoad, payLoad.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		//Verify User details correctly updated
		
		Response resAfterUpdate = UserEndpoints.getUser(payLoad.getUsername());
		Assert.assertEquals(resAfterUpdate.jsonPath().getString("username"), payLoad.getUsername());
		Assert.assertEquals(resAfterUpdate.jsonPath().getString("firstName"), payLoad.getFirstName());
		Assert.assertEquals(resAfterUpdate.jsonPath().getString("email"), payLoad.getEmail());
		Assert.assertEquals(resAfterUpdate.jsonPath().getString("lastName"), payLoad.getLastName());
	}
	
	@Test (priority =4)
	public void deleteUserTest() {
		System.out.println("Deleting User with UserName: "+payLoad.getUsername());
		Response res = UserEndpoints.deleteUser(payLoad.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
		Response resAfterDelete = UserEndpoints.getUser(payLoad.getUsername());
		resAfterDelete.then().log().all();
		Assert.assertEquals(resAfterDelete.statusCode(),404);
	}
}

