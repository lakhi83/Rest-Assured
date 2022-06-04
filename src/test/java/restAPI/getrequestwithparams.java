package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getrequestwithparams {
	
	

	@Test
	public void test1() {
		
		RestAssured.baseURI ="http://localhost:3000/employees/";
		
		RequestSpecification request =  RestAssured.given();
		
		Response response =request.param("id", "1").get();
		
		String ResponseBody = response.getBody().asString();
		

		
		
		
		System.out.println(ResponseBody);
		
		
		
		int ResponseCode =response.getStatusCode();
		
		Assert.assertEquals(ResponseCode, 200);
		
		Assert.assertTrue(ResponseBody.contains("Pankaj"));
		
		JsonPath japth = response.jsonPath();
	
		List<String> names = japth.get("name");
		
		System.out.println(names.get(0));
		
		Assert.assertEquals(names.get(0),"Pankaj");
		
		
		
		
		
	}

}
