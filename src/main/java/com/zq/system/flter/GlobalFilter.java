package com.zq.system.flter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zq.system.util.CommonConstants;



public class GlobalFilter implements Filter {

	/**
	 * 初始化codeMap表到内存
	 */
	
	public void init(FilterConfig config) throws ServletException {
		/**
		 * 通过静态方式获取spring bean,并加载数据到内存
		 */
		/*CodeManagerService service = SpringBeanContext.getBean(CodeManagerService.class);
		service.loadCodeMapFromDb();*/
		//删除 无效附件
		//FileService  fileService = SpringBeanContext.getBean(FileService.class);
		//fileService.deleteFileByWebInit();
	}

	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		if(session.getAttribute(CommonConstants.SEESION_MEMBER) == null) {
			response.sendRedirect(request.getContextPath()   +"/login.jsp");
			return;
		}
		
		if(!CommonConstants.ALLOW_VIEW_JSP){
			response.sendRedirect(request.getContextPath()  +"/login.jsp");
			return;
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}
	
	
	public void destroy() {

	}

}
