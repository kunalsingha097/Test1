package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

public class Register extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String accno=req.getParameter("accno");
			String name=req.getParameter("name");
			String pass=req.getParameter("pass");
			String email=req.getParameter("email");
			int balance=Integer.parseInt(req.getParameter("balance"));
			
			Model model=new Model();
			model.setAccno(accno);
			model.setName(name);
			model.setPassword(pass);
			model.setEmail_id(email);
			model.setBalance(balance);
			
			boolean status=model.register();
			
			if(status==true)
			{
				res.sendRedirect("/BankingProject/regsuccess.jsp");
			}
			else
			{
				res.sendRedirect("/BankingProject/regfail.jsp");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
