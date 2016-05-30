<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
   
    <link href="css/bootstrap.min.css" rel="stylesheet"> 
<title>商品展示</title>
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

<!--页面主体-->
<hr />
<div class="container">
        <div class="row">
        <c:forEach items="${page.list }" var="p">
        <div class="col-md-3">
        <form action="demo2.action?method=create" method="post">
        <input type="hidden" name="productid" value="${p.productID}">
            <input type="hidden" name="name" value="${p.productname}"><div class="panel">${p.productname }
            <div class="panel-body">
            <img src="${p.image }" width="230" height="180" class="img-rounded" />
            <input type="hidden" name="amount" value="${p.number}"><label for="inputEmal3" class="col-xs-4 control-label">数量</label>
            <p class="">${p.number }</p>
            <label for="inputEmal3" class="col-xs-4 control-label">描述</label>
            <p class="">${p.description }</p>
            <label for="inputEmal3" class="col-xs-4 control-label">价格</label>
            <input type="hidden" name="price" value="${p.price}"><p><span style="color:red;font-size:15px;">${p.price }</span> 元</p>
          
            </div>
            <div class="panel-footer">
            <input type="submit" value="加入购物车" />
            <a href="#">详细信息</a>
            </form>
            </div>
            </div>
        </div>
        </c:forEach>
    </div>
    </div>
<div class="row">
<div class="col-md-12 col-xs-offset-5">
<ul class="pagination">
  <li><a href="demo1.action?cateid=${page.cateid }& currentPage=${(page.currentPage-1)<1?1:page.currentPage-1 }">上一页</a></li>
<c:forEach begin="${page.startPage }" end="${page.endPage }" var="pagenum">
  <li><a href="demo1.action?cateid=${page.cateid }& currentPage=${pagenum }">${pagenum }</a></li>
</c:forEach>
<li><a href="demo1.action?cateid=${page.cateid }& currentPage=${page.currentPage+1>page.totalPages?page.totalPage:page.currentPage+1}">下一页</a></li>
</ul>
</div>
</div>
</div>

</body>
</html>
