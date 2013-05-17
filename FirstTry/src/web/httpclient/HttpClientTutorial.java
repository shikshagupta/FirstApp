/**
 * 
 */
package web.httpclient;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;

/**
 * @author Shiksha.Gupta
 *
 */
public class HttpClientTutorial {
	private static String url = "http://www.apache.org/";
	
	public static void main(String[] args) {
	    HttpClient client = new HttpClient(); // Create an instance of HttpClient.
	    GetMethod method = new GetMethod(url); // Create a method instance.	    
	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler(3, false));// Provide custom retry handler is necessary
	    try{
	        int statusCode = client.executeMethod(method); // Execute the method.
	        if (statusCode != HttpStatus.SC_OK) {
	        	System.err.println("Method failed: " + method.getStatusLine());
	        }
	        byte[] responseBody = method.getResponseBody(); // Read the response body.
	        System.out.println(new String(responseBody));// Deal with the response.// Use caution: ensure correct character encoding and is not binary data
	    }
	    catch (HttpException e) {
	        System.err.println("Fatal protocol violation: " + e.getMessage());
	        e.printStackTrace();
	    }
	    catch (IOException e) {
	        System.err.println("Fatal transport error: " + e.getMessage());
	        e.printStackTrace();
	    }
	    finally {
	        method.releaseConnection();// Release the connection.
	    }  

	}

}
