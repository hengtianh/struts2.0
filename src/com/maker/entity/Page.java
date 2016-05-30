package com.maker.entity;

import java.util.ArrayList;
import java.util.List;

//分页类
public class Page {
	private List<Product> list = new ArrayList<Product>(); //分页的主体信息
	private int startPage = 0; //显示的起始页
	private int endPage = 0; //显示的最后一页
	private int totalRecord = 0; //总的记录数
	private int currentPage = 0; //当前显示页
	private int totalPages = 0; //总的分页数
	private int size = 4; //每页显示的记录数
	private int startIndex = 0; //每页第一条记录的索引
	private int cateid = 0; //查询的物品分类id
	public Page(){
		
	}
	public Page(int currentPage, int totalRecord , int cateid) {
		//super();
		this.cateid = cateid;
		this.totalPages = totalRecord % size==0 ? totalRecord / size : totalRecord / size+1;
		this.startIndex = (currentPage - 1)*size + 1;
		//总页数小于5时，从前往后依次显示
		if(totalPages<=5){
			startPage = 1;
			endPage = totalPages;
		}else{
			//总页数大于5时，先计算起止页
			this.startPage = currentPage - 2;
			this.endPage = currentPage + 2;
			//起始页小于1，则从第一页显示
			if(startPage<1){
				startPage = 1;
				endPage = 5;
			}
			//最后一页大于总页数时，从后往前显示
			if(endPage>totalPages){
				endPage = totalPages;
				startPage = endPage - 4;
			}
		}
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
