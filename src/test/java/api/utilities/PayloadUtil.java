package api.utilities;

import com.github.javafaker.Faker;

import api.payload.User;

public class PayloadUtil {

	public static User getUserPayload() {
		
			Faker faker = new Faker();
			User payLoad = new User();
			payLoad.setId(faker.idNumber().hashCode());
			payLoad.setFirstName(faker.name().firstName());
			payLoad.setEmail(faker.internet().emailAddress());
			payLoad.setLastName(faker.name().lastName());
			payLoad.setPassword(faker.internet().password());
			payLoad.setPhone(faker.phoneNumber().cellPhone());
			payLoad.setUsername(faker.name().username());
			return payLoad;
	}

}
