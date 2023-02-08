package com.techpalle;

import java.sql.*;

public class Student 
{
	Connection con = null;
	Statement st = null;
	PreparedStatement ps =null;
	
	public static String url ="jdbc:mysql://localhost:3306/palletech";
	public static String username ="root";
	public static String password ="PrakashA4$";
	
  public void creating() 
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		st = con.createStatement();
		
		st.executeUpdate("create table student(sno int primary key auto_increment,sname varchar(50),"
				+ "sub varchar(30),email varchar(40))");
	  }
	  catch (ClassNotFoundException e)
	  {
		e.printStackTrace();
	  } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally 
		{
			try 
			{
				if(st !=null)
				{
					st.close();
				}
				if(con != null) 
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
  }
  public void inserting(String name, String sub,String email) 
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		st = con.createStatement();
		ps=con.prepareStatement("insert into student (sname,sub,email)values(?,?,?)");
		ps.setString(1, name);
		ps.setString(2, sub);
		ps.setString(3, email);
		
		ps.executeUpdate();
	  }
	  catch (ClassNotFoundException e)
	  {
		e.printStackTrace();
	  } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally 
		{
			try 
			{
				if(st !=null)
				{
					st.close();
				}
				if(con != null) 
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
  }
  public void Update(int sno, String sub, String email)
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		st = con.createStatement();
		ps=con.prepareStatement("update student set sub=?, email=? where sno=?");
		
		ps.setString(1, sub);
		ps.setString(2, email);
		ps.setInt(3, sno);
		
		ps.executeUpdate();
	  }
	  catch (ClassNotFoundException e)
	  {
		e.printStackTrace();
	  } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally 
		{
			try 
			{
				if(st !=null)
				{
					st.close();
				}
				if(con != null) 
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
  }
  public void delete(int sno)
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		st = con.createStatement();
		ps=con.prepareStatement("delete from student where sno=?");
		ps.setInt(1, sno);
		
		ps.executeUpdate();
	  }
	  catch (ClassNotFoundException e)
	  {
		e.printStackTrace();
	  } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally 
		{
			try 
			{
				if(st !=null)
				{
					st.close();
				}
				if(con != null) 
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
  }
  public void read()
  {
	  try 
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, username, password);
		
		st = con.createStatement();
		String qry= "select * from student";
		ResultSet rs =st.executeQuery(qry);
		
		while(rs.next()) 
		{
			System.out.println(rs.getInt("sno"));
			System.out.println(rs.getString("sname"));
			System.out.println(rs.getString("sub"));
			System.out.println(rs.getString("email"));
			System.out.println("**********************");
		}
	  }
	  catch (ClassNotFoundException e)
	  {
		e.printStackTrace();
	  } 
	  catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally 
		{
			try 
			{
				if(st !=null)
				{
					st.close();
				}
				if(con != null) 
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
}
  }
