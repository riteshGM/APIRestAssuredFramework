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
		payLoad.setId(faker.idNumber().hashCode());
		payLoad.setFirstName(faker.name().firstName());
		payLoad.setEmail(faker.internet().emailAddress());
		payLoad.setLastName(faker.name().lastName());
		payLoad.setPassword(faker.internet().password());
		payLoad.setPhone(faker.phoneNumber().cellPhone());
		payLoad.setUsername(faker.name().username());
	}
	
	@Test
	public void createUser() {
		Response res = UserEndpoints.createUser(payLoad);
		
		Assert.assertEquals(res.statusCode(), 200);
	}

}
