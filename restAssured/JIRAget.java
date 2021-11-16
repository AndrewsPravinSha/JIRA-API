package org.practical.restAssured;

import org.restAPI.base.BaseClassAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRAget extends BaseClassAPI{

	public static void main(String[] args) {
		readPropertyFile();
		RestAssured.baseURI=prop.getProperty("Jira");
		
		//get
		Response response = RestAssured.
				given()
				.header("Content-Type","application/json")
				.auth()
				.preemptive()
				.basic(excelRead("JIRA-API", 1, 0),excelRead("JIRA-API", 1, 1))
				.when()
				.get("/rest/api/2/search");
		
		System.out.println("Status code: "+response.getStatusCode());
		String prettyString = response.getBody().asPrettyString();
		System.out.println(prettyString);


	}

}
