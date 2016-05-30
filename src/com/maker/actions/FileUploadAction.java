package com.maker.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.maker.constant.My_Constant;
import com.maker.entity.Product;
import com.maker.service.ProductService;
import com.maker.serviceimpl.ProductServiceImpl;
import com.opensymphony.xwork2.Action;



public class FileUploadAction implements Action {
	private File file;
	private String fileContentType;
	private String fileFileName;
	
	private ProductService service = new ProductServiceImpl();
	@Override
	public String execute() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/upload/");
		InputStream in = new FileInputStream(file);
		
		OutputStream out = new FileOutputStream(new File(path+file.getName()));
		byte[] buf = new byte[1024];
		int length = 0;
		while((length=in.read(buf,0,buf.length))!=-1){
			out.write(buf);
		}
		out.close();
		in.close();
		//System.out.println(cateID);
		Product p =new Product();
		p.setCateID(cateID);
		p.setId(id);
		p.setProductname(productname);
		p.setImage("upload/"+file.getName());
		p.setNumber(number);
		p.setPrice(price);
		p.setDescription(description);
		
		if(service.addPro(p)){
			setPtips("恭喜，添加成功了");
			return "tips";
		}else{
			setPtips("抱歉，添加未完成");
			return "tips";
		}
	}
	
	private String ptips;
	private String image;
	private int id;//添加的人
	private int cateID; //类别a
	private String productname;
	private double price;
	private int number;
	private String description;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getPtips() {
		return ptips;
	}
	public void setPtips(String ptips) {
		this.ptips = ptips;
	}
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
