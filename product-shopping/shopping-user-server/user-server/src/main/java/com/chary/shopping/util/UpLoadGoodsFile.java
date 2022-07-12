package com.chary.shopping.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UpLoadGoodsFile {

	/**
	 * 文件上传
	 * @param multipartFile
	 * @return
	 */
	public static String upload(MultipartFile multipartFile) {
		String filePath = "C:\\Users\\Administrator\\Desktop\\Java\\product\\product-shopping\\shopping-user-server\\user-view\\src\\main\\resources\\static\\images\\" + multipartFile.getOriginalFilename();
		File file = new File(filePath);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return file.getAbsolutePath();
	}
	
}
