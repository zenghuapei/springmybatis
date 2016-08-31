<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
 <style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    </style>  
		<script src="${pageContext.request.contextPath}/scripts/boot.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/jquery.json-2.3.min.js" type="text/javascript"></script>
</head>
	<body>
   
    
<div class="mini-splitter" style="width:100%;height:100%;">
    <div size="240" showCollapseButton="true">
        <div class="mini-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">                
            <span style="padding-left:5px;">名称：</span>
            <input class="mini-textbox" />
            <a class="mini-button" iconCls="icon-search" plain="true">查找</a>                  
        </div>
        <div class="mini-fit">
            <ul id="departmentTree" class="mini-tree" url="${pageContext.request.contextPath}/department/getDepartmentListUser.do?userId=${sessionScope.currentUser.userId}"  style="width:100%;"
                showTreeIcon="true" textField="departmentName" idField="departmentId" parentField="parentId" resultAsTree="false"
                
            >        
            </ul>
        </div>
        
    </div>
    <div showCollapseButton="true">
        <div class="mini-toolbar" style="padding:2px;border-top:0;border-left:0;border-right:0;">                            
          <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                        <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>       
                    </td>
                    <td style="white-space:nowrap;">
                        <input id="key" class="mini-textbox" emptyText="请输入部门名称" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>                     
        </div>
        <div class="mini-fit" >
            <div id="grid1" class="mini-datagrid" style="width:100%;height:100%;" 
                borderStyle="border:0;"
                url="${pageContext.request.contextPath}/userInfo/queryPage.do" multiSelect="true" allowResize="true"
                showFilterRow="true" allowCellSelect="true" allowCellEdit="true"                
            >
                <div property="columns">  
                	<div type="checkcolumn" ></div>           
                    <div field="userName" width="120"  align="center" headerAlign="center" allowSort="true">姓名
                    </div>      
                    <div field="userEmail" width="120"  align="center" headerAlign="center" allowSort="true">E-mail                        
                        <input id="nameFilter" property="filter" class="mini-textbox" onvaluechanged="onNameFilterChanged" style="width:100%;" />
                    </div>                
                    <div field="userSex" width="100" allowSort="true" renderer="onGenderRenderer" align="center" headerAlign="center">性别
                    </div>            
                    <div field="userRecruitment"  align="center" width="100" allowSort="true">籍贯
                    </div>
                    <div field="userNewaddress"  align="center" width="100" allowSort="true" dateFormat="yyyy-MM-dd">现居住地址
                    </div>                                    
                    <div field="userNumber" width="100"  align="center" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">联系电话</div>                
                </div>
            </div>  
        </div>
    </div>        
</div>
    <input  type="hidden" id="departmentId"/>
    <script type="text/javascript">
        mini.parse();

        var tree = mini.get("departmentTree");
        var grid = mini.get("grid1");

        tree.on("nodeselect", function (e) {
        
            if (e.isLeaf) {
                grid.load({ departmentId: e.node.departmentId });
                $("#departmentId").val(e.node.departmentId);
            } else {
               grid.load({ departmentId: e.node.departmentId });
               $("#departmentId").val(e.node.departmentId);
            }
        });
        //////////////////////////////////////////////
        var Genders = [{ id: 1, text: '男' }, { id: 2, text: '女'}];
        function onGenderRenderer(e) {
            for (var i = 0, l = Genders.length; i < l; i++) {
                var g = Genders[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        
        function onNameFilterChanged(e) {
            var textbox = e.sender;
            var key = textbox.getValue();
            
            var node = tree.getSelectedNode();
            if (node) {
                grid.load({ dept_id: node.id, key: key });
            }
        }
         function add() {
            
            mini.open({
                url: "${pageContext.request.contextPath}/view/userInfoeditadd.jsp",
                title: "新增用户", width: 600, height: 360,                
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var departmentId = $("#departmentId").val();
                    var data = { action: "add",departmentId:departmentId};
                    iframe.contentWindow.SetData(data);
                },
                ondestroy: function (action) {

                    grid.reload();
                }
            });
        }
       
        function saveData() {
            var data = grid.getChanges();
            var json = mini.encode(data);
            grid.loading("保存中，请稍后......");
            $.ajax({
                url: "../data/AjaxService.aspx?method=SaveEmployees",
                data: { data: json },
                type: "post",
                success: function (text) {
                    grid.reload();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }
    </script>

</body>
</html>