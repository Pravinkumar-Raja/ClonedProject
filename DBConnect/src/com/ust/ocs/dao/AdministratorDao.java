package com.ust.ocs.dao;

import java.sql.*;
import java.util.ArrayList;

import com.ust.ocs.bean.EmployeeBean;

public class AdministratorDao {
	
	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pk","root","pass@word1");
			
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println(cnf);
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return con;
	}
	
	public static int addEmp(EmployeeBean eb)
	{
		int i=0;
		try
		{
			ps=con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, eb.getId());
			ps.setString(2, eb.getName());
			ps.setInt(3, eb.getSalary());
			i=ps.executeUpdate();
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static int updateEmp(EmployeeBean eb)
	{
		int i=0;
		try {
			ps=con.prepareStatement("update employee set name=?,salary=? where id=?");
			ps.setString(1, eb.getName());
			ps.setInt(2, eb.getSalary());
			ps.setInt(3, eb.getId());
			i=ps.executeUpdate();
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static int deleteEmployee(int id)
	{
		int i=0;
		try {
			ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);
			i=ps.executeUpdate();
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static EmployeeBean selectEmployee(int id)
	{
		EmployeeBean e=new EmployeeBean();
		try {
			ps=con.prepareStatement("select *from employee where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				
			}
			
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		
		return e;
	}
	
	public static ArrayList<EmployeeBean> selectAll()
	{
		ArrayList<EmployeeBean> all=new ArrayList<EmployeeBean>();
		try
			{
		 ps=con.prepareStatement("select * from employee");
		rs=ps.executeQuery();
		while(rs.next())
		{
		EmployeeBean eb=new EmployeeBean();
		eb.setId(rs.getInt(1));
		eb.setName(rs.getString(2));
		eb.setSalary(rs.getInt(3));
		all.add(eb);
		}
		}
		catch(SQLException sql)
		{
		System.out.println(sql);
		}
		return all;
	}
}
