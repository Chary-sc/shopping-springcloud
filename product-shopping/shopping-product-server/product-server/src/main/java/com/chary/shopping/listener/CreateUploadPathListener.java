package com.chary.shopping.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.chary.shopping.util.SessionConstantKey;
import com.chary.shopping.util.StringUtil;

@WebListener
public class CreateUploadPathListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String path = sce.getServletContext().getInitParameter("uploadPath");
		
		if(StringUtil.checkNull(path)) {
			path = "images";
		}
		String basePath = sce.getServletContext().getRealPath("/");
		File parent = new File(basePath).getParentFile();
		File fl = new File(parent, path);
		if(!fl.exists()) {
			fl.mkdirs();
		}
		
		SessionConstantKey.basePath = parent.getAbsolutePath();	
		SessionConstantKey.uploadPath = path;
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
}
