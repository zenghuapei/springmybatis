<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script src="./scripts/boot.js" type="text/javascript"></script>
<script src="./scripts/jquery.json-2.3.min.js" type="text/javascript"></script>
<style type="text/css">
    body
    {
        width:100%;height:100%;margin:0;overflow:hidden;
    }
    </style>
</head>
<script type="text/javascript">
function reloadVerifyCode(){  
    document.getElementById('verifyCodeImage').setAttribute('src', './getVerifyCodeImage.do?'+new Date().getTime());  
}  
</script>
<body>
<div id="loginWindow" class="mini-window" title="用户登录" style="width:350px;height:190px;" 
   showModal="true" showCloseButton="false"
    >

    <div id="loginForm" style="padding:15px;padding-top:10px;">
        <table >
            <tr>
                <td style="width:60px;"><label for="username$text">帐号：</label></td>
                <td colspan="2">
                    <input id="username" name="username" onvalidation="onUserNameValidation" class="mini-textbox" required="true" style="width:150px;"/>
                </td>    
            </tr>
            <tr>
                <td style="width:60px;"><label for="pwd$text">密码：</label></td>
                <td colspan="2">
                    <input id="password" name="password" onvalidation="onPwdValidation" class="mini-password" requiredErrorText="密码不能为空" required="true" style="width:150px;" onenter="onLoginClick"/>
                    &nbsp;&nbsp;<a href="#" >忘记密码?</a>
                </td>
            </tr>
            <tr>
                <td style="width:60px;"><label for="pwd$text">验证码：</label></td>
                <td>
                	
                    <input id="verifyCode" name="verifyCode" onvalidation="onverifyCode" class="mini-textbox" requiredErrorText="验证码不能为空" required="true" style="width:120px;" onenter="onLoginClick"/>
                    &nbsp;&nbsp;
                </td>
                <td><img id="verifyCodeImage" style=" border:3 dashed #990000" onclick="reloadVerifyCode()" src="./getVerifyCodeImage.do"/><br/> </td>
            </tr>               
            <tr>
                <td></td>
                <td style="padding-top:5px;">
                    <a onclick="onLoginClick" class="mini-button" style="width:60px;">登录</a>
                    <a onclick="onResetClick" class="mini-button" style="width:60px;">重置</a>
                </td>
            </tr>
        </table>
    </div>

</div> 


<script type="text/javascript">
        mini.parse();

        var loginWindow = mini.get("loginWindow");
        loginWindow.show();

        function onLoginClick(e) {
            var form = new mini.Form("#loginWindow");

            form.validate();
            if (form.isValid() == false){
            	return;
            }else{
            	var params = getSubmitParams("input");
				var params1 = {data:$.toJSON(params)}; 
            	/* $.ajax({ url: "${pageContext.request.contextPath}/login.do", context: form..submit(), success: function(data){
   					alert(data);
				}}); */
				$.ajax( {    
				    url:'./login.do',// 跳转到 action    
				    data:params1,    
				    type:'post',    
				    cache:false,    
				    dataType:'text',    
				    success:function(data) {  
				        if(data =="success" ){    
				        loginWindow.hide();
			            mini.loading("登录成功，马上转到系统...", "登录成功");
			            setTimeout(function () {
			                window.location = "./view/index.jsp";
			            }, 1500); 
				            
				        }else{  
					       mini.alert(data);
				        }    
				     },    
				     error : function(e) {    
				          mini.alert("程序异常！");    
				     }    
				});  
            } 
			
         
        }
        function onResetClick(e) {
            var form = new mini.Form("#loginWindow");
            form.clear();
        }
        /////////////////////////////////////
        function isEmail(s) {
            if (s.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
                return true;
            else
                return true;
        }
        function onUserNameValidation(e) {
            if (e.isValid) {
                if (isEmail(e.value) == false) {
                    e.errorText = "必须输入邮件地址";
                    e.isValid = false;
                }
            }
        }
        function onPwdValidation(e) {
            if (e.isValid) {
                if (e.value.length < 5) {
                    e.errorText = "密码不能少于5个字符";
                    e.isValid = false;
                }
            }
        }
        function onverifyCode(e) {
            if (e.isValid) {
                if (e.value.length < 4) {
                    e.errorText = "验证码输入错误";
                    e.isValid = false;
                }
            }
        }
    </script>
</body>
</html>