package com.ust.ocs.util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import com.ust.ocs.bean.*;
import com.ust.ocs.dao.AdministratorDao;
public class Clinic {
	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/careconnect","root","pass@word1");
			System.out.println("Connected Successfully");
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
	
	public static int addDoctor(DoctorBean d)
	{
		int i=0;
		try {
			ps=con.prepareStatement("insert into OCS_TBL_DOCTOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
			ps.setString(1, d.getDoctorID());
			ps.setString(2, d.getDoctorName());
//			ps.setDate(3, d.getDateOfBirth());
//			ps.setDate(4, d.getDateOfJoining());
			ps.setString(5, d.getGender());
			ps.setString(6, d.getQualification());
			ps.setString(7, d.getSpecialization());
			ps.setInt(8, d.getYearsOfExperience());
			ps.setString(9, d.getStreet());
			ps.setString(10, d.getLocation());
			ps.setString(11, d.getLocation());
			ps.setString(12, d.getState());
			ps.setString(13, d.getCity());
			ps.setString(14, d.getContactNumber());
			ps.setString(15, d.getEmailID());
			i=ps.executeUpdate();
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return i;
	}

	
}
