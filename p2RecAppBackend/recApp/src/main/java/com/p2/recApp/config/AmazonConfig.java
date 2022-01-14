package com.p2.recApp.config;

import org.springframework.context.annotation.Bean;
/*************************************Works Cited*********************************************
 * Title: "Spring Boot Tutorial | Spring Boot Full Stack with React.js | Full Course | 2021"
 * Author: Nelson (amigoscode)
 * Date: 3/28/20 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/i-hoSg8iRG0
 *********************************************************************************************/
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
	
	@Bean
	public AmazonS3 s3() {
		
		AWSCredentials awsCredentials = new BasicAWSCredentials(
				 "AKIA27X2IFHHZFWHBJX4", 
				 "YnwKR+rh/FSJchSuvz4eFRIochSRg/zGcRxkFRIN"
				
				);
		return AmazonS3ClientBuilder
				.standard()
				.withRegion("us-west-1")
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
		
		//add a region?
		
		
	}

}
