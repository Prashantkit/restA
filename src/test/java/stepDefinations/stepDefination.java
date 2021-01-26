package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefination extends Utils{
	RequestSpecification requ;
	ResponseSpecification resp;
	Response respo;
	static String place_id;
	TestDataBuild data=new TestDataBuild();
	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String Name, String Lanuage, String Address) throws IOException {
	//public void add_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions

	
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		requ=given().spec(requestSpecification()).body(data.addPlacePayload(Name,Lanuage,Address));
		//requ=given().log().all().spec(requestSpecification()).body(data.addPlacePayload(Name,Lanuage,Address));
	}

	@When("User call {string} with {string} request")
	public void user_call_with_request(String resourse, String method) {
	    // Write code here that turns the phrase above into concrete actions
	APIResources resourseAPI=APIResources.valueOf(resourse);
	System.out.println(resourseAPI.getResourse());
		resp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		 respo=requ.when().post(resourseAPI.getResourse());
		 //then().log().all().spec(resp).extract().response();
		else if (method.equalsIgnoreCase("GET"))
			respo=requ.when().get(resourseAPI.getResourse());
			
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals( respo.getStatusCode(),200);
	}
	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	
	   assertEquals(getJsonPath(respo, keyValue),Expectedvalue);
	}
	@And("Verify place id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id=getJsonPath(respo, "place_id");
		requ=given().spec(requestSpecification()).queryParam("place_id",place_id);
		//requ=given().log().all().spec(requestSpecification()).queryParam("place_id",place_id);
		user_call_with_request(resource,"GET");
		String actualname=getJsonPath(respo, "name");
		assertEquals(expectedName, actualname);
	}
	
	@Given("Delete Payload")
	public void delete_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		requ= given().spec(requestSpecification()).body(data.detelePlace_payload(place_id));
	
	}


}
