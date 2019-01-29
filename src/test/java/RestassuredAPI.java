import static io.restassured.RestAssured.get;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RestassuredAPI extends Baseclass {
		   @Test
			public void contenttypeisjson() throws IOException
				{
			   Response response=get(BaseURL);
			   String headervalue=(String)getheader(response,"Server");
			   Assert.assertEquals(headervalue, "GitHub.com");
				}
		   
		   
		private String getheader(Response response, String headername) {
			
			Headers allheader=response.headers();
			
			String returnHeader="";
			
		
			for(io.restassured.http.Header header: allheader)
			{
				if(headername.equalsIgnoreCase(header.getName()))
						{
					returnHeader=header.getValue();
					
						}
				
				else if(returnHeader.isEmpty())
				{
					throw new RuntimeException("Header is not found" + header);
				}
				
				
			}
			
			return returnHeader;
			// TODO Auto-generated method stub
			
		}
			
}
