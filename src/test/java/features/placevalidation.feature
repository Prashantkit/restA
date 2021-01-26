Feature: Validating Place API

@AddPlace @Regression
Scenario Outline:: Verify if Add Place Api successfully added 
	Given Add place payload with "<name>" "<Language>" "<address>"
	When User call "AddplaceAPI" with "Post" request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And Verify place id created maps to "<name>" using "getPlaceAPI"
	
Examples: 
	|name  |Lanuage|address|
	|AAhuose|English|7208 w 115th Street|
	
@DeletePlace @Regression	 
Scenario: Verify delete Place Fucntionality is working
	Given Delete Payload 
	When User call "DeleteAPI" with "POST" request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	