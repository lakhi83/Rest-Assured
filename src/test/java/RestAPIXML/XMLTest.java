package RestAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {
	
	@Test()
	public void test1() {
		
		RestAssured.given().baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get()
		.then()
		.log().body()
		
		.statusCode(200);

	
	
}
	
	
	@Test()
	public void test2() {
		
	Response response =	RestAssured.given().baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get();
	
NodeChildrenImpl books =	response .then().extract().path("bookstore.book.title ");
		
	System.out.println("All the books are "+ books.toString());
	System.out.println("All the books is "+ books.get(0).toString());
	System.out.println("All the books is "+ books.get(1).toString());
	
	System.out.println("Langurage of first book is "+ books.get(0).getAttribute("lang"));
	
	/*for(int  index=0; index<books.size();index++)
		
	{
		System.out.println(books.get(index));
	}*/
	
	  for (String b:books) {
	        System.out.println(b.toString());
	    }
	
	
	  NodeChildrenImpl prices =	response .then().extract().path("bookstore.book.price ");
	  System.out.println("All the prices are "+ prices.toString());
	  
	  System.out.println("first price "+ prices.get(0).children().get("paperback"));
	 
		
	
	
	/*NodeChildrenImpl books1 =	response .then().extract().path("bookstore.book.author");
	
	System.out.println("All the Author are "+ books1.toString());
	System.out.println("All the first author is "+ books1.get(0).toString());
	System.out.println("All the  second books is "+ books1.get(1).toString()); */
}
}