<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!doctype>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
   
    <link href="css/bootstrap.min.css" rel="stylesheet"> 
<title>商品上架</title>
</head>


<body>

<nav class="navbar navbar-default nn" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">校园旧物在线交易平台</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">首页</a></li>
       <li class=""><a href="#"></a></li>
        <li class=""><a href="#"></a></li>                    
      <ul class="nav navbar-nav navbar-right navbar-text">
    	  <li>欢迎您！</li>
      </ul>     
    </ul>        

  </div><!-- /.navbar-collapse -->
</nav> 
<hr>
<div class="row">
<div class="col-xs-1">
</div>
<div class="col-xs-8">
<form class="form-horizontal" role="form" action="upfile.action" method="post" enctype="multipart/form-data">
   <div class="form-group">
   <input type="hidden" name="id" value="${user.id }">
  <div class="row">
    <label for="inputEmail3" class="col-xs-4 control-label">类型</label>
    <div class="col-xs-5">
      <select class="form-control">
          <c:forEach var="t" items="${TYPE }"><option>${t.typename }</option></c:forEach>
      </select>
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  <div class="form-group">
  <div class="row">
    <label for="inputEmail3" class="col-xs-4 control-label">类别</label>
    <div class="col-xs-5">
      <select class="form-control" name="cateID">
          <c:forEach var="c" items="${CATE }"><option value="${c.cateid }">${c.catename }</option></c:forEach>
      </select>
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  <div class="form-group">
  <div class="row">
    <label for="inputEmail3" class="col-xs-4 control-label">物品名称</label>
    <div class="col-xs-5">
      <input type="text" class="form-control" name="productname" id="inputEmail3" placeholder="name">
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  <div class="form-group">
  <div class="row">
    <label for="inputEmal3" class="col-xs-4 control-label">售价</label>
    <div class="col-xs-5">
      <input type="text class="form-control" name="price" id="inputPassword3" placeholder="price">
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
    <div class="form-group">
  <div class="row">
    <label for="inputEmal3" class="col-xs-4 control-label">数量</label>
    <div class="col-xs-5">
      <input type="text" class="form-control" name="number" id="inputPassword3" placeholder="number">
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  <div class="form-group">
  <div class="row">
    <label for="inputEmal3" class="col-xs-4 control-label">上传图片</label>
    <div class="col-xs-5">
     <input type="file" name="file" id="exampleInputFile">
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  <div class="form-group">
  <div class="row">
    <label for="inputEmal3" class="col-xs-4 control-label">物品描述</label>
    <div class="col-xs-5">
     <textarea class="form-control" name="description" rows="3"></textarea>
    </div>
    <div class="col-xs-3"></div>
  </div>
  </div>
  
  <div class="form-group">
  <div class="row">
  <div class="col-xs-4"></div>
    <div class="col-xs-5">
      <button type="submit" class="btn btn-default">上架</button>
    </div>
  <div class="col-xs-3"></div>
  </div>
  </div>
</form>
</div>
<div class="col-xs-3">
</div>
</div>
</body>
</html>
