package restAPI;




import org.testng.annotations.Test;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class listemployee {
	
	
	
	@Test
	public void GetCall() {
		
		RestAssured.baseURI ="http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
	     //Response response =request.get("/employees");
	     Response response =request.get("/employees");
	     
	     JsonPath jpath = response.jsonPath();
	        List <String> Names = jpath.get("name");
	        
	        for (int i=0;i<Names.size();i++) {
	            System.out.println(Names.get(i));
	        }
	}
}

