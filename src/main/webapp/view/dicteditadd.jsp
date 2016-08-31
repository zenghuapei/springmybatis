<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>字典项添加修改</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    
    <script src="${pageContext.request.contextPath}/scripts/boot.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery.json-2.3.min.js" type="text/javascript"></script>

    <style type="text/css">
    html, body
    {
        font-size:12px;
        padding:0;
        margin:0;
        border:0;
        height:100%;
        overflow:hidden;
    }
    </style>
</head>
<body>    
     
    <form id="dict" method="post">
        <input name="id" class="mini-hidden" />
        <input id="t_parentId" name="parentId" value=""  class="mini-hidden"/>
        <fieldset style="border:solid 1px #aaa;padding:3px;">
            <legend >字典信息</legend>
            <div style="padding:5px;">
                <table>
            <tr>
                <td style="width:70px;">字典名称:</td>
                <td style="width:150px;">
                    <input name="dictName" id="t_dictName" class="mini-textbox" required="true"/>
                </td>
                 <td style="width:70px;">字典编码:</td>
                <td style="width:150px;">
                    <input name="dictCode" id="t_dictCode" class="mini-textbox" required="true"/>
                </td>

            </tr>
            <tr>
                 <td style="width:70px;">字典值:</td>
                <td style="width:150px;">
                    <input name="dictValue" id="t_dictValue" class="mini-textbox" required="true"/>
                </td>
                <td >排序号：</td>
                <td >
                    <input name="dictDesc" id="t_dictDesc" class="mini-textbox" required="true"/>
                </td>
            </tr>
            <tr>

                <td >是否生效：</td>
                <td >
                    <input name="dictIsEffective" id="t_dictIsEffective" class="mini-combobox" style="width:150px;" textField="dictName" emptyText="请选择类型"
                           url="${pageContext.request.contextPath}/dict/getDictList.do?dictId=4" valueField="dictValue"  required="true" allowInput="true" showNullItem="false"/>
                </td>
            </tr>
        </table>
            </div>
        </fieldset>
        
      

        <div style="text-align:center;padding:10px;">               
            <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>       
            <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>       
        </div>        
    </form>
    <script type="text/javascript">
        mini.parse();

        var form = new mini.Form("dict");

        function SaveData() {
            var o = form.getData();            

            form.validate();
            if (form.isValid() == false) return;

            var params = getSubmitParams("[id^='t_']");
			var params1 = {data:$.toJSON(params)};
            $.ajax({
                url: "${pageContext.request.contextPath}/dict/addDict.do",
				type: 'post',
                data: params1,
                cache: false,
                success: function (text) {
                    CloseWindow("save");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                    CloseWindow();
                }
            });
        }

        ////////////////////
        //标准方法接口定义
        function SetData(data) {
        	$("#t_parentId").val(data.dictId);
            if (data.action == "edit") {
                //跨页面传递的数据对象，克隆后才可以安全使用
                data = mini.clone(data);

                $.ajax({
                    url: "../data/AjaxService.jsp?method=GetEmployee&id=" + data.id,
                    cache: false,
                    success: function (text) {
                        var o = mini.decode(text);
                        form.setData(o);
                        form.setChanged(false);

                        onDeptChanged();
                        mini.getbyName("position").setValue(o.position);
                    }
                });
            }
        }

        function GetData() {
            var o = form.getData();
            return o;
        }
        function CloseWindow(action) {            
            if (action == "close" && form.isChanged()) {
                if (confirm("数据被修改了，是否先保存？")) {
                    return false;
                }
            }
            if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
            else window.close();            
        }
        function onOk(e) {
            SaveData();
        }
        function onCancel(e) {
            alert(1);
            CloseWindow("cancel");
        }
        //////////////////////////////////
        function onDeptChanged(e) {
            var deptCombo = mini.getbyName("dept_id");
            var positionCombo = mini.getbyName("position");
            var dept_id = deptCombo.getValue();

            positionCombo.load("../data/AjaxService.jsp?method=GetPositionsByDepartmenId&id=" + dept_id);
            positionCombo.setValue("");
        }



    </script>
</body>
</html>
