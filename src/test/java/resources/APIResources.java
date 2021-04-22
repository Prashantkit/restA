package resources;

public enum APIResources{
	
	AddplaceAPI("/maps/api/place/add/json"),
	DeleteAPI("/maps/api/place/delete/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	putPalceAPI("/maps/api/place/update/json");
	
	private String resourse;
	
	APIResources(String resourse) {
		// TODO Auto-generated constructor stub
		this.resourse=resourse;
	}
	public String getResourse() {
		return resourse;
		//helloq
	}
	
	

}
