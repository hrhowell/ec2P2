package com.p2.recApp.filestore;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

/*************************************Works Cited********************************************************
 * Title: "Spring Boot Tutorial | Spring Boot Full Stack with React.js | Full Course | 2021"
 * Author: Nelson (amigoscode)
 * Date: 3/28/20 (Accessed 12/29/21)
 * Code Version: Java 15
 * Availability: https://youtu.be/i-hoSg8iRG0
 * 
 * Title: "How to set InputStream content Length"
 * Author: Vella
 * Date: 2/1/21 (Accessed 1/5/22)
 * Code Version: NA
 * Availability: https://www.semicolonworld.com/question/79153/how-to-set-inputstream-content-length
 ********************************************************************************************************/
@Service
public class FileStore {
	
	private final AmazonS3 s3;

	@Autowired
	public FileStore(AmazonS3 s3) {
		super();
		this.s3 = s3;
	}
	
	//the map part allows us to pass metadata from images and files
	public void save(
			String path,
			String fileName,
			Optional<Map<String, String>> optionalMetadata,
			InputStream inputStream) throws IOException {
		
		ObjectMetadata metadata = new ObjectMetadata();
		
		optionalMetadata.ifPresent(map -> {
			if(!map.isEmpty()) {
				map.forEach(metadata:: addUserMetadata);
			}
		});
//		try {
//			s3.putObject(path, fileName, inputStream, metadata);
//			
//		}catch(AmazonServiceException e) {
//			throw new IllegalStateException("failed to store image in s3", e);
//		}
		
		byte[] bytes = IOUtils.toByteArray(inputStream);
		metadata.setContentLength(bytes.length);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		PutObjectRequest putObjectRequest = new PutObjectRequest(path, fileName, byteArrayInputStream, metadata);
		try {
		s3.putObject(putObjectRequest);
		System.out.println("I did it!");
		}catch(AmazonServiceException e) {
			throw new IllegalStateException("failed to store image in s3", e);
		}
	}

	 public byte[] download(String path, String key) {
	        try {
	            S3Object object = s3.getObject(path, key);
	            System.out.println("I also did it!");
	            return IOUtils.toByteArray(object.getObjectContent());
	        } catch (AmazonServiceException | IOException e) {
	            throw new IllegalStateException("Failed to download file to s3", e);
	        }
	
	
	 }
}
