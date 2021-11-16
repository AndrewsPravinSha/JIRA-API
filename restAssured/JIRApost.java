package org.practical.restAssured;

import org.input.restAPI.Payload;
import org.restAPI.base.BaseClassAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRApost extends BaseClassAPI{
	
	public static void main(String[] args) {
		readPropertyFile();
		RestAssured.baseURI = prop.getProperty("Jira");
		
		//post
		Response response = RestAssured
		.given()
		 .header("Content-Type","application/json")
		 .body(Payload.createIssue())
		 .auth()
		 .preemptive()
		 .basic(excelRead("JIRA-API", 1, 0),excelRead("JIRA-API", 1, 1))
		.when()
		 .post("/rest/api/2/issue/");
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code:" + statusCode);
		System.out.println(response.asPrettyString());	
		
	}

}
