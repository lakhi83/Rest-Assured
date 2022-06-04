package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postrequest {

	
	@Test()
	public void test1() {
		
		RestAssured.baseURI ="http://localhost:3000/employees";
		RequestSpecification request =  RestAssured.given();
		
	Response response=	request.contentType(ContentType.JSON).accept(ContentType.JSON).body("{\r\n"
			+ "    \r\n"
			+ "        \"name\": \"harleen\",\r\n"
			+ "        \"salary\": \"2000\"\r\n"
			+ "    }").post("/create");
	
String responsebody = response.getBody().asString();
				
				System.out.println(responsebody);
				
				int ResponseCode =response.getStatusCode();
				
				Assert.assertEquals(ResponseCode, 201);
				
				
				JsonPath japth = response.jsonPath();
			
				
				System.out.println("id"+japth.get("id"));
}
}