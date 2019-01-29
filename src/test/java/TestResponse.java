import java.io.IOException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestResponse extends Baseclass {
	
	
	
	@Test
	public void elementvalue() throws IOException
	{
		HttpGet get=new HttpGet("http://parabank.parasoft.com/parabank/services/bank/customers/12212");
		response=client.execute(get);
	String jbody= EntityUtils.toString(response.getEntity());
	JSONObject obj=new JSONObject(jbody);
	String value=(String)getvalue(obj,"login");
	Assert.assertEquals(value, "nnnnnnn");
		
	}

	private Object getvalue(JSONObject obj, String key) {
		
		return obj.get(key);
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void nestedfunction()
	{
		HttpGet get=new HttpGet("http://parabank.parasoft.com/parabank/services/bank/customers/12212");
		response=client.execute(get);
	String jbody= EntityUtils.toString(response.getEntity());
	JSONObject obj=new JSONObject(jbody);
	String value=(String)getvalue(obj,"login");
	Assert.assertEquals(value, "nnnnnnn");
		
	}


}
