package com.ust.ocs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.service.Reporter;

public class ReporterDao implements Reporter{

	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/careconnect","root","pass@word1");
			
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
	@Override
	public ArrayList<DoctorBean> viewAllAvailableDoctors(Date date) {
		ArrayList<DoctorBean> view =new ArrayList<DoctorBean>();
		try {
			ps=con.prepareStatement("select * from OCS_TBL_DOCTOR where DATE=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public ArrayList<DoctorBean> intimateAdmin(Date date, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
