<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>员工面板</title>
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
     
    <form id="department" method="post">
        <input name="id" class="mini-hidden" />      
        <fieldset style="border:solid 1px #aaa;padding:3px;">
            <legend >基本信息</legend>
            <div style="padding:5px;">
        <table>
            <tr>
                <td style="width:70px;">姓名:</td>
                <td style="width:150px;">    
                    <input name="userName" id="t_userName" class="mini-textbox" required="true"/>
                </td>
                <td style="width:70px;">性别：</td>
                <td >                        
                    <select name="userSex" id="t_userSex" class="mini-radiobuttonlist">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </td>
                
            </tr>
            <tr>
                 <td style="width:70px;">联系电话:</td>
                <td style="width:150px;">    
                    <input name="userNumber" id="t_userNumber" class="mini-textbox" required="true"/>
                </td>
                <td >出生日期：</td>
                <td >    
                    <input name="userBirthday" id="t_userBirthday" class="mini-datepicker" required="true" emptyText="请选择日期"/>
                </td>
            </tr>
             <tr>
                  <td >籍贯：</td>
                  <td >    
                      <input name="userRecruitment" id="t_userRecruitment" class="mini-textbox" required="true"/>
                  </td>
                  <td >现地址：</td>
                  <td >    
                      <input name="userNewaddress" id="t_userNewaddress" class="mini-textbox" required="true" valueField="id" textField="name"/>
                  </td>
            </tr>
               
            <tr>
                <td >学历：</td>
                <td >    
                    <input name="userEducation" id="t_userEducation" class="mini-textbox" valueField="id" textField="name" url="" />
                </td>
                <td >状态：</td>
                <td >    
                    <input name="userState" id="t_userState" class="mini-textbox" />
                </td>
            </tr>           
            <tr>
                <td >E-mail:</td>
                <td >    
                    <input name="userEmail" id="t_userEmail" class="mini-textbox" required="true"/>
                </td>
                <td >注册时间：</td>
                <td >    
                    <input name="userRegister" id="t_userRegister" class="mini-datepicker" required="true" emptyText="请选择日期"/>
                </td>
            </tr>
             <tr>
               
                 <td style="width:100px;">紧急联系电话:</td>
                <td style="width:150px;">    
                    <input name="userUrgentnumber" id="t_userUrgentnumber" class="mini-textbox" required="true"/>
                </td>
               
            </tr>
        </table>            
            </div>
        </fieldset>
        
          <fieldset style="border:solid 1px #aaa;padding:3px;">
            <legend >账号信息</legend>
            <div style="padding:5px;">
            
            <div style="padding-left:11px;padding-bottom:5px;">
            <table style="table-layout:fixed;">
                <tr>
                    <td style="width:90px;">账号：</td>
                    <td style="width:150px;">    
                        <input name="account.account" id="t_account" class="mini-textbox" required="true"  emptyText="请输入帐号"/>
                    </td>
                    <td style="width:70px;">密码：</td>
                    <td style="width:150px;">    
                        <input name="account.passWord" id="t_passWord" class="mini-textbox" />
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

        var form = new mini.Form("department");

        function SaveData() {
            var o = form.getData();            

            form.validate();
            if (form.isValid() == false) return;

           // var params = getSubmitParams("[id^='t_']");
			//var params1 = {data:$.toJSON(params)}; 
            var json = mini.encode(o);
            $.ajax({
                url: "${pageContext.request.contextPath}/userInfo/addUserInfo.do",
				type: 'post',
                data: {data:json},
                cache: false,
                success: function (text) {
                    //CloseWindow("save");
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
