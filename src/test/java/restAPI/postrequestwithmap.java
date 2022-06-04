package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postrequestwithmap {

	
	@Test()
	public void test1() {
		
RestAssured.baseURI ="http://localhost:3000/employees";
		
	Map<String,Object> Mapobj  =new HashMap<String,Object>();
		
	Mapobj.put("name", "yashdeep singh");
	Mapobj.put("salary", "6000");
		
		
		RequestSpecification request =  RestAssured.given();
		
		Response response=	request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(Mapobj)
				.post("/create");
		
	String responsebody = response.getBody().asString();
					
					System.out.println(responsebody);
					
					int ResponseCode =response.getStatusCode();
					
					Assert.assertEquals(ResponseCode, 201);
					
					
					JsonPath japth = response.jsonPath();
				
					
					System.out.println("id"+japth.get("id"));
		
		
		
		
		
		
	}
}
