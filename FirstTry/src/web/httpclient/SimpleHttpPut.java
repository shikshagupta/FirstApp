/**
 * 
 */
package web.httpclient;

/**
 * @author Shiksha.Gupta
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class SimpleHttpPut {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
	    
		HttpClient client = new DefaultHttpClient();
	    HttpPost post = null;
	    
	    try {
	    	post = new HttpPost("http://10.0.0.44:38081/HDMEXQA/LoginSubmit.jsp");
	    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	    	nameValuePairs.add(new BasicNameValuePair("txtUserID","cm_admin"));
	    	nameValuePairs.add(new BasicNameValuePair("txtPassword","abcd123"));
	    	post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	 
	    	HttpResponse response = client.execute(post);
	    	BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	    	String line = "";
	    	while ((line = rd.readLine()) != null) {
	    		System.out.println(line);
	    	}
	
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	}
} 