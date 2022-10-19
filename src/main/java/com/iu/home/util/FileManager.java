package com.iu.home.util;

import java.io.File;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager {

	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public String saveFile(MultipartFile multipartFile, String path)throws Exception {
	
	
		//1. 중복되지 않는 파일명 생성(UUID, Milisecond)
		String fileName = UUID.randomUUID().toString();
		
		//2. 확장자
		StringBuffer bf =new StringBuffer(); 
		bf.append(fileName);
		bf.append("_");
		bf.append(multipartFile.getOriginalFilename());
		log.info("FileName {}",bf.toString());
		
		//3. File save
		File file =new File(path, bf.toString());
		
		//Filecopyutils
		//multipartFile
	
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		multipartFile.transferTo(file);
		return fileName;
	}
}
