package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wxm-Imperio.
 */
public class loginFilter implements Filter {
	private FilterConfig config;

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse respons = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();

		String noLoginPaths = config.getInitParameter("noLoginPaths");
		//解决乱码问题
		String charset = config.getInitParameter("charset");
		if(charset == null) {
			charset = "UTF-8";
		}
		request.setCharacterEncoding(charset);

		if (noLoginPaths != null) {
			//截取路径信息
			String[] strArray = noLoginPaths.split(";");
			for (int i = 0; i < strArray.length; i++) {
				//登录页面不再过滤
				if(strArray[i] == null || "".equals(strArray[i])) {
					continue;
				}
				if(request.getRequestURI().indexOf(strArray[i]) != -1) {
					filterChain.doFilter(servletRequest, servletResponse);
					return;
				}
			}
		}
		//如果有用户名，直接跳转到登录成功页面
		if(session.getAttribute("username") != null) {
			filterChain.doFilter(servletRequest, servletResponse);
		}else {
			respons.sendRedirect("login.jsp");
		}
	}
}
