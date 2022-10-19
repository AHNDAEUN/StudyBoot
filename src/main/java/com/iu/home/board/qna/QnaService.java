package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;
import com.iu.home.util.Pager;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Value("${app.upload.qna}")
	private String path;
	
	@Autowired
	private FileManager fileManager;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	
	public List<QnaVO> getList(Pager pager)throws Exception{
		
		
		pager.getPerPage();
		System.out.println("perPage"+pager.getPerPage());
		System.out.println("page:"+pager.getPage());
		pager.makeRow();
		return qnaMapper.getList(pager);
	}
	
	
	
	public int setAdd(QnaVO qnaVO) throws Exception{
		int result= qnaMapper.setAdd(qnaVO);
		
			File file = new File(path);
			
			
			if(!file.exists()) {
				boolean check = file.mkdirs();
			}
			
		for (MultipartFile f : qnaVO.getFiles()) {
		if(!f.isEmpty()) {
		log.info("FileName:{}",f.getOriginalFilename());
		String fileName=fileManager.saveFile(f, path);
		QnaFileVO qnaFileVO =new QnaFileVO();
		qnaFileVO.setFileName(fileName);
		qnaFileVO.setOriName(f.getOriginalFilename());
		qnaFileVO.setNum(qnaVO.getNum());
		qnaMapper.setFileAdd(qnaFileVO);
				
			}
			
		}
		
		return result;
	}

}
