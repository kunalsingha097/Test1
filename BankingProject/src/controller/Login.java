package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String accno=req.getParameter("accno");
			String pass=req.getParameter("pass");
			Model model=new Model();
			model.setAccno(accno);
			model.setPassword(pass);
			
			boolean status = model.login();
			if(status==true)
			{
				String accnum=model.getAccno();
				String name=model.getName();
				HttpSession session = req.getSession(true);
				session.setAttribute("accno", accnum);
				session.setAttribute("name", name);
				
				res.sendRedirect("/BankingProject/loginsuccess.jsp");
			}
			else
			{
				res.sendRedirect("/BankingProject/loginfail.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
