<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/scripts/boot.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery.json-2.3.min.js" type="text/javascript"></script>
</head>
<body>
    <h1>LoadTree 加载树形</h1>
    
<ul id="tree1" class="mini-tree" url="${pageContext.request.contextPath}/data/deptTree.txt" style="width:300px;height:200px;padding:5px;" 
    showTreeIcon="true" textField="name" 
    idField="id" parentField="pid" resultAsTree="false"
    expandOnLoad="0"
        > 
</ul>

    
    <script type="text/javascript">
        mini.parse();
        
    </script>

    <div class="description">
        <h3>Description</h3>
        <p>
        从服务端数据库完整演示加载树形数据。
        </p>
    </div>
</body>
</html>