package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI ="http://localhost:3000/employees/";
		
		RequestSpecification request =  RestAssured.given();
		
		Response response =request.get();
		
		//System.out.println(request.get());
		
		
		String ResponseBody = response.getBody().asString();
		
		
		
		//System.out.println(ResponseBody);
		
		int ResponseCode =response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 200);
		
		JsonPath japth = response.jsonPath();
		
		List<String> names = japth.get("name");
		
		//System.out.println(names);
		
		String Header=		response.getHeader("Content-Type");
		
		//System.out.println(Header);
		
		
		
		
		
	}

}
