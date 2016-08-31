package com.zq.system.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zq.system.entity.UserInfo;
import com.zq.system.util.CommonConstants;
 
/**
 * @author chenlf
 * 
 *         2014-3-25
 */
public class MemberInterceptor implements HandlerInterceptor {
 
   
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
            Exception arg3) throws Exception {
        // TODO Auto-generated method stub
 
    }
 
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
            ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub
 
    }
 
    /*
     * (non-Javadoc)
     * 拦截mvc.xml配置的/member/**路径的请求
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
    	
    	String requestUrl = request.getRequestURI(); 
    	if(requestUrl.indexOf(CommonConstants.VERIFYCODE_URL)!=-1){ 
    		return true; 
    	}else if(requestUrl.indexOf(CommonConstants.LOGIN_URL)!=-1){
    		return true; 
    	}else{ 

    		//请求的路径
            String contextPath=request.getContextPath();
            String  url=request.getServletPath().toString();
            HttpSession session = request.getSession();
            UserInfo user = (UserInfo) session.getAttribute(CommonConstants.SEESION_MEMBER);
            //这里可以根据session的用户来判断角色的权限，根据权限来重定向不同的页面，简单起见，这里只是做了一个重定向
            if (user==null) {
                //被拦截，重定向到login界面
                response.sendRedirect(contextPath+"/login.jsp?redirectURL="
                        + URLEncoder.encode(url));
                return true;
            }
            return true;
    	}        
    }
 
}
