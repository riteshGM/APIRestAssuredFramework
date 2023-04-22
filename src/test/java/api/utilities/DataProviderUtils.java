package api.utilities;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

import api.payload.User;

public class DataProviderUtils {
	
	
	@DataProvider(name = "payloads")
	public User[] getMultiplePayloads(){
		//HashMap<Integer,User> data = new HashMap<Integer,User>();
		
		User [] data = new User[5];
		//As of now we set HashMap using Faker Library
		//If we want to run 5 times we enter 5 Records in HashMap
		for (int i=0;i<5;i++) {
			
			data[i]= PayloadUtil.getUserPayload();
				
		}
		return data;
	}

}
