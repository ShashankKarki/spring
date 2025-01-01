package com.shashank.demo.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

	@Override
	public boolean uploadProductImage(MultipartFile image) {
		File uploadDir=new File(UPLOAD_DIR+"//"+"product_image");
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		//upload directory created if not exists 
		
		String uploadPath= UPLOAD_DIR+"//"+"product_image"+"//"+image.getOriginalFilename();
		
		File uploadFile= new File(uploadPath);
		try {
			image.transferTo(uploadFile);
			return true;
		}
		catch(IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProductImage(String imageName) {
		// TODO Auto-generated method stub
		
		String deletePath= UPLOAD_DIR+"//"+"product_image"+"//"+imageName;
		File deleteFile= new File(deletePath);
		if(deleteFile.exists()) {
				deleteFile.delete();
				return true;
		}
		
		else {
			System.out.println("File not found: " + deletePath);
		return false;
		}
	
	}

}
