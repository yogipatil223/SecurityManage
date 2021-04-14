package com.shadow.bean;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadBean {

	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
