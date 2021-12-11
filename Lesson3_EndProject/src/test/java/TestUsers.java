//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class TestUsers {

	// GET request 
	@Test
	public static void validate_Response(){
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200).log().all();
		   
	}
	// POST request
	@Test
	void Create_user() {
		
		JSONObject request = new JSONObject();
	
		request.put("name", "Mohammed");
		request.put("job", "Automation engineer");
		
		given().
			body(request.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
	}
	
	// PUT request
	@Test
	void update_user() {
		
		JSONObject request = new JSONObject();
	
		request.put("name", "Mohammed");
		request.put("job", "Automation engineer");
		
		given().
			body(request.toJSONString())
		.when()
			.put("https://reqres.in/api/users/2")
		.then()
			.statusCode(200);
	}
	//DELETE request
	@Test
	void delete_user() {
		
		JSONObject request = new JSONObject();
	
		request.put("name", "Mohammed");
		request.put("job", "Automation engineer");
		
		given().
			body(request.toJSONString())
		.when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204);
	}
	
}






