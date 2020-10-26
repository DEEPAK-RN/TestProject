package Test1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class urlBroken
{
	@Test
	public void urlVerify() throws IOException
	{
		//to send url connection
		URL url = new URL("https://quantumspider.com/");
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int status  = con.getResponseCode();
		System.out.println(status);
		String msg = con.getResponseMessage();
		System.out.println(msg);
	}

}
