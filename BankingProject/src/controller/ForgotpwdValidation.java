package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotpwdValidation extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res)
	{

		String accno = req.getParameter("accno");
		String name = req.getParameter("name");
		String emailid = req.getParameter("emailid");
		String npwd = req.getParameter("npwd");
		String cnpwd = req.getParameter("cnpwd");
		try
		{
			
			if(accno.length()==0||name.length()==0||emailid.length()==0||npwd.length()==0||cnpwd.length()==0)
			{
				res.sendRedirect("/BankingProject/errorforgotpwd.jsp");
			}
			else
			{
				if(npwd.equals(cnpwd))
				{
					req.getServletContext().getRequestDispatcher("/ForgotPwd").forward(req, res);
				}
				else
				{
					res.sendRedirect("/BankingProject/errorforgotpwd.jsp");
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
