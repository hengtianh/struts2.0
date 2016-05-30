<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.maker.tags/jsp/core" prefix="data" %>
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
  
  <body>
    <!-- 在售商品 -->
      <div class="container">
      <h3>在售商品</h3>      
      <form role="form" action="onsell.action" method="post">
      <table class="table">
  		<tr><td>序号</td><td>名称</td><td>单价</td><td>数量</td><td>描述</td><td>操作</td></tr>
  		<c:forEach items="${sessionScope.onsell }" var="sell" varStatus="car">
  		<tr><td>${car.count }</td><td>${sell.productname }</td><td>${sell.price }</td><td>${sell.number }</td><td>${sell.description }</td><td><a href="edit.jsp?index=${car.count  }">修改</a></td></tr>
  		</c:forEach>
	  </table>
      </form>
       </div>
  </body>
</html>
