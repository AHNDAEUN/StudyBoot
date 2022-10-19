package com.iu.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.Pager;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	
	public List<QnaVO> getList(Pager pager)throws Exception{
		pager.getPerPage();
		System.out.println("perPage"+pager.getPerPage());
		System.out.println("page:"+pager.getPage());
		pager.makeRow();
		return qnaMapper.getList(pager);
	}
	
	public int setAdd(QnaVO qnaVO) throws Exception{
		
		for (MultipartFile f : qnaVO.getFiles()) {
			
			if(!f.isEmpty()) {
				
				log.info("FileName:{}",f.getOriginalFilename());

				
			}
			
		}
		
		return 1;//qnaMapper.setAdd(qnaVO);
	}

}
