package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model 
{
	private String accno;
	private String name;
	private String password;
	private String email_id;
	private int balance;
	
	
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	String path="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String user="system";
	String pwd="system";
	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public Model(){
		try
		{
			Class.forName(path);
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("Driver is loaded and connected successfully.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean login()
	{
		try
		{
			pstmt=con.prepareStatement("SELECT * FROM BANK WHERE ACCNO=? AND PASSWORD=?");
			pstmt.setString(1, accno);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next()==true)
			{
				name=rs.getString("name");
				accno=rs.getString("accno");
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean register()
	{
		try
		{
			String sql="INSERT INTO BANK VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accno);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, email_id);
			pstmt.setInt(5, balance);
			int row=pstmt.executeUpdate();
			 if(row==0)
			 {
				 return false;
			 }
			 else
			 {
				 return true;
			 }
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean balance()
	{
		try{
			String sql = "SELECT balance FROM BANK WHERE ACCNO=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, accno);
			rs=pstmt.executeQuery();
			if(rs.next()==true)
			{
				balance=rs.getInt("balance");
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean changePassword(String npwd)
	{
		try
		{
			String sql = "UPDATE BANK SET PASSWORD =? WHERE ACCNO=? AND PASSWORD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, npwd);
			pstmt.setString(2, accno);
			pstmt.setString(3, password);
			int row = pstmt.executeUpdate();
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	}
	
	public boolean transfer(String taccno, int amount)
	{
		try
		{
			String sql1 = "UPDATE BANK SET BALANCE =BALANCE-? WHERE ACCNO=? ";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, amount);
			pstmt.setString(2, accno);
			int row1 = pstmt.executeUpdate();
			

			String sql2 = "UPDATE BANK SET BALANCE =BALANCE+? WHERE ACCNO=? ";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, amount);
			pstmt.setString(2, taccno);
			int row2 = pstmt.executeUpdate();
			
			
			if(row1==0 ||row2==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	}
	
	public boolean forgotPassword(String npwd)
	{
		try
		{
			String sql= "UPDATE BANK SET PASSWROD = ? WHERE ACCNO=? AND NAME=? AND EMAIL_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, npwd);
			pstmt.setString(2, accno);
			pstmt.setString(3, name);
			pstmt.setString(4, email_id);
			
			int row = pstmt.executeUpdate();
			
			if(row==0)
			{
				return false;
			}
			else
			{
				return true;
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
