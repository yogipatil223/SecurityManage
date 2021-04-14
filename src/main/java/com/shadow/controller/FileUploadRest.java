package com.shadow.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shadow.bean.ImageUploadBean;

@RestController
@RequestMapping("/FileUploadRest")
public class FileUploadRest {

	@PostMapping("/uploadImage")
	public String uploadImage( ImageUploadBean bean) {
		System.out.println("uploadImage----");
		MultipartFile file = bean.getFile();
		String result = "false";
		try {
			Path fileNameandPath = Paths.get("C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 8.0.27\\webapps\\images\\", file.getOriginalFilename());
			Files.write(fileNameandPath, file.getBytes());
			result = "true";
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}	
}
