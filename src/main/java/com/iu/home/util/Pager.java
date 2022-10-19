package com.iu.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage=10L;
	
	private String search;
	private String kind;
	
	
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	//----------------------------------
	public Long getPage() {
		if(this.page==null||this.page<1) {
			this.page=1L;
		}
		return this.page;
	}
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	
	public void makeRow() {
		this.startRow = (this.getPage()-1)*perPage;
	}

}
