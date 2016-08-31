package com.zq.system.controller;

import com.zq.common.util.VerifyCodeUtil;
import com.zq.system.service.UserInfoService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
  
/** 
 * 本例中用到的jar文件如下 
 * @see aopalliance.jar 
 * @see commons-lang3-3.1.jar 
 * @see commons-logging-1.1.2.jar 
 * @see log4j-1.2.17.jar 
 * @see shiro-all-1.2.2.jar 
 * @see slf4j-api-1.7.5.jar 
 * @see slf4j-log4j12-1.7.5.jar 
 * @see spring-aop-3.2.4.RELEASE.jar 
 * @see spring-beans-3.2.4.RELEASE.jar 
 * @see spring-context-3.2.4.RELEASE.jar 
 * @see spring-core-3.2.4.RELEASE.jar 
 * @see spring-expression-3.2.4.RELEASE.jar 
 * @see spring-jdbc-3.2.4.RELEASE.jar 
 * @see spring-oxm-3.2.4.RELEASE.jar 
 * @see spring-tx-3.2.4.RELEASE.jar 
 * @see spring-web-3.2.4.RELEASE.jar 
 * @see spring-webmvc-3.2.4.RELEASE.jar 
 * @create Sep 30, 2013 11:10:06 PM 
 * @author 玄玉<http://blog.csdn.net/jadyer> 
 */  
@Controller("LoginController")   
public class LoginController {
	@Autowired
	private UserInfoService userInfoService;
    /** 
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中) 
     */  
    @RequestMapping("/getVerifyCodeImage")  
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        //设置页面不缓存  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
        VerifyCodeUtil vCode = new VerifyCodeUtil(75,30,4,50);   
        request.getSession().setAttribute("verifyCode", vCode.getCode());   
        vCode.write(response.getOutputStream());   
    }  
      
      
    /** 
     * 用户登录 
     */  
    @RequestMapping(value="/login", method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Object login(HttpServletRequest request){  
       // String resultPageURL = "../login"; 
    	String message ="用户名密码错误!";
    	
    	
    	String data = request.getParameter("data");
    	
    	JSONObject json = JSONObject.fromObject(data);
        String username = json.getString("username");  
        String password = json.getString("password");  
        //获取HttpSession中的验证码  
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");  
        //获取用户请求表单中输入的验证码  
        //String submitCode = WebUtils.getCleanParam(request, "verifyCode"); 
        String submitCode = json.getString("verifyCode");  
        System.out.println("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");  
        if (StringUtils.isEmpty(submitCode) || !StringUtils.equalsIgnoreCase(verifyCode, submitCode.toLowerCase())){  
            request.setAttribute("message_login", "验证码不正确"); 
            message="验证码不正确!";
            return message;
        } 
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
        token.setRememberMe(false);  
        System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();  
        try {  	
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            System.out.println("对用户[" + username + "]进行登录验证..验证开始");  
            currentUser.login(token);  
            System.out.println("对用户[" + username + "]进行登录验证..验证通过");  
            message="success";
            return message;
        }catch(UnknownAccountException uae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
            request.setAttribute("message_login", "未知账户");  
        }catch(IncorrectCredentialsException ice){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
            request.setAttribute("message_login", "密码不正确");  
        }catch(LockedAccountException lae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
            request.setAttribute("message_login", "账户已锁定");  
        }catch(ExcessiveAttemptsException eae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
            request.setAttribute("message_login", "用户名或密码错误次数过多");  
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
            request.setAttribute("message_login", "用户名或密码不正确");  
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
        }else{  
            token.clear();  
        }   
        return message;
    }  
      
      
    /** 
     * 用户登出 
     */  
    @RequestMapping("/logout")  
    public String logout(HttpServletRequest request){  
         SecurityUtils.getSubject().logout();  
         return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";  
    }
    @RequestMapping("/test")  
    @ResponseBody
    public Object test(HttpServletRequest request){
    	
    	return "dfsfs";
    }
    
}  
