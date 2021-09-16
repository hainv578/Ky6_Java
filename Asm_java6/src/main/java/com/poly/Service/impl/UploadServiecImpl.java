package com.poly.Service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.Service.UploadService;
@Service
public class UploadServiecImpl implements UploadService {
	@Autowired ServletContext app;

	public File save(MultipartFile file, String folder) {
		File dir = new File(app.getRealPath("/assets/" + folder));
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File savedFile = new  File(dir,name);
			file.transferTo(savedFile.getAbsoluteFile());
			return savedFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
	
