package org.practical.restAssured;

import org.input.restAPI.Payload;
import org.restAPI.base.BaseClassAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRAput extends BaseClassAPI{
	public static void main(String[] args) {
		readPropertyFile();
		RestAssured.baseURI = prop.getProperty("Jira");
		//put
		Response response = RestAssured
		.given()
		 .header("Content-Type","application/json")
		 .body(Payload.updateIssue())
		 .auth()
		 .preemptive()
		 .basic(excelRead("JIRA-API", 1, 0),excelRead("JIRA-API", 1, 1))
		.when()
		 .put("/rest/api/2/issue/PBI-5");
		
		System.out.println("status code :"+ response.statusCode());
	}

}
