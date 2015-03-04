package servlet;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wxm-Imperio.
 */
@javax.servlet.annotation.WebServlet(name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

//------测试中文乱码
		System.out.println(username);

		if("admin".equals(username) && "admin".equals(password)) {
			//校验通过
			//设置session
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath() + "/successLogin.jsp");
		}else {
			//校验失败
			response.sendRedirect(request.getContextPath() + "/failLogin.jsp");
		}
	}

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		doPost(request, response);
	}
}
