package javacs602;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

public class RestFileConsume {

	public static void main(String args[])
	{
		Client cc= ClientBuilder.newClient();
		String ss="";
		Scanner sc = new Scanner(System.in);
		ss=sc.nextLine();
		WebTarget target=cc.target("https://jsonmock.hackerrank.com/api/movies/search/?Title="+ss);
		JSONObject asq=target.request(MediaType.APPLICATION_JSON).get(JSONObject.class);
//		JSONObject as=(JSONObject) target.request(MediaType.APPLICATION_JSON);
		System.out.println(asq);
		System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
	}
}
