/**
 * 
 */

/**
 * @author Shiksha.Gupta
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import psl.api.ssapi.client.SSRestServiceClient;
import psl.api.ssapi.model.AvailableTrip;
import psl.api.ssapi.model.AvailableTripList;
import psl.api.ssapi.model.CityList;
import psl.api.ssapi.model.DateParameter;

import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class MediaPlayer {
	private static final String consumerKey = "ANwhpxc7owtm3HurEaxVHvC3HS1qqz";
    private static final String consumerSecret = "bO7y2b68jlxr5UMVoGDw1d5phOjpj8";
    private static final SSRestServiceClient client = SSRestServiceClient.getInstance("http://api.seatseller.travel", consumerKey,consumerSecret);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(client.getAllSources());
	    Scanner in2 = new Scanner(System.in);

	    System.out.println("Enter date");
	    String s2 = in2.nextLine();
		
		DateParameter d=new DateParameter(s2);
		MediaPlayer g=new MediaPlayer();
	    
		String re = "";
		try{
			re = g.r(); 
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		Long i=(long) 674;

		//JSONObject json = (JSONObject)new JSONParser().parse(s);
 	    // System.out.println("width=" + json.get("width"));
		//String k=j.getString("availa");
		
        //System.out.println(k);
		
		AvailableTripList availableTrips = client.getAvailableTrips((long)3,(long)6, d);
		availableTrips.getAvailableTrips();
		int ia=0;
		for (AvailableTrip entry : availableTrips.getAvailableTrips()){
			/*System.out.println(entry.getAvailableSeats());
			System.out.println(entry.getBusType());
			System.out.println(entry.getCancellationPolicy());
			System.out.println(entry.getTravels());
			System.out.println(entry.getArrivalTime());
			System.out.println(entry.getDepartureTime());
			System.out.println(entry.getDroppingTimes().size());
			*/
			for(int k=0;k<entry.getDroppingTimes().size();k++){
				//System.out.println(entry.getDroppingTimes().get(k).getLocation());
				//System.out.println(entry.getDroppingTimes().get(k).getTime());
			}
		
			//System.out.println(entry.getBoardingTimes().size());
			ArrayList<String> j=new ArrayList<String>();
			ArrayList<Integer> p=new ArrayList<Integer>();
			for(int k=0;k<entry.getBoardingTimes().size();k++){
				//System.out.println(entry.getBoardingTimes().get(k).getLocation());
				//System.out.println(entry.getBoardingTimes().get(k).getTime());

				j.add(k,entry.getBoardingTimes().get(k).getLocation());

				//URL yahoo = new URL("http://maps.googleapis.com/maps/api/distancematrix/xml?origins=Wipro+Park&destinations="+j.get(k).replaceAll("\\s", "+")+"+Bangalore&sensor=false");
				//URLConnection yc = yahoo.openConnection();
				/*BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				in.close();*/
				System.out.println("http://maps.googleapis.com/maps/api/distancematrix/xml?origins="+re+"&destinations="+j.get(k).replaceAll("\\s", "+")+"+Bangalore&sensor=false");
				String sXML = MediaPlayer.getDoc("http://maps.googleapis.com/maps/api/distancematrix/xml?origins="+re+"&destinations="+j.get(k).replaceAll("\\s", "+")+"+Bangalore&sensor=false");
		
				Document dom ;
				try{
					dom = MediaPlayer.loadXMLFromString(sXML);
					Element el = dom.getDocumentElement();
					String d3=MediaPlayer.getTextValue(el, "value");
					//System.out.println(mediaplayer.getTextValue(el, "text"));
					//System.out.println(mediaplayer.getTextValue(el, "value"));
			
					p.add(k,Integer.parseInt(d3));

				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			int min=0;
			int least=0;
			for(int h=0;h<p.size();h++){
				min=p.get(0);
		
				if(p.get(h)<min){
					min=p.get(h);
					least=h;
				}
		
			}
			ArrayList<String> j1=new ArrayList<String>();
			ArrayList<Integer> p1=new ArrayList<Integer>();
			for(int k=0;k<entry.getDroppingTimes().size();k++){
				//System.out.println(entry.getBoardingTimes().get(k).getLocation());
				//System.out.println(entry.getBoardingTimes().get(k).getTime());

				j1.add(k,entry.getDroppingTimes().get(k).getLocation());

				//URL yahoo = new URL("http://maps.googleapis.com/maps/api/distancematrix/xml?origins=Wipro+Park&destinations="+j.get(k).replaceAll("\\s", "+")+"+Bangalore&sensor=false");
				//URLConnection yc = yahoo.openConnection();
				/*BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
				in.close();*/

				String sXML = MediaPlayer.getDoc("http://maps.googleapis.com/maps/api/distancematrix/xml?origins=Ameerpet&destinations="+j1.get(k).replaceAll("\\s", "+")+"+Hyderabad&sensor=false");
		
				Element el;
				try {
					Document dom = MediaPlayer.loadXMLFromString(sXML);
					el = dom.getDocumentElement();
					System.out.println(MediaPlayer.getTextValue(el, "text"));
					System.out.println(MediaPlayer.getTextValue(el, "value"));

				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				//String d1=mediaplayer.getTextValue(el, "value");

				//p1.add(k,Integer.parseInt(d1));
			}
			int min1=0;
			int least1=0;
			for(int h=0;h<p1.size();h++){
				min1=p1.get(0);
				if(p1.get(h)<min1){
					min1=p1.get(h);
					least1=h;
				}
			}

			/*System.out.println("nearest boarding distance:"+min);
			p.clear();
			System.out.println("nearest boarding point:"+entry.getBoardingTimes().get(least).getLocation());
			System.out.println("nearest dropping distance:"+min1);
			p1.clear();
			System.out.println("nearest dropping point:"+entry.getDroppingTimes().get(least1).getLocation());
			System.out.println("available seats:"+entry.getAvailableSeats());
			System.out.println("bus type:"+entry.getBusType());
			//System.out.println(entry.getCancellationPolicy());
			System.out.println("travels:"+entry.getTravels());
			System.out.println("arrival time:"+entry.getArrivalTime());
			System.out.println("departure time:"+entry.getDepartureTime());
			//System.out.println(entry.getDroppingTimes().size());
		
			System.out.println("........");
			 */	
			ia++;	

		}
		System.out.println(ia);

	}
	public static String getDoc(String urlToRead) {

		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";

		try {
			url = new URL(urlToRead);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			rd.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Document loadXMLFromString(String xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return  builder.parse(is);
	}

	public static String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(1);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}
	
	public String r(){
		String result2 = "";
		try {
			String sXML1 = HttpGetter.getDoc("http://maps.googleapis.com/maps/api/geocode/xml?latlng=12.8833,77.5833&sensor=true");
			Document dom1 = HttpGetter.loadXMLFromString(sXML1);
			Element el1 = dom1.getDocumentElement();
			String y1=HttpGetter.getTextValue(el1, "formatted_address");
			//System.out.println(HttpGetter.getTextValue(el, "value"));
			//System.out.println(HttpGetter.getTextValue(el, "temperature"));
			result2=y1.replaceAll("\\s", "+");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result2;
	}
	
	public static String getDoc1(String urlToRead) {
		URL url1;
		HttpURLConnection conn1;
		BufferedReader rd1;
		String line1;
		String result1 = "";
		try {
			url1 = new URL(urlToRead);
			conn1 = (HttpURLConnection) url1.openConnection();
			conn1.setRequestMethod("GET");
			rd1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
			while ((line1 = rd1.readLine()) != null) {
				result1 += line1;
			}
			rd1.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result1;
	}

	public static Document loadXMLFromString1(String xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return  builder.parse(is);
	}

	public static String getTextValue1(Element ele1, String tagName) {
		String textVal1 = null;
		NodeList nl1 = ele1.getElementsByTagName(tagName);
		if (nl1 != null && nl1.getLength() > 0) {
			Element el1 = (Element) nl1.item(0);
			textVal1 = el1.getFirstChild().getNodeValue();
		}
	
		return textVal1;
	}

}
