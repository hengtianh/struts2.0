<%@page import="com.maker.constant.My_Constant"%>
<%@ page language="java" import="java.util.*,com.maker.entity.Product" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>在售商品</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
   
    <link href="css/bootstrap.css" rel="stylesheet"> 
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <%
  	int index = Integer.parseInt(request.getParameter("index"));
  	session = request.getSession();
  	List list= (List)session.getAttribute(My_Constant.Onsell);
  	Product p = (Product)list.get(index-1);
  	request.setAttribute("edit", p);
  %>
  
  <body>
  <div class="container">
  <h3 align="center">修改在售商品</h3>
   
  <form class="form-horizontal" role="form" action="demo4.action?productid=${edit.productID}&id=${edit.id}" method="post">
  <div class="form-group">
  <div class="row">
    <label for="inputEmail3" class="col-xs-4 control-label">物品名称</label>
    <div class="col-xs-5">
      <input type="text" class="form-control" name="productname" value="${edit.productname }" id="inputEmail3" placeholder="">
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  <div class="form-group">
  <div class="row">
    <label for="inputEmal3" class="col-xs-4 control-label">售价</label>
    <div class="col-xs-5">
      <input type="text class="form-control" name="price" value="${edit.price }" id="inputPassword3" placeholder="price">
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
    <div class="form-group">
  <div class="row">
    <label for="inputEmal3" class="col-xs-4 control-label">数量</label>
    <div class="col-xs-5">
      <input type="text" class="form-control" name="number" value="${edit.number }" id="inputPassword3" placeholder="number">
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  <div class="form-group">
  <div class="row">
    <label for="inputEmal3" class="col-xs-4 control-label">物品描述</label>
    <div class="col-xs-5">
     <textarea class="form-control" name="description"  rows="3">${edit.description }</textarea>
    </div>
    <div class="col-xs-3"></div>
  </div>
  <div class="form-group">
  <div class="row">
    <br />
    <label for="inputEmal3" class="col-xs-4 control-label">修改完成</label>
    <div class="col-xs-5">
    <button type="submit" class="btn btn-info">确认</button>
     
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  </form>
  </div>
  </body>
</html>
