package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endusers.Requests;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User payload;
	
	@BeforeClass
	public void setData() {
		
		faker = new Faker();
		payload = new User();
		
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setId(faker.idNumber().hashCode());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password());
		payload.setUsername(faker.name().username());
		payload.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	
	@Test(priority=1)
	public void testPostRequest() {
		
		Response response=Requests.createUser(payload);
		response.then().log().body();
		
			
	}
	
	@Test(priority=2)
	public void testGetRequest() {
		
		Response response=Requests.getUser(this.payload.getUsername());
		response.then().log().body();
		
			
	}
	
	@Test(priority=3)
	public void testPutRequest() {
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		
		
		Response response=Requests.putUser(this.payload.getUsername(), payload);
		response.then().log().body();
		
		Response responseafterupdate=Requests.getUser(this.payload.getUsername());
		responseafterupdate.then().log().body();	
	}
	
	@Test(priority=4)
	public void testDeleteRequest() {
		
		Response response=Requests.deleteUser(this.payload.getUsername());
		response.then().log().body();
		
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
