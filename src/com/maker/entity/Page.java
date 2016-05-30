package com.maker.entity;

import java.util.ArrayList;
import java.util.List;

//��ҳ��
public class Page {
	private List<Product> list = new ArrayList<Product>(); //��ҳ��������Ϣ
	private int startPage = 0; //��ʾ����ʼҳ
	private int endPage = 0; //��ʾ�����һҳ
	private int totalRecord = 0; //�ܵļ�¼��
	private int currentPage = 0; //��ǰ��ʾҳ
	private int totalPages = 0; //�ܵķ�ҳ��
	private int size = 4; //ÿҳ��ʾ�ļ�¼��
	private int startIndex = 0; //ÿҳ��һ����¼������
	private int cateid = 0; //��ѯ����Ʒ����id
	public Page(){
		
	}
	public Page(int currentPage, int totalRecord , int cateid) {
		//super();
		this.cateid = cateid;
		this.totalPages = totalRecord % size==0 ? totalRecord / size : totalRecord / size+1;
		this.startIndex = (currentPage - 1)*size + 1;
		//��ҳ��С��5ʱ����ǰ����������ʾ
		if(totalPages<=5){
			startPage = 1;
			endPage = totalPages;
		}else{
			//��ҳ������5ʱ���ȼ�����ֹҳ
			this.startPage = currentPage - 2;
			this.endPage = currentPage + 2;
			//��ʼҳС��1����ӵ�һҳ��ʾ
			if(startPage<1){
				startPage = 1;
				endPage = 5;
			}
			//���һҳ������ҳ��ʱ���Ӻ���ǰ��ʾ
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
