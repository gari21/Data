import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Get200 extends Baseclass {
	@DataProvider
	private Object[][] endpoint()
	{
		return new Object[][]{
			{"/rate_limit"}
			
		};
	}
		
	@Test
	public void teststatuscode() throws IOException
	{
		HttpGet get=new HttpGet(BaseURL);
		response=client.execute(get);
		int actualstatuscode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(actualstatuscode, 200);
		
	}
	@Test(dataProvider="endpoint")
	public void ratelimitcode(String url) throws IOException
	{
		HttpGet get=new HttpGet(BaseURL + url);
		HttpResponse response=client.execute(get);
		int actualstatuscode=response.getStatusLine().getStatusCode();
		Assert.assertEquals(actualstatuscode, 200);
		
	}

}
