<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<%-- <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-treeview.min.css" rel="stylesheet" type="text/css"> --%>

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]
    -->
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-treeview.min.js"></script> --%>

<title>测试页面</title>
</head>
<body>
<p>
  <button class="btn btn-large btn-primary" type="button">Large button</button>
  <button class="btn btn-large" type="button">Large button</button>
</p>
<p>
  <button class="btn btn-primary" type="button">Default button</button>
  <button class="btn" type="button">Default button</button>
</p>
<p>
  <button class="btn btn-small btn-primary" type="button">Small button</button>
  <button class="btn btn-small" type="button">Small button</button>
</p>
<p>
  <button class="btn btn-mini btn-primary" type="button">Mini button</button>
  <button class="btn btn-mini" type="button">Mini button</button>
</p>
<div id="menu">

</div>

<img id="verifyCodeImage" onclick="reloadVerifyCode()" src="${pageContext.request.contextPath}/getVerifyCodeImage.do"/>
</body>
<script>
var zNodes=[
{id:0,pId:-1,name:"Aaaa"},
    {id:1,pId:0,name:"A"},
    {id:11,pId:1,name:"A1"},
    {id:12,pId:1,name:"A2"},
    {id:13,pId:1,name:"A3"},
    {id:50,pId:11,name:"sfsfdsfs"},
    {id:2,pId:0,name:"B"},
    {id:21,pId:2,name:"B1"},
    {id:22,pId:2,name:"B2"},
    {id:23,pId:2,name:"B3"},
    {id:3,pId:0,name:"C"},
    {id:31,pId:3,name:"C1"},
    {id:32,pId:3,name:"C2"},
    {id:33,pId:3,name:"C3"},
    {id:34,pId:31,name:"x"},
    {id:35,pId:31,name:"y"},  
    {id:36,pId:31,name:"z"},
    {id:37,pId:36,name:"z1123"} ,
    {id:38,pId:37,name:"z123123123"}   
];
function treeMenu(a){
    this.tree=a||[];
    this.groups={};
};
treeMenu.prototype={
    init:function(parentId){
        this.group();
        return this.getDom(this.groups[parentId]);
    },
    group:function(){
        for(var i=0;i<this.tree.length;i++){
            if(this.groups[this.tree[i].parentId]){
                this.groups[this.tree[i].parentId].push(this.tree[i]);
            }else{
                this.groups[this.tree[i].parentId]=[];
                this.groups[this.tree[i].parentId].push(this.tree[i]);
            }
        }
    },
    getDom:function(a){
        if(!a){       
        	return ''
        }
         var html='';
        if(a[0].parentId==0){
        	var html='\n<ul class="nav nav-list">\n';
	        for(var i=0;i<a.length;i++){
	            html+='<li><a href="#"><i class='+a[i].menuIcon+'></i>'+a[i].menuName+'</a>';
	            var xhtml = this.getDom(this.groups[a[i].menuId]);
	            if(xhtml!=""){	            
	            	html+='<b class="arrow icon-angle-down"></b>';	            	
	            }
	            html+=xhtml;
	            html+='</li>\n';
	        };
        }else{
        	var html='\n<ul class="submenu">\n';
	        for(var i=0;i<a.length;i++){
	            html+='<li><a href="#"><i class='+a[i].menuIcon+'></i>'+a[i].menuName+'</a>';
	            var xhtml = this.getDom(this.groups[a[i].menuId]);
	            if(xhtml!=""){	            
	            	html+='<b class="arrow icon-angle-down"></b>';	            	
	            }
	            html+=xhtml;
	            html+='</li>\n';
	        };
        }
       
        html+='</ul>\n';
        return html;
    }
};
$.post("./role/roleUserMenu.do",{userid:'${sessionScope.currentUser.userId }'},function(data){
	var html=new treeMenu(data).init(0);
	alert(html);
	$("#menu").append(html);
	//alert(html);
},"json");


</script>

</html>