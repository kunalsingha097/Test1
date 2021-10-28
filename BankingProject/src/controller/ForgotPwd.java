package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

public class ForgotPwd extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res){
		try{

			String accno = req.getParameter("accno");
			String name = req.getParameter("name");
			String emailid = req.getParameter("emailid");
			String npwd = req.getParameter("npwd");
			
			Model model= new Model();
			model.setAccno(accno);
			model.setName(name);
			model.setEmail_id(emailid);
			
			boolean status=model.forgotPassword(npwd);
			
			if(status==true)
			{
				res.sendRedirect("/BankingProject/forgotpwdsuccess.jsp");
			}
			else
			{
				res.sendRedirect("/BankingProject/forgotpwdfail.jsp");
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

		
	}
	
	

}
