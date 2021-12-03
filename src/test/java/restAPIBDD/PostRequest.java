package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void Postcall() {
		Map<String,Object>PostBody=new HashMap<String,Object>();
		PostBody.put("name", "Ramanand");
		PostBody.put("salary", "3000");
		
		
		RestAssured.given()
        .baseUri("http://localhost:7000")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(PostBody)
        .when()
        .post("/employees/create")
        .then()
        .statusCode(201)
        //.body("[0].name",Matchers.equalTo("Pankaj"))//to know particular userr
        //.body("[0].salary",Matchers.equalTo("10000"))
        .log()
        .all();
		
	}

}
