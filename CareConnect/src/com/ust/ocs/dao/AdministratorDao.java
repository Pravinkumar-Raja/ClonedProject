package com.ust.ocs.dao;
import com.ust.ocs.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import com.ust.ocs.main.*;

import javax.swing.JOptionPane;

import com.ust.ocs.bean.AppointmentBean;
import com.ust.ocs.bean.CredentialBean;
import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.bean.PatientBean;
import com.ust.ocs.service.Administrator;
import java.util.*
;public class AdministratorDao implements Administrator{
	static ArrayList <DoctorBean>al=new ArrayList<>();
	static ArrayList <DoctorBean>ar=new ArrayList<>();
	
	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:","root","pass@word1");
			
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
	
	public Boolean login(CredentialBean creadential)
	{
		
		if(creadential.getUserID().equalsIgnoreCase("Admin")&&creadential.getPassword().equalsIgnoreCase("Admin@123"))
		{
		
			creadential.setLoginStatus(1);
			creadential.setUserType("Admin");
			return true;
		}
		return false;
	}
	
	@Override
	public String addDoctor(DoctorBean doctoerBean) {
//		if(al.add(doctoerBean))
//		{
//			
//			return "Doctor added Successfully";
//		}
//		
//		return "Failed to Add";
//		
//		
		int i=0;
		try {
			ps=con.prepareStatement("insert into OCS_TBL_DOCTOR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
			ps.setString(1, doctoerBean.getDoctorID());
			ps.setString(2, doctoerBean.getDoctorName());
			ps.setDate(3, (java.sql.Date) doctoerBean.getDateOfBirth());
			ps.setDate(4, (java.sql.Date) doctoerBean.getDateOfJoining());
			ps.setString(5, doctoerBean.getGender());
			ps.setString(6, doctoerBean.getQualification());
			ps.setString(7, doctoerBean.getSpecialization());
			ps.setInt(8, doctoerBean.getYearsOfExperience());
			ps.setString(9, doctoerBean.getStreet());
			ps.setString(10, doctoerBean.getLocation());
			ps.setString(11, doctoerBean.getLocation());
			ps.setString(12, doctoerBean.getState());
			ps.setString(13, doctoerBean.getCity());
			ps.setString(14, doctoerBean.getContactNumber());
			ps.setString(15, doctoerBean.getEmailID());
			i=ps.executeUpdate();
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return "Doctor Added Successfully";
		
	}

	@Override
	public Boolean modifyDoctor(DoctorBean doctorBean) {
		ar.add(doctorBean);
		boolean bool=true;
		if(al==ar)
		{
			bool=false;
		}
		return bool;
	}

	@Override
	public ArrayList<DoctorBean> viewAllDoctors() {
		for(DoctorBean d:al)
		{
			System.out.println(d);
//			JOptionPane.showMessageDialog(null, d);
		}
		
		return null;
	}

	@Override
	public int removeDoctor(String doctorID) {
	
//		for(int i=0;i<al.size();i++)
//		{
//		if(al.get(i).equals(doctorID))
//		{
//			al.remove(doctorID);
//			
//		}
//		}
		al.remove(doctorID);
		System.out.println("The Doctor Details Removed Successfully");
		JOptionPane.showMessageDialog(null, "Doctor Details removed Successfully");
		
		return 0;
	}

	@Override
	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate) {
		// TODO Auto-generated method stub
		return null;
	}
	

	}

