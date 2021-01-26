package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import javax.imageio.stream.FileImageOutputStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
		PrintStream log=new PrintStream(new FileOutputStream("Loging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
		 
		 return req;
		}
		return req;
		
	}
	public static String getGlobalValue(String key) throws IOException {
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream("D:\\gitdemo\\RestFulFreamworkAgain\\src\\test\\java\\resources\\global.properties");
		pro.load(fis);
		return pro.getProperty(key);
		
		
	}
	
	public String getJsonPath(Response resonse,String key) {
		String resp=resonse.asString();
		JsonPath js =new JsonPath(resp);
		return js.get(key).toString();
	}

}
