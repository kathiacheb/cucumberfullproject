package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Commons{
	
	//@Before (order=1)
//	public void kathia() {
	//	System.out.println("****this is me *****");
	//}
	

	@Before //(order=2)
	public void before () {
		log.info("configure extent report");
	configreport();	
	}
	@After
	public void after() {
		log.info("praparing repport");
		extent.flush();
		log.info("browser is closed");
		teardown();
	}
	
	
	
	
	
}
