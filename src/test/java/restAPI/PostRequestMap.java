package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestMap {
	
	@Test
	public void PostCall() {
		
		RestAssured.baseURI ="http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Map<String,Object>PostBody=new HashMap<String,Object>();
		PostBody.put("name", "Virat");
		PostBody.put("salary", "3000");
		
		Response response =request.contentType(ContentType.JSON)
		                           .accept(ContentType.JSON)
		                           .body("{\n" + 
		                           		"    \"name\": \"Chirag\",\n" + 
		                           		"    \"salary\": \"8000\"\n" + 
		                           		"}")
		                           .post("/employees/create");
		                           
		
		    String ResponseBody = response.body().asString();
		                  	     
		   
		    System.out.println(ResponseBody);
		
		int ActResponse =response.statusCode();
		int ExpResponse=201;
		
		
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
	}

}


