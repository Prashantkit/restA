package resources;

import java.util.ArrayList;
import java.util.List;


import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String Name,String Lanuage,String Address) {
		AddPlace  p=new AddPlace ();
	p.setAccuracy(3);
	p.setName(Name);
	p.setPhone_number("123456789");
	p.setAddress(Address);
	p.setWebsite("http//hello.com");
	p.setLanguage(Lanuage);
	List<String> mylist=new ArrayList<String>();
	mylist.add("park1");
	mylist.add("shop1");
	p.setTypes(mylist);
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
	return p;
}
	public String detelePlace_payload(String placeid) {
		return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}";
	}
}