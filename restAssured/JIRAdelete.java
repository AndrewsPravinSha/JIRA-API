package org.practical.restAssured;

import org.restAPI.base.BaseClassAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRAdelete extends BaseClassAPI{
	public static void main(String[] args) {
		readPropertyFile();
		RestAssured.baseURI = prop.getProperty("Jira");
		
		Response response = RestAssured
		 .given()
		  .header("Content-Type","application/json")
		  .auth()
		  .preemptive()
		  .basic(excelRead("JIRA-API", 1, 0),excelRead("JIRA-API", 1, 1))
		 .when()
		  .delete("/rest/api/3/issue/PBI-5/delete");
		 
		
		System.out.println("Status code: " + response.statusCode());
		
	}

}
