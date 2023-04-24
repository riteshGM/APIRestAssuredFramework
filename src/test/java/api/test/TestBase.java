package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public Logger log;
	
	@BeforeSuite
	public void setup() {
		log = LogManager.getLogger(this.getClass());
	}

}
