<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>首页</title>
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
  
  <style>
  	.nn{
		margin:10px 0 20px;
		}
  	.foot-fix{
		padding-bottom:5px;
		}
  	#header-bg {
    background: transparent url("images/banner.jpg") no-repeat scroll 0px 0px / cover;
    padding-bottom: 6em;
}
  	#listAll{
		
		}
	#listAll ul{
		margin-bottom:20px;
		}
  	#listAll ul li{margin:0 0 0 20px;
		   padding-top:5px;
		   display:none;
	}
  </style>
  <body>
  	<div id="header-bg" class="container-fluid">
	
   
   <!--导航条-->
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
       <li class=""><a href="#"></a></li>
        <li class=""><a href="#"></a></li>
      
     
      <li><a href="#">我的订单</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">我是卖家<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#" data-toggle="modal" data-target="#login">登录</a></li>
          <li class="divider"></li>
          <li><a href="#">订单列表</a></li>
          <li><a href="#">出售商品</a></li>  
          <li><a href="#">在售商品</a></li>
          <li class="divider"></li>
          <li><a href="#">联系管理员</a></li>
        </ul>
      </li>
      <li><a href="#">关于</a></li>
      <li><a href="#" data-toggle="modal" data-target="#login">请登录</a></li>
      <ul class="nav navbar-nav navbar-right navbar-text">
    	  <li>欢迎您！</li>
      </ul>
      
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
     
      <li>
      	<button id="example" type="button" class="btn btn-default btn-xs navbar-text" data-container="body" data-toggle="popover" data-placement="bottom" data-content="显示购物车中的内容
        显示购物车中的内容
        显示购物车中的内容
        显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容显示购物车中的内容" data-trigger="hover">
      
  			<span class="glyphicon glyphicon-shopping-cart"></span> 购物车
	  	</button>
      </li>

      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">菜单<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#" data-toggle="modal" data-target="#register">注册会员</a></li>
          <li><a href="#" data-toggle="modal" data-target="#register">升级为卖家</a></li>
          <li class="divider"></li>
           <li><a href="#">注销登录</a></li>
        </ul>
      </li>
    </ul>
   <form class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default glyphicon glyphicon-search">&nbsp;搜索</button>
    </form>
    
    <ul class="nav navbar-nav navbar-right navbar-text">
      <li>没有想要？</li>
    </ul>

  </div><!-- /.navbar-collapse -->
</nav> 
<div class="container-fluid">
<div class="jumbotron text-danger">
  <h1>Look here!</h1>
  <p class="text-info">${requestScope.note }</p>
  <p class="text-danger">${requestScope.tip }</p>
  <p class="text-danger">${requestScope.info }</p>
  <p class="text-danger">${requestScope.warn }</p>
  <p class="text-danger">${requestScope.ptips }</p>
   <p class="text-danger">${requestScope.cinfo }</p>
   <p class="text-danger">${requestScope.ere }</p>
  <p><a class="btn btn-primary btn-lg" role="button" href="index.jsp">我知道了！</a></p>
</div>
</div>


</div>
</body>
</html>

