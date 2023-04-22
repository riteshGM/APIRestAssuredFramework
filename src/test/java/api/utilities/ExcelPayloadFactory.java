package api.utilities;

import com.github.javafaker.Faker;

import api.payload.User;

public class ExcelPayloadFactory {

	public static User getUserPayload(int excelRowIndex) {
			ExcelUtil excelObj = new ExcelUtil(".\\resources\\UserData.xlsx");
			User payLoad = new User();
			System.out.println(excelObj.getCellData("user", "username", excelRowIndex));
			String id = excelObj.getCellData("user", "id", excelRowIndex);
			if(id.indexOf(".")==-1) {
				payLoad.setId(Integer.parseInt(id));
					
			}else {
				payLoad.setId(Integer.parseInt(id.substring(0,id.indexOf("."))));		
			}
			payLoad.setFirstName(excelObj.getCellData("user", "firstName", excelRowIndex));
			payLoad.setEmail(excelObj.getCellData("user", "email", excelRowIndex));
			payLoad.setLastName(excelObj.getCellData("user", "lastName", excelRowIndex));
			payLoad.setPassword(excelObj.getCellData("user", "password", excelRowIndex));
			payLoad.setPhone(excelObj.getCellData("user", "phone", excelRowIndex));
			payLoad.setUsername(excelObj.getCellData("user", "username", excelRowIndex));
			return payLoad;
	}

	public static void main (String args[]) {
		getUserPayload(4);
	}
}
