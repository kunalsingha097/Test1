package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Balance extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			HttpSession session = req.getSession();
			String accno=(String)session.getAttribute("accno");
			Model model = new Model();
			model.setAccno(accno);
			boolean status = model.balance();
			if(status==true)
			{
				int balance = model.getBalance();
				session.setAttribute("balance", balance);
				res.sendRedirect("/BankingProject/balancesuccess.jsp");
			}
			else
			{
				res.sendRedirect("/BankingProject/balancefail.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
