import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class headers extends Baseclass {
   @Test
	public void contenttypeisjson() throws IOException
		{
			HttpGet get=new HttpGet(BaseURL);
			response=client.execute(get);
			Header contenttype=response.getEntity().getContentType();
			Assert.assertEquals(contenttype.getValue(),"application/json; charset=utf-8");
			
		}
   
   @Test
	public void serverisgithub() throws IOException
		{
			HttpGet get=new HttpGet(BaseURL);
			response=client.execute(get);
			
               String headervalue=getheader(response,"Server");
               Assert.assertEquals(headervalue, "GitHub.com");
		}

private String getheader(CloseableHttpResponse response, String headername) {
	
	Header[] headers=response.getAllHeaders();
	
	List<Header> header= Arrays.asList(headers);
	String returnHeader="";
	
	for(Header h:header)
	{
		if(headername.equalsIgnoreCase(h.getName()))
				{
			returnHeader=h.getValue();
			
				}
		
		else if(returnHeader.isEmpty())
		{
			throw new RuntimeException("Header is not found" + header);
		}
		
		
	}
	
	return returnHeader;
	// TODO Auto-generated method stub
	
}
	
	//public String EtagisPresent(loseableHttpResponse response, String headername)

}
