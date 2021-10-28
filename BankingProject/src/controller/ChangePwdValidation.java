package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangePwdValidation extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String opwd = req.getParameter("opwd");
			String npwd = req.getParameter("npwd");
			String cnpwd = req.getParameter("cnpwd");
			if(opwd.length()==0||npwd.length()==0||cnpwd.length()==0)
			{
				res.sendRedirect("/BankingProject/errorchangepwd.jsp");
			}
			else
			{
				if(npwd.equals(cnpwd))
				{
					req.getServletContext().getRequestDispatcher("/ChangePwd").forward(req, res);
				}
				else
				{
					res.sendRedirect("/BankingProject/errorinpwd.jsp");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
