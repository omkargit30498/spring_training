package com.zensar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
			String username=request.getParameter("username");
			String password=request.getParameter("passwrd");
			LoginRepository repo=new LoginRepository();
			boolean rs=repo.finduser(username);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			if(rs) {
				try {
					rd.forward(request, response);
				}catch (Exception e) {
				System.out.println("error"+e);
				}
			}else {
				try {
					response.sendRedirect("index.jsp");
				}catch(Exception e) {
					System.out.println("error"+e);
				}
			}
		}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request,response);
	}

}
