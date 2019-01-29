import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Get400 {
	
	CloseableHttpClient client;
	CloseableHttpResponse response;
	public static String BaseURL="https://api.github.com";
	
	@DataProvider
	private Object[][] endpoints()
	{
		return new Object[][]{
			{"/user"},
		{"/user/followers"},
		{"/notifications"}
	};
	
	}
	
	
	
	@BeforeMethod
	public void setup()
	{
	client=HttpClientBuilder.create().build();
	
	}
	
	@AfterMethod
	public void tearup() throws IOException
	{
		client.close();
		response.close();
	}
	
	@Test(dataProvider="endpoints")
	public void notfoundstatuscode(String endpoint) throws IOException
	{
		HttpGet get=new HttpGet(BaseURL + endpoint);
		response=client.execute(get);
		int actualstatuscode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(actualstatuscode, 403);
		
	}


}
