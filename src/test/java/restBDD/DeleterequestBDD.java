package restBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleterequestBDD {

	
	@Test()
	public void test1() {
		
		RestAssured.given().baseUri("http://localhost:3000/employees")
		.when()
		.delete("/27")
		.then()
		.log().body()
		
		.statusCode(200);
		
	}
}
