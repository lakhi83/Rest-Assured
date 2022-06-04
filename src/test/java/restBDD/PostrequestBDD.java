package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostrequestBDD {
	
	@Test()
	public void test1()
	{
		
		Map<String,Object> Mapobj  =new HashMap<String,Object>();
		
		Mapobj.put("name", "Tiger");
		Mapobj.put("salary", "6000");
			
		
		RestAssured.given().baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .body(Mapobj)
		.when()
		.post("/create")
		.then()
		.log().body()
		
		.statusCode(201)
		.body("name", Matchers.equalTo("Tiger"));
		
	}

}
