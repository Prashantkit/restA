package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforescenario() throws IOException {
		
		stepDefination m=new stepDefination();
		if (stepDefination.place_id==null){
		m.add_place_payload_with("Prashant", "English", "E12");
		m.user_call_with_request("AddplaceAPI", "Post");
		m.verify_place_id_created_maps_to_using("Prashant", "getPlaceAPI");
	}

}
}