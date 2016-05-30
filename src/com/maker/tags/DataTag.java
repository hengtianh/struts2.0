package com.maker.tags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.maker.service.TypeService;
import com.maker.serviceimpl.TypeServiceImpl;


public class DataTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		//获取页面数据
		TypeService service = new TypeServiceImpl();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession se = request.getSession();
		if(se.getAttribute("TYPE")==null && se.getAttribute("CATE")==null){
			List type = service.getType();
			se.setAttribute("TYPE", type);
			List cate = service.getCate();
			se.setAttribute("CATE", cate);
		}
			return super.doStartTag();
		}
	}
