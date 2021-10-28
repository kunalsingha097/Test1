package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class ChangePwd extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{

			String opwd = req.getParameter("opwd");
			String npwd = req.getParameter("npwd");
			
			HttpSession session = req.getSession();
			String accno = (String)session.getAttribute("accno");
			
			Model model=new Model();
			model.setAccno(accno);
			model.setPassword(opwd);
			boolean status = model.changePassword(npwd);
			if(status == true){
				res.sendRedirect("/BankingProject/changepwdsuccess.jsp");
				
			}
			else
			{
				res.sendRedirect("/BankingProject/changepwdfail.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
