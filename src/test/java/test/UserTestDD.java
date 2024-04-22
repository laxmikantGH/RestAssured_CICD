package test;





import org.testng.Assert;
import org.testng.annotations.Test;


import api.endusers.Requests;
import api.payload.User;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {


	
	@Test(priority=1,dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd, String phone)
	{

		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(lname);
		userPayload.setPassword(email);
		userPayload.setPhone(phone);
		Response response = Requests.createUser(userPayload);

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
	}

	}