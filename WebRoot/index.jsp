<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://com.maker.tags/jsp/core" prefix="data" %>
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
      <li class="active"><a href="#">首页</a></li>
       <li class=""><a href="#"></a></li>
        <li class=""><a href="#"></a></li>
      
     
     <!--  <li><a href="#">我的订单</a></li> -->
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">我是卖家<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#" data-toggle="modal" data-target="#login">登录</a></li>
          <li class="divider"></li>
          <li><a href="addProd.jsp">出售商品</a></li>  
          <li><a href="demo3.action?userid=${sessionScope.user.id }">在售商品</a></li>
          <li class="divider"></li>
          <li><a href="#">联系管理员</a></li>
        </ul>
      </li>
      <li><a href="#">关于</a></li>
      <c:if test="${stuID !=null}"><li><a href="javascript:void(0)">${sessionScope.user.username }</a></li></c:if>
      <c:if test="${stuID ==null}"><li><a href="#" data-toggle="modal" data-target="#login">请登录</a></li></c:if>
      <ul class="nav navbar-nav navbar-right navbar-text">
    	  <li>欢迎您！</li>
      </ul>
      
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
     
      <li>
      	<button onclick="" id="example" type="button" class="btn btn-default btn-xs navbar-text" data-container="body" data-toggle="popover" data-placement="bottom" 
      	data-content="" data-trigger="hover">
      
  			<a href="#" data-toggle="modal" data-target="#cart"><span class="glyphicon glyphicon-shopping-cart"></span> 购物车</a>
	  	</button>
      </li>

      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">菜单<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#" data-toggle="modal" data-target="#register">注册会员</a></li>
          <li><a href="up.action">升级为卖家</a></li>
          <li class="divider"></li>
           <li><a href="out.action">注销登录</a></li>
        </ul>
      </li>
    </ul>
   <form class="navbar-form navbar-right" role="search" action="demo5.action" method="post">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="keyword">
      </div>
      <button type="submit" class="btn btn-default glyphicon glyphicon-search">&nbsp;搜索</button>
    </form>
    
    <ul class="nav navbar-nav navbar-right navbar-text">
      <li>没有想要？</li>
    </ul>

  </div><!-- /.navbar-collapse -->
</nav> 

<!-- java代码块，用于在页面加载的时候或的分类信息 -->

<data:getData/>

<!-- java代码块，用于在页面加载的时候或的分类信息 -->

<c:forEach var="tt" items="${SessionScope.TYPE }">


</c:forEach>

	
<div style="height:10px;">
</div>
<hr>
    <!--页面主体-->
    <div class="container-fluid">
    <div class="row">
    <div class="col-md-2" id="listAll">
    <c:forEach var="tt" items="${TYPE }">
        <ul id="${tt.typeid }" class="nav nav-pills nav-stacked">
            <li style="margin:5px 0 0 5px; display:block;" class="active"><a class="active" href="javascript:" onclick="list(${tt.typeid})">${tt.typename }</a></li>
            <c:forEach var="cc" items="${CATE }">
            <c:if test="${cc.typeid==tt.typeid }"><li><a href="demo1.action?cateid=${cc.cateid }&currentPage=1">${cc.catename }</a></li></c:if>
            </c:forEach>
        </ul>
    </c:forEach>
    </div>
    
    <!--商品展示第一层-->
    <div class="col-md-10">
    <div class="row">
    <div class="col-lg-6 col-xs-offset-3" style="padding-bottom:50px;">
    <form class="form-inline" role="form" action="demo5.action" method="post">
  	<div class="form-group">
    <label class="sr-only" for="exampleInputEmail2">Email address</label>
    <input type="text" class="form-control" name="keyword" id="exampleInputEmail2" placeholder="搜索想要">
    <button type="submit" class="btn btn-default glyphicon glyphicon-search"></button>
    <label for="exampleInputEmail1">&nbsp;没有想要？你想要的，这里都有！</label>
    </form>
    </div>
    <div class="col-lg-6"></div>
    </div>
  </div>
  <div style="height:5px;">
	</div>
   <!-- 右侧商品显示块 -->
   <c:if test="${page.list==null &&slist==null }">您还没有查看任何商品</c:if>
   <c:if test="${requestScope.slist!=null }">
   <div class="row">
        <c:forEach items="${slist }" var="p">
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
            </form>
            </div>
            </div>
        </div>
        </c:forEach></c:if>
   <c:if test="${page.list!=null&&list==null }">
     <div class="row">
        <c:forEach items="${page.list }" var="p">
        <div class="col-md-3">
        <form action="demo2.action?method=create" method="post">
        <input type="hidden" name="productid" value="${p.productID}">
            <input type="hidden" name="name" value="${p.productname}"><div class="panel">${p.productname }
            <div class="panel-body">
            <img src="${p.image }" width="230" height="180" class="img-rounded" />
            <input type="hidden" name="amount" value="1"><label for="inputEmal3" class="col-xs-4 control-label">数量</label>
            <p class="">${p.number }</p>
            <label for="inputEmal3" class="col-xs-4 control-label">描述</label>
            <p class="">${p.description }</p>
            <label for="inputEmal3" class="col-xs-4 control-label">价格</label>
            <input type="hidden" name="price" value="${p.price}"><p><span style="color:red;font-size:15px;">${p.price }</span> 元</p>
          
            </div>
            <div class="panel-footer">
            <input type="submit" value="加入购物车" />
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
</c:if>
       
       
        
    
    <!--用户登录-->
    <div class="modal fade" id="login">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">用户登录</h4>
          </div>
          <div class="modal-body">
            
            <form role="form" action="demo.action" method="post">
      <div class="form-group">
        <label for="exampleInputEmail">用户学号</label>
        <input type="text" name="stuID" value="${stuID }" class="form-control" id="exampleInputEmail" placeholder="student ID">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="Boss" checked="checked" value="true">我是卖家
        </label>
      </div>
      <button type="submit" class="btn btn-default">登录</button>
    </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    
    <!--用户注册-->
    <div class="modal fade" id="register">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">欢迎注册会员</h4>
          </div>
          <div class="modal-body">
            <form role="form" action="reg.action" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">用户姓名</label>
        <input type="text" name="name" value="${name }" class="form-control" id="exampleInputEmail1" placeholder="Enter name">
      </div>
       <div class="form-group">
        <label for="exampleInputEmail1">性别</label>
        <input type="text" name="sex" value="${sex }" class="form-control" id="exampleInputEmail1" placeholder="Enter gender">
      </div>
       <div class="form-group">
        <label for="exampleInputEmail1">学号</label>
        <input type="text" name="stuid" value="${stuid }" class="form-control" id="exampleInputEmail1" placeholder="student ID">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">确认密码</label>
        <input type="password" name="repassword" class="form-control" id="exampleInputPassword1" placeholder="repeat Password">
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">公寓地址</label>
        <input type="text" name="address" value="${address }" class="form-control" id="exampleInputEmail1" placeholder="Address">
      </div>
       <div class="form-group">
        <label for="exampleInputEmail1">联系电话</label>
        <input type="text" name="phone" value="${phone }" class="form-control" id="exampleInputEmail1" placeholder="Address">
      </div>
      <div class="form-group">
        <label for="exampleInputEmail1">电子邮箱</label>
        <input type="email" name="email" value="${email }" class="form-control" id="exampleInputEmail1" placeholder="e-mail">
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="boss" checked="checked" value="true">我要做卖家
        </label>
      </div>
      <button type="submit" class="btn btn-info">注册</button>
    </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    
    <!-- 购物车 -->
    <div class="modal fade" id="cart">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">购物车列表</h4>
          </div>
          <div class="modal-body">
            
      <form role="form" action="demo.action" method="post">
      <table class="table">
  		<tr><td>序号</td><td>id</td><td>名称</td><td>单价</td><td>数量</td><td>操作</td></tr>
  		<c:forEach items="${cart.items }" var="ca" varStatus="car">
  		<tr><td>${car.count }</td><td>${ca.productid }</td><td>${ca.name }</td><td>${ca.price }</td><td><input type="text" value="${ca.amount }"></td><td><a href="demo2.action?method=delete&productid=${ca.productid }">删除</a></td></tr>
  		</c:forEach>
  		<tr><td colspan="4"></td><td style="text-align:right;">总花费为：</td><td><p><span style="color:red;font-size:15px;">${p.price }${cart.totalcost }</span>元</td></tr>
	  </table>
      </form>
          </div>
          <div class="modal-footer">
            <a href="order1.action">结算</a>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
 
 
 
  <div class="container-fluid  foot-fix navbar-fixed-bottom">
	 <hr>
     <!--底部-->
     <footer>
     <p class="pull-right"><a href="#">回到顶部</a>&nbsp;&nbsp;<a href="#top" class="glyphicon glyphicon-arrow-up"></a></p>
     
     <p>版权所有 @maker &nbsp;&nbsp;2016-2018</p>
     </footer>
</div> 
     
	  

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/tooltip.js"></script>
    <script src="js/popover.js"></script>
	<script>
	$(function(){
		$("[data-toggle='popover']").popover();
		});

	function list(num){
		var oU=document.getElementById(num);
		var oL=oU.getElementsByTagName('li');
			for(var i=1;i<oL.length;i++){	
				if(oL[i].style.display=='none'){
					oL[i].style.display='block';
					}
				else{
					oL[i].style.display='none';
				}
			}
	}
	</script>
  </body>
</html>