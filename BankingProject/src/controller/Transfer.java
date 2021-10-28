package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Transfer extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String taccno = req.getParameter("taccno");
			int amount = Integer.parseInt(req.getParameter("amount"));
			HttpSession session = req.getSession();
			String accno= (String)session.getAttribute("accno");
			Model model = new Model();
			model.setAccno(accno);
			boolean status = model.balance();
			if(status==true)
			{
				int balance = model.getBalance();
				if(balance>amount){
					boolean status1= model.transfer(taccno,amount);
					if(status1==true)
					{
						res.sendRedirect("/BankingProject/transfersuccess.jsp");
					}
					else
					{
						res.sendRedirect("/BankingProject/transferfail.jsp");
					}
				}
				else
				{
					res.sendRedirect("/BankingProject/transferfail.jsp");
				}
			}
			else
			{
				res.sendRedirect("/BankingProject/transferfail.jsp");
			}
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
