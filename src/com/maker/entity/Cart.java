package com.maker.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {

	private double totalcost=0;
	private List<CartItem> items = new ArrayList<CartItem>();
	
	//暴露添加购物项的方法
	public void addItem(CartItem item){
		if(items.size()>0){
			Iterator<CartItem> iterator = items.listIterator();
			if(iterator.hasNext()){
				CartItem it = iterator.next();
				if(it.getProductid()==item.getProductid()){
					it.setAmount(it.getAmount()+1);
					//items.add(it);
				}
			}
		}else{
			items.add(item);
		}
	}
	
	//删除购物项方法
	public void deleteItem(CartItem item){
		items.remove(item);
	}
	
	//计算总花费
	public double getTotalcost(){
		totalcost = 0;
		for(CartItem i : items){
			totalcost = totalcost+i.getAccount();
		}
		return totalcost;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
}
