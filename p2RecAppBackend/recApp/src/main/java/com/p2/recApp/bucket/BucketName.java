package com.p2.recApp.bucket;


/*************************************Works Cited*********************************************
 * Title: "Spring Boot Tutorial | Spring Boot Full Stack with React.js | Full Course | 2021"
 * Author: Nelson (amigoscode)
 * Date: 3/28/20 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/i-hoSg8iRG0
 *********************************************************************************************/

public enum BucketName {
	
	PROFILE_IMAGE("revature-project-two");
	
	private final String bucketName;

	private BucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	
	public String getBucketName() {
		return bucketName;
	}

}
