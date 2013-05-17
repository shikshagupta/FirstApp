/**
 * 
 */

package set1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



import org.json.simple.JSONObject;
//import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;




/**
 * @author Shiksha.Gupta
 *
 */
public class HttpGetter {

	public static void main(String[] args)throws Exception {
		System.out.println("Enter ISBN of the book u want to search costs at major stores");//9781585424801
		InputStreamReader in=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(in);
		String isbn=buf.readLine();
		    
		String sXML1 = HttpGetter.getDoc1("http://api.dataweave.in/v1/book_search/searchByIsbn/?api_key=b20a79e582ee4953ceccf41ac28aa08d&isbn="+isbn);
		//System.out.println(sXML1);
		JSONObject json = (JSONObject)new JSONParser().parse(sXML1);
		System.out.println(json.get("data"));

	}
	/*Document dom1 = HTTPGetter.loadXMLFromString1(sXML1);

	Element el1 = dom1.getDocumentElement();
	String y1=HTTPGetter.getTextValue1(el1, "formatted_address");
	System.out.println(HTTPGetter.getTextValue1(el1, "formatted_address"));
	//System.out.println(HttpGetter.getTextValue(el, "value"));
	//System.out.println(HttpGetter.getTextValue(el, "temperature"));
	String result2=y1.replaceAll("\\s", "+");
	System.out.println(result2);
	//return result2;
	}
	*/
	
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

	/*public static Document loadXMLFromString1(String xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return  builder.parse(is);
	}

	public static String getTextValue1(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
		Element el = (Element) nl.item(0);
		textVal = el.getFirstChild().getNodeValue();
	}

	return textVal;
	}
	*/
}
