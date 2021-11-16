package org.practical.restAssured;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class Sample3 {
	public static void main(String[] args) {
         File srcPath = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Input Data\\task.json");
         JsonPath jsonPath = new JsonPath(srcPath);
         int length = jsonPath.getInt("courses[1].price");
         System.out.println(length);
	}
}
