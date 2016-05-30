package com.maker.actions;

import com.maker.entity.Page;
import com.maker.service.ProductService;
import com.maker.serviceimpl.ProductServiceImpl;

public class PageAction {
	private ProductService service = new ProductServiceImpl();

	public String execute() throws Exception {
		Page p = service.findByid(cateid, currentPage);
//		System.out.println(p);
//		System.out.println(p.getList().size());
		this.setPage(p);
		//System.out.println(getPage().getTotalPages());
		return "success";
	}
	private Page page;
	private int cateid;
	private int currentPage;
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getCateid() {
		return cateid;
	}

	public void setCateid(int cateid) {
		this.cateid = cateid;
	}

	public ProductService getService() {
		return service;
	}

	public void setService(ProductService service) {
		this.service = service;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
