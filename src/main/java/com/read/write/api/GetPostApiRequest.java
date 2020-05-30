package com.read.write.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;





@Cacheable("userCache")
@CacheEvict(value="userCache",allEntries = true)
public class GetPostApiRequest {

	
	public static String getAPIResponseforQueryParams(String tag,String sortBy,String direction) throws UnsupportedOperationException, IOException	{
		String URL  = "https://hatchways.io/api/assessment/blog/posts?tag="+tag+"&SortBy="+sortBy+"&direction="+direction;
		System.out.println("*****TEST CASE STARTED:Tag  "+tag+"  "+"Sort by  "+sortBy+"  Direction"+direction);
		HttpClient client =new DefaultHttpClient();;
		HttpGet request = new HttpGet(URL);
		HttpResponse response = client.execute(request);
		String statusCode = Integer.toString(response.getStatusLine().getStatusCode());
		System.out.println("  STATUS CODE  "+statusCode);
		
		if(statusCode.equals("200"))
		{
			BufferedReader readLine = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			StringBuffer stringBuffer = new StringBuffer(); 
			String line = "";
			  while ((line = readLine.readLine()) != null) {
			    System.out.println(line);
			    stringBuffer.append(line);
			    stringBuffer.append(System.lineSeparator());
			  }
			  System.out.println("Tag  "+tag+"  "+"Sort by  "+sortBy+"  Direction  "+direction+"****Ended");
			//  stringtoJason(stringBuffer.toString());
			  return stringBuffer.toString();
		}
		else
		{
			System.out.println("***SOME THING WENT WRONG***STATUS CODE"+statusCode);
		}
		
		return statusCode=null;
		}
	
	/*
	 * public static void stringtoJason(String string) throws JSONException {
	 * JSONArray jasonArray = new JSONArray(string);
	 * 
	 * for(int counter=0;counter<jasonArray.length();counter++) { JSONObject
	 * jsonObject =jasonArray.getJSONObject(counter);
	 * System.out.println(jsonObject.toString()); }
	 * 
	 * //return jsonObject.toString();
	 * 
	 * }
	 */
}
