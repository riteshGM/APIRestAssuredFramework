package api.utilities;

import org.testng.annotations.DataProvider;
import api.payload.User;

public class DataProviderUtils {

	/**
	 * Data Provider Using Payload Util and Actual Data is generated on Runtime
	 * using Faker
	 * 
	 * @return
	 */
	@DataProvider(name = "payloads")
	public User[] getMultiplePayloadsFromFaker() {
		User[] data = new User[5];
		for (int i = 0; i < 5; i++) {
			data[i] = FakerPayloadFactory.getUserPayload();
		}
		return data;
	}

	/**
	 * In this Method we Retrieve Test Data from Excel Sheet and load it into data[]
	 * of Type "User"
	 * 
	 * @return
	 */
	@DataProvider(name = "payLoadFromExcel")
	public User[] getMultiplePayloadsFromExcel() {
		// Create Excel Util Object
		ExcelUtil excelObj = new ExcelUtil(ProjectConstantProperties.USER_DATA_EXCEL);
		// Identify Total Data Rows Count - Since Excel Row Index starts from Zero we
		// need to less the count by 1
		int dataRowCount = excelObj.getRowCount("user") - 1;
		// Define User Payload Array
		User data[] = new User[dataRowCount];
		// Loop for Test Data as per row count
		for (int i = 0; i < dataRowCount; i++) {
			// Get Each Payload and assign to data Array
			data[i] = ExcelPayloadFactory.getUserPayload(i + 1);
		}
		return data;
	}
}
