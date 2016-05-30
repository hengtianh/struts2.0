package com.maker.actions;

import java.util.List;

import com.maker.service.ProductService;
import com.maker.serviceimpl.ProductServiceImpl;

public class SearchAction {
	private ProductService service = new ProductServiceImpl();
	
	public String execute() throws Exception {
		List searchList = service.findByProName(keyword);
		if(searchList!=null){
			setSlist(searchList);
			return "success";
		}else{
			setEre("未查找的该商品");
			return "tips";
		}
	}

	private String ere;
	private List slist;
	private String keyword;

	public String getEre() {
		return ere;
	}

	public void setEre(String ere) {
		this.ere = ere;
	}
	public List getSlist() {
		return slist;
	}

	public void setSlist(List slist) {
		this.slist = slist;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
