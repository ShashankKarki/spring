package com.shashank.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	
	//upload kata garne vanera path deko 
	public static final String UPLOAD_DIR="c://users//dell//desktop//online_commerce";
	
	public boolean uploadProductImage(MultipartFile image);
	
	public boolean deleteProductImage(String imageName);
	
	
}
